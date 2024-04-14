import React, { useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import "./LoginForm.css";

function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate(); // Hook for navigation

  const handleLogin = async (event) => {
    event.preventDefault(); // Prevent the default form submission
    try {
      const response = await axios.get("http://localhost:8080/user/login", {
        params: {
          uname: username,
          psw: password,
        },
      });
      if (response.status === 200) {
        console.log("Login successful", response.data);
        // Redirect to control panel page
        navigate("/controlPanel");
      } else {
        setError("Invalid username or password");
      }
    } catch (error) {
      setError("Login failed. Please try again later.");
      console.error("Login error:", error);
    }
  };

  return (
    <div className="loginForm">
      <h2>Logg på eller lag en konto</h2>
      <form onSubmit={handleLogin}>
        <div className="container">
          <label htmlFor="uname">
            <b>Username</b>
          </label>
          <input
            type="text"
            placeholder="Enter Username"
            name="uname"
            required
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />

          <label htmlFor="psw">
            <b>Password</b>
          </label>
          <input
            type="password"
            placeholder="Enter Password"
            name="psw"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          <button type="submit">Logg inn</button>
          {error && <div style={{ color: "red" }}>{error}</div>}
        </div>

        <div className="container" style={{ backgroundColor: "#f1f1f1" }}>
          <span className="psw">Forgot password</span>
        </div>

        <p>
          Har du ikke en konto? <Link to="/registrer">Registrer deg her</Link>
        </p>
      </form>
    </div>
  );
}

export default LoginForm;
