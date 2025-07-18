import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Header from '../components/Header';
import Footer from '../components/Footer';

const CreateTask = () => {
  const { empId } = useParams(); // Extract empId from URL
  const navigate = useNavigate();
  const token = localStorage.getItem('token');

  const [task, setTask] = useState({
    title: '',
    description: '',                           
    status: '',
  });

  const authHeaders = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  };

  const handleChange = (e) => {
    setTask({ ...task, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newTask = {
      ...task,
      empId: parseInt(empId)  // Must match backend model (int)
    };

    try {
      await axios.post('http://localhost:8080/task', newTask, authHeaders);
      alert('Task created successfully!');
      navigate('/employee'); // Redirect after success
    } catch (error) {
      console.error('Error creating task:', error);
      alert('Failed to create task.');
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <Header />
      <h2>Create Task for Employee ID: {empId}</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title: </label>
          <input
            type="text"
            name="title"
            value={task.title}
            onChange={handleChange}
            required
          />
        </div>
        <br />
        <div>
          <label>Description: </label>
          <input
            type="text"
            name="description"
            value={task.description}
            onChange={handleChange}
            required
          />
        </div>
        <br />
        <div>
          <label>Status: </label>
          <select
            name="status"
            value={task.status}
            onChange={handleChange}
            required
          >
            <option value="">-- Select Status --</option>
            <option value="Yet to Start">Yet to Start</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
          </select>
        </div>
        <br />
        <button type="submit">Create Task</button>
      </form>
      <Footer />
    </div>
  );
};

export default CreateTask;
