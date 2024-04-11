import { Link } from "react-router-dom";
import "./HotelSchowCase.css";

function HotelShowCase() {
  return (
    <div class="hotelshowcase">
      <div class="container">
        <h1>Utforsk populære destinasjoner</h1>
        <ul class="destinations">
          <li class="destination">
            <a href="#">
              <img
                src="http://localhost:8080/api/get/image/Oslo.jpg"
                alt="Home"
              />
              <h2>Oslo</h2>
              <p>Norge</p>
            </a>
          </li>
          <li class="destination">
            <a href="#">
              <img
                src="http://localhost:8080/api/get/image/Ålesund.jpg"
                alt="Home"
              />
              <h2>Ålesund</h2>
              <p>Norge</p>
            </a>
          </li>
          <li class="destination">
            <a href="#">
              <img
                src="http://localhost:8080/api/get/image/Amsterdam.png"
                alt="Home"
              />
              <h2>Amsterdam</h2>
              <p>Nederland</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
  );
}
export default HotelShowCase;
