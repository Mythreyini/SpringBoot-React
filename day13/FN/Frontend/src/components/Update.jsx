import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';

const Update = () => {
  const { empId } = useParams();//take from url
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    empName: '',
    email: '',
    userName: '',
    password: '',
    roleName: ''
  });

  const token = localStorage.getItem('token');

  const authHeaders = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    },
  
  };

 
  const fetchEmployeeById = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/employees/${empId}`, authHeaders);
      setEmployee(res.data);
    } catch (err) {
      console.error(' Failed to fetch employee:', err);
    }
  };

  useEffect(() => {
    fetchEmployeeById();
  }, [empId,token]);//it starts when the value of empId and token changes i.e while clicking update button in the employee page

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({ ...employee, [name]: value });
  };

  const handleUpdate = async () => {
    try {
      await axios.put(`http://localhost:8080/employees/${empId}`, employee, authHeaders);
      console.log('Employee updated:', employee);
      alert('Employee updated successfully!');
      navigate('/employees');
    } catch (error) {
      console.error('Update error:', error);

    }
  };

  return (
    <div style={{ padding: '30px' }}>
      <Header />
      <h2>Update Employee: {empId}</h2>
      <div style={{ maxWidth: '600px', margin: '0 auto' }}>
        <label>Name:</label>
        <input
          type="text"
          name="empName"
          value={employee.empName}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
        />

        <label>Email:</label>
        <input
          type="email"
          name="email"
          value={employee.email}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
        />

        <label>Username:</label>
        <input
          type="text"
          name="userName"
          value={employee.userName}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
        />

        <label>Password:</label>
        <input
          type="password"
          name="password"
          value={employee.password}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
        />

        <label>Role Name:</label>
        <input
          type="text"
          name="roleName"
          value={employee.roleName}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px', marginBottom: '20px' }}
        />

        <button onClick={handleUpdate} style={{
          padding: '10px 20px',
          backgroundColor: '#2980b9',
          color: 'white',
          border: 'none',
          borderRadius: '6px',
          cursor: 'pointer'
        }}>
          Update Employee
        </button>
      </div>
      <Footer />
    </div>
  );
};

export default Update;
