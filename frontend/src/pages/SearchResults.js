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
  const searchParams = JSON.parse(sessionStorage.getItem("searchParams"));

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  useEffect(() => {
    let sortedData = [...data];
    if (sortType === "price1") {
      sortedData.sort((a, b) => a.price - b.price);
    } else if (sortType === "name") {
      sortedData.sort((a, b) => a.hotelName.localeCompare(b.hotelName));
    } else if (sortType === "price2") {
      sortedData.sort((a, b) => b.price - a.price);
    }
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

  const formatDates = ({ startDate, endDate }) => {
    // Convert strings to Date objects
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
          <div className="sort-dropdown-container">
            <label htmlFor="sort">Sort by:</label>
            <select id="sort" onChange={(e) => setSortType(e.target.value)}>
              <option value="">Select</option>
              <option value="price1">Price low-high</option>
              <option value="price2">Price high-low</option>
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
                        <strong>Arrival:</strong>{" "}
                        {new Date(item.arrivalDate).toLocaleDateString()}
                      </p>
                      <p>
                        <strong>Departure:</strong>{" "}
                        {new Date(item.departureDate).toLocaleDateString()}
                      </p>
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
                          onClick={() => handleBooking(item.listingID)}
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
