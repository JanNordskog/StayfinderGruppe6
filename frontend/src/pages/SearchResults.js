import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import "./SearchResults.css";
import SearchBar from "../SearchBar"; 

function SearchResults() {
  const location = useLocation();
  const navigate = useNavigate();
  const { data } = location.state || { data: [] };
  const searchParams = JSON.parse(sessionStorage.getItem("searchParams"));

  useEffect(() => {
    window.scrollTo(0, 0);
  });

  const handleBooking = (listingId) => {
    axios
      .get(`http://localhost:8080/listings/getlistingByID/${listingId}`)
      .then((response) => {
        navigate("/hotelpage", {
          state: {
            data: response.data,
          },
        });
      })
      .catch((error) => {
        console.error("Error fetching listing data:", error);
        alert("Listing data could not be fetched.");
      });
  };

  const formatDates = ({ startDate, endDate }) => {
   
    const start = new Date(startDate);
    const end = new Date(endDate);
    return `${start.toLocaleDateString()} - ${end.toLocaleDateString()}`;
  };

  return (
    <div className="Search">
      <div className="search-bar-container">
        <SearchBar />
      </div>
      <div className="SearchResults">
        <h1>Hotel Listings</h1>
        <div className="search-details">
          {searchParams && (
            <div className="search-params-display">
              <h3>Search Details:</h3>
              <p>
                <strong>Destination:</strong> {searchParams.destination}
              </p>
              <p>
                <strong>Guests:</strong> {searchParams.guests}
              </p>
              <p>
                <strong>Dates:</strong> {formatDates(searchParams.range[0])}
              </p>
            </div>
          )}
        </div>

        <div className="listings-grid">
          {data.length > 0 ? (
            data.map((item, index) => (
              <div className="listing-card" key={index}>
                <img
                  src={item.imageLink}
                  alt={`${item.hotelName}`} 
                  className="hotel-image"
                />
                <div className="text-content">
                  <div className="hotel-header">
                    <h2>{item.hotelName}</h2>
                    <button
                      className="favorite-button"
                      onClick={() => console.log("Toggle Favorite")}
                    >
                      <img
                        src="http://localhost:8080/api/get/image/favourite.png"
                        alt="Toggle favorite"
                      />{" "}
                     
                    </button>
                  </div>
                  <p>
                    <strong>Room Type Available:</strong>{" "}
                    {item.roomTypeAvailable}
                  </p>
                  <p>
                    <strong>Extra Features:</strong> {item.extraFeatures}
                  </p>
                  <h2 className="price">
                    <strong>Price:</strong> ${item.price}
                  </h2>
                  <button
                    className="book-button"
                    onClick={() => handleBooking(item.listingID)}
                  >
                    Book now
                  </button>
                </div>
              </div>
            ))
          ) : (
            <p>No results found.</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default SearchResults;
