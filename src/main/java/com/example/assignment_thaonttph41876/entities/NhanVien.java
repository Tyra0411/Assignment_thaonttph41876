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
public class NhanVien {
    private Integer id;
    @NotBlank
    private String ten;
    @NotBlank
    private String maNV;
    @NotBlank
    private String tenDangNhap;
    @NotBlank
    private String matKhau;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
