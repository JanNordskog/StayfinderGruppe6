import { Link } from "react-router-dom";
import React, { useState } from "react";
import "./RegistrerForm.css";
import axios from "axios";

function RegisterForm() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rpassword, setRpassword] = useState("");
  const [address, setAddress] = useState("");
  const [gender, setGender] = useState("");
  const [phone, setPhone] = useState("");
  const [dob, setDob] = useState("");

  async function save(event) {
    console.log("email:", email);
    console.log("password:", password);
    console.log("address:", address);
    console.log("gender:", gender);
    console.log("phone:", phone);
    console.log("dob:", dob);
    event.preventDefault();

    if (
      !email ||
      !password ||
      !rpassword ||
      !address ||
      !gender ||
      !phone ||
      !dob
    ) {
      alert("Please fill out all fields!");
      return;
    }

    if (password !== rpassword) {
      alert("Passwords do not match!");
      return;
    }
    try {
      await axios.post("http://localhost:8080/user", {
        email: email,
        password: password,
        address: address,
        gender: gender,
        phone: phone,
        dob: dob,
      });
      alert("Employee Registration Successfully");
      setEmail("");
      setPassword("");
      setRpassword("");
      setAddress("");
      setGender("");
      setPhone("");
      setDob("");
    } catch (err) {
      alert("User Registration Failed");
    }
  }

  return (
    <div className="RegistrerForm">
      <h1>Please fill in this form to create an account</h1>
      <div className="container">
        <label htmlFor="email">
          <b>Email</b>
        </label>
        <input
          type="text"
          placeholder="Enter Email"
          name="email"
          id="email"
          required
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
        />

        <label htmlFor="psw">
          <b>Password</b>
        </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="psw"
          id="psw"
          required
          value={password}
          onChange={(event) => {
            setPassword(event.target.value);
          }}
        />

        <label htmlFor="psw-repeat">
          <b>Repeat Password</b>
        </label>
        <input
          type="password"
          placeholder="Repeat Password"
          name="psw-repeat"
          id="psw-repeat"
          required
          value={rpassword}
          onChange={(event) => {
            setRpassword(event.target.value);
          }}
        />

        <label htmlFor="address">
          <b>Address</b>
        </label>
        <input
          type="text"
          placeholder="Enter Address"
          name="address"
          id="address"
          required
          value={address}
          onChange={(event) => {
            setAddress(event.target.value);
          }}
        />

        <label htmlFor="gender">
          <b>Gender</b>
        </label>
        <select
          name="gender"
          id="gender"
          required
          value={gender}
          onChange={(event) => {
            setGender(event.target.value);
          }}
        >
          <option value="">Select...</option>
          <option value="male">Male</option>
          <option value="female">Female</option>
          <option value="other">Other</option>
        </select>

        <label htmlFor="phone">
          <b>Phone</b>
        </label>
        <input
          type="tel"
          placeholder="Enter Phone"
          name="phone"
          id="phone"
          required
          value={phone}
          onChange={(event) => {
            setPhone(event.target.value);
          }}
        />

        <label htmlFor="dob">
          <b>Date of Birth</b>
        </label>
        <input
          type="date"
          name="dob"
          id="dob"
          required
          value={dob}
          onChange={(event) => {
            setDob(event.target.value);
          }}
        />

        <p>By creating an account you agree to our Terms & Privacy</p>

        <button type="submit" className="registerbtn" onClick={save}>
          <Link to="/login">Register</Link>
        </button>
      </div>

      <div className="container signin">
        <p>
          Already have an account? <Link to="/login">Sign in here</Link>.
        </p>
      </div>
    </div>
  );
}

export default RegisterForm;