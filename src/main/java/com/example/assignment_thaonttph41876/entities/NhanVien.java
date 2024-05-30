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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank
    @Column(name = "Ten")
    private String ten;
    @NotBlank
    @Column(name = "Ma")
    private String maNV;
    @NotBlank
    @Column(name = "TenDangNhap")
    private String tenDangNhap;
//    private String role;
//    public void setRole(String role) {
//        this.role = role;
//    }

    @NotBlank
    @Column(name = "MatKhau")
    private String matKhau;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;
}
