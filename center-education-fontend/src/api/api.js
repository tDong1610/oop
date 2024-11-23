import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api";

const api = {
  students: {
    getAll: () => axios.get(`${API_BASE_URL}/students`),
    getById: (id) => axios.get(`${API_BASE_URL}/students/${id}`),
    create: (data) => axios.post(`${API_BASE_URL}/students`, data),
    update: (id, data) => axios.put(`${API_BASE_URL}/students/${id}`, data),
    delete: (id) => axios.delete(`${API_BASE_URL}/students/${id}`),
  },
  courses: {
    getAll: () => axios.get(`${API_BASE_URL}/courses`),
    getById: (id) => axios.get(`${API_BASE_URL}/courses/${id}`),
    create: (data) => axios.post(`${API_BASE_URL}/courses`, data),
    update: (id, data) => axios.put(`${API_BASE_URL}/courses/${id}`, data),
    delete: (id) => axios.delete(`${API_BASE_URL}/courses/${id}`),
  },
  certificates: {
    getAll: () => axios.get(`${API_BASE_URL}/certificates`),
    getById: (id) => axios.get(`${API_BASE_URL}/certificates/${id}`),
    create: (data) => axios.post(`${API_BASE_URL}/certificates`, data),
    update: (id, data) => axios.put(`${API_BASE_URL}/certificates/${id}`, data),
    delete: (id) => axios.delete(`${API_BASE_URL}/certificates/${id}`),
  },
  enrollments: {
    getAll: () => axios.get(`${API_BASE_URL}/enrollments`),
    getById: (id) => axios.get(`${API_BASE_URL}/enrollments/${id}`),
    create: (data) => axios.post(`${API_BASE_URL}/enrollments`, data),
    update: (id, data) => axios.put(`${API_BASE_URL}/enrollments/${id}`, data),
    delete: (id) => axios.delete(`${API_BASE_URL}/enrollments/${id}`),
  },
};

export default api;
