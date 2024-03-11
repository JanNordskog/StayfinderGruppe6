import { Link } from "react-router-dom";
import React from 'react';
import "./RegistrerForm.css";

function RegisterForm() {
    return (
        <div className="RegistrerForm">
           <h1>Please fill in this form to create an account</h1>
                <div className="container">
                    <label htmlFor="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" required />

                    <label htmlFor="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id="psw" required />

                    <label htmlFor="psw-repeat"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required />

                 
                    <p>By creating an account you agree to our Terms & Privacy</p>

                    <button type="submit" className="registerbtn"><Link to="/login">Register</Link></button>
                </div>
       

            <div className="container signin">
                <p>Already have an account? <Link to="/login">Sign in here</Link>.</p>
            </div>
        </div>
    );
}

export default RegisterForm;
