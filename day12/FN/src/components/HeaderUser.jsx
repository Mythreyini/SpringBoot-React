import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Header = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    alert("Logged out successfully!");
    navigate("/");
  };
const UserEmployeeAlert = () => {
    alert("User Employee Page Cannot be accessed directly!");

    navigate("/homeuser");
  };
  return (
    <div className="header">
      <style>{`
        .header {
          width: 100%;
          background-color: #2c3e50;
          color: white;
          font-family: 'Segoe UI', sans-serif;
          position: fixed;
          top: 0;
          left: 0;
          z-index: 1000;
          height: 100px;
        }

        .navbar {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 15px 30px;
        }

        .navbar h2 {
          margin: 0;
          font-size: 24px;
        }

        .nav-links {
          display: flex;
          gap: 15px;
          align-items: center;
        }

        .nav-links a {
          color: white;
          text-decoration: none;
          font-weight: 500;
          padding: 8px 16px;
          border-radius: 5px;
          transition: background-color 0.3s;
        }

        .nav-links a:hover {
          background-color: #34495e;
        }

        .nav-links button {
          background-color: #e74c3c;
          color: white;
          border: none;
          padding: 8px 16px;
          font-weight: 500;
          border-radius: 5px;
          cursor: pointer;
          transition: background-color 0.3s;
        }

        .nav-links button:hover {
          background-color: #c0392b;
        }

        .home-content {
          margin-top: 90px; /* To avoid header overlap */
          padding: 40px 20px;
          text-align: center;
        }

        .home-content h1 {
          margin: 0;
          font-size: 2rem;
          color: #2c3e50;
        }

        @media (max-width: 768px) {
          .navbar {
            flex-direction: column;
            align-items: flex-start;
          }
          .nav-links {
            flex-direction: column;
            width: 100%;
            margin-top: 10px;
          }
        }
      `}</style>

      <div className="navbar">
        <h1>Employee Portal</h1>
        <div className="nav-links">
          <Link to="/add">Add</Link>
          <button onClick={UserEmployeeAlert}>Employee</button>
          <button onClick={handleLogout}>Logout</button>
        </div>
      </div>

      
    </div>
  );
};

export default Header;
