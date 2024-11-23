import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import api from "../api/api";

const EnrollmentList = () => {
  const [enrollments, setEnrollments] = useState([]);

  useEffect(() => {
    // Lấy danh sách ghi danh từ API
    api.enrollments.getAll().then((response) => setEnrollments(response.data));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this enrollment?")) {
      api.enrollments.delete(id).then(() => {
        setEnrollments(enrollments.filter((enroll) => enroll.id !== id));
      });
    }
  };

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <h2>Enrollment Management</h2>
        <button className="btn btn-primary mb-3">Add New Enrollment</button>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Student ID</th>
              <th>Course ID</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {enrollments.map((enrollment) => (
              <tr key={enrollment.id}>
                <td>{enrollment.id}</td>
                <td>{enrollment.studentId}</td>
                <td>{enrollment.courseId}</td>
                <td>
                  <button className="btn btn-info btn-sm mx-1">Edit</button>
                  <button
                    className="btn btn-danger btn-sm mx-1"
                    onClick={() => handleDelete(enrollment.id)}
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

export default EnrollmentList;
