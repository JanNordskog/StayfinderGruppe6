import React from "react";
import { useLocation } from "react-router-dom";
import Footer from "../Footer";

function HotelPage() {
  const location = useLocation();
  const hotel = location.state?.data; // Assuming the data is passed as 'data' in the state

  return (
    <div className="hotel">
      <h1>Hotel Details</h1>
      {hotel ? (
        <div>
          <h2>{hotel.name}</h2>
          <p>
            <strong>Address:</strong> {hotel.address}
          </p>
          <p>
            <strong>Phone:</strong> {hotel.phoneNumber}
          </p>
          <p>
            <strong>Website:</strong>{" "}
            <a href={hotel.website} target="_blank" rel="noopener noreferrer">
              {hotel.website}
            </a>
          </p>
          <p>
            <strong>Location Type:</strong> {hotel.locationType}
          </p>
          <p>
            <strong>Room Types Available:</strong> {hotel.roomTypeAvailable}
          </p>
          <p>
            <strong>Extra Features:</strong> {hotel.extraFeatures}
          </p>
        </div>
      ) : (
        <p>No hotel data available.</p>
      )}
      <Footer />
    </div>
  );
}
export default HotelPage;
