package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.*;
import com.example.assignment_thaonttph41876.repository.asm2.HDCTRepository;
import com.example.assignment_thaonttph41876.repository.asm2.HoaDonRepository;
import com.example.assignment_thaonttph41876.repository.asm2.SanPhamChiTietRepo;
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
@RequestMapping("hdct")
public class HDCTController {
    @Autowired
    private HDCTRepository hdctRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;

//    @GetMapping("create")
//    public String create(@ModelAttribute("data") HDCT hdct, Model model) {
//        List<HoaDon> listHD = hoaDonRepository.findAll();
//        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepo.findAll();
//        model.addAttribute("dataHD", listHD);
//        model.addAttribute("dataSPCT", listSPCT);
//        return "hdct/create";
//    }
//
//    @PostMapping("store")
//    public String store(Model model, @Valid HDCT hdct, BindingResult validate) {
//        if (validate.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError e : validate.getFieldErrors()) {
//                errors.put(e.getField(), e.getDefaultMessage());
//            }
//            model.addAttribute("data", hdct);
//            model.addAttribute("errors", errors);
//            List<HoaDon> listHD = hoaDonRepository.findAll();
//            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepo.findAll();
//            model.addAttribute("dataHD", listHD);
//            model.addAttribute("dataSPCT", listSPCT);
//            return "hdct/create";
//        }
//        this.hdctRepository.create(hdct);
//        return "redirect:/hdct/index";
//    }

//    @GetMapping("index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "1") int page,
//                        @RequestParam(name = "size", defaultValue = "5") int size,
//                        @RequestParam(name = "idHoaDon", required = false) Integer idHoaDon) {
//        if (idHoaDon != null && idHoaDon <= 0) {
//            idHoaDon = null;
//        }
//        List<HDCT> hdcts = (idHoaDon == null)
//                ? hdctRepository.findPaginated(page, size)
//                : hdctRepository.findByHoaDonIdPaginated(idHoaDon, page, size);
//
//        int totalItems = (idHoaDon == null)
//                ? hdctRepository.getTotalItems()
//                : hdctRepository.getTotalItemsByHoaDonId(idHoaDon);
//
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("data", hdcts);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("idHoaDon", idHoaDon);
//        return "hdct/index";
//    }

    @GetMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int pageNo,
                        @RequestParam(name = "size", defaultValue = "10") int pageSize,
                        Model model) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<HDCT> page = hdctRepository.findAll(pageable);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        return "hdct/index";
    }


//    @GetMapping("delete/{id}")
//    public String delete(@PathVariable("id") Integer id) {
//        this.hdctRepository.deleteById(id);
//        return "redirect:/hdct/index";
//    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") HDCT hdct, Model model) {
        model.addAttribute("data", hdct);
        List<HoaDon> listHD = hoaDonRepository.findAll();
        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepo.findAll();
        model.addAttribute("dataHD", listHD);
        model.addAttribute("dataSPCT", listSPCT);
        return "hdct/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid HDCT hdct, BindingResult validate, Model model){
        if(validate.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", hdct);
            List<HoaDon> listHD = hoaDonRepository.findAll();
            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepo.findAll();
            model.addAttribute("dataHD", listHD);
            model.addAttribute("dataSPCT", listSPCT);
            model.addAttribute("errors", errors);
            return "hdct/edit";
        }
        this.hdctRepository.save(hdct);
        return "redirect:/hdct/index";
    }
}
