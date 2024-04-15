import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";
import axios from "axios"; // Ensure axios is imported if you plan to fetch data
import "./Navbar.css";

function Navbar() {
  const [isActive, setIsActive] = useState(false);
  const navigate = useNavigate(); // Use the useNavigate hook

  const location = useLocation(); // Hook to access router state
  const user = location.state?.user; // Access user data passed in state

  const toggleMenu = () => {
    setIsActive(!isActive);
  };

  // Function to handle fe5gr´tching all listings or with empty criteria
  const handleAllListings = async () => {
    try {
      // You might want to modify this request to suit how your backend handles fetching all listings
      const response = await axios.get("http://localhost:8080/listings");
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings:", error);
    }
  };

  return (
    <div className={`navbar ${isActive ? "active" : ""}`}>
      <div className="logo">
        <Link className="NavbarDink" to="/">
          <img
            src="http://localhost:8080/api/get/image/LogoIcon.png"
            alt="Logo"
          />
        </Link>
      </div>
      <div className="hamburger" onClick={toggleMenu}>
        <img
          src="http://localhost:8080/api/get/image/Hamburgermenu.png"
          alt="Menu"
        />
      </div>
      <ul
        className={isActive ? "nav-links-mobile" : "nav-links"}
        onClick={() => setIsActive(false)}
      >
        <li>
          {/* Update this Link to use onClick handler */}
          <a className="NavbarLink" href="#!" onClick={handleAllListings}>
            Hotell & destinations
          </a>
        </li>
        <li>
          <Link className="NavbarLink" to="/UtvalgteTilbud">
            Check sites
          </Link>
        </li>
        <li>
          <Link className="NavbarLink" to="/aboutus">
            About us
          </Link>
        </li>
        <Link className="NavbarLink3" to="/Login">
          <button>Logg inn</button>
        </Link>
      </ul>
      <div className="logg-inn-desktop">
        <Link className="NavbarLink2" to="/Login">
          <button>Logg inn</button>
        </Link>
      </div>
    </div>
  );
}

export default Navbar;
