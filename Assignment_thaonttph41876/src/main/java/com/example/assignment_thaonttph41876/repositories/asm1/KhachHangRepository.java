package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.KhachHang;
import com.example.assignment_thaonttph41876.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private List<KhachHang> ds;

    public KhachHangRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new KhachHang(1, "KH01", "Nguyen Van A", "0123456789", 1));
        this.ds.add(new KhachHang(2, "KH02", "Tran Thi B", "01987654321", 1));
    }

    public List<KhachHang> findAll() {
        return this.ds;
    }

    public void create(KhachHang khachHang) {
        khachHang.setId(this.ds.size()+1);
        this.ds.add(khachHang);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khachHang = this.ds.get(i);
            if (khachHang.getId() == id) {
                this.ds.remove(khachHang);
            }
        }
    }

    public KhachHang findById(int id) {
        KhachHang ketQua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khachHang = this.ds.get(i);
            if (khachHang.getId() == id) {
                ketQua = khachHang;
            }
        }
        return ketQua;
    }

    public void update(KhachHang khachHang) {
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh = this.ds.get(i);
            if (khachHang.getId() == kh.getId()) {
                this.ds.set(i, khachHang);
            }
        }
    }
}
