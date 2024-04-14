import React from 'react';
import { Link } from "react-router-dom";
import "./DiscountAd.css";

const DiscountAd = () => {
    return (
        <div className="Background">
            <ul>
                <li>
                    <h1>Get your discounts!<br /> Login at <Link to="/login">stayfinder.com</Link> to collect your points now.</h1>
                </li>
                <li>
                    <p>We collect the best prices for you on the internet.
                        Sign up now to collect exclusive discounts and save points for your next destinations!</p>
                </li>
            </ul>
        </div>
    );
};

export default DiscountAd;