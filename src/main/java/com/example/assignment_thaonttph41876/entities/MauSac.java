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
public class MauSac {
    private Integer id;
    @NotBlank
    private String ma;
    @NotBlank
    private String ten;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
