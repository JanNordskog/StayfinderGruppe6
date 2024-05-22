import React from 'react';
import {useLocation} from 'react-router-dom';
import './Confirmation.css';

export const BACKENDURL = process.env.REACT_APP_BACKENDURL;

function Confirmation() {
    const location = useLocation();
    const email = location.state?.email || 'your email';
    
    return (
        <div className="confirmation-container">
            <h1>Reservation Confirmed!</h1>
            <p>Thank you so much for your reservation!</p>
            <p>Booking confirmation has been sent to <strong>{email}</strong>.</p>
        </div>
    );
}

export default Confirmation;
