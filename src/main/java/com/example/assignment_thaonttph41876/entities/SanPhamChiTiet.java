package com.example.assignment_thaonttph41876.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private String maSPCT;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer idKichThuoc;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer idSanPham;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer idMauSac;
    @NotNull
    private int soLuong;
    @NotNull
    private double donGia;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
