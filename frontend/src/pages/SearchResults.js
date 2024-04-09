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
                            {/* Display the hotel name instead of the hotel ID */}
                            <h2>{item.hotelName}</h2>
                            <p><strong>Address:</strong> {item.hotelAddress}</p>
                            <p><strong>Room Type Available:</strong> {item.roomTypeAvailable}</p>
                            <p><strong>Extra Features:</strong> {item.extraFeatures}</p>
                            {/* Display the agency name */}
                            <p><strong>Agency:</strong> {item.agencyName}</p>
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
