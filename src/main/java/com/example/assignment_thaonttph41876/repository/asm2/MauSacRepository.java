package com.example.assignment_thaonttph41876.repository.asm2;

import com.example.assignment_thaonttph41876.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    Page<MauSac> findByTenContainingIgnoreCase(String keyword, Pageable pageable);

}
