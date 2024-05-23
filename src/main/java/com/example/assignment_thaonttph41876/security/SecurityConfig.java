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
//            authorizeRequests.requestMatchers("/hoa-don/index").hasAuthority("ADMIN");


//            authorizeRequests.requestMatchers("/hoa-don/create").hasAnyAuthority("USER","ADMIN");
            //request matchers la duong dan can phan quyen khi truy cap vao can dang nhap voi vai tro
//
//
//            authorizeRequests.anyRequest().permitAll();
            //cho phép toàn quyền hoạt động không cần đăng nhập
            authorizeRequests.anyRequest().authenticated();
            //yêu cầu tất cả phải đăng nhập

            // nếu muốn đăng xuất chỉ cần localhost:8080/logout
        });
        http.formLogin(Customizer.withDefaults());
        http.formLogin( formLogin-> formLogin.defaultSuccessUrl("/hoa-don/index", true));
        return http.build();
    }
}
