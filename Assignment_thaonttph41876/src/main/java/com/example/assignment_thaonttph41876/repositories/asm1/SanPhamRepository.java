package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.controller.SanPhamController;
import com.example.assignment_thaonttph41876.entities.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamRepository {
    private List<SanPham> ds;

    public SanPhamRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new SanPham(1, "SP01", "Ao phong", 1));
        this.ds.add(new SanPham(2, "SP02", "Ao so mi", 1));
        this.ds.add(new SanPham(3, "SP03", "Ao khoac", 1));
        this.ds.add(new SanPham(4, "SP04", "Ao dai", 1));
        this.ds.add(new SanPham(5, "SP05", "Ao chong nang", 1));
        this.ds.add(new SanPham(6, "SP06", "Quan jeans", 1));
        this.ds.add(new SanPham(7, "SP07", "Ao thun nam", 1));
        this.ds.add(new SanPham(8, "SP08", "Vay dam nu", 1));
        this.ds.add(new SanPham(9, "SP09", "Giay sneakers", 1));
        this.ds.add(new SanPham(10, "SP10", "Tui xach da", 1));
    }

    public List<SanPham> findAll() {
        return this.ds;
    }

    public List<SanPham> findPaginated(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }

    public int getTotalItems() {
        return ds.size();
    }

    public void create(SanPham sanPham) {
        sanPham.setId(this.ds.size()+1);
        this.ds.add(sanPham);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sp = this.ds.get(i);
            if (sp.getId() == id) {
                this.ds.remove(sp);
            }
        }
    }

    public SanPham findById(int id) {
        SanPham ketQua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sanPham = this.ds.get(i);
            if (sanPham.getId() == id) {
                ketQua = sanPham;
            }
        }
        return ketQua;
    }

    public void update(SanPham sanPham) {
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sp = this.ds.get(i);
            if (sp.getId() == sanPham.getId()) {
                this.ds.set(i, sanPham);
            }
        }
    }

    public List<SanPham> searchByName(String keyword) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sp : ds) {
            if (sp.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public List<SanPham> searchByNamePaginated(String keyword, int page, int pageSize) {
        List<SanPham> searchResult = searchByName(keyword);
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, searchResult.size());
        return searchResult.subList(start, end);
    }

    public int getTotalSearchItems(String keyword) {
        return searchByName(keyword).size();
    }
}
