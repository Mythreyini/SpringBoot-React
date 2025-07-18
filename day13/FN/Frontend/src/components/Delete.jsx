import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Delete = () => {
  const { empId } = useParams(); // ✅ Correct destructuring
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({});

  const token = localStorage.getItem('token');

  const authHeaders = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  };

  // Fetch employee details (optional, for display or validation)
  const fetchEmployeeById = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/employees/${empId}`, authHeaders);
      setEmployee(res.data);
    } catch (err) {
      console.error('Failed to fetch employee:', err);
    }
  };

  useEffect(() => {
    fetchEmployeeById();
  }, [empId]);

  const deleteEmployee = async () => {
    try {
      await axios.delete(`http://localhost:8080/id/${empId}`, authHeaders); 
      console.log('Employee deleted:', empId);
      alert('Employee deleted successfully!');
      navigate('/employee');
    } catch (error) {
      console.error('Delete error:', error);
      alert('Failed to delete employee. Check console for details.');
    }
  };

  return (
    <div style={{ padding: '30px' }}>
      <h2>Are you sure you want to delete this employee?</h2>
      <p><strong>Name:</strong> {employee.empName}</p>
      <p><strong>Email:</strong> {employee.email}</p>
      <button onClick={deleteEmployee} style={{ marginRight: '10px', backgroundColor: 'red', color: 'white', padding: '10px' }}>
        Yes, Delete
      </button>
      <button onClick={() => navigate('/employee')} style={{ padding: '10px' }}>
        Cancel
      </button>
    </div>
  );
};

export default Delete;
