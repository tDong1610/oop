package com.example.management.repository;

import com.example.management.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    // Lấy danh sách chứng chỉ theo trạng thái
    List<Certificate> findAllByStatus(String status);
}
