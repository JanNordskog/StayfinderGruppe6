import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import "./SearchResults.css";
import Footer from "../Footer";
import SearchBar from "../SearchBar";

function SearchResults() {
  const location = useLocation();
  const navigate = useNavigate();
  const { data: initialData } = location.state || { data: [] };
  const [data, setData] = useState(initialData);
  const [sortType, setSortType] = useState("");

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  useEffect(() => {
    let sortedData = [...data];
    if (sortType === "price") {
      sortedData.sort((a, b) => a.price - b.price);
    } else if (sortType === "name") {
      sortedData.sort((a, b) => a.hotelName.localeCompare(b.hotelName));
    } // Add more sort types if needed
    setData(sortedData);
  }, [sortType]);

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

  return (
    <div className="Search">
      <div className="search-bar-container">
        <SearchBar />
      </div>
      <div className="SearchResults">
        <h1>Hotel Listings</h1>
        <div>
          <label>Sort by: </label>
          <select onChange={(e) => setSortType(e.target.value)}>
            <option value="">Select</option>
            <option value="price">Price</option>
            <option value="name">Name</option>
          </select>
        </div>
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
                  onClick={() => handleBooking(item.listingID)} // Ensure this is the correct property name for listing ID in your data structure
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
    </div>
  );
}

export default SearchResults;
