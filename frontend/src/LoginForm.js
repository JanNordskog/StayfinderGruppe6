import { Link } from "react-router-dom";
import React from 'react';
import "./LoginForm.css";

function LoginForm() {
    return (
        <div className="loginForm">
            <h2>Logg på eller lag en konto</h2>
            <form action="action_page.php" method="post">
                <div className="imgcontainer">
               
                </div>

                <div className="container">
                    <label htmlFor="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required />

                    <label htmlFor="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required />

                    <button type="submit">Logg inn</button>

             
                </div>

                <div className="container" style={{ backgroundColor: '#f1f1f1' }}>
              
                    <span className="psw">Forgot password</span>
                </div>

         
                <p>Har du ikke en konto? <Link to="/registrer">Registrer deg her</Link></p>
            </form>
        </div>
    );
}

export default LoginForm;