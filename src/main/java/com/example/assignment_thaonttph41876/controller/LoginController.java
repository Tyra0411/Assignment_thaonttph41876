package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("auth")
public class LoginController {

    @Autowired
    @Qualifier("Admin_Bean")
    private NhanVien admin;

    @Autowired
    @Qualifier("User_Bean")
    private NhanVien user;

    @GetMapping("login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Failed Username or Password!");
        }
        return "login";
    }

    @PostMapping("checkLogin")
    public String check(Model model, @RequestParam("tenDangNhap") String tenDangNhap,
                        @RequestParam("matKhau") String matKhau,
                        HttpSession session) {
        NhanVien nhanVien = null;
        if (admin.getTenDangNhap().equals(tenDangNhap) && admin.getMatKhau().equals(matKhau)) {
            nhanVien = admin;
        } else if (user.getTenDangNhap().equals(tenDangNhap) && user.getMatKhau().equals(matKhau)) {
            nhanVien = user;
        }

        if (nhanVien != null) {
            session.setAttribute("tenDangNhap", tenDangNhap);
            session.setAttribute("role", nhanVien.getRole());
            return "redirect:/san-pham/index";
        } else {
            model.addAttribute("error", "Failed Username or Password!");
            return "login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
