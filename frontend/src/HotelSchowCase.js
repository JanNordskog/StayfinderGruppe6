import React from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./HotelSchowCase.css";

function HotelShowCase() {
  const navigate = useNavigate();
  const today = new Date().toISOString().split("T")[0];
  // Function to fetch listings for Oslo and navigate to search results
  const handleNavigateToOslo = async () => {
    try {
      // Assuming you want to fetch data similar to the HotelShowCase component
      // Adjust the URL/path/query as needed to match your backend API
      const response = await axios.get("http://localhost:8080/listings", {
        params: {
          destination: "Oslo",
          arrivalDate: today, // Set to today's date
          departureDate: today,
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings for Oslo:", error);
    }
  };

  const handleNavigateToÅlesund = async () => {
    try {
      // Fetch listings filtered by Oslo
      // Adjust the URL/path/query as needed to match your backend API
      const response = await axios.get("http://localhost:8080/listings", {
        params: {
          destination: "Ålesund",
          arrivalDate: today, // Set to today's date
          departureDate: today,
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings for Ålesund:", error);
    }
  };

  const handleNavigateToAmsterdam = async () => {
    try {
      // Fetch listings filtered by Oslo
      // Adjust the URL/path/query as needed to match your backend API
      const response = await axios.get("http://localhost:8080/listings", {
        params: {
          destination: "Amsterdam",
          arrivalDate: today, // Set to today's date
          departureDate: today,
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings for Amsterdam:", error);
    }
  };

  return (
    <div className="hotelshowcase">
      <div className="container">
        <h1>Discover trending destinations</h1>
        <ul className="destinations">
          <li className="destination">
            {/* Use onClick handler directly on the <li> element */}
            <a onClick={handleNavigateToOslo} href="#!">
              <img
                src="http://localhost:8080/api/get/image/Oslo.jpg"
                alt="Oslo"
              />
              <h2>Oslo</h2>
              <p>Norge</p>
            </a>
          </li>
          <li className="destination">
            {/* Use onClick handler directly on the <li> element */}
            <a onClick={handleNavigateToÅlesund} href="#!">
              <img
                src="http://localhost:8080/api/get/image/Ålesund.jpg"
                alt="Ålesund"
              />
              <h2>Ålesund</h2>
              <p>Norge</p>
            </a>
          </li>
          <li className="destination">
            {/* Use onClick handler directly on the <li> element */}
            <a onClick={handleNavigateToAmsterdam} href="#!">
              <img
                src="http://localhost:8080/api/get/image/Amsterdam.png"
                alt="Amsterdam"
              />
              <h2>Amsterdam</h2>
              <p>Norge</p>
            </a>
          </li>
          {/* Other destinations unchanged */}
        </ul>
      </div>
    </div>
  );
}

export default HotelShowCase;
