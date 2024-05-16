import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function CheckOut() {
  const navigate = useNavigate();
  const searchParams = JSON.parse(sessionStorage.getItem("searchParams"));
  // States for form data
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [creditCard, setCreditCard] = useState("");
  const [expiryDate, setExpiryDate] = useState("");
  const [cvv, setCVV] = useState("");

  // Function to handle form submission
  const handleCheckout = (event) => {
    event.preventDefault();
    // Add validation and API calls if needed
    console.log("Submitting:", name, email, creditCard, expiryDate, cvv);
    // Navigate to a confirmation page or handle next steps
    navigate("/confirmation");
  };

  const formatDates = ({ startDate, endDate }) => {
    // Convert strings to Date objects
    const start = new Date(startDate);
    const end = new Date(endDate);
    return `${start.toLocaleDateString()} - ${end.toLocaleDateString()}`;
  };

  return (
    <div className="checkout-container">
      <h1>Checkout</h1>

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
