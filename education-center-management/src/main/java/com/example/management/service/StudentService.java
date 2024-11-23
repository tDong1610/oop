package com.example.management.service;

import com.example.management.model.Student;
import com.example.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Lấy danh sách tất cả học sinh
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Lấy thông tin học sinh theo ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Tạo mới học sinh
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Cập nhật thông tin học sinh
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        student.setFullName(studentDetails.getFullName());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setHometown(studentDetails.getHometown());
        student.setPermanentAddress(studentDetails.getPermanentAddress());
        return studentRepository.save(student);
    }

    // Xóa học sinh
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Tìm kiếm học sinh theo tên
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByFullNameContainingIgnoreCase(name);
    }

    // Đếm số lượng học sinh theo quê quán
    public long countStudentsByHometown(String hometown) {
        return studentRepository.countByHometown(hometown);
    }
}
