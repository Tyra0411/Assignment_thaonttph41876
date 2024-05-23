package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class NhanVienRepository {
    private List<NhanVien> list;

    public NhanVienRepository(){
        list = new ArrayList<>();
        list.add(new NhanVien(1, "Nguyen Van An", "NV001", "annv1@gmail.com", "123456", 1));
        list.add(new NhanVien(2, "Nguyen Van Binh", "NV002", "binhnv1@gmail.com", "123456", 1));
        list.add(new NhanVien(3, "Tran Thi Chuc", "NV003", "chuctt1@gmail.com", "123456", 1));
        list.add(new NhanVien(4, "Nguyen Thi Ha", "NV004", "hant1@gmail.com", "123456", 0));
        list.add(new NhanVien(5, "Pham Van Duong", "NV005", "duongpv1@gmail.com", "123456", 1));
    }

    public List<NhanVien> findAll(){
        return list;
    }

    public void create(NhanVien nhanVien){
        nhanVien.setId(list.size()+1);
        list.add(nhanVien);
    }

    public void deleteById(int id){
        for (int i = 0; i < list.size(); i++) {
            NhanVien nhanVien = list.get(i);
            if (nhanVien.getId()==id){
                list.remove(nhanVien);
            }
        }
    }

    public NhanVien findById(int id){
        NhanVien ketQua = null;
        for (int i = 0; i < list.size(); i++) {
            NhanVien nhanVien = list.get(i);
            if (nhanVien.getId()==id){
                ketQua = nhanVien;
            }
        }
        return ketQua;
    }

    public void update(NhanVien nhanVien){
        for (int i = 0; i < list.size(); i++) {
            NhanVien nv = list.get(i);
            if(nhanVien.getId()==nv.getId()){
                list.set(i, nhanVien);
            }
        }
    }

    // Trong NhanVienRepository.java
    public NhanVien login(String tenDangNhap, String matKhau) {
        for (NhanVien nv : list) {
            if (nv.getTenDangNhap().equals(tenDangNhap) && nv.getMatKhau().equals(matKhau)) {
                return nv;
            }
        }
        return null;
    }

}
