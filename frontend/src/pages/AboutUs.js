import React from 'react';
import './AboutUs.css'; // Assuming you have an accompanying CSS file for styling

function AboutUs() {
  const API_BASE_PATH = process.env.REACT_APP_API_BASE_PATH;

  return (
      <div className="us">
        <meta name="viewport" content="width=device, initial-scale=1.0" />
        <h1>About us:</h1>
        <p>Welcome to Stay Finder, your premier destination for discovering the most exceptional
          accommodation deals for both leisure and business travel. At Stay Finder, we believe that finding
          the perfect place to stay should be straightforward and rewarding.</p>
        <p>Our mission is to simplify your search for the best accommodation prices and options. We do this
          by bringing together a curated selection of unique properties from various trusted websites into
          one user-friendly platform. This aggregation not only saves you time but also ensures you're
          getting great value by comparing prices side-by-side.
        </p>
        <p>But Stay Finder is more than just a search engine for great deals. We're a comprehensive travel
          companion committed to enhancing your stay experience. Our platform features a range of
          properties from cozy bed-and-breakfasts to luxurious resorts, each with detailed descriptions,
          high-quality images, and honest reviews from travelers like you.</p>
        <p>We pride ourselves on transparency and convenience, eliminating the need to trawl through
          multiple websites. With just a few clicks, Stay Finder presents you with an array of choices,
          allowing you to filter results according to your preferences, whether it's by price, location,
          amenities, or property type. Our innovative tools and features are designed to give you the power
          to plan your stay with confidence. Explore interactive maps to find accommodations in the
          vicinity of your interests, get personalized recommendations based on your past searches and
          bookings, and set up alerts for price drops on your favorite spots.</p>
        <div className='cards'>
          <div className="flip-card">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img
                    src={`${API_BASE_PATH}/api/get/image/jan.png`}
                    alt="Avatar"
                    style={{ width: "300px", height: "300px" }}
                />
              </div>
              <div className="flip-card-back">
                <h1>Jan Nordskog</h1>
                <p>Website Developer</p>
                <p>Computer Engineer</p>
              </div>
            </div>
          </div>
          <div className="flip-card">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img
                    src={`${API_BASE_PATH}/api/get/image/ulrik.png`}
                    alt="Avatar"
                    style={{ width: "300px", height: "300px" }}
                />
              </div>
              <div className="flip-card-back">
                <h1>Ulrik Ribler</h1>
                <p>Website Developer</p>
                <p>Computer Engineer</p>
              </div>
            </div>
          </div>
          <div className="flip-card">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img
                    src={`${API_BASE_PATH}/api/get/image/alejandro.png`}
                    alt="Avatar"
                    style={{ width: "300px", height: "300px" }}
                />
              </div>
              <div className="flip-card-back">
                <h1>Alejandro Miguel Talley Grønhaug</h1>
                <p>Website Developer</p>
                <p>Computer Engineer</p>
              </div>
            </div>
          </div>
          <div className="flip-card">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img
                    src={`${API_BASE_PATH}/api/get/image/avnit.png`}
                    alt="Avatar"
                    style={{ width: "300px", height: "300px" }}
                />
              </div>
              <div className="flip-card-back">
                <h1>Avnit Simon Singh Anand</h1>
                <p>Website Developer</p>
                <p>Computer Engineer</p>
              </div>
            </div>
          </div>
        </div>
        <p>Join Stay Finder today and embark on a journey to find stays that are as unique as your travel
          plans. Whether you're looking for a quaint hideaway for a weekend escape, a strategic hotel for
          your business meetings, or a stunning venue for your family holiday, we have something to suit
          every desire and budget. With Stay Finder, every trip you take is bound to be memorable,
          comfortable, and impeccably arranged.
        </p>
      </div>
  );
}

export default AboutUs;
