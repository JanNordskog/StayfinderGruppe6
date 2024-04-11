// MainSearch.jsx
import React from "react";
import "./MainSearch.css";
import SearchBar from "./SearchBar"; // Adjust the import path as needed

function MainSearch() {
  const background = "api/get/image/StayfinderSearchbackground.png";

  return (
    <div
      className="MainSearch"
      style={{
        backgroundImage: "url(http://localhost:8080/" + background + ")",
      }}
    >
      <div className="MainItems">
        <h1>Hvor vil du reise?</h1>
        <SearchBar />
      </div>
    </div>
  );
}

export default MainSearch;
