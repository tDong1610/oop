
package com.example.management.service;

import com.example.management.model.Course;
import com.example.management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setCourseName(courseDetails.getCourseName());
        course.setStartDate(courseDetails.getStartDate());
        course.setEndDate(courseDetails.getEndDate());
        course.setContent(courseDetails.getContent());
        return courseRepository.save(course);
    }
    public List<Course> getCoursesByYear(int year) {
        return courseRepository.findAllByStartDateYear(year);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
        
    }
}