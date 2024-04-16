// SearchBar.jsx
import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import DateRangeComp from "./components/DateRangeComp"; // Adjust the import path as needed
import "./SearchBar.css";
import { addDays } from "date-fns";

function SearchBar() {
  const navigate = useNavigate();
  const [searchParams, setSearchParams] = useState({
    destination: "",
    guests: "0",
    range: [
      {
        startDate: new Date(),
        endDate: addDays(new Date(), 0),
        key: "selection",
      },
    ],
  });

  const handleChange = (event) => {
    setSearchParams({
      ...searchParams,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const { destination, range } = searchParams;
    const { startDate, endDate } = range[0]; // Assuming the first range item contains the dates

    try {
      const response = await axios.get("http://localhost:8080/listings/engine", {
        params: {
          destination: destination,
          arrivalDate: startDate.toISOString().split("T")[0], // Format the date as 'YYYY-MM-DD'
          departureDate: endDate.toISOString().split("T")[0], // Format the date as 'YYYY-MM-DD'
        },
      });

      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Search failed:", error);
    }
  };

  return (
    <div className="MainItems">
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          id="destination"
          name="destination"
          placeholder="Going to"
          onChange={handleChange}
        />
        <DateRangeComp
          range={searchParams.range}
          setRange={(range) => setSearchParams({ ...searchParams, range })}
        />
        <select id="Gjester" name="guests" onChange={handleChange}>
          <option value="0">Guests</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
        </select>
        <div className="Søk">
          <button type="submit">Søk</button>
        </div>
      </form>
    </div>
  );
}

export default SearchBar;
