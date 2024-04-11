// SearchResults.js
import React from "react";
import { useLocation } from "react-router-dom";
import "./SearchResults.css"; // Ensure this path matches your file structure
import Footer from "../Footer"; // Adjust the import path as needed
import SearchBar from "../SearchBar"; // Adjust the import path as needed

function SearchResults() {
  const location = useLocation();
  const { data } = location.state || { data: [] }; // Ensure you're handling the state correctly based on your routing and state management

  const handleBooking = (hotelName) => {
    // Implement your booking logic or navigation here
    console.log(`Booking for ${hotelName}`);
  };

  return (
    <div className="Search">
      <div className="search-bar-container">
        <SearchBar />
      </div>

      <div className="SearchResults">
        <h1>Here are the search results:</h1>
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
                <p>
                  <strong>Agency:</strong> {item.agencyName}
                </p>
                <p>
                  <strong>Arrival:</strong>{" "}
                  {new Date(item.arrivalDate).toLocaleDateString()}
                </p>
                <p>
                  <strong>Departure:</strong>{" "}
                  {new Date(item.departureDate).toLocaleDateString()}
                </p>
                <h2 className="price">
                  <strong>Price:</strong> ${item.price}
                </h2>
                <button
                  className="book-button"
                  onClick={() => handleBooking(item.hotelName)}
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
