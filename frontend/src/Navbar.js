import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
    return (
        <div class="navbar">
            <div className="logo">
            <Link className="NavbarLink" to="/">  <img src="http://localhost:8080/api/get/image/LogoIcon.png" alt="Logo" width="60" height="auto" /></Link>

           

            </div>
            <ul>
                <li><Link className="NavbarLink" to="/hotellDestinasjoner">Hotell & destinasjoner</Link></li>
                <li><Link className="NavbarLink" to="/UtvalgteTilbud">Utvalgte tilbud</Link></li>
                <li><Link className="NavbarLink" to="/hotel">Hotel</Link></li>
            </ul>
            <Link className="NavbarLink" to="/Login"><button>Logg inn</button></Link>
        </div>
    );
}
export default Navbar;