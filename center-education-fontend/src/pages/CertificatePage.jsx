import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import api from "../api/api";

const CertificateList = () => {
  const [certificates, setCertificates] = useState([]);

  useEffect(() => {
    // Lấy danh sách chứng chỉ từ API
    api.certificates.getAll().then((response) => setCertificates(response.data));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this certificate?")) {
      api.certificates.delete(id).then(() => {
        setCertificates(certificates.filter((cert) => cert.id !== id));
      });
    }
  };

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <h2>Certificate Management</h2>
        <button className="btn btn-primary mb-3">Add New Certificate</button>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Description</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {certificates.map((certificate) => (
              <tr key={certificate.id}>
                <td>{certificate.id}</td>
                <td>{certificate.title}</td>
                <td>{certificate.description}</td>
                <td>
                  <button className="btn btn-info btn-sm mx-1">Edit</button>
                  <button
                    className="btn btn-danger btn-sm mx-1"
                    onClick={() => handleDelete(certificate.id)}
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

export default CertificateList;
