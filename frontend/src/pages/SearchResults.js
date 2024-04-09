import React from 'react';
import { useLocation } from 'react-router-dom';
import './SearchResults.css'; // Assuming you have a CSS file for styling

function SearchResults() {
    const location = useLocation();
    const { data } = location.state || { data: [] };

    return (
        <div className="SearchResults">
            <h1>Dette er SearchResults page</h1>
            <div className="listings-grid">
                {data.length > 0 ? (
                    data.map((item, index) => (
                        <div className="listing-card" key={index}>
                            <h2>Hotel ID: {item.hotelID}</h2>
                            <p><strong>Agency:</strong> {item.agencyID}</p>
                            <p><strong>Arrival:</strong> {new Date(item.arrivalDate).toLocaleDateString()}</p>
                            <p><strong>Departure:</strong> {new Date(item.departureDate).toLocaleDateString()}</p>
                            <p className="price"><strong>Price:</strong> ${item.price}</p>
                        </div>
                    ))
                ) : (
                    <p>Ingen resultater funnet.</p>
                )}
            </div>
        </div>
    );
}

export default SearchResults;
