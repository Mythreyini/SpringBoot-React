import { useNavigate } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import './LandingPage.css';

const Home = ()=>{

    const navigate = useNavigate()

    return(
        <>
        <h1></h1>
            <div className = "home-container">
                <h1>Welcome to Employee Management System</h1>
                    
                </div>
                    <div className = "body-container">
                        <h2>Select an Option</h2>
                        <div className = "button-group">
                            <button onClick = {()=>navigate('/register')}>
                                Register
                            </button>
                            <button onClick = {()=>navigate('/login')}>
                                Login
                            </button>
                        </div>
                    </div>
                <div className = "footer">
                    <Footer/>
                
            </div>
        </>
    );
};

export default Home;