package com.example.assignment_thaonttph41876.controller;

import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;
import com.example.assignment_thaonttph41876.repositories.asm1.SanPhamChiTietRepo;
import com.example.assignment_thaonttph41876.repositories.asm1.SanPhamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("spct")
public class SPCTController {
    private SanPhamRepository sanPhamRepository;
    private SanPhamChiTietRepo sanPhamChiTietRepo;

    public SPCTController(){
        sanPhamRepository = new SanPhamRepository();
        sanPhamChiTietRepo = new SanPhamChiTietRepo();
    }

    @GetMapping("index")
    public String index(@RequestParam(required = false)Integer idSanPham, Model model){
        List<SanPham> listSP = sanPhamRepository.findAll();
        model.addAttribute("dataSP", listSP);
        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepo.findAll();
        if(idSanPham != null && !idSanPham.describeConstable().isEmpty()) {
            try {
                listSPCT = this.sanPhamChiTietRepo.findBySanPhamId(idSanPham);
            }catch (NumberFormatException e) {
                listSPCT = this.sanPhamChiTietRepo.findAll();
            }
        }else {
            listSPCT = this.sanPhamChiTietRepo.findAll();
        }
        model.addAttribute("dataSPCT", listSPCT);
        return "spct/index";
    }

}
