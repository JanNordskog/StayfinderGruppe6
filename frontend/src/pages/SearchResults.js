import React from "react";
import { useLocation } from "react-router-dom";
import "./SearchResults.css"; // Make sure this is the correct path to your CSS file
import Footer from "../Footer";

function SearchResults() {
  const location = useLocation();
  const { data } = location.state || { data: [] };

  const handleBooking = (hotelName) => {
    // Implement your booking logic or navigation here
    console.log(`Booking for ${hotelName}`);
  };

  return (
    <div className="Search">
      <div className="SearchResults">
        <h1>Here is the search results:</h1>
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
                {/* Book button */}
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
