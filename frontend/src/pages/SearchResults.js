import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import "./SearchResults.css";
import SearchBar from "../SearchBar";

function SearchResults() {
  const location = useLocation();
  const navigate = useNavigate();
  const { data } = location.state || { data: [] };
  const searchParams = JSON.parse(sessionStorage.getItem("searchParams"));
  const user = JSON.parse(sessionStorage.getItem("user")); // Retrieve user from session storage
  const [favorites, setFavorites] = useState(new Set()); // State to track favorite listings

  const API_BASE_PATH = process.env.REACT_APP_API_BASE_PATH;

  useEffect(() => {
    window.scrollTo(0, 0);
    if (user) {
      // Optionally load favorites from the server when the component mounts
      axios
          .get(`${API_BASE_PATH}/api/favorites/user/${user.id}`)
          .then((response) => {
            const newFavorites = new Set(
                response.data.map((fav) => fav.listing.listingID)
            );
            setFavorites(newFavorites);
          })
          .catch((error) => console.error("Error fetching favorites:", error));
    }
  }, [user, API_BASE_PATH]);

  const handleBooking = (listingId) => {
    axios
        .get(`${API_BASE_PATH}/listings/getlistingByID/${listingId}`)
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

  const toggleFavorite = (listingId) => {
    if (!user) {
      alert("Please log in to add favorites.");
      return;
    }

    const newFavorites = new Set(favorites);
    let message = "Favorite added successfully!";
    if (favorites.has(listingId)) {
      newFavorites.delete(listingId);
      message = "Favorite removed successfully!";
    } else {
      newFavorites.add(listingId);
    }

    const url = `${API_BASE_PATH}/api/favorites/add?userId=${user.id}&listingId=${listingId}`;

    axios
        .post(url)
        .then(() => {
          alert(message);
          setFavorites(newFavorites); // Update favorites state correctly
        })
        .catch((error) => {
          console.error("Error toggling favorite:", error);
          alert("Failed to toggle favorite.");
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
                              onClick={() => toggleFavorite(item.listingID)}
                              disabled={!user || favorites.has(item.listingID)} // Disable if not logged in or already a favorite
                          >
                            <img
                                src={`${API_BASE_PATH}/api/get/image/favourite.png`}
                                alt="Toggle favorite"
                            />
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
