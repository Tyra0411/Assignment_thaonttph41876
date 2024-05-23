package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.MauSac;
import com.example.assignment_thaonttph41876.repositories.asm1.MauSacRepository;
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
@RequestMapping("mau-sac")
public class MauSacController {
    private MauSacRepository mauSacRepository;

    public MauSacController(){
        this.mauSacRepository = new MauSacRepository();
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") MauSac mauSac){
        return "mau_sac/create";
    }

    @PostMapping("store")
    public String store(Model model, @Valid MauSac mauSac, BindingResult validate){
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", mauSac);
            model.addAttribute("errors", errors);
            return "mau_sac/create";
        }
        this.mauSacRepository.create(mauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("index")
    public String index(Model model){
        List<MauSac> ds = this.mauSacRepository.findAll();
        model.addAttribute("data", ds);
        return "mau_sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model){
        MauSac mauSac = this.mauSacRepository.findById(id);
        model.addAttribute("data", mauSac);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(MauSac mauSac){
        this.mauSacRepository.update(mauSac);
        return "redirect:/mau-sac/index";
    }
}
