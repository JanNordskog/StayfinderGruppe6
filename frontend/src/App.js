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
      </Routes>
    </>
  );
}

export default App;
