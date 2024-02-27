import { Link } from "react-router-dom";
import "./MainSearch.css";
import DateRangeComp from './components/DateRangeComp.jsx'

function MainSearch() {
    return (
        <div className="MainSearch">
           <div className="MainItems"> 
         <h1>Hvor vil du reise?</h1>
         <form>
            <input type="text" id="destination" name="destination" placeholder="Skal til"/><br/>
            <DateRangeComp />
            <input type="number" id="guests" name="guests" min="1" placeholder="Gjester"/>
            <div className="Søk">
            <button>Søk</button>
            </div>
         </form> 
         </div>
        </div>
    );
}
export default MainSearch;
