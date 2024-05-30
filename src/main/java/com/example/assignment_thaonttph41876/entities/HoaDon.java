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

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Component
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdNV")
    private int idNhanVien;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdKH")
    private int idKhachHang;
    @NotBlank
    @Column(name = "NgayMuaHang")
    private Date ngayMuaHang;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;
}
