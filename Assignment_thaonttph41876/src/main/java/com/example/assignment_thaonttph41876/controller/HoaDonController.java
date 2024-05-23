package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.HoaDon;
import com.example.assignment_thaonttph41876.entities.KhachHang;
import com.example.assignment_thaonttph41876.entities.NhanVien;
import com.example.assignment_thaonttph41876.repositories.asm1.HoaDonRepository;
import com.example.assignment_thaonttph41876.repositories.asm1.KhachHangRepository;
import com.example.assignment_thaonttph41876.repositories.asm1.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    private HoaDonRepository hoaDonRepository;
    private NhanVienRepository nhanVienRepository;
    private KhachHangRepository khachHangRepository;
    public HoaDonController(){
        hoaDonRepository = new HoaDonRepository();
        nhanVienRepository = new NhanVienRepository();
        khachHangRepository = new KhachHangRepository();
    }

    @GetMapping("/create")
    public String create(Model model,
                         HoaDon hoaDon){
        List<NhanVien> listNV = this.nhanVienRepository.findAll();
        List<KhachHang> listKH = this.khachHangRepository.findAll();
        model.addAttribute("data", hoaDon);
        model.addAttribute("dataNV", listNV);
        model.addAttribute("dataKH", listKH);
        return "hoa_don/create";
    }

    @PostMapping("/store")
    public String store(Model model,
                        @Valid HoaDon hoaDon, BindingResult validate){
        if (validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e:validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", hoaDon);
            model.addAttribute("errors", errors);
            return "hoa_don/create";
        }
        this.hoaDonRepository.create(hoaDon);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        List<HoaDon> list = this.hoaDonRepository.findAll();
        model.addAttribute("data", list);
        return "hoa_don/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        hoaDonRepository.deleteById(id);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model){
        HoaDon hoaDon = hoaDonRepository.findById(id);
        model.addAttribute("data", hoaDon);
        List<NhanVien> listNV = this.nhanVienRepository.findAll();
        List<KhachHang> listKH = this.khachHangRepository.findAll();
        model.addAttribute("dataNV", listNV);
        model.addAttribute("dataKH", listKH);
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(HoaDon hoaDon){
        hoaDonRepository.update(hoaDon);
        return "redirect:/hoa-don/index";
    }
}
