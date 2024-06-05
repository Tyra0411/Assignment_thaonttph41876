package com.example.assignment_thaonttph41876.entities.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SpctCustom {
    @Id
    private Integer id;

    private String tenSP;
    private String tenMS;
    private String tenKT;
    private String maSPCT;
    private int soLuong;
    private double donGia;
    private int trangThai;
}