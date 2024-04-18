import React from "react";
import { useLocation } from "react-router-dom";
import Footer from "../Footer";
import "./HotelPage.css";

function HotelPage() {
  const location = useLocation();
  const hotel = location.state?.data; // Assuming the data is passed as 'data' in the state

  return (
      <div className="hotelpage">
        <h1>Hotel Details</h1>
        {hotel ? (
            <div>
              <h2>{hotel.hotelName}</h2>
              <p><strong>Agency:</strong> {hotel.agencyName}</p>
              <p><strong>Email:</strong> {hotel.agency.email}</p>
              <p><strong>Phone:</strong> {hotel.agency.phoneNumber}</p>
              <p>
                <strong>Website:</strong>
                <a href={hotel.agency.website} target="_blank" rel="noopener noreferrer">
                  {" " + hotel.agency.website}
                </a>
              </p>
              <p><strong>Address:</strong> {hotel.hotelAddress}</p>
              <p><strong>Arrival Date:</strong> {hotel.arrivalDate}</p>
              <p><strong>Departure Date:</strong> {hotel.departureDate}</p>
              <p><strong>Price:</strong> ${hotel.price.toFixed(2)}</p>
              <p><strong>Room Type Available:</strong> {hotel.roomTypeAvailable}</p>
              <p><strong>Description:</strong> {hotel.hotelDescription}</p>
              <p><strong>Extra Features:</strong> {hotel.extraFeatures}</p>
              <p>
                <img src={hotel.imageLink} alt={hotel.hotelName} style={{ width: "100%", height: "auto" }}/>
              </p>
              <button className="book-now-btn">Book Now</button>  {/* Book Now button */}
            </div>
        ) : (
            <p>No hotel data available.</p>
        )}
      </div>
  );
}

export default HotelPage;
