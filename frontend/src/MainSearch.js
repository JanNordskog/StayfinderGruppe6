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
                <option value="0">Antall gjester</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
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
