package com.example.assignment_thaonttph41876.repository.asm2;

import com.example.assignment_thaonttph41876.entities.SanPhamChiTiet;
import com.example.assignment_thaonttph41876.entities.custom.SpctCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet, Integer> {
    @Query("SELECT new com.example.assignment_thaonttph41876.entities.custom.SpctCustom(" +
            " spct.id, sp.ten, ms.ten, kt.ten, spct.maSPCT, " +
            " spct.soLuong, spct.donGia, spct.trangThai) " +
            " FROM SanPhamChiTiet spct" +
            " JOIN SanPham sp ON spct.idSP = sp.id" +
            " JOIN MauSac ms ON ms.id = spct.idMS" +
            " JOIN KichThuoc kt ON kt.id = spct.idKT" +
            " WHERE (:idSanPham IS NULL OR sp.id = :idSanPham)" +
            " ORDER BY spct.id DESC")
    Page<SpctCustom> findBySanPhamId(@Param("idSanPham") Integer idSanPham, Pageable pageable);

    @Query("SELECT new com.example.assignment_thaonttph41876.entities.custom.SpctCustom(" +
            " spct.id, sp.ten, ms.ten, kt.ten, spct.maSPCT, " +
            " spct.soLuong, spct.donGia, spct.trangThai) " +
            " FROM SanPhamChiTiet spct" +
            " JOIN SanPham sp ON spct.idSP = sp.id" +
            " JOIN MauSac ms ON ms.id = spct.idMS" +
            " JOIN KichThuoc kt ON kt.id = spct.idKT" +
            " ORDER BY spct.id DESC")
    Page<SpctCustom> findAllWithPropName(Pageable pageable);
}



