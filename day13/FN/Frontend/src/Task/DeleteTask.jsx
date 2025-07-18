import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Header from '../components/Header';
import Footer from '../components/Footer';

const DeleteTask = () => {
  const { taskId } = useParams();
  const navigate = useNavigate();
  const [task, setTask] = useState({});

  const token = localStorage.getItem('token');
  const authHeaders = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  };

  const fetchTaskById = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/task/tasks/${taskId}`, authHeaders);
      setTask(res.data);
    } catch (err) {
      console.error('Failed to fetch task:', err);
    }
  };

  useEffect(() => {             
    fetchTaskById();
  }, [taskId, token]); // ✅ FIXED

  const deleteTask = async () => {
    try {
      await axios.delete(`http://localhost:8080/task/task/${taskId}`, authHeaders);
      console.log('Task deleted:', taskId);
      alert('Task deleted successfully!');
      navigate('/employee');
    } catch (error) {
      console.error('Delete error:', error);
      alert('Failed to delete task. Check console for details.');
    }
  };

  return (
    <div style={{ padding: '30px' }}>
      <Header />
      <h2>Are you sure you want to delete this task?</h2>
      <h3>{task.title}</h3>
      <button
        onClick={deleteTask}
        style={{ marginRight: '10px', backgroundColor: 'red', color: 'white', padding: '10px' }}
      >
        Yes, Delete
      </button>
      <button onClick={() => navigate('/employee')} style={{ padding: '10px' }}>
        Cancel
      </button>
      <Footer />
    </div>
  );
};

export default DeleteTask;
