import React from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import './Confirmation.css';

function Confirmation() {
    const navigate = useNavigate();
    const location = useLocation();
    const email = location.state?.email || 'your email';
    const handleGoHome = () => {
        navigate('/', { replace: true });
    };

    return (
        <div className="confirmation-container">
            <h1>Reservation Confirmed!</h1>
            <p>Thank you so much for your reservation!</p>
            <p>Booking confirmation has been sent to <strong>{email}</strong>.</p>
        </div>
    );
}

export default Confirmation;
