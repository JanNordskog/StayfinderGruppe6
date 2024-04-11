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

    try {
      // Adjust the endpoint or params as necessary to match your API's requirements
      const response = await axios.get("http://localhost:8080/listings", {
        params: {
          destination: searchParams.destination,
          arrivalDate: searchParams.range[0].startDate
            .toISOString()
            .split("T")[0], // Format date as needed
          departureDate: searchParams.range[0].endDate
            .toISOString()
            .split("T")[0], // Format date as needed
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
          placeholder="Skal til"
          onChange={handleChange}
        />
        <DateRangeComp
          range={searchParams.range}
          setRange={(range) => setSearchParams({ ...searchParams, range })}
        />
        <select id="Gjester" name="guests" onChange={handleChange}>
          <option value="0">Antall gjester</option>
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
