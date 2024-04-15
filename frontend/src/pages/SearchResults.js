// SearchResults.js
import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import "./SearchResults.css";
import Footer from "../Footer";
import SearchBar from "../SearchBar";

function SearchResults() {
  const location = useLocation();
  const navigate = useNavigate();
  const { data } = location.state || { data: [] };

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const handleBooking = (hotelId) => {
    axios
      .get(`http://localhost:8080/hotels/${hotelId}`)
      .then((response) => {
        navigate("/hotelpage", { state: { data: response.data } });
      })
      .catch((error) => {
        console.error("Error fetching hotel data:", error);
        alert("Hotel data could not be fetched.");
      });
  };

  return (
    <div className="Search">
      <div className="search-bar-container">
        <SearchBar />
      </div>

      <div className="SearchResults">
        <h1>Hotel Listings</h1>
        <div className="listings-grid">
          {data.length > 0 ? (
            data.map((item, index) => (
              <div className="listing-card" key={index}>
                <img
                  src={item.imageLink}
                  alt={`Image of ${item.hotelName}`}
                  className="hotel-image"
                />
                <h2>{item.hotelName}</h2>
                <p>
                  <strong>Address:</strong> {item.hotelAddress}
                </p>
                <p>
                  <strong>Room Type Available:</strong> {item.roomTypeAvailable}
                </p>
                <p>
                  <strong>Extra Features:</strong> {item.extraFeatures}
                </p>
                <h2 className="price">
                  <strong>Price:</strong> ${item.price}
                </h2>
                <button
                  className="book-button"
                  onClick={() => handleBooking(item.hotelID)}
                >
                  Book now
                </button>
              </div>
            ))
          ) : (
            <p>No results found.</p>
          )}
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default SearchResults;
