package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import com.example.assignment_thaonttph41876.repositories.asm1.NhanVienRepository;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    private NhanVienRepository nhanVienRepository;

    public NhanVienController() {
        nhanVienRepository = new NhanVienRepository();
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") NhanVien nhanVien) {
        return "nhan_vien/create";
    }

    @PostMapping("store")
    public String store(Model model,
                        @Valid NhanVien nhanVien, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", nhanVien);
            model.addAttribute("errors", errors);
            return "nhan_vien/create";
        }
        this.nhanVienRepository.create(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("index")
    public String index(Model model){
        List<NhanVien> list = nhanVienRepository.findAll();
        model.addAttribute("data", list);
        return "nhan_vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model){
        NhanVien nhanVien = nhanVienRepository.findById(id);
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(NhanVien nhanVien){
        nhanVienRepository.update(nhanVien);
        return "redirect:/nhan-vien/index";
    }
}
