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
                    <p>By signing up, you agree to our terms and conditions.</p>
                </form>
            </div>
            <div className="section right-section">
                <img src="http://localhost:8080/api/get/image/Logo.png" alt="Right Image" />
                <h2>Support</h2>
                <ul>
                    <li><Link to="/help">Help Centre</Link></li>
                    <li><Link to="/faqs">FAQs</Link></li>
                    <li><Link to="/track-order">Track your Order</Link></li>
                    <li><Link to="/contact">Contact Us</Link></li>
                </ul>
            </div>
        </div>
    );
};

export default Footer;
