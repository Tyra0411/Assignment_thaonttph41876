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
public class KhachHang {
    private Integer id;
    @NotBlank
    private String maKH;
    @NotBlank
    private String ten;
    @NotBlank
    private String sdt;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
