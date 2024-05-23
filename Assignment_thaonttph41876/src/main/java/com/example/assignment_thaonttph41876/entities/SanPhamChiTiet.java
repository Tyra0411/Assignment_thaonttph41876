package com.example.assignment_thaonttph41876.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTiet {
    private Integer id;
    private String maSPCT;
    private Integer idKichThuoc;
    private Integer idSanPham;
    private Integer idMauSac;
    private int soLuong;
    private double donGia;
    private int trangThai;
}
