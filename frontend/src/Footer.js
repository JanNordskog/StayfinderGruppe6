import React from "react";
import { Link } from "react-router-dom"; 
import "./Footer.css";

const Footer = () => {
  return (
    <div className="Footer">
      <div className="section left-section">
        <img src="http://localhost:8080/api/get/image/Logo.png" alt="Left Image" />
        <h1></h1>
        <p>Medlemskapet du har lett lenge etter.</p>
        <form>
          <input type="text" placeholder="Enter your details" />
          <button type="submit">Submit</button>
          <p>By signing up, you agree to our terms and conditions.</p>
        </form>
      </div>
      <div className="section right-section">
        <img src="http://localhost:8080/api/get/image/Logo.png" alt="Right Image" />
        <h2>Support</h2>
        <ul>
          <li>
            <a href="#">Help Centre</a>
          </li>
          <li>
            <a href="#">FAQs</a>
          </li>
          <li>
            <a href="#">Track your Order</a>
          </li>
          <li>
            <a href="#">Contact Us</a>
          </li>
        </ul>
        {/* Add social media icons and footer content here */}
      </div>
    </div>
  );
};

export default Footer;
