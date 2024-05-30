package com.example.assignment_thaonttph41876.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "HoaDonChiTiet")
@Component
public class HDCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "IdHoaDon")
    private int idHoaDon;
    @NotNull
    @Column(name = "IdSPCT")
    @Digits(integer = 1, fraction = 0)
    private int idSPCT;
    @NotNull
    @Positive
    @Column(name = "SoLuong")
    private int soLuong;
    @NotNull
    @Min(100000)
    @Column(name = "DonGia")
    private double donGia;
    @NotBlank
    @Column(name = "ThoiGian")
    private Date thoiGian;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;
}
