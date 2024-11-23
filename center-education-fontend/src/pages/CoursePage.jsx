import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import api from "../api/api";

const CourseList = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Lấy danh sách khóa học từ API
    api.courses.getAll().then((response) => setCourses(response.data));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this course?")) {
      api.courses.delete(id).then(() => {
        setCourses(courses.filter((course) => course.id !== id));
      });
    }
  };

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <h2>Course Management</h2>
        <button className="btn btn-primary mb-3">Add New Course</button>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <tr key={course.id}>
                <td>{course.id}</td>
                <td>{course.title}</td>
                <td>{course.startDate}</td>
                <td>{course.endDate}</td>
                <td>
                  <button className="btn btn-info btn-sm mx-1">Edit</button>
                  <button
                    className="btn btn-danger btn-sm mx-1"
                    onClick={() => handleDelete(course.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default CourseList;
