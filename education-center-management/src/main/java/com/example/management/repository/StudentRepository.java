package com.example.management.repository;

import com.example.management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Truy vấn tùy chỉnh để tìm học sinh theo tên
    List<Student> findByFullNameContainingIgnoreCase(String name);

    // Truy vấn tùy chỉnh để đếm số học sinh theo quê quán
    long countByHometown(String hometown);
}
