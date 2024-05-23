package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.NhanVien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        list.add(new NhanVien(6, "Tran Van Cuong", "NV006", "cuongtv1@gmail.com", "123456", 1));
        list.add(new NhanVien(7, "Le Thi Kim", "NV007", "kimlt1@gmail.com", "123456", 1));
        list.add(new NhanVien(8, "Hoang Minh Duc", "NV008", "duchm1@gmail.com", "123456", 1));
        list.add(new NhanVien(9, "Do Thi Thanh", "NV009", "thanhdt1@gmail.com", "123456", 1));
        list.add(new NhanVien(10, "Tran Van Luong", "NV010", "luongtv1@gmail.com", "123456", 1));
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

    public List<NhanVien> searchByName(String keyword) {
        List<NhanVien> result = new ArrayList<>();
        for (NhanVien nv : list) {
            if (nv.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public List<NhanVien> searchByNamePaginated(String keyword, int page, int pageSize) {
        List<NhanVien> searchResult = searchByName(keyword);
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, searchResult.size());
        return searchResult.subList(start, end);
    }

    public int getTotalSearchItems(String keyword) {
        return searchByName(keyword).size();
    }

    public int getTotalItems() {
        return list.size();
    }


}
