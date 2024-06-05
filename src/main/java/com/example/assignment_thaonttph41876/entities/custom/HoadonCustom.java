package com.example.assignment_thaonttph41876.entities.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HoadonCustom {
    @Id
    private Integer id;
    private String tenNV;
    private String tenKH;
    private Date ngayMuaHang;
    private int trangThai;
}
