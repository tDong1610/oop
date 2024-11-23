package com.example.management.repository;

import com.example.management.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Thống kê số lượng khóa học theo năm
    List<Course> findAllByStartDateYear(int year);
}
