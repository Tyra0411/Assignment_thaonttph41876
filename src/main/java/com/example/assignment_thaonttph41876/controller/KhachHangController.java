package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.KhachHang;
import com.example.assignment_thaonttph41876.repository.asm2.KhachHangRepository;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khachHangRepository;


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
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    //    @GetMapping("/index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page,
//                        @RequestParam(name = "size", defaultValue = "5") int size,
//                        @RequestParam(name = "keyword", required = false) String keyword) {
//        List<KhachHang> khachHangs;
//
//        if (keyword != null && !keyword.isEmpty()) {
//            // Thực hiện tìm kiếm theo keyword
//            khachHangs = khachHangRepository.findByPhoneNumber(keyword);
//        } else {
//            // Trả về toàn bộ danh sách nếu không có keyword
//            khachHangs = khachHangRepository.findPaginated(page, size);
//        }
//
//        int totalItems = khachHangRepository.getTotalItems();
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", khachHangs);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("keyword", keyword); // Chuyển keyword vào view để hiển thị trong input search
//        return "khach_hang/index";
//    }
    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<KhachHang> page = khachHangRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "khach_hang/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") KhachHang khachHang, Model model) {
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
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

//    @GetMapping("search")
//    public String search(@RequestParam(name = "phoneNumber", required = false) String phoneNumber,
//                         @RequestParam(name = "page", defaultValue = "1") int page,
//                         @RequestParam(name = "size", defaultValue = "5") int size,
//                         Model model) {
//        List<KhachHang> searchResults;
//
//        if (phoneNumber != null && !phoneNumber.isEmpty()) {
//            searchResults = khachHangRepository.findPaginatedByPhoneNumber(phoneNumber, page, size);
//        } else {
//            searchResults = khachHangRepository.findPaginated(page, size);
//            phoneNumber = ""; // Đặt phoneNumber thành rỗng để hiển thị trên view
//        }
//
//        int totalItems = khachHangRepository.getTotalItems();
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", searchResults);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("phoneNumber", phoneNumber); // Chuyển số điện thoại vào view để hiển thị trong input search
//        return "khach_hang/index";
//    }


}
