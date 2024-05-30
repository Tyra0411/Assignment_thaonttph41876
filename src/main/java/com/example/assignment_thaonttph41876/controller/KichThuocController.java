package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.KichThuoc;
import com.example.assignment_thaonttph41876.repository.asm2.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository kichThuocRepository;


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
        this.kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }

//    @GetMapping("/index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page,
//                        @RequestParam(name = "size", defaultValue = "5") int size,
//                        @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
//        List<KichThuoc> ds;
//        int totalItems;
//
//        if (!keyword.isEmpty()) {
//            // Thực hiện tìm kiếm theo keyword
//            ds = this.kichThuocRepository.findByKeyword(keyword, page, size);
//            totalItems = this.kichThuocRepository.getTotalItems(keyword);
//        } else {
//            // Trả về danh sách kích thước ban đầu nếu keyword rỗng
//            ds = this.kichThuocRepository.findPaginated(page, size);
//            totalItems = this.kichThuocRepository.getTotalItems();
//        }
//
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", ds);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("keyword", keyword); // Chuyển keyword vào view để hiển thị trong input search
//        return "kich_thuoc/index";
//    }

    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<KichThuoc> page = kichThuocRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "kich_thuoc/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KichThuoc kichThuoc, Model model){
        model.addAttribute("data", kichThuoc);
        return "kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid KichThuoc kichThuoc, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kichThuoc);
            model.addAttribute("errors", errors);
            return "kich_thuoc/edit";
        }
        this.kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }

//    @GetMapping("search")
//    public String search(@RequestParam(name = "name", required = false, defaultValue = "") String name,
//                         @RequestParam(name = "page", defaultValue = "1") int page,
//                         @RequestParam(name = "size", defaultValue = "5") int size,
//                         Model model) {
//        List<KichThuoc> searchResults;
//        int totalItems;
//
//        if (name.isEmpty()) {
//            // Nếu không nhập gì vào ô input tìm kiếm, trả về danh sách ban đầu
//            searchResults = kichThuocRepository.findPaginated(page, size);
//            totalItems = kichThuocRepository.getTotalItems();
//        } else {
//            // Thực hiện tìm kiếm theo tên
//            searchResults = kichThuocRepository.findByName(name);
//            totalItems = kichThuocRepository.getTotalSearchItems(name);
//        }
//
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", searchResults);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("name", name); // Chuyển tên kích thước vào view để hiển thị trong input search
//        return "kich_thuoc/index";
//    }

}
