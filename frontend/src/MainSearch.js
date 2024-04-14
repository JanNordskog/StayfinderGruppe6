import React from "react";
import { Link } from "react-router-dom";
import "./MainSearch.css";
import SearchBar from "./SearchBar";

function MainSearch() {
    const background = "api/get/image/0_0.png";

    return (
        <div
            className="MainSearch"
            style={{
                backgroundImage: "url(http://localhost:8080/" + background + ")",
            }}
        >
            <div className="MainItems">
                <h1>Where do you want to go?</h1>
                <SearchBar />
            </div>
        </div>
    );
}

export default MainSearch;
