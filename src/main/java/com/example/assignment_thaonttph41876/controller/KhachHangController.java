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
    private final KhachHangRepository khachHangRepository;

    public KhachHangController() {
        this.khachHangRepository = new KhachHangRepository();
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("data") KhachHang khachHang) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KhachHang khachHang,
                        BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
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
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", required = false) String keyword) {
        List<KhachHang> khachHangs;

        if (keyword != null && !keyword.isEmpty()) {
            // Thực hiện tìm kiếm theo keyword
            khachHangs = khachHangRepository.findByPhoneNumber(keyword);
        } else {
            // Trả về toàn bộ danh sách nếu không có keyword
            khachHangs = khachHangRepository.findPaginated(page, size);
        }

        int totalItems = khachHangRepository.getTotalItems();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("data", khachHangs);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword); // Chuyển keyword vào view để hiển thị trong input search
        return "khach_hang/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        KhachHang khachHang = this.khachHangRepository.findById(id);
        model.addAttribute("data", khachHang);
        return "khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid KhachHang khachHang, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", khachHang);
            model.addAttribute("errors", errors);
            return "khach_hang/edit";
        }
        this.khachHangRepository.update(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("search")
    public String search(@RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "size", defaultValue = "5") int size,
                         Model model) {
        List<KhachHang> searchResults;

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            searchResults = khachHangRepository.findPaginatedByPhoneNumber(phoneNumber, page, size);
        } else {
            searchResults = khachHangRepository.findPaginated(page, size);
            phoneNumber = ""; // Đặt phoneNumber thành rỗng để hiển thị trên view
        }

        int totalItems = khachHangRepository.getTotalItems();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("data", searchResults);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("phoneNumber", phoneNumber); // Chuyển số điện thoại vào view để hiển thị trong input search
        return "khach_hang/index";
    }


}
