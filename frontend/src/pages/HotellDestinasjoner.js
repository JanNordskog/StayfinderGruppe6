import React, { useState, useEffect } from "react";
import axios from "axios";

function HotellDestinasjoner() {
  const [listings, setListings] = useState([]);

  useEffect(() => {
    // Fetch all listings from the database
    const fetchListings = async () => {
      try {
        const response = await axios.get("http://localhost:8080/listings");
        setListings(response.data);
      } catch (error) {
        console.error("Error fetching listings:", error);
      }
    };

    fetchListings();
  }, []);

  return (
    <div className="hotellDestinasjoner">
      <h1>HotellDestinasjoner</h1>
      <div className="listings-grid">
        {listings.length > 0 ? (
          listings.map((listing, index) => (
            <div className="listing-card" key={index}>
              <h2>Hotel ID: {listing.hotelID}</h2>
              <p>
                <strong>Agency:</strong> {listing.agencyID}
              </p>
              <p>
                <strong>Arrival:</strong>{" "}
                {new Date(listing.arrivalDate).toLocaleDateString()}
              </p>
              <p>
                <strong>Departure:</strong>{" "}
                {new Date(listing.departureDate).toLocaleDateString()}
              </p>
              <p className="price">
                <strong>Price:</strong> ${listing.price}
              </p>
            </div>
          ))
        ) : (
          <p>Ingen resultater funnet.</p>
        )}
      </div>
    </div>
  );
}

export default HotellDestinasjoner;
