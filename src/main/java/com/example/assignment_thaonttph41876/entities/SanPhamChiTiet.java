package com.example.assignment_thaonttph41876.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank
    @Column(name = "MaSPCT")
    private String maSPCT;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdKichThuoc")
    private Integer idKichThuoc;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdSanPham")
    private Integer idSanPham;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdMauSac")
    private Integer idMauSac;
    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;
    @NotNull
    @Column(name = "DonGia")
    private double donGia;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;
}
