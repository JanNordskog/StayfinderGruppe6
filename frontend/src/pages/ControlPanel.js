import React, { useState, useEffect } from "react";
import axios from "axios";
import { useLocation } from "react-router-dom";
import "./ControlPanel.css";

function ControlPanel() {
  const location = useLocation();
  const user = location.state?.user;
  const [listings, setListings] = useState([]);
  const userid = user.userid;

  useEffect(() => {
    if (user?.userperm === 1) {
      fetchListings();
    }
    else if (user?.userperm === 0)
    {
        fetchFaveListings();
    }
  }, [user]);

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




    const fetchFaveListings = async () => {
        try {
            const response = await axios.get("http://localhost:8080//api/favorites/{id}", {
                params: {
                  userid: userid,
                },
              });
                    response.data.map((listing) => ({ ...listing, hidden: false })
                  );
                } catch (error) {
                  console.error("Could not load favorites:", error);
                }
                };



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
        </div>
      )}

      {user?.userperm === 1 && ( // Conditional rendering based on user permissions
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
