import React, { useState } from 'react';
import axios from 'axios';
import Header from './Header';
import Footer from './Footer';
import { Link } from 'react-router-dom';

const Employee = () => {
  const [employees, setEmployees] = useState([]);

  const handleGetEmployees = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.get("http://localhost:8080/api/auth");
      console.log("Employee data:", response.data);
      setEmployees(response.data);
      alert("Fetched employee list successfully!");
    } catch (e) {
      console.error("Error fetching employees", e);
      alert("Failed to fetch employee data");
    }
  };

  return (
    <div>
      <style>{`
        .employee-container {
          padding: 20px;
          color: blue;
          font-family: 'Segoe UI', sans-serif;
        }

        .employee-container h2 {
          margin-bottom: 20px;
          color: #2c3e50;
        }

        button {
          padding: 10px 20px;
          font-size: 16px;
          background-color: #2980b9;
          color: white;
          border: none;
          border-radius: 6px;
          cursor: pointer;
          margin-bottom: 20px;
        }

        button:hover {
          background-color: #2471a3;
        }

        table {
          color: white;
          background-color: #0a4c7aff;
          width: 100%;
          border-collapse: collapse;
          margin-top: 10px;
        }

        th, td {
          border: 1px solid #ccc;
          padding: 10px;
          text-align: left;
        }

        th {
          color: royalblue;
          background-color: #f2f2f2;
        }
      `}</style>

      <div className="header">
        <Header />
      </div>

      <div className="employee-container">
        <h2>Click to fetch Employee</h2>
        <button onClick={handleGetEmployees}>Get Employees</button>

        <table>
          <thead>
            <tr>
              <th>Employee ID</th>
              <th>Name</th>
              <th>Username</th>
              <th>Email</th>
              <th>Roles</th>
              {/* Optional: Uncomment if you add update/delete later */}
              {/* <th>Actions</th> */}
            </tr>
          </thead>
          <tbody>
            {employees.map((emp) => (
              <tr key={emp.empId}>
                <td>{emp.empId}</td>
                <td>{emp.empName}</td>
                <td>{emp.userName}</td>
                <td>{emp.email}</td>
                <td>
                  {emp.roles && emp.roles.length > 0
                    ? emp.roles.map((r) => r.roleName).join(", ")
                    : "N/A"}
                </td>
                {/* Optional Update button */}
                 <td><Link to={`/update/${emp.empId}`}>Update</Link></td> 
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Employee;
