package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import com.example.assignment_thaonttph41876.repositories.asm1.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String matKhau, NhanVienRepository nhanVienRepository) {
        NhanVien nv = nhanVienRepository.login(tenDangNhap, matKhau);
        if (nv != null) {
            // Đăng nhập thành công
            if (nv.getId() == 1) {
                // Admin
                return "redirect:/hoa-don/index";
            } else {
                // User
                return "redirect:/hoa-don/create";
            }
        } else {
            // Đăng nhập không thành công
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }
    }
}

