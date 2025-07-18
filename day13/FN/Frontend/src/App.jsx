import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './components/Login'
import Register from './components/Register'
import { BrowserRouter , Routes , Route } from 'react-router-dom'
import LandinPage from './components/LandingPage'
import Dashboard from './components/Dashboard'
import Home from './components/Home'
import Employee from './components/Employee'
import Add from './components/Add'
import Update from './components/Update'
import Delete from './components/Delete'
import Tasks from './Task/Tasks'
import CreateTask from './Task/CreateTask'
import DeleteTask from './Task/DeleteTask'
import UpdateTask from './Task/UpdateTask'
import GetTask from './Task/GetTask'

import Homeuser from './components/HomeUser'
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/" element = {<LandinPage/>}/>
        <Route path = "/register" element = {<Register/>}/>
        <Route path = "/login" element = {<Login/>}/>
        <Route path = "/dashboard" element = {<Dashboard/>}/>
       <Route path = "/home" element = {<Home/>}/>  
        <Route path="/employee" element={<Employee />} /> 
        <Route path="/add" element={<Add />} />
        <Route path="/homeuser" element={<Homeuser/>} />
        <Route path="/update/:empId" element={<Update />} />
<Route path="/delete/:empId" element={<Delete />} />
<Route path="/tasks/:empId" element={<Tasks />} />
<Route path="/createtask/:empId" element={<CreateTask />} />
<Route path="/deletetask/:taskId" element={<DeleteTask />} />
<Route path="/updatetask/:taskId" element={<UpdateTask />} />
<Route path="/gettask/:empId" element={<GetTask />} />

      
        {/* Add more routes as needed */}
      </Routes>
    </BrowserRouter>
  )
}

export default App
/*element- Route for that particular component with path 
on providing the path to the component on the browser it will render/display that component*/