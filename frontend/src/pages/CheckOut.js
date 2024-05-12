import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function CheckOut() {
    const navigate = useNavigate();

    // States for form data
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [creditCard, setCreditCard] = useState('');
    const [expiryDate, setExpiryDate] = useState('');
    const [cvv, setCVV] = useState('');

    // Function to handle form submission
    const handleCheckout = (event) => {
        event.preventDefault();
        // Add validation and API calls if needed
        console.log('Submitting:', name, email, creditCard, expiryDate, cvv);
        // Navigate to a confirmation page or handle next steps
        navigate('/confirmation');
    };

    return (
        <div className="checkout-container">
            <h1>Checkout</h1>
            <form onSubmit={handleCheckout}>
                <label>
                    Name:
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
                </label>
                <label>
                    Email:
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </label>
                <label>
                    Credit Card Number:
                    <input type="text" value={creditCard} onChange={(e) => setCreditCard(e.target.value)} required />
                </label>
                <label>
                    Expiry Date:
                    <input type="month" value={expiryDate} onChange={(e) => setExpiryDate(e.target.value)} required />
                </label>
                <label>
                    CVV:
                    <input type="number" value={cvv} onChange={(e) => setCVV(e.target.value)} required />
                </label>
                <button type="submit">Complete Booking</button>
            </form>
        </div>
    );
}

export default CheckOut;
