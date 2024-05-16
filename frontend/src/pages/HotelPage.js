import React, {useEffect, useState} from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import DateRangeComp from '../components/DateRangeComp';
import { parse } from 'date-fns';
import './HotelPage.css';
import axios from "axios";

function HotelPage() {
  const location = useLocation();
  const hotel = location.state?.data;

  const searchParams = JSON.parse(sessionStorage.getItem('searchParams') || '{}');
  const [dateRange, setDateRange] = useState([
    {
      startDate: null,
      endDate: null,
      key: 'selection',
    },
  ]);
  const isDateSelected = dateRange[0].startDate && dateRange[0].endDate;
  const [openDate, setOpenDate] = useState("");
  const [closingDate, setClosingDate] = useState("");

  const navigate = useNavigate();

  const goToCheckOut = () => {
      navigate('/checkout', { state: { hotel: hotel, dateRange: dateRange } });
  };

    useEffect(() => {
        axios.get("http://localhost:8080/listings/getopendates/" + hotel.hotelID)
            .then((r) => {/*
                setClosingDate(parse(r.data.closedDate, "yyyy-MM-dd", new Date()));
                setOpenDate(parse(r.data.openDate, "yyy-MM-dd", new Date()));*/
                const minDate = parse(r.data.closedDate, "yyyy-MM-dd", new Date());
                const maxDate = parse(r.data.openDate, "yyyy-MM-dd", new Date());
                setClosingDate(minDate);
                setOpenDate(maxDate);
            })
    }, [hotel]);

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
                  <DateRangeComp min={openDate} max={closingDate} range={dateRange} setRange={setDateRange} />
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
