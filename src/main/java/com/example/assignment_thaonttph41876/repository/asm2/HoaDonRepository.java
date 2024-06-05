package com.example.assignment_thaonttph41876.repository.asm2;

import com.example.assignment_thaonttph41876.entities.HoaDon;
import com.example.assignment_thaonttph41876.entities.custom.HoadonCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    @Query("SELECT new com.example.assignment_thaonttph41876.entities.custom.HoadonCustom (" +
            " hd.id, nv.ten, kh.ten, hd.ngayMuaHang, hd.trangThai)" +
            " FROM HoaDon hd" +
            " JOIN NhanVien nv ON nv.id = hd.idNhanVien" +
            " JOIN KhachHang kh ON kh.id = hd.idKhachHang"+
            " ORDER BY hd.id DESC"
    )
    public Page<HoadonCustom> findAllWithPropName(Pageable pageable);


    Page<HoadonCustom> findByTrangThai(Integer trangThai, Pageable pageable);

}

