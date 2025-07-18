import React from 'react'
import Header from './Header'
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Footer from './Footer';

const Add = () => {
    const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roleName, setRoleName] = useState([]);

  const navigate = useNavigate();

  const availableRoles = ["USER", "ADMIN", "MODERATOR"];

  const handleRoleChange = (e) => {
    const selectedRole = e.target.value;
    if (e.target.checked) {
      setRoleName([...roleName, selectedRole]);
    } else {
      setRoleName(roleName.filter((role) => role !== selectedRole));
    }
  };

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/register",
        {
          name,
          email,
          password,
          userName,
          roleName,
        }
      );
      console.log(response);
      navigate("/employee");
      alert("User Added successfully Successfully");
    } catch (e) {
      console.log("Addtion error ", e);
      alert("Addtion error!!");
    }
  }

  return (
    <>
      <style>
      
        {`
          .register-container {
            width: 500px;
            margin: 50px auto;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 12px;
            background: #fff;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
            font-family: 'Segoe UI', sans-serif;
          }

          .register-container h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
          }

          .form-group {
            margin-bottom: 20px;
          }

          .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            color: #34495e;
            text-align: left;
          }

          .form-group input[type="text"],
          .form-group input[type="password"] {
            width: 95%;
            padding: 10px;
            border: 1px solid #bbb;
            border-radius: 6px;
            font-size: 14px;
            background-color: #f7f7f7;
            color:blue;
          }

          .checkbox-group {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
          }

          .checkbox-group input[type="checkbox"] {
            margin-right: 10px;
            width: 18px;
            height: 18px;
          }

          .checkbox-group label {
            font-weight: 500;
            color: #444;
          }

          button {
            width: 100%;
            padding: 12px;
            background-color: darkblue;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
          }

          button:hover {
            background-color: #4398d0ff;
          }
        `}
      
        `
      </style>

      <div className="register-container">
        <Header />
        <h1>Add User</h1>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="text"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="userName">Username:</label>
            <input
              type="text"
              id="userName"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
            />
          </div>

          <div className="form-group">
            <label>Select Roles:</label>
            {availableRoles.map((role) => (
              <div key={role} className="checkbox-group">
                <input
                  type="checkbox"
                  id={role}
                  value={role}
                  checked={roleName.includes(role)}
                  onChange={handleRoleChange}
                />
                <label htmlFor={role}>{role}</label>
              </div>
            ))}
          </div>

          <button type="submit">Add</button>
        </form>
        <Footer />
      </div>
    </>
  );
};


export default Add
