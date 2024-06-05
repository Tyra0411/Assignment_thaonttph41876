package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.KichThuoc;
import com.example.assignment_thaonttph41876.entities.MauSac;
import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;
import com.example.assignment_thaonttph41876.entities.custom.SpctCustom;
import com.example.assignment_thaonttph41876.repository.asm2.KichThuocRepository;
import com.example.assignment_thaonttph41876.repository.asm2.MauSacRepository;
import com.example.assignment_thaonttph41876.repository.asm2.SanPhamChiTietRepo;
import com.example.assignment_thaonttph41876.repository.asm2.SanPhamRepository;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("spct")
public class SPCTController {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;
    @Autowired
    private KichThuocRepository kichThuocRepository;
    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(required = false) Integer idSanPham,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SpctCustom> pageData;

        if (idSanPham != null && idSanPham > 0) {
            pageData = sanPhamChiTietRepo.findBySanPhamId(idSanPham, pageable);
        } else {
            pageData = sanPhamChiTietRepo.findAllWithPropName(pageable);
        }

        model.addAttribute("data", pageData.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageData.getTotalPages());
        model.addAttribute("dataSP", sanPhamRepository.findAll());
        model.addAttribute("idSanPham", idSanPham);

        return "spct/index";
    }


    @GetMapping("create")
    public String create(Model model) {
        List<KichThuoc> kichThuocList = kichThuocRepository.findAll().stream().limit(30).collect(Collectors.toList());
        List<MauSac> mauSacList = mauSacRepository.findAll().stream().limit(30).collect(Collectors.toList());
        List<SanPham> sanPhamList = sanPhamRepository.findAll().stream().limit(30).collect(Collectors.toList());
        model.addAttribute("dataSP", sanPhamList);
        model.addAttribute("dataKT", kichThuocList);
        model.addAttribute("dataMS", mauSacList);
        model.addAttribute("data", new SanPhamChiTiet());

        return "spct/create";
    }

    @PostMapping("store")
    public String store(Model model, @Valid SanPhamChiTiet sanPhamChiTiet, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }

            List<KichThuoc> kichThuocList = kichThuocRepository.findAll().stream().limit(30).collect(Collectors.toList());
            List<MauSac> mauSacList = mauSacRepository.findAll().stream().limit(30).collect(Collectors.toList());
            List<SanPham> sanPhamList = sanPhamRepository.findAll().stream().limit(30).collect(Collectors.toList());
            model.addAttribute("dataSP", sanPhamList);
            model.addAttribute("dataKT", kichThuocList);
            model.addAttribute("dataMS", mauSacList);

            model.addAttribute("data", sanPhamChiTiet);
            model.addAttribute("errors", errors);

            return "spct/create";
        }

        sanPhamChiTietRepo.save(sanPhamChiTiet);
        return "redirect:/spct/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.sanPhamChiTietRepo.deleteById(id);
        return "redirect:/spct/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPhamChiTiet sanPhamChiTiet, Model model) {

        List<KichThuoc> kichThuocList = kichThuocRepository.findAll().stream().limit(30).collect(Collectors.toList());
        List<MauSac> mauSacList = mauSacRepository.findAll().stream().limit(30).collect(Collectors.toList());
        List<SanPham> sanPhamList = sanPhamRepository.findAll().stream().limit(30).collect(Collectors.toList());
        model.addAttribute("dataSP", sanPhamList);
        model.addAttribute("dataKT", kichThuocList);
        model.addAttribute("dataMS", mauSacList);

        model.addAttribute("data", sanPhamChiTiet);

        return "spct/edit";
    }


    @PostMapping("update/{id}")
    public String update(@Valid SanPhamChiTiet sanPhamChiTiet, BindingResult validate, Model model) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }

            List<KichThuoc> kichThuocList = kichThuocRepository.findAll().stream().limit(30).collect(Collectors.toList());
            List<MauSac> mauSacList = mauSacRepository.findAll().stream().limit(30).collect(Collectors.toList());
            List<SanPham> sanPhamList = sanPhamRepository.findAll().stream().limit(30).collect(Collectors.toList());
            model.addAttribute("dataSP", sanPhamList);
            model.addAttribute("dataKT", kichThuocList);
            model.addAttribute("dataMS", mauSacList);

            model.addAttribute("data", sanPhamChiTiet);

            model.addAttribute("errors", errors);
            return "spct/edit";
        }
        this.sanPhamChiTietRepo.save(sanPhamChiTiet);
        return "redirect:/spct/index";
    }


}
