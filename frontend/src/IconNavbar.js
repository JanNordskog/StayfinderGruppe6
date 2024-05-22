import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./IconNavbar.css";

const IconNavbar = () => {
  const navigate = useNavigate(); // Hook to programmatically navigate
  const navRef = useRef(null);

  const handleNavigate = async (extraFeature) => {
    try {
      const response = await axios.get(`${process.env.REACT_APP_API_BASE_PATH}/extra`, {
        params: {
          extraFeatures: extraFeature,
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
          <ul ref={navRef}>
            <li>
              <a className="NavbarLink" onClick={() => handleNavigate("bar")} href="#!">
                <img src={`${process.env.REACT_APP_IMAGE_BASE_PATH}/Bar.png`} alt="Bar" />
                Bar
              </a>
            </li>
            {/* Add other menu items similarly */}
          </ul>
        </nav>
        <hr />
      </>
  );
};

export default IconNavbar;
