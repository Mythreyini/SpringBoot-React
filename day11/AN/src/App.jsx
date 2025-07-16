import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './components/Home'
import Login from './components/Login'
import Register from './components/Register'
import { BrowserRouter , Routes , Route } from 'react-router-dom'
import Dashboard from './components/Dashboard'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/" element = {<Home/>}/>
        <Route path = "/register" element = {<Register/>}/>
        <Route path = "/login" element = {<Login/>}/>
        <Route path = "/dashboard" element = {<Dashboard/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App