import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import "./CheckOut.css";

function CheckOut() {
  const navigate = useNavigate();
  const location = useLocation();
  const bookingParams = location.state; // Using the state passed from HotelPage

  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [creditCard, setCreditCard] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [cvv, setCVV] = useState('');

  const formatDates = ({ startDate, endDate }) => {
    const start = new Date(startDate);
    const end = new Date(endDate);
    return `${start.toLocaleDateString()} - ${end.toLocaleDateString()}`;
  };

  const handleCheckout = async (event) => {
    event.preventDefault();
    const order = {
      name,
      email,
      creditCard,
      expiryDate,
      cvv,
      hotelId: bookingParams.hotel.hotelID, // Retrieve hotel ID from bookingParams
      destination: bookingParams.hotel.hotelAddress, // Retrieve destination from bookingParams
      guests: bookingParams.guests || 1, // Retrieve guests from bookingParams, default to 1 if null
      arrivalDate: bookingParams.dateRange[0].startDate,
      departureDate: bookingParams.dateRange[0].endDate,
      price: bookingParams.hotel.price
    };

    console.log("Submitting order:", order); // Debug log

    try {
      const response = await axios.post("http://localhost:8080/orders", order);
      console.log("Order response:", response); // Debug log
      if (response.status === 200) {
        navigate("/confirmation", { state: { email: order.email }, replace: true });
      } else {
        console.error("Failed to create order:", response);
      }
    } catch (error) {
      console.error("Error creating order:", error);
    }
  };

  return (
      <div className="checkout-container">
        <h1>Checkout</h1>
        {bookingParams && (
            <div className="search-details">
              <div className="search-params-display">
                <h3>Search Details:</h3>
                <p><strong>Destination:</strong> {bookingParams.hotel.hotelAddress}</p>
                <p><strong>Guests:</strong> {bookingParams.guests}</p>
                <p><strong>Dates:</strong> {formatDates(bookingParams.dateRange[0])}</p>
              </div>
            </div>
        )}
        <form onSubmit={handleCheckout}>
          <label>
            Name:
            <input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
            />
          </label>
          <label>
            Email:
            <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
          </label>
          <label>
            Credit Card Number:
            <input
                type="text"
                value={creditCard}
                onChange={(e) => setCreditCard(e.target.value)}
                required
            />
          </label>
          <p className="warning-text">This is a test website, don't add your real card details.</p>
          <label>
            Expiry Date:
            <input
                type="month"
                value={expiryDate}
                onChange={(e) => setExpiryDate(e.target.value)}
                required
            />
          </label>
          <label>
            CVV:
            <input
                type="number"
                value={cvv}
                onChange={(e) => setCVV(e.target.value)}
                required
            />
          </label>
          <button type="submit">Complete Booking</button>
        </form>
      </div>
  );
}

export default CheckOut;
