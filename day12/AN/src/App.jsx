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
        <Route path="/update/:id" element={<Update />} />
        {/* Add more routes as needed */}
      </Routes>
    </BrowserRouter>
  )
}

export default App
/*element- Route for that particular component with path 
on providing the path to the component on the browser it will render/display that component*/