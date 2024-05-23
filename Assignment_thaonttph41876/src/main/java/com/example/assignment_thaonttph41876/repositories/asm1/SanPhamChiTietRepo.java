package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietRepo {
    private List<SanPhamChiTiet> ds;

    public SanPhamChiTietRepo() {
        this.ds = new ArrayList<>();
        this.ds.add(new SanPhamChiTiet(1, "SPCT01", 1, 1, 1, 10, 150000, 1));
        this.ds.add(new SanPhamChiTiet(2, "SPCT02", 2, 1, 2, 10, 190000, 1));
        this.ds.add(new SanPhamChiTiet(3, "SPCT03", 1, 2, 2, 10, 130000, 1));
        this.ds.add(new SanPhamChiTiet(4, "SPCT04", 2, 2, 1, 10, 150000, 1));
        this.ds.add(new SanPhamChiTiet(5, "SPCT05", 2, 3, 2, 10, 110000, 1));
    }

    public List<SanPhamChiTiet> findAll() {
        return this.ds;
    }

    public void create(SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTiet.setId(this.ds.size() + 1);
        this.ds.add(sanPhamChiTiet);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet sanPhamChiTiet = this.ds.get(i);
            if (sanPhamChiTiet.getId() == id) {
                this.ds.remove(sanPhamChiTiet);
            }
        }
    }

    public List<SanPhamChiTiet> findBySPId(int idSP) {
        List<SanPhamChiTiet> ketQua = new ArrayList<>();
        for (SanPhamChiTiet spct : ds) {
            if (spct.getIdSanPham() == idSP) {
                ketQua.add(spct);
            }
        }
        return ketQua;
    }

    public void update(SanPhamChiTiet sanPhamChiTiet) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet spct = this.ds.get(i);
            if (spct.getId() == sanPhamChiTiet.getId()) {
                this.ds.set(i, spct);
            }
        }
    }

    public List<SanPhamChiTiet> findBySanPhamId(int idSanPham) {
        List<SanPhamChiTiet> ketQua = new ArrayList<>();
        for(SanPhamChiTiet spct : ds) {
            if(spct.getIdSanPham() == idSanPham) {
                ketQua.add(spct);
            }
        }
        return ketQua;
    }

}
