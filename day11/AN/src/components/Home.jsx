import { useNavigate } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import './Home.css';

const Home = ()=>{

    const navigate = useNavigate()

    return(
        <>
            <div className = "home-container">
                <div className = "header">
                    <Header/>
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
            </div>
        </>
    );
};

export default Home;