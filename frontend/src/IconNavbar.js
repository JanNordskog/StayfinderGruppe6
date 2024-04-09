import { Link } from "react-router-dom";
import "./IconNavbar.css";

const IconNavbar = () => {
  return (
    <>
    <nav className="IconNavbar">
      <ul>
        <li><Link className="NavbarLink" to="/Home"><img src="http://localhost:8080/api/get/image/HouseIcon.png" alt="Home" />Hotell & destinasjoner</Link></li>
        <li><Link className="NavbarLink" to="/Home"><img src="http://localhost:8080/api/get/image/HouseIcon.png" alt="Home" />Hotell & destinasjoner</Link></li>
        <li><Link className="NavbarLink" to="/Home"><img src="http://localhost:8080/api/get/image/HouseIcon.png" alt="Home" />Hotell & destinasjoner</Link></li>    
        <li><Link className="NavbarLink" to="/Home"><img src="http://localhost:8080/api/get/image/HouseIcon.png" alt="Home" />Hotell & destinasjoner</Link></li>
      </ul>
    </nav>
    <hr />
    </>
  );
};

export default IconNavbar;
