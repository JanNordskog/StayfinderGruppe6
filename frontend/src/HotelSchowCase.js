import React from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./HotelSchowCase.css";

function HotelShowCase() {
  const navigate = useNavigate();
  const today = new Date().toISOString().split("T")[0];
  const apiBaseUrl = process.env.REACT_APP_API_BASE_PATH; // Get the API base URL from environment variables

  const handleNavigate = async (destination) => {
    try {
      const response = await axios.get(`${apiBaseUrl}/listings/engine`, {
        params: {
          destination: destination,
          arrivalDate: today,
          departureDate: today,
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error(`Failed to fetch listings for ${destination}:`, error);
    }
  };

  return (
      <div className="hotelshowcase">
        <div className="container">
          <h1>Discover trending destinations</h1>
          <ul className="destinations">
            <li className="destination">
              <a onClick={() => handleNavigate("Oslo")} href="#!">
                <img src={`${apiBaseUrl}/api/get/image/Oslo.jpg`} alt="Oslo" />
                <h2>Oslo</h2>
                <p>Norge</p>
              </a>
            </li>
            <li className="destination">
              <a onClick={() => handleNavigate("Ålesund")} href="#!">
                <img src={`${apiBaseUrl}/api/get/image/Ålesund.jpg`} alt="Ålesund" />
                <h2>Ålesund</h2>
                <p>Norge</p>
              </a>
            </li>
            <li className="destination">
              <a onClick={() => handleNavigate("Amsterdam")} href="#!">
                <img src={`${apiBaseUrl}/api/get/image/Amsterdam.png`} alt="Amsterdam" />
                <h2>Amsterdam</h2>
                <p>Norge</p>
              </a>
            </li>
            {/* Add other destinations similarly */}
          </ul>
        </div>
      </div>
  );
}

export default HotelShowCase;
