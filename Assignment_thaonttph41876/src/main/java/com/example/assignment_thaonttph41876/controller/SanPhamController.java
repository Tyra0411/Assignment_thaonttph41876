package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.repositories.asm1.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

//    public SanPhamController() {
//        this.sanPhamRepository = new SanPhamRepository();
//    }

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
        this.sanPhamRepository.create(sanPham);
        return "redirect:/san-pham/index";
    }

//    @GetMapping("index")
//    public String index(Model model) {
//        List<SanPham> ds = this.sanPhamRepository.findAll();
//        model.addAttribute("data", ds);
//        return "san_pham/index";
//    }

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size) {
        List<SanPham> sanPhams = sanPhamRepository.findPaginated(page, size);
        int totalItems = sanPhamRepository.getTotalItems();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("data", sanPhams);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "san_pham/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPham sanPham = this.sanPhamRepository.findById(id);
        model.addAttribute("data", sanPham);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(SanPham sanPham){
        this.sanPhamRepository.update(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("search")
    public String search(@RequestParam(name = "keyword") String keyword,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "size", defaultValue = "5") int size,
                         Model model) {
        List<SanPham> searchResults = sanPhamRepository.searchByNamePaginated(keyword, page, size);
        int totalItems = sanPhamRepository.getTotalSearchItems(keyword);
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("data", searchResults);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword);
        return "san_pham/index";
    }
}
