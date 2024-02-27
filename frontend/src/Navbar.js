import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
    return (
        <div class="navbar">
            <div className="logo">
                <img src="http://localhost:8080/api/get/image/Logo.png" alt="Logo" width="190" height="auto"></img>
            </div>
            <ul>
                <li><Link className="NavbarLink" to="/">Hotell & destinasjoner</Link></li>
                <li><Link className="NavbarLink" to="/hotel">Utvalgte tilbud</Link></li>
                <li><Link className="NavbarLink" to="/hotel">Hotel</Link></li>
            </ul>
            <button>Logg inn</button>
        </div>
    );
}
export default Navbar;