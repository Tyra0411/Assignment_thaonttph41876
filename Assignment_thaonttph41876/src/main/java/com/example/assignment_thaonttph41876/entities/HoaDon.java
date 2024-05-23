package com.example.assignment_thaonttph41876.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    private Integer id;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int idNhanVien;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int idKhachHang;
    private Date ngayMuaHang;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
