import React, { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import Footer from '../components/Footer';
import Header from '../components/Header';

const GetTask = () => {
  const { empId } = useParams();
  const [tasks, setTasks] = useState([]);

  const token = localStorage.getItem('token');

  const authHeaders = {
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  };

  useEffect(() => {
    fetchTasksByEmpId();
  }, [empId]);

  const fetchTasksByEmpId = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/task/employee/${empId}`, authHeaders);
      setTasks(response.data);
      console.log('Tasks fetched:', response.data);
    } catch (error) {                                               //23CS124
      console.error('Failed to fetch tasks:', error);
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <Header />
      <h1>Tasks for Employee ID: {empId}</h1>

      {tasks.length === 0 ? (
        <p>No tasks found.</p>
      ) : (
        tasks.map((task) => (
          <div
            key={task.taskId}
            style={{
              border: '1px solid #ccc',
              padding: '10px',
              marginBottom: '10px',
              borderRadius: '5px',
              backgroundColor: '#10054eff',
            }}
          >
            <h3>Title: {task.title}</h3>
            <p>Description: {task.description}</p>
            <p>Status: {task.status}</p>

            <Link to={`/updatetask/${task.taskId}`} style={{ marginRight: '10px' }}>
              Update Task
            </Link>
            <Link to={`/deletetask/${task.taskId}`} style={{ color: 'red' }}>
              Delete Task
            </Link>
            <Footer />
          </div>
        ))
      )}
    </div>
  );
};

export default GetTask;
