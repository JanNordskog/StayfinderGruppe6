import React from "react";
import "./MainSearch.css";
import SearchBar from "./SearchBar";

function MainSearch() {
  const background = "0_0.png";

  return (
      <div
          className="MainSearch"
          style={{
            backgroundImage: `url(${process.env.REACT_APP_IMAGE_BASE_PATH}${background})`,
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
