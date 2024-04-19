import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Navbar.css";
import axios from "axios";

function Navbar() {
  const [isActive, setIsActive] = useState(false);
  const navigate = useNavigate();

  // Retrieve user data from sessionStorage and parse it
  const user = JSON.parse(sessionStorage.getItem("user"));

  const toggleMenu = () => {
    setIsActive(!isActive);
  };

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
        {user ? (
          <li>
            <Link className="NavbarLink3" to="/controlPanel">
              <button>My Page</button>
            </Link>
          </li>
        ) : (
          <li>
            <Link className="NavbarLink3" to="/Login">
              <button>Sign in</button>
            </Link>
          </li>
        )}
      </ul>
      <div className="logg-inn-desktop">
        {user ? (
          <Link className="NavbarLink2" to="/controlPanel">
            <button>My Page</button>
          </Link>
        ) : (
          <Link className="NavbarLink2" to="/Login">
            <button>Sign in</button>
          </Link>
        )}
      </div>
    </div>
  );
}

export default Navbar;
