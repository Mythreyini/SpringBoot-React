import React from 'react'
import HeaderUser from './HeaderUser'
import Footer from './Footer'

const HomeUser = () => {
  return (
    <div>
        <div><HeaderUser/></div>
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
}

export default HomeUser
