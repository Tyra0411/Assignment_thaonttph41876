package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.KhachHang;
import com.example.assignment_thaonttph41876.entities.SanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KhachHangRepository {
    private List<KhachHang> ds;

    public KhachHangRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new KhachHang(1, "KH01", "Nguyen Van An", "0123456789", 1));
        this.ds.add(new KhachHang(2, "KH02", "Tran Thi Binh", "01987654321", 1));
        this.ds.add(new KhachHang(3, "KH03", "Le Van Cuong", "0365987412", 1));
        this.ds.add(new KhachHang(4, "KH04", "Hoang Thi Dung", "0945671238", 1));
        this.ds.add(new KhachHang(5, "KH05", "Pham Van Quoc", "0789456123", 1));
        this.ds.add(new KhachHang(6, "KH06", "Truong Thi Ha", "0654321897", 1));
        this.ds.add(new KhachHang(7, "KH07", "Le Van Giang", "0356897412", 1));
        this.ds.add(new KhachHang(8, "KH08", "Nguyen Thi Hoa", "0987456321", 1));
        this.ds.add(new KhachHang(9, "KH09", "Hoang Van Khoa", "0978563412", 1));
        this.ds.add(new KhachHang(10, "KH10", "Tran Van Khai", "0864213579", 1));
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

    // Trong KhachHangRepository.java
    public List<KhachHang> findByPhoneNumber(String phoneNumber) {
        return this.ds.stream()
                .filter(khachHang -> khachHang.getSdt().equals(phoneNumber))
                .collect(Collectors.toList());
    }

    public List<KhachHang> findPaginatedByPhoneNumber(String phoneNumber, int page, int size) {
        List<KhachHang> result = findByPhoneNumber(phoneNumber);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, result.size());
        return result.subList(startIndex, endIndex);
    }
    // Trong KhachHangRepository.java

    public List<KhachHang> findPaginated(int page, int size) {
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, ds.size());
        return ds.subList(startIndex, endIndex);
    }

    public int getTotalItems() {
        return ds.size();
    }


    public int getTotalSearchItems(String phoneNumber) {
        return (int) ds.stream()
                .filter(khachHang -> khachHang.getSdt().equals(phoneNumber))
                .count();
    }


}
