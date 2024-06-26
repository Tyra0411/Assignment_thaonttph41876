package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import com.example.assignment_thaonttph41876.repository.asm2.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

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
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }

//    @GetMapping("index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page,
//                        @RequestParam(name = "size", defaultValue = "5") int size,
//                        @RequestParam(name = "keyword", required = false) String keyword) {
//        List<NhanVien> nhanViens;
//        int totalItems;
//
//        if (keyword != null && !keyword.isEmpty()) {
//            List<NhanVien> searchResults = nhanVienRepository.searchByName(keyword);
//            totalItems = searchResults.size();
//            int totalPages = (int) Math.ceil((double) totalItems / size);
//            int start = (page - 1) * size;
//            int end = Math.min(start + size, totalItems);
//            nhanViens = searchResults.subList(start, end);
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("totalPages", totalPages);
//        } else {
//            List<NhanVien> allNhanViens = nhanVienRepository.findAll();
//            totalItems = allNhanViens.size();
//            int totalPages = (int) Math.ceil((double) totalItems / size);
//            int start = (page - 1) * size;
//            int end = Math.min(start + size, totalItems);
//            nhanViens = allNhanViens.subList(start, end);
//            model.addAttribute("totalPages", totalPages);
//        }
//
//        model.addAttribute("data", nhanViens);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalItems", totalItems);
//        return "nhan_vien/index";
//    }

    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhanVien> page = nhanVienRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "nhan_vien/index";
    }



    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")NhanVien nhanVien, Model model){
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid NhanVien nhanVien, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", nhanVien);
            model.addAttribute("errors", errors);
            return "nhan_vien/edit";
        }
        nhanVien.setId(id);
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }


    @GetMapping("search")
    public String search(HttpSession session,
                         @RequestParam(name = "page", defaultValue = "0") int pageNo,
                         @RequestParam(name = "size", defaultValue = "10") int pageSize,
                         @RequestParam(name = "keyword", required = false) String keyword,
                         Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhanVien> page;
        if (keyword != null && !keyword.isEmpty()) {
            page = nhanVienRepository.findByTenContainingIgnoreCase(keyword, pageable);
        } else {
            page = nhanVienRepository.findAll(pageable);
        }
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "nhan_vien/index";
    }

}
