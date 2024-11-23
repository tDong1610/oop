import React from "react";
import Navbar from "../components/Navbar";

const Home = () => {
  return (
    <>
      <Navbar />
      <div className="container mt-5 text-center">
        <h1>Welcome to the Management System</h1>
        <p>Select a category below to start managing data.</p>
        <div className="mt-4">
          <button className="btn btn-primary btn-lg mx-2">Manage Courses</button>
          <button className="btn btn-success btn-lg mx-2">Manage Students</button>
          <button className="btn btn-secondary btn-lg mx-2">Login</button>
        </div>
      </div>
    </>
  );
};

export default Home;
