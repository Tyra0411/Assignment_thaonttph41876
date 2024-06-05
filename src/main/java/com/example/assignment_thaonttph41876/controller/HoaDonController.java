package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.*;
import com.example.assignment_thaonttph41876.entities.custom.HoadonCustom;
import com.example.assignment_thaonttph41876.repository.asm2.HoaDonRepository;
import com.example.assignment_thaonttph41876.repository.asm2.KhachHangRepository;
import com.example.assignment_thaonttph41876.repository.asm2.NhanVienRepository;
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
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;


//    @GetMapping("/create")
//    public String create(Model model,
//                         HoaDon hoaDon){
//        List<NhanVien> listNV = this.nhanVienRepository.findAll();
//        List<KhachHang> listKH = this.khachHangRepository.findAll();
//        model.addAttribute("data", hoaDon);
//        model.addAttribute("dataNV", listNV);
//        model.addAttribute("dataKH", listKH);
//        return "hoa_don/create";
//    }
//
//    @PostMapping("/store")
//    public String store(Model model,
//                        @Valid HoaDon hoaDon, BindingResult validate){
//        if (validate.hasErrors()){
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError e:validate.getFieldErrors()){
//                errors.put(e.getField(), e.getDefaultMessage());
//            }
//            model.addAttribute("data", hoaDon);
//            model.addAttribute("errors", errors);
//            return "hoa_don/create";
//        }
//        this.hoaDonRepository.create(hoaDon);
//        return "redirect:/hoa-don/index";
//    }

//    @GetMapping("/index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page) {
//        int pageSize = 5; // Số hóa đơn trên mỗi trang
//        List<HoaDon> list = this.hoaDonRepository.findAll();
//
//        // Tính tổng số trang
//        int totalPages = (int) Math.ceil((double) list.size() / pageSize);
//
//        // Tính chỉ số bắt đầu của trang hiện tại
//        int startIndex = (page - 1) * pageSize;
//
//        // Lấy một phần danh sách hóa đơn cho trang hiện tại
//        List<HoaDon> paginatedList = list.subList(startIndex, Math.min(startIndex + pageSize, list.size()));
//
//        model.addAttribute("data", paginatedList);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("currentPage", page);
//
//        return "hoa_don/index";
//    }

    @GetMapping("/index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<HoadonCustom> page = hoaDonRepository.findAllWithPropName(pageable);
        model.addAttribute("data", page); // Đổi thành page, không chỉ là content
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "hoa_don/index";
    }




//    @GetMapping("delete/{id}")
//    public String delete(@PathVariable("id")Integer id){
//        hoaDonRepository.deleteById(id);
//        return "redirect:/hoa-don/index";
//    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")HoaDon hoaDon, Model model){
        model.addAttribute("data", hoaDon);
        model.addAttribute("dataNV", nhanVienRepository.findAll());
        model.addAttribute("dataKH", khachHangRepository.findAll());
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid HoaDon hoaDon, BindingResult validate, Model model){
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", hoaDon);
            List<NhanVien> listNV = this.nhanVienRepository.findAll();
            List<KhachHang> listKH = this.khachHangRepository.findAll();
            model.addAttribute("dataNV", listNV);
            model.addAttribute("dataKH", listKH);
            model.addAttribute("errors", errors);
            return "hoa_don/edit";
        }
        this.hoaDonRepository.save(hoaDon);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "trangThai", required = false) Integer trangThai,
                         @RequestParam(name = "page", defaultValue = "0") int pageNo,
                         @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        Page<HoadonCustom> page;
        if (trangThai != null) {
            page = hoaDonRepository.findByTrangThai(trangThai, PageRequest.of(pageNo, pageSize));
        } else {
            page = hoaDonRepository.findAllWithPropName(PageRequest.of(pageNo, pageSize));
        }

        model.addAttribute("data", page);
        model.addAttribute("trangThai", trangThai); // Truyền trạng thái để hiển thị lại trong form search

        return "hoa_don/index";
    }




}
