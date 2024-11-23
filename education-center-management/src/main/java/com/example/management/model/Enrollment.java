package com.example.management.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course courseId;

    private String status;

    // Getters và setters

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return studentId;
    }

    public void setStudent(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourse() {
        return courseId;
    }

    public void setCourse(Course course) {
        this.courseId = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}