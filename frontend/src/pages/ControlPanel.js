import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./ControlPanel.css";

function ControlPanel() {
  const navigate = useNavigate();
  // Retrieve user data from sessionStorage
  const user = JSON.parse(sessionStorage.getItem("user"));
  const [listings, setListings] = useState([]);

  useEffect(() => {
    if (user) {
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
    } else {
      navigate("/login");
    }
  }, [user, navigate]);

  useEffect(() => {
    if (isAdmin) {
      fetchListings();
    }

  const fetchListings = async () => {
    try {
      const response = await axios.get("http://localhost:8080/listings");
      setListings(
        response.data.map((listing) => ({ ...listing, hidden: false }))
      );
    } catch (error) {
      console.error("Error fetching listings:", error);
    }


  };



    const fetchFaveListings = async => {
        try {
            const response = await axios.get("http://localhost:8080//api/favorites/{id}", {
                params: {
                  userid: userid,
                },
              });
                    response.data.map((listing) => ({ ...listing, hidden: false }))
                  );
                } catch (error) {
                  console.error("Could not load favorites:", error);
                }});

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
    sessionStorage.removeItem("user"); // Clear the user session data
    window.dispatchEvent(new Event("storage")); // Manually trigger the storage event
    navigate("/login"); // Redirect to login page
  };

  return (
    <div className="Panel">
      {user && (
        <div>
          <h1>Du har nå logget inn</h1>
          <h2>Velkommen, {user.name}</h2>
          <p>Email: {user.email}</p>
          <p>Address: {user.address}</p>
          <p>Phone: {user.phone}</p>
          <p>Gender: {user.gender}</p>
          <p>Date of Birth: {user.dob}</p>
          <button onClick={handleLogout}>Logout</button>{" "}
          {/* Add a logout button */}
        </div>
      )}

      {isAdmin && (
        <div>
          <h2>Available Listings:</h2>
          {listings.length > 0 ? (
            <ul>
              {listings.map((listing) => (
                <li
                  key={listing.listingID}
                  style={{
                    margin: "20px",
                    padding: "10px",
                    border: "1px solid #ccc",
                    borderRadius: "8px",
                  }}
                >
                  <h3>
                    {listing.hotelName} - {listing.roomTypeAvailable}
                  </h3>
                  <img
                    src={listing.imageLink}
                    alt={listing.hotelName}
                    style={{ width: "100px", height: "auto" }}
                  />
                  <p>Agency: {listing.agency.name}</p>
                  <p>
                    Contact: {listing.agency.email} |{" "}
                    {listing.agency.phoneNumber}
                  </p>
                  <p>Hotel Address: {listing.hotelAddress}</p>
                  <p>
                    Arrival: {listing.arrivalDate} | Departure:
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
    </div>
  );
}

export default ControlPanel;
