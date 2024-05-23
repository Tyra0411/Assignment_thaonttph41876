package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.SanPham;
import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SanPhamChiTietRepo {
    private List<SanPhamChiTiet> ds;

    public SanPhamChiTietRepo() {
        this.ds = new ArrayList<>();
        this.ds.add(new SanPhamChiTiet(1, "SPCT01", 1, 1, 1, 10, 150000, 1));
        this.ds.add(new SanPhamChiTiet(2, "SPCT02", 2, 1, 2, 10, 190000, 1));
        this.ds.add(new SanPhamChiTiet(3, "SPCT03", 1, 2, 2, 10, 130000, 1));
        this.ds.add(new SanPhamChiTiet(4, "SPCT04", 2, 2, 1, 10, 150000, 1));
        this.ds.add(new SanPhamChiTiet(5, "SPCT05", 2, 3, 2, 10, 110000, 1));
        this.ds.add(new SanPhamChiTiet(6, "SPCT06", 3, 3, 3, 10, 120000, 1));
        this.ds.add(new SanPhamChiTiet(7, "SPCT07", 4, 4, 4, 10, 100000, 1));
        this.ds.add(new SanPhamChiTiet(8, "SPCT08", 5, 5, 5, 10, 160000, 1));
        this.ds.add(new SanPhamChiTiet(9, "SPCT09", 6, 6, 6, 10, 170000, 1));
        this.ds.add(new SanPhamChiTiet(10, "SPCT10", 7, 7, 7, 10, 180000, 1));
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

    public SanPhamChiTiet findById(int id) {
        return this.ds.stream().filter(sanPhamChiTiet -> sanPhamChiTiet.getId() == id).findFirst().orElse(null);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet) {
        for (int i = 0; i < this.ds.size(); i++) {
            if (this.ds.get(i).getId() == sanPhamChiTiet.getId()) {
                this.ds.set(i, sanPhamChiTiet);
                break;
            }
        }
    }

    public List<SanPhamChiTiet> findBySanPhamIdPaginated(int idSanPham, int page, int pageSize) {
        List<SanPhamChiTiet> ketQua = new ArrayList<>();
        for (SanPhamChiTiet spct : ds) {
            if (spct.getIdSanPham() == idSanPham) {
                ketQua.add(spct);
            }
        }
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ketQua.size());
        return ketQua.subList(start, end);
    }

    public int getTotalItemsBySanPhamId(int idSanPham) {
        int totalItems = 0;
        for (SanPhamChiTiet spct : ds) {
            if (spct.getIdSanPham() == idSanPham) {
                totalItems++;
            }
        }
        return totalItems;
    }

    public List<SanPhamChiTiet> findPaginated(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }

    public int getTotalItems() {
        return ds.size();
    }

}
