package com.example.management.model;

import jakarta.persistence.*;

@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificateId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course courseId;

    private String status;

    // Getters và setters

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Student getStudent() {
        return studentId;
    }

    public void setStudent(Student student) {
        this.studentId = student;
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
