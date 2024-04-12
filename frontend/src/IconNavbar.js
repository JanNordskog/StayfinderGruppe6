import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate
import axios from "axios"; // Make sure axios is imported if it's needed for API calls
import "./IconNavbar.css";

const IconNavbar = () => {
  const navigate = useNavigate(); // Hook to programmatically navigate
  const today = new Date().toISOString().split("T")[0];
  // Similar function to `handleNavigateToOslo` for the "Pool" link
  const handleNavigateToPool = async () => {
    try {
      // Corrected to match the backend controller's base path and query parameter
      const response = await axios.get("http://localhost:8080/extra", {
        params: {
          extraFeatures: "pool", // Using 'bar' as an example extra feature
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToBar = async () => {
    try {
      // Corrected to match the backend controller's base path and query parameter
      const response = await axios.get("http://localhost:8080/extra", {
        params: {
          extraFeatures: "Bar", // Using 'bar' as an example extra feature
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  return (
    <>
      <nav className="IconNavbar">
        <ul>
          <li>
            {/* Convert to <a> element with onClick handler */}
            <a className="NavbarLink" onClick={handleNavigateToPool} href="#!">
              <img
                src="http://localhost:8080/api/get/image/HouseIcon.png"
                alt="Home"
              />
              Pool
            </a>
          </li>
          {/* Other links remain unchanged */}
          <li>
            <a className="NavbarLink" href="/Home">
              <img
                src="http://localhost:8080/api/get/image/HouseIcon.png"
                alt="Home"
              />
              Hotell & destinasjoner
            </a>
          </li>
          <li>
            <a className="NavbarLink" href="/Home">
              <img
                src="http://localhost:8080/api/get/image/HouseIcon.png"
                alt="Home"
              />
              Hotell & destinasjoner
            </a>
          </li>
          <li>
            <a className="NavbarLink" href="/Home">
              <img
                src="http://localhost:8080/api/get/image/HouseIcon.png"
                alt="Home"
              />
              Hotell & destinasjoner
            </a>
          </li>
        </ul>
      </nav>
      <hr />
    </>
  );
};

export default IconNavbar;
