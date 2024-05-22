import React from "react";
import "./MainSearch.css";
import SearchBar from "./SearchBar";

export const BACKENDURL = process.env.REACT_APP_BACKENDURL;

function MainSearch() {
  const background = "/api/get/image/0_0.png";
  const url = BACKENDURL

  return (
    <div
      className="MainSearch"
      style={{
        backgroundImage: "url("+ url + background + ")",
      }}
    >
      <div className="MainItems">
        <h1>Book your journey</h1>
        <SearchBar />
      </div>
    </div>
  );
}

export default MainSearch;
