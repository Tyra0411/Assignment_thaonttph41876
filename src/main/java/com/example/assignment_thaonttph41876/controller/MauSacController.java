package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.MauSac;
import com.example.assignment_thaonttph41876.repository.asm2.MauSacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private MauSacRepository mauSacRepository;


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
        this.mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/index";
    }

//    @GetMapping("index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page,
//                        @RequestParam(name = "size", defaultValue = "5") int size,
//                        @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
//        List<MauSac> ds;
//        int totalItems;
//
//        if (!keyword.isEmpty()) {
//            ds = this.mauSacRepository.findByKeyword(keyword, page, size);
//            totalItems = this.mauSacRepository.getTotalItems(keyword);
//        } else {
//            ds = this.mauSacRepository.findPaginated(page, size);
//            totalItems = this.mauSacRepository.getTotalItems();
//        }
//
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", ds);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("keyword", keyword);
//        return "mau_sac/index";
//    }

    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<MauSac> page = mauSacRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "mau_sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac){
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model){
        model.addAttribute("data", mauSac);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid MauSac mauSac, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", mauSac);
            model.addAttribute("errors", errors);
            return "mau_sac/edit";
        }
        this.mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/index";
    }

//    @GetMapping("search")
//    public String search(@RequestParam(name = "name", required = false, defaultValue = "") String name,
//                         @RequestParam(name = "page", defaultValue = "1") int page,
//                         @RequestParam(name = "size", defaultValue = "5") int size,
//                         Model model) {
//        List<MauSac> searchResults;
//        int totalItems;
//
//        if (name.isEmpty()) {
//            // Nếu không nhập gì vào ô input tìm kiếm, trả về danh sách ban đầu
//            searchResults = mauSacRepository.findPaginated(page, size);
//            totalItems = mauSacRepository.getTotalItems();
//        } else {
//            // Thực hiện tìm kiếm theo tên
//            searchResults = mauSacRepository.findByName(name);
//            totalItems = mauSacRepository.getTotalSearchItems(name);
//        }
//
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", searchResults);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("name", name); // Chuyển tên màu sắc vào view để hiển thị trong input search
//        return "mau_sac/index";
//    }

}
