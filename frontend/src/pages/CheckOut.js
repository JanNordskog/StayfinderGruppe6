import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import "./CheckOut.css";

function CheckOut() {
  const navigate = useNavigate();
  const bookingParams = JSON.parse(sessionStorage.getItem('bookingParams') || '{}');

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

  const handleCheckout = (event) => {
    event.preventDefault();
    console.log("Submitting:", name, email, creditCard, expiryDate, cvv);
    navigate("/confirmation");  // Assume "/confirmation" is your confirmation page route
  };

  return (
      <div className="checkout-container">
        <h1>Checkout</h1>
        {bookingParams && (
            <div className="search-details">
              <div className="search-params-display">
                <h3>Search Details:</h3>
                <p><strong>Destination:</strong> {bookingParams.destination}</p>
                <p><strong>Guests:</strong> {bookingParams.guests}</p>
                <p><strong>Dates:</strong> {formatDates(bookingParams.range)}</p>
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
