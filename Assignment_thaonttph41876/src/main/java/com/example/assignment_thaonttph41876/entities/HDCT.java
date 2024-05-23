package com.example.assignment_thaonttph41876.entities;

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
    private int idHoaDon;
    private int idSPCT;
    private int soLuong;
    private double donGia;
    private int trangThai;
}
