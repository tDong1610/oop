import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import api from "../api/api";

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Lấy danh sách sinh viên từ API
    api.students.getAll().then((response) => setStudents(response.data));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this student?")) {
      api.students.delete(id).then(() => {
        setStudents(students.filter((student) => student.id !== id));
      });
    }
  };

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <h2>Student Management</h2>
        <button className="btn btn-primary mb-3">Add New Student</button>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Birth Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.birthDate}</td>
                <td>
                  <button className="btn btn-info btn-sm mx-1">Edit</button>
                  <button
                    className="btn btn-danger btn-sm mx-1"
                    onClick={() => handleDelete(student.id)}
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

export default StudentList;
