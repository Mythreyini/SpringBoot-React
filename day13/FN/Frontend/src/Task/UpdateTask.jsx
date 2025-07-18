import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Footer from '../components/Footer';
import Header from '../components/Header';
const UpdateTask = () => {
  const { taskId } = useParams(); // Extract taskId from URL
  const navigate = useNavigate();

  const token = localStorage.getItem('token');
  const authHeaders = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  };

  const [task, setTask] = useState({
    title: '',
    description: '',
    status: ''
  });

  useEffect(() => {
    fetchTaskById();
  }, [taskId]); // token doesn't need to be in dependency

  const fetchTaskById = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/task/tasks/${taskId}`, authHeaders);
      console.log(response.data);
      setTask(response.data);
    } catch (error) {
      console.error('Error fetching task:', error);
      alert('Error fetching task details.');
    }
  };

  const handleUpdateTask = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/task/${taskId}`, task, authHeaders);
      alert('Task updated successfully!');
      navigate(`/tasks/${task.empId}`); // Or redirect as needed
    } catch (error) {
      console.error('Error updating task:', error);
      alert('Failed to update task.');
    }
  };

  return (
    <div>
      <h2>Update Task</h2>
      <Header />
      <form onSubmit={handleUpdateTask}>
        <label>Task Title:</label><br />
        <input
          type="text"
          value={task.title}
          onChange={(e) => setTask({ ...task, title: e.target.value })}
        /><br />
        
        <label>Task Description:</label><br />
        <input
          type='text'
          value={task.description}
          onChange={(e) => setTask({ ...task, description: e.target.value })}
        /><br />

        <label>Task Status:</label><br />
        <input
          type='text'
          value={task.status}
          onChange={(e) => setTask({ ...task, status: e.target.value })}
        /><br />

        <button type='submit'>Update Task</button>
      </form>
      <Footer />
    </div>
  );
};

export default UpdateTask;
