import React from "react";
import { Link } from "react-router-dom";
import "./Footer.css";

const Footer = () => {
  return (
      <div className="Footer">
        <div className="section left-section">
          <p>Sign up for newsletter to get discounted offers!</p>
          <form>
            <input type="text" placeholder="Enter your details" />
            <button type="submit">Submit</button>
            <p>
              This website is a result of a university group project, performed in
              the course IDATA2301 Web technologies, at NTNU. All the information
              provided here is a result of imagination. Any resemblance with real
              companies or products is a coincidence.
            </p>
          </form>
        </div>
        <div className="section right-section">
          <img
              src={`${process.env.REACT_APP_API_BASE_PATH}/api/get/image/Logo.png`}
              alt="Logo"
          />
          <h2>Support</h2>
          <ul>
            <li>
              <Link to="/help">Help Centre</Link>
            </li>
            <li>
              <Link to="/faqs">FAQs</Link>
            </li>
            <li>
              <Link to="/track-order">Track your Order</Link>
            </li>
            <li>
              <Link to="/contact">Contact Us</Link>
            </li>
          </ul>
        </div>
      </div>
  );
};

export default Footer;
