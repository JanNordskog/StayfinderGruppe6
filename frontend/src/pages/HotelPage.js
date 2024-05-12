import React, { useState } from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import DateRangeComp from '../components/DateRangeComp';
import './HotelPage.css';

function HotelPage() {
  const location = useLocation();
  const hotel = location.state?.data;

  const searchParams = JSON.parse(sessionStorage.getItem('searchParams') || '{}');
  const [dateRange, setDateRange] = useState([
    {
      startDate: new Date(searchParams?.range?.[0]?.startDate || new Date()),
      endDate: new Date(searchParams?.range?.[0]?.endDate || new Date()),
      key: 'selection',
    },
  ]);
  const isDateSelected = dateRange[0].startDate && dateRange[0].endDate;

  const navigate = useNavigate();

  const goToCheckOut = () => {
      navigate('/checkout', { state: { hotel: hotel, dateRange: dateRange } });
  };

  return (
      <div className="hotel-page-container">
        <header className="hotel-header">
          <h1>Hotel Details</h1>
        </header>
        <div className="hotel-main-content">
          {hotel ? (
              <>
                <div className="hotel-image">
                  <img src={hotel.imageLink} alt={hotel.hotelName} />
                  <p className="hotel-description">{hotel.hotelDescription}</p>
                </div>
                <div className="hotel-details">
                  <h2>{hotel.hotelName}</h2>
                  <p><strong>Address:</strong> {hotel.hotelAddress}</p>
                  <p><strong>Room Type Available:</strong> {hotel.roomTypeAvailable}</p>
                  <p><strong>Extra Features:</strong> {hotel.extraFeatures}</p>
                  <p><strong>Price:</strong> ${hotel.price.toFixed(2)}</p>
                  <DateRangeComp range={dateRange} setRange={setDateRange} />
                  <button className="book-now-btn" onClick={goToCheckOut} disabled={!isDateSelected}>
                    Book Now
                  </button>
                </div>
              </>
          ) : (
              <p>No hotel data available.</p>
          )}
        </div>
      </div>
  );
}

export default HotelPage;
