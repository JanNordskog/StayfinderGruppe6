import { Route, Routes } from "react-router-dom";

import "./App.css";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Hotel from "./pages/Hotel";
import UtvalgteTilbud from "./pages/UtvalgteTilbud";
import Registrer from "./pages/Registrer";
import SearchResults from "./pages/SearchResults";
import HotelPage from "./pages/HotelPage";
import ControlPanel from "./pages/ControlPanel";
import AboutUs from "./pages/AboutUs";
import CheckOut from "./pages/CheckOut";
import Confirmation from "./pages/Confirmation";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/hotel" element={<Hotel />} />
        <Route path="/utvalgteTilbud" element={<UtvalgteTilbud />} />
        <Route path="/registrer" element={<Registrer />} />
        <Route path="/searchResults" element={<SearchResults />} />
        <Route path="/hotelPage" element={<HotelPage />} />
        <Route path="/controlPanel" element={<ControlPanel />} />
        <Route path="/aboutus" element={<AboutUs />} />
        <Route path="/checkout" element={<CheckOut />} />
        <Route path="/confirmation" element={<Confirmation />} />
      </Routes>
    </>
  );
}

export default App;
