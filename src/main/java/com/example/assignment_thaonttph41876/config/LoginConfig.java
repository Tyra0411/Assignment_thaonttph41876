package com.example.assignment_thaonttph41876.config;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class LoginConfig {
    public static void main(String[] args) {
        SpringApplication.run(LoginConfig.class, args);
    }

    @Bean(name = "Admin_Bean")
    public NhanVien admin() {
        NhanVien nv = new NhanVien();
        nv.setTenDangNhap("admin");
        nv.setMatKhau("123456");
        nv.setRole("ADMIN");
        return nv;
    }

    @Bean(name = "User_Bean")
    public NhanVien nv() {
        NhanVien nv = new NhanVien();
        nv.setTenDangNhap("user");
        nv.setMatKhau("123456");
        nv.setRole("USER");
        return nv;
    }
}
