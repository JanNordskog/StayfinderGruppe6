// SearchBar.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import DateRangeComp from "./components/DateRangeComp"; // Adjust the import path as needed
import "./SearchBar.css";

function SearchBar() {
  const [searchParams, setSearchParams] = useState({
    destination: "",
    guests: "0",
  });

  const navigate = useNavigate();

  const handleChange = (event) => {
    setSearchParams({
      ...searchParams,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get("http://localhost:8080/listings", {
        params: {
          destination: searchParams.destination,
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
        <DateRangeComp />
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
