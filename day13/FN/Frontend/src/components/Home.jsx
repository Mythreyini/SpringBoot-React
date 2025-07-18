import React from "react";
import { Link, useNavigate } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
const Home = () => {
  

  return (
    <div>
        <div><Header/></div>
        <div className="home-container">
            <div className="home-left">
                <h1>Welcome to Employee Management System</h1>
                <p>
                    This is a simple application to manage employee records.
                    You can add, view, and manage employees easily.
                </p>
                
                <Footer />
            </div>
        </div>
     
    </div>
      
    )
};

export default Home;
