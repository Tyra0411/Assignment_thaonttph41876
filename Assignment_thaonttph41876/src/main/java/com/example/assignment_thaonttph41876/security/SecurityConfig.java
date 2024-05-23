package com.example.assignment_thaonttph41876.security;

//import lombok.RequiredArgsConstructor;
//import org.example.springsecurity6.emuns.RoleEnum;
//import org.example.springsecurity6.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // nhan vien fix cung
        UserDetails nhanVien = User
                .builder()
                .username("user")
                .password(bCryptPasswordEncoder.encode("123456"))
                .roles("USER")
                .build();
        UserDetails admin = User
                .builder()
                .username("admin")
                .password(bCryptPasswordEncoder.encode("0123456"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(nhanVien,admin);
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(authorizeRequests ->{
            // NAY  LA PHAN QUYEN TREN DUONG DAN AUTHORITY LA VAI TRO

//            authorizeRequests.requestMatchers("/").hasAuthority("ADMIN");

            // tat ca cac duong dan bat dau bang /admin/ can co vai tro ADMIN

//            authorizeRequests.requestMatchers("/admin/**").hasAnyAuthority("USER","ADMIN");

            // tat ca cac duong dan bat dau bang /admin/ can co vai tro ADMIN hoac USER
            // ** la tat ca cac duong dan con cua admin

//            authorizeRequests.anyRequest().permitAll();
            // tat ca cac duong dan khac khong can dang nhap

            authorizeRequests.anyRequest().authenticated();
            // tat ca cac duong dan khac can dang nhap phai comment code hoac xoa vao khi da phan quyen bang authorizeRequests.requestMatchers()
        });
        http.formLogin(Customizer.withDefaults());
        http.formLogin( formLogin-> formLogin.defaultSuccessUrl("/"));
        return http.build();
    }
}
