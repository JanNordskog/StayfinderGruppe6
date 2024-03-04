import './css/Home.css';
import MainSearch from '../MainSearch';
import IconNavbar from '../IconNavbar';
import HotelShowCase from '../HotelSchowCase';
import DiscountAd from '../DiscountAd';
import Footer from '../Footer';

function Home() {
    return(
        <div className="Home">
              <MainSearch/>
             <IconNavbar/>
               <HotelShowCase/>
             <DiscountAd/>
             <Footer/>
        </div>
    );
}

export default Home;