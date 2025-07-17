import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';

const Update = () => {
  const { empId } = useParams();
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

  // Fetch employee by ID
  const fetchEmployeeById = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/employees/${empId}`, authHeaders);
      setEmployee(res.data);
    } catch (err) {
      console.error('❌ Failed to fetch employee:', err);

      if (err.response) {
        // Server responded with status code outside 2xx
        console.error('🔎 Response error status:', err.response.status);
        console.error('📄 Response data:', err.response.data);
        console.error('📬 Response headers:', err.response.headers);
        alert(`❗ Server error: ${err.response.status} - ${err.response.data?.message || 'Unknown error'}`);
      } else if (err.request) {
        // Request made but no response
        console.error('📡 No response received:', err.request);
        alert('❗ No response from server. Possible CORS issue or server down.');
      } else {
        // Other setup issue
        console.error('⚠️ Request setup error:', err.message);
        alert(`❗ Request error: ${err.message}`);
      }
    }
  };

  useEffect(() => {
    fetchEmployeeById();
  }, [empId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({ ...employee, [name]: value });
  };

  const handleUpdate = async () => {
    try {
      await axios.put(`http://localhost:8080/employees/${empId}`, employee, authHeaders);
      console.log('✅ Employee updated:', employee);
      alert('Employee updated successfully!');
      navigate('/employees');
    } catch (error) {
      console.error('❌ Update error:', error);

      if (error.response) {
        console.error('🔎 Error status:', error.response.status);
        console.error('📄 Error data:', error.response.data);
        alert(`❗ Update failed: ${error.response.status} - ${error.response.data?.message || 'Unknown error'}`);
      } else if (error.request) {
        console.error('📡 No response:', error.request);
        alert('❗ No response from server during update.');
      } else {
        console.error('⚠️ Request config error:', error.message);
        alert(`❗ Request error: ${error.message}`);
      }
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
