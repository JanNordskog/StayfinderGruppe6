import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar(){
    return(
        <div className="Navbar">
            <Link className="NavbarLink" to="/">Home</Link>
            <Link className="NavbarLink" to="/hotel">Hotel</Link>
        </div>
    );
}
export default Navbar;