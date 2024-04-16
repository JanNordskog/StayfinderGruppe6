import React from 'react';
import Footer from "../Footer";
import './AboutUs.css'; // Assuming you have an accompanying CSS file for styling

function AboutUs() {
    return (
        <div className="hotel">
            <h1>About us:</h1>
            <div className="flip-card">
                <div className="flip-card-inner">
                    <div className="flip-card-front">
                        <img src="http://localhost:8080/api/get/image/jan.jpg" alt="Avatar" style={{ width: '300px', height: '300px' }} />
                    </div>
                    <div className="flip-card-back">
                        <h1>Jan Nordskog</h1>
                        <p>Architect & Engineer</p>
                        <p>We love that guy</p>
                    </div>
                </div>
            </div>
            <div className="flip-card">
                <div className="flip-card-inner">
                    <div className="flip-card-front">
                        <img src="http://localhost:8080/api/get/image/ulrik.png" alt="Avatar" style={{ width: '300px', height: '300px' }} />
                    </div>
                    <div className="flip-card-back">
                        <h1>Ulrik Ribler</h1>
                        <p>Architect & Engineer</p>
                        <p>We love that guy</p>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default AboutUs;
