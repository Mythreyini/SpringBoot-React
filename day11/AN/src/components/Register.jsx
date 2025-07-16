import { useState} from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Register = ()=>{

  const[name,setName] = useState("");
  const[email,setEmail] = useState("");
  const[password,setPassword] = useState("");
  const[userName,setUserName] = useState("");
  const[roleNames,setRoleNames] = useState("");

  const navigate = useNavigate()

  async function handleSubmit(event){
    event.preventDefault();
    try{

      const response = await axios.post("https://springboot1-backend-1.onrender.com/api/auth/register",{
        name ,
        email , 
        password , 
        userName , 
        roleNames : roleNames.split(',').map(role=>role.trim())
      });
      console.log(response);
      navigate("/dashboard")
    }
    catch(e){
      console.log("Register error " , e);
      alert("Register error!!");
    }
  }

  return(
    <>
      <div>
        <h1>Register Form</h1>
        <form onSubmit={handleSubmit}>

          <label htmlFor = "name"> Name : </label>
          <input type = "text" id = "name" value = {name} onChange = {(e)=>setName(e.target.value)}/>
          <br/><br/>
          <label htmlFor = "email">Email : </label>
          <input type = "text" id = "email" value = {email} onChange = {(e)=>setEmail(e.target.value)}/>
          <br/><br/>
          <label htmlFor = "password">Password : </label>
          <input type = "password" id = "password" value = {password} onChange = {(e)=>setPassword(e.target.value)}/>
          <br/><br/>
          <label htmlFor = "userName"> Username : </label>
          <input type = "text" id = "userName" value = {userName} onChange = {(e)=>setUserName(e.target.value)}/>
          <br/><br/>
          <label htmlFor = "roleNames"> RoleNames : </label>
          <input type = "text" id = "roleNames" value = {roleNames} onChange = {(e)=>setRoleNames(e.target.value)}/>
          <br/><br/>
          <button type = "submit" > Register</button>
        </form>
      </div>
    </>
  )
}

export default Register;