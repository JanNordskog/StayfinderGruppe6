import MainSearch from "../MainSearch";
import IconNavbar from "../IconNavbar";
import HotelShowCase from "../HotelSchowCase";
import DiscountAd from "../DiscountAd";

function Home() {
  return (
    <div className="Home">
      <MainSearch />
      <IconNavbar />
      <HotelShowCase />
      <DiscountAd />
    </div>
  );
}

export default Home;
