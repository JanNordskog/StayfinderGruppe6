import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./ControlPanel.css";

export const BACKENDURL = process.env.REACT_APP_BACKENDURL;

function ControlPanel() {
  const navigate = useNavigate();
  const user = JSON.parse(sessionStorage.getItem("user"));
  const [listings, setListings] = useState([]);
  const [isAdmin, setIsAdmin] = useState(false);

  // useCallback to ensure function identity is stable
  const fetchListings = useCallback(async () => {
    try {
      const response = await axios.get("http://localhost:8080/listings");
      setListings(
        response.data.map((listing) => ({ ...listing, hidden: false }))
      );
    } catch (error) {
      console.error("Error fetching listings:", error);
    }
  }, []);

  const fetchFaveListings = useCallback(async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/favorites/listing/${user.id}`
      );
      setListings(
        response.data.map((listing) => ({ ...listing.listing, hidden: false }))
      );
    } catch (error) {
      console.error("Error fetching listings:", error);
    }
  }, [user.id]); // user.id as a dependency to recreate the function when user.id changes

  useEffect(() => {
    if (!user) {
      navigate("/login");
    } else {
      const checkAdminStatus = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8080/user/${user.id}/is-admin`
          );
          setIsAdmin(response.data);
        } catch (error) {
          console.error("Error checking admin status:", error);
        }
      };
      checkAdminStatus();
    }
  }, [user, navigate]);

  useEffect(() => {
    if (isAdmin) {
      fetchListings();
    } else {
      fetchFaveListings();
    }
  }, [isAdmin, fetchListings, fetchFaveListings]); // Adding both functions to dependencies

  const toggleListingVisibility = async (id, isVisible) => {
    try {
      await axios.put(
        `http://localhost:8080/listings/${id}/${isVisible ? "show" : "hide"}`
      );
      const updatedListings = listings.map((listing) =>
        listing.listingID === id
          ? { ...listing, visible: isVisible ? 1 : 0 }
          : listing
      );
      setListings(updatedListings);
    } catch (error) {
      console.error(
        `Error ${isVisible ? "showing" : "hiding"} listing:`,
        error
      );
    }
  };

  const handleLogout = () => {
    sessionStorage.removeItem("user");
    navigate("/login");
  };

  const removeFavorite = async (listingId) => {
    try {
      await axios.delete(`http://localhost:8080/api/favorites/delete`, {
        params: {
          userId: user.id,
          listingId: listingId,
        },
      });

      fetchFaveListings();
    } catch (error) {
      console.error("Error removing favorite:", error);
    }
  };

  return (
    <div className="Panel">
      {user && (
        <div className="user-info-box">
          <h1>Du har nå logget inn</h1>
          <h2>Velkommen, {user.name}</h2>
          <p>Email: {user.email}</p>
          <p>Address: {user.address}</p>
          <p>Phone: {user.phone}</p>
          <p>Gender: {user.gender}</p>
          <p>Date of Birth: {user.dob}</p>
          <button onClick={handleLogout}>Logout</button>
        </div>
      )}

      {isAdmin && (
        <div className="Panel1">
          <h2>Available Listings:</h2>
          {listings.length > 0 ? (
            <ul>
              {listings.map((listing) => (
                <li key={listing.listingID}>
                  <h3>
                    {listing.hotelName} - {listing.roomTypeAvailable}
                  </h3>
                  <img src={listing.imageLink} alt={listing.hotelName} />
                  <p>Agency: {listing.agency.name}</p>
                  <p>
                    Contact: {listing.agency.email} |{" "}
                    {listing.agency.phoneNumber}
                  </p>
                  <p>Hotel Address: {listing.hotelAddress}</p>
                  <p>
                    Arrival: {listing.arrivalDate} | Departure:{" "}
                    {listing.departureDate}
                  </p>
                  <p>Price: ${listing.price}</p>
                  <p>Features: {listing.extraFeatures}</p>
                  <button
                    onClick={() =>
                      toggleListingVisibility(
                        listing.listingID,
                        listing.visible === 0
                      )
                    }
                  >
                    {listing.visible === 0 ? "Show Listing" : "Hide Listing"}
                  </button>
                </li>
              ))}
            </ul>
          ) : (
            <p>No listings available.</p>
          )}
        </div>
      )}
      {!isAdmin && (
        <div>
          <h2>Saved Favorites:</h2>
          {listings.length > 0 ? (
            <ul>
              {listings.map((listing) => (
                <li key={listing.listingID} className="listing-item">
                  <h3>{listing.hotelName}</h3> {/* Hotel Name */}
                  <img
                    src={listing.imageLink}
                    alt={`Image of ${listing.hotelName}`}
                    style={{ width: "200px", height: "auto" }} // Inline styles for the image
                  />
                  <button onClick={() => removeFavorite(listing.listingID)}>
                    Remove Favorite
                  </button>
                </li>
              ))}
            </ul>
          ) : (
            <p>No listings available.</p>
          )}
        </div>
      )}
    </div>
  );
}

export default ControlPanel;
