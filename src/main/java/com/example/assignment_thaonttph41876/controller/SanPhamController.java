package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.repository.asm2.SanPhamRepository;
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
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    //@Cotroller: lấy dữ liệu
    //@Component: chung
    //@Service: thực thi nghiệp vụ
    //@Repo: truy vấn vaò db
    private SanPhamRepository sanPhamRepository;

    @GetMapping("create")
    public String create(@ModelAttribute("data") SanPham sanPham) {
        return "san_pham/create";
    }

    @PostMapping("store")
    public String store(Model model, @Valid SanPham sanPham, BindingResult validate) {
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sanPham);
            model.addAttribute("errors", errors);
            return "san_pham/create";
        };
        this.sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/index";
    }


//    @GetMapping("index")
////    public String index(Model model,
////                        @RequestParam(name = "page", defaultValue = "1") int page,
////                        @RequestParam(name = "size", defaultValue = "5") int size) {
////        List<SanPham> sanPhams = sanPhamRepository.findPaginated(page, size);
////        int totalItems = sanPhamRepository.getTotalItems();
////        int totalPages = (int) Math.ceil((double) totalItems / size);
////
////        model.addAttribute("data", sanPhams);
////        model.addAttribute("currentPage", page);
////        model.addAttribute("totalPages", totalPages);
////        return "san_pham/index";
////    }

    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SanPham> page = sanPhamRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "san_pham/index";
    }



    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model){
        model.addAttribute("data", sanPham);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid SanPham sanPham, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sanPham);
            model.addAttribute("errors", errors);
            return "san_pham/edit";
        }
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/index";
    }
    @GetMapping("search")
    public String search(HttpSession session,
                         @RequestParam(name = "page", defaultValue = "0") int pageNo,
                         @RequestParam(name = "size", defaultValue = "10") int pageSize,
                         @RequestParam(name = "keyword", required = false) String keyword,
                         Model model) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SanPham> page;
        if (keyword != null && !keyword.isEmpty()) {
            page = sanPhamRepository.findByTenContainingIgnoreCase(keyword, pageable);
        } else {
            page = sanPhamRepository.findAll(pageable);
        }
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "san_pham/index";
    }


}
