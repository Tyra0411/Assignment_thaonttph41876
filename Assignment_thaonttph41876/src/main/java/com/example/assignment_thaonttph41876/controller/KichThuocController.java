package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.KichThuoc;
import com.example.assignment_thaonttph41876.repositories.asm1.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    private KichThuocRepository kichThuocRepository;

    public KichThuocController(){
        this.kichThuocRepository = new KichThuocRepository();
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data")KichThuoc kichThuoc){
        return "kich_thuoc/create";
    }

    @PostMapping("store")
    public String store(Model model, @Valid KichThuoc kichThuoc,
                        BindingResult validate){
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());

            }
            model.addAttribute("data", kichThuoc);
            model.addAttribute("errors", errors);
            return "kich_thuoc/create";
        }
        this.kichThuocRepository.create(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("index")
    public String index(Model model){
        List<KichThuoc> ds = this.kichThuocRepository.findAll();
        model.addAttribute("data", ds);
        return "kich_thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KichThuoc kichThuoc = this.kichThuocRepository.findById(id);
        model.addAttribute("data", kichThuoc);
        return "kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(KichThuoc kichThuoc){
        this.kichThuocRepository.update(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
}
