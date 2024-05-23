    package com.example.assignment_thaonttph41876.controller;

    import com.example.assignment_thaonttph41876.entities.KichThuoc;
    import com.example.assignment_thaonttph41876.entities.MauSac;
    import com.example.assignment_thaonttph41876.entities.SanPham;
    import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;
    import com.example.assignment_thaonttph41876.repositories.asm1.KichThuocRepository;
    import com.example.assignment_thaonttph41876.repositories.asm1.MauSacRepository;
    import com.example.assignment_thaonttph41876.repositories.asm1.SanPhamChiTietRepo;
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
        public String index(
                @RequestParam(required = false) Integer idSanPham,
                @RequestParam(required = false) Double minDonGia,
                @RequestParam(required = false) Double maxDonGia,
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "5") int pageSize, // Cập nhật kích thước trang mặc định là 5
                Model model) {

            List<SanPham> listSP = sanPhamRepository.findAll();
            model.addAttribute("dataSP", listSP);

            List<SanPhamChiTiet> listSPCT;
            int totalItems;

            if (idSanPham != null) {
                listSPCT = sanPhamChiTietRepo.findBySanPhamIdPaginated(idSanPham, page, pageSize);
                totalItems = sanPhamChiTietRepo.getTotalItemsBySanPhamId(idSanPham);
            } else if (minDonGia != null && maxDonGia != null) {
                // Implement search by price range with pagination if needed
                listSPCT = sanPhamChiTietRepo.findAll(); // Placeholder
                totalItems = listSPCT.size(); // Placeholder
            } else {
                listSPCT = sanPhamChiTietRepo.findPaginated(page, pageSize);
                totalItems = sanPhamChiTietRepo.getTotalItems();
            }

            model.addAttribute("dataSPCT", listSPCT);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalItems", totalItems);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", (int) Math.ceil((double) totalItems / pageSize));

            return "spct/index";
        }

        @GetMapping("create")
        public String create(Model model, SanPhamChiTiet sanPhamChiTiet){
            List<SanPham> listSP = sanPhamRepository.findAll();
            List<KichThuoc> listKT = kichThuocRepository.findAll();
            List<MauSac> listMS = mauSacRepository.findAll();
            model.addAttribute("dataSP", listSP);
            model.addAttribute("dataKT", listKT);
            model.addAttribute("dataMS", listMS);
            model.addAttribute("data", sanPhamChiTiet);

            return "spct/create";
        }

        @PostMapping("store")
        public String store(Model model, @Valid SanPhamChiTiet sanPhamChiTiet, BindingResult validate) {
            if(validate.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                for (FieldError e: validate.getFieldErrors()){
                    errors.put(e.getField(), e.getDefaultMessage());
                }
                model.addAttribute("data", sanPhamChiTiet);
                List<SanPham> listSP = sanPhamRepository.findAll();
                List<KichThuoc> listKT = kichThuocRepository.findAll();
                List<MauSac> listMS = mauSacRepository.findAll();
                model.addAttribute("dataSP", listSP);
                model.addAttribute("dataKT", listKT);
                model.addAttribute("dataMS", listMS);
                model.addAttribute("errors", errors);
                return "spct/create";
            };
            this.sanPhamChiTietRepo.create(sanPhamChiTiet);
            return "redirect:/spct/index";
        }

        @GetMapping("delete/{id}")
        public String delete(@PathVariable("id") Integer id) {
            this.sanPhamChiTietRepo.deleteById(id);
            return "redirect:/spct/index";
        }

        @GetMapping("edit/{id}")
        public String edit(@PathVariable("id") Integer id, Model model){
            SanPhamChiTiet sanPhamChiTiet = this.sanPhamChiTietRepo.findById(id);
            model.addAttribute("data", sanPhamChiTiet);
            List<SanPham> listSP = sanPhamRepository.findAll();
            List<KichThuoc> listKT = kichThuocRepository.findAll();
            List<MauSac> listMS = mauSacRepository.findAll();
            model.addAttribute("dataSP", listSP);
            model.addAttribute("dataKT", listKT);
            model.addAttribute("dataMS", listMS);
            return "spct/edit";
        }


        @PostMapping("update/{id}")
        public String update(@Valid SanPhamChiTiet sanPhamChiTiet, BindingResult validate, Model model){
            if(validate.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                for (FieldError e: validate.getFieldErrors()){
                    errors.put(e.getField(), e.getDefaultMessage());
                }
                model.addAttribute("data", sanPhamChiTiet);
                List<SanPham> listSP = sanPhamRepository.findAll();
                List<KichThuoc> listKT = kichThuocRepository.findAll();
                List<MauSac> listMS = mauSacRepository.findAll();
                model.addAttribute("dataSP", listSP);
                model.addAttribute("dataKT", listKT);
                model.addAttribute("dataMS", listMS);
                model.addAttribute("errors", errors);
                return "spct/edit";
            }
            this.sanPhamChiTietRepo.update(sanPhamChiTiet);
            return "redirect:/spct/index";
        }



    }
