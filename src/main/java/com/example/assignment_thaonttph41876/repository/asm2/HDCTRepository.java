package com.example.assignment_thaonttph41876.repository.asm2;

import com.example.assignment_thaonttph41876.entities.HDCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDCTRepository extends JpaRepository<HDCT, Integer> {
}
