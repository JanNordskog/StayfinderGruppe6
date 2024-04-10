import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
    const [isActive, setIsActive] = useState(false);

    const toggleMenu = () => {
        setIsActive(!isActive);
    };

    return (
        <div className={`navbar ${isActive ? 'active' : ''}`}>
            <div className="logo">
                <Link className="NavbarLink" to="/">
                    <img src="http://localhost:8080/api/get/image/LogoIcon.png" alt="Logo" />
                </Link>
            </div>
            <div className="hamburger" onClick={toggleMenu}>
                <img src="http://localhost:8080/api/get/image/Hamburgermenu.png" alt="Menu" />
            </div>
            <ul className={isActive ? 'nav-links-mobile' : 'nav-links'} onClick={() => setIsActive(false)}>
                <li><Link className="NavbarLink" to="/hotellDestinasjoner">Hotell & destinasjoner</Link></li>
                <li><Link className="NavbarLink" to="/UtvalgteTilbud">Utvalgte tilbud</Link></li>
                <li><Link className="NavbarLink" to="/hotel">Hotel</Link></li>
                <Link className="NavbarLink3" to="/Login"><button>Logg inn</button></Link>
            </ul>
            <div className="logg-inn-desktop">
                <Link className="NavbarLink2" to="/Login"><button>Logg inn</button></Link>
            </div>
        </div>
    );
}

export default Navbar;
