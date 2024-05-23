package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.KhachHang;
import com.example.assignment_thaonttph41876.repositories.asm1.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    private KhachHangRepository khachHangRepository;

    public KhachHangController() {
        this.khachHangRepository = new KhachHangRepository();
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data")KhachHang khachHang) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KhachHang khachHang,
                        BindingResult validate) {
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", khachHang);
            model.addAttribute("errors", errors);
            return "khach_hang/create";
        }
        this.khachHangRepository.create(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<KhachHang> ds = this.khachHangRepository.findAll();
        model.addAttribute("data", ds);
        return "khach_hang/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KhachHang khachHang = this.khachHangRepository.findById(id);
        model.addAttribute("data", khachHang);
        return "khach_hang/edit";
    }

    @PostMapping("/update/{id}")
    public String update(KhachHang khachHang){
        this.khachHangRepository.update(khachHang);
        return "redirect:/khach-hang/index";
    }
}
