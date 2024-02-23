import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar(){
    return(
        <div className="Navbar">
            <ul>
                <li> <div className="Logo">
            <img src="http://localhost:8080/api/get/image/Logo.png" alt="Logo"width="50" height="auto"></img>
            </div></li>
                <li> <Link className="NavbarLink" to="/">Home</Link></li>
                <li> <Link className="NavbarLink" to="/hotel">Hotel</Link></li>

            </ul>
        </div>
    );
}
export default Navbar;