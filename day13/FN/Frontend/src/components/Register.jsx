// // Importing necessary hooks and libraries
// import { useState, useEffect } from "react";
// import { useNavigate } from "react-router-dom"; // For navigation after registration
// import axios from "axios"; // For making HTTP requests

// const Register = () => {
//   // State variables for storing form input values
//   const [name, setName] = useState("");              // For storing Name input
//   const [email, setEmail] = useState("");            // For storing Email input
//   const [password, setPassword] = useState("");      // For storing Password input
//   const [userName, setUserName] = useState("");      // For storing Username input
//   const [roleName, setRoleName] = useState([]);      // Array to hold selected roles
//   const [availableRoles, setAvailableRoles] = useState([]); // List of roles fetched from API

//   const navigate = useNavigate(); // To redirect user after successful registration

//   // useEffect runs once when the component is mounted
//   useEffect(() => {
//     // Async function to fetch available roles from backend
//     async function fetchRoles() {
//       try {
//         const response = await axios.get("https://springboot1-backend-1.onrender.com/api/auth/roles");
//         setAvailableRoles(response.data); // Set roles to state
//       } catch (error) {
//         console.error("Failed to fetch roles:", error); // Log error if request fails
//       }
//     }

//     fetchRoles(); // Call the function
//   }, []);

//   // Handler for checkbox change to select/deselect roles
//   const handleRoleChange = (e) => {
//     const selectedRole = e.target.value; // Get the selected role value
//     if (e.target.checked) {//e.target.checked → A boolean (true or false) that tells whether the checkbox is checked (selected) or not checked (unselected)
//       // If checked, add to roleName list
//       setRoleName([...roleName, selectedRole]);
//     } else {
//       // If unchecked, remove it from roleName list
//       setRoleName(roleName.filter((role) => role !== selectedRole));
//     }
//   };

//   // Submit handler for the form
//   async function handleSubmit(event) {
//     event.preventDefault(); // Prevent default form submission behavior
//     try {
//       // Send POST request to register the user
//       const response = await axios.post(
//         "https://springboot1-backend-1.onrender.com/api/auth/register",
//         {
//           name,
//           email,
//           password,
//           userName,
//           roleName,
//         }
//       );
//       console.log(response); // Log response (for debugging)
//       navigate("/dashboard"); // Redirect to dashboard page on success
//     } catch (e) {
//       console.log("Register error ", e); // Log error if registration fails
//       alert("Register error!!"); // Show error alert
//     }
//   }

//   // Return JSX for the Register form
//   return (
//     <>
//       {/* Embedded CSS styling for form */}
//       <style>
//         {`
//           .register-container {
//             max-width: 500px;
//             margin: 50px auto;
//             padding: 30px;
//             border: 1px solid #ddd;
//             border-radius: 12px;
//             background-color: #ffffff;
//             font-family: 'Segoe UI', sans-serif;
//             box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
//             color: #333;
//           }

//           .register-container h1 {
//             text-align: center;
//             color: #2c3e50;
//             margin-bottom: 30px;
//           }

//           .form-group {
//             margin-bottom: 20px;
//           }

//           .form-group label {
//             display: block;
//             margin-bottom: 8px;
//             font-weight: 600;
//             color: #2c3e50;
//           }

//           .form-group input[type="text"],
//           .form-group input[type="password"] {
//             width: 100%;
//             padding: 10px;
//             border: 1px solid #bbb;
//             border-radius: 6px;
//             font-size: 14px;
//             color: blue;
//             background-color: #f7f7f7;
//           }

//           .checkbox-group {
//             display: flex;
//             align-items: center;
//             margin-bottom: 10px;
//           }

//           .checkbox-group input[type="checkbox"] {
//             margin-right: 10px;
//             width: 18px;
//             height: 18px;
//           }

//           .checkbox-group label {
//             font-weight: 500;
//             color: #444;
//           }

//           button {
//             width: 100%;
//             padding: 12px;
//             background-color: #2980b9;
//             color: white;
//             font-size: 16px;
//             font-weight: bold;
//             border: none;
//             border-radius: 8px;
//             cursor: pointer;
//             transition: background-color 0.3s ease;
//           }

//           button:hover {
//             background-color: #2471a3;
//           }
//         `}
//       </style>

//       {/* Form container */}
//       <div className="register-container">
//         <h1>Register</h1>
//         <form onSubmit={handleSubmit}>
//           {/* Name Input */}
//           <div className="form-group">
//             <label htmlFor="name">Name:</label>
//             <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} />
//           </div>

//           {/* Email Input */}
//           <div className="form-group">
//             <label htmlFor="email">Email:</label>
//             <input type="text" id="email" value={email} onChange={(e) => setEmail(e.target.value)} />
//           </div>

//           {/* Password Input */}
//           <div className="form-group">
//             <label htmlFor="password">Password:</label>
//             <input type="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} />
//           </div>

//           {/* Username Input */}
//           <div className="form-group">
//             <label htmlFor="userName">Username:</label>
//             <input type="text" id="userName" value={userName} onChange={(e) => setUserName(e.target.value)} />
//           </div>

//           {/* Role Selection Checkboxes */}
//           <div className="form-group">
//             <label>Select Roles:</label>
//             {/* If roles are available, render checkboxes */}
//             {availableRoles.length > 0 ? (
//               availableRoles.map((role) => (
//                 <div key={role.roleId} className="checkbox-group">
//                   <input
//                     type="checkbox"
//                     id={role.roleName}
//                     value={role.roleName}
//                     checked={roleName.includes(role.roleName)} // Checked if selected
//                     onChange={handleRoleChange}
//                   />
//                   <label htmlFor={role.roleName}>{role.roleName}</label>
//                 </div>
//               ))
//             ) : (
//               <p>Loading roles...</p> // Show message while loading roles
//             )}
//           </div>

//           {/* Submit Button */}
//           <button type="submit">Register</button>
//         </form>
//       </div>
//     </>
//   );
// };

// // Export the Register component
// export default Register;

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roleName, setRoleName] = useState([]);

  const navigate = useNavigate();

  const availableRoles = ["USER", "ADMIN"];

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
      //navigate("/dashboard");
      navigate("/login"); // Redirect to login page after successful registration
      alert("Registered Successfully");
    } catch (e) {
      console.log("Register error ", e);
      alert("Register error!!");
    }
  }

  return (
    <>
      <style>
        {`
          .register-container {
            max-width: 1500px;
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
      </style>

      <div className="register-container">
        <h1>Register Form</h1>
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

          <button type="submit">Register</button>
        </form>
      </div>
    </>
  );
};

export default Register;
