import { Link } from "react-router-dom";
import "./MainSearch.css";
import DateRangeComp from './components/DateRangeComp.jsx'

function MainSearch() {

    const background = "api/get/image/StayfinderSearchbackground.png";

    return (
        <div className="MainSearch" style={{"backgroundImage" : "url(http://localhost:8080/" + background + ")"}}>
           <div className="MainItems"> 
         <h1>Hvor vil du reise?</h1>
         <form>
            <input type="text" id="destination" name="destination" placeholder="Skal til"/>
            <DateRangeComp />
            {/* <input type="number" id="guests" name="guests" min="1" placeholder="Gjester"/> */}
            <select id="Gjester" name="Gjester" placeholder="Antall gjester">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
            </select>
            <div className="Søk">
            <button>Søk</button>
            </div>
         </form> 
         </div>
        </div>
    );
}
export default MainSearch;
