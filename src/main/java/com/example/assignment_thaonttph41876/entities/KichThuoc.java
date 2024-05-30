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
@Entity
@Table
@Component
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank
    @Column(name = "Ma")
    private String ma;
    @NotBlank
    @Column(name = "Ten")
    private String ten;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;
}
