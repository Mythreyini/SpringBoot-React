import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import React from "react";

const Login = () => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function handleLogin(event) {
    event.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        userName,
        password,
      });

      const { token, roles } = response.data;
      console.log("Token:", token);
      console.log("Roles:", roles);

      localStorage.setItem("token", token);
      alert("Login Successful");

      if (roles.includes("ADMIN")) {
        navigate("/home");
      } else {
        navigate("/homeuser");
      }
    } catch (e) {
      console.log("Login Error", e);
      alert("Invalid Credentials");
    }
  }

  return (
    <div className="login-container">
      <style>{`
        .login-container {
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;
      border-radius: 10px;
          background-color: #f2f2f2;
          color:black;
          font-family: 'Segoe UI', sans-serif;
        }

        h2 {
          color: #2c3e50;
        }

        form {
          background: white;
          padding: 30px 40px;
          border-radius: 10px;
          box-shadow: 0 0 10px rgba(0,0,0,0.1);
          width: 300px;
        }

        label {
          display: block;
          margin-bottom: 8px;
          font-weight: bold;
          text-align: left;
        }

        input[type="text"],
        input[type="password"] {
          width: 100%;
          padding: 10px;
          margin-bottom: 20px;
          border: 1px solid #ccc;
          border-radius: 4px;
          font-size: 14px;
        }

        button {
          width: 70%;
          padding: 10px;
          background-color: #2c3e50;
          color: white;
          border: none;
          border-radius: 4px;
          font-size: 16px;
          cursor: pointer;
          align-self: center;
        }

        button:hover {
          background-color: #34495e;
        }
      `}</style>

      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <label htmlFor="userName">User Name</label>
        <input
          id="userName"
          name="userName"
          type="text"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />

        <label htmlFor="password">Password</label>
        <input
          id="password"
          name="password"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
