import { Link } from "react-router-dom";
import React, { useState } from 'react';
import "./RegistrerForm.css";
import axios from 'axios';

function RegisterForm() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    async function save(event)
    
    {
        console.log("email:", email);
        console.log("password:",password);
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/user",
        {

                email: email,
                password: email

        });
          alert("Employee Registation Successfully");
          setEmail("");
          setPassword("");
        
        }
    catch(err)
        {
          alert("User Registation Failed");
        }

    }
    return (
        <div className="RegistrerForm">
           <h1>Please fill in this form to create an account</h1>
                <div className="container">
                    <label htmlFor="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" required 
                    value={email}
                    onChange={(event) =>
                    {
                        setEmail(event.target.value)
                    }}
                    />


                    <label htmlFor="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id="psw" required 
                      value={password}
                      onChange={(event) =>
                      {
                          setPassword(event.target.value)
                      }}
                    />

                    <label htmlFor="psw-repeat"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required />

                 
                    <p>By creating an account you agree to our Terms & Privacy</p>

                    <button type="submit" className="registerbtn" onClick={save}><Link to="/login">Register</Link></button>
                </div>
       

            <div className="container signin">
                <p>Already have an account? <Link to="/login">Sign in here</Link>.</p>
            </div>
        </div>
    );
}

export default RegisterForm;
