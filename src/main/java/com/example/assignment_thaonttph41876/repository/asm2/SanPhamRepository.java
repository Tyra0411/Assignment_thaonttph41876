package com.example.assignment_thaonttph41876.repository.asm2;

import com.example.assignment_thaonttph41876.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    Page<SanPham> findByTenContainingIgnoreCase(String keyword, Pageable pageable);
}
