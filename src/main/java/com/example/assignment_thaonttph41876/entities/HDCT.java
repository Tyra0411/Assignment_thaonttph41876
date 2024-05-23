package com.example.assignment_thaonttph41876.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HDCT {
    private Integer id;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int idHoaDon;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int idSPCT;
    @NotNull
    @Positive
    private int soLuong;
    @NotNull
    @Min(100000)
    private double donGia;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
