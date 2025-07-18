import React from 'react'
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';

const Tasks = () => {
    const { empId } = useParams(); // Assuming empId is passed as a URL parameter
  return (
    <div>
      <Header/>
      <h1>Tasks for Employee {empId}</h1>
       <Link to={`/createtask/${empId}`}> Create</Link>
       <Link to={`/gettask/${empId}`}> Explore</Link>
       <Footer />
    </div>
  )
}

export default Tasks
