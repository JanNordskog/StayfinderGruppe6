import { Route, Routes } from 'react-router-dom'; 

import './App.css';
import Home from './pages/Home';
import Login from './pages/Login';
import HotellDestinasjoner from './pages/HotellDestinasjoner'; 
import Hotel from './pages/Hotel'; 
import UtvalgteTilbud from './pages/UtvalgteTilbud'; 
import Registrer from './pages/Registrer'; 
import SearchResults from './pages/SearchResults'; 

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/login' element={<Login />} />
        <Route path='/hotellDestinasjoner' element={<HotellDestinasjoner />} />
        <Route path='/hotel' element={<Hotel />} />
        <Route path='/utvalgteTilbud' element={<UtvalgteTilbud />} />
        <Route path='/registrer' element={<Registrer />} />
        <Route path='/searchResults' element={<SearchResults />} />
      </Routes>
    </>
  );
}

export default App;
