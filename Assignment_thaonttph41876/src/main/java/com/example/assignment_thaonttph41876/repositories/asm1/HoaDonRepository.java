package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.HoaDon;
import com.example.assignment_thaonttph41876.entities.SanPham;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonRepository {
    private List<HoaDon> ds;

    public HoaDonRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new HoaDon(1, 1, 1, new Date(), 1));
        this.ds.add(new HoaDon(2, 1, 2, new Date(), 0));
        this.ds.add(new HoaDon(3, 3, 5, new Date(), 0));
        this.ds.add(new HoaDon(4, 2, 3, new Date(), 1));
        this.ds.add(new HoaDon(5, 4, 4, new Date(), 1));
    }

    public List<HoaDon> findAll(){
        return this.ds;
    }

    public void create(HoaDon hoaDon){
        hoaDon.setId(ds.size()+1);
        hoaDon.setNgayMuaHang(new Date());
        this.ds.add(hoaDon);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hoaDon = this.ds.get(i);
            if (hoaDon.getId()==id){
                this.ds.remove(hoaDon);
            }
        }
    }

    public HoaDon findById(int id){
        HoaDon ketQua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if(hd.getId()==id){
                ketQua = hd;
            }
        }
        return ketQua;
    }

//    public void update(HoaDon hoaDon){
//        for (int i = 0; i < this.ds.size(); i++) {
//            HoaDon hd = this.ds.get(i);
//            if(hd.getId()==hoaDon.getId()){
//                this.ds.set(i, hoaDon);
//            }
//        }
//    }

    public void update(HoaDon hoaDon) {
        for (HoaDon existingHoaDon : ds) {
            if (existingHoaDon.getId().equals(hoaDon.getId())) {
                // Update the necessary fields while preserving ngayMuaHang
                existingHoaDon.setIdNhanVien(hoaDon.getIdNhanVien());
                existingHoaDon.setIdKhachHang(hoaDon.getIdKhachHang());
                existingHoaDon.setTrangThai(hoaDon.getTrangThai());
                // ngayMuaHang is not set to preserve the original value
                break; // Exit the loop after updating the correct HoaDon
            }
        }
    }
}
