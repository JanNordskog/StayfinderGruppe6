import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./IconNavbar.css";

export const BACKENDURL = process.env.REACT_APP_BACKENDURL;
export const IMGURL = process.env.REACT_APP_IMGURL;

const IconNavbar = () => {
  const navigate = useNavigate(); // Hook to programmatically navigate
  const navRef = useRef(null);

  const handleNavigateToBar = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "bar",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToSpa = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "spa",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToResort = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "resort",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToBusinessCenter = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "business center",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToFitnessCenter = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "fitness center",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToArtDecor = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "art decor",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToGym = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "gym",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToRoofTop = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "rooftop",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToEcoFriendly = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "eco-friendly",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToBabySitting = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "babysitting",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToDining = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "dining",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToExotic = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "exotic",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToArtic = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "artic",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToBeach = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "beach",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToCheap = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "cheap",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  const handleNavigateToWedding = async () => {
    try {
      const response = await axios.get(`${BACKENDURL}/extra`, {
        params: {
          extraFeatures: "wedding",
        },
      });
      navigate("/searchResults", { state: { data: response.data } });
    } catch (error) {
      console.error("Failed to fetch listings based on extra features:", error);
    }
  };

  return (
    <>
      <nav className="IconNavbar">
        <ul ref={navRef}>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToBar} href="#!">
              <img src={`${IMGURL}/api/get/image/Bar.png`} alt="Bar" />
              Bar
            </a>
          </li>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToSpa} href="#!">
              <img src={`${IMGURL}/api/get/image/Spa.png`} alt="Spa" />
              Spa
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToResort}
              href="#!"
            >
              <img src={`${IMGURL}/api/get/image/Resort.png`} alt="Resort" />
              Resort
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToBusinessCenter}
              href="#!"
            >
              <img
                src={`${IMGURL}/api/get/image/BusinessCenter.png`}
                alt="Business Center"
              />
              Business Center
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToFitnessCenter}
              href="#!"
            >
              <img
                src={`${IMGURL}/api/get/image/FitnessCenter.png`}
                alt="Fitness Center"
              />
              Fitness Center
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToArtDecor}
              href="#!"
            >
              <img
                src={`${IMGURL}/api/get/image/ArtDecor.png`}
                alt="Art Decor"
              />
              Art Decor
            </a>
          </li>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToGym} href="#!">
              <img src={`${IMGURL}/api/get/image/Gym.png`} alt="Gym" />
              Gym
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToRoofTop}
              href="#!"
            >
              <img src={`${IMGURL}/api/get/image/RoofTop.png`} alt="Roof Top" />
              Roof Top
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToEcoFriendly}
              href="#!"
            >
              <img
                src={`${IMGURL}/api/get/image/EcoFriendly.png`}
                alt="Eco-Friendly"
              />
              Eco-friendly
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToBabySitting}
              href="#!"
            >
              <img
                src={`${IMGURL}/api/get/image/BabySitting.png`}
                alt="Babysitting"
              />
              Babysitting
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToDining}
              href="#!"
            >
              <img src={`${IMGURL}/api/get/image/Dining.png`} alt="Dining" />
              Dining
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToExotic}
              href="#!"
            >
              <img src={`${IMGURL}/api/get/image/Exotic.png`} alt="Exotic" />
              Exotic
            </a>
          </li>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToArtic} href="#!">
              <img src={`${IMGURL}/api/get/image/Artic.png`} alt="Artic" />
              Artic
            </a>
          </li>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToBeach} href="#!">
              <img src={`${IMGURL}/api/get/image/Beach.png`} alt="Beach" />
              Beach
            </a>
          </li>
          <li>
            <a className="NavbarLink" onClick={handleNavigateToCheap} href="#!">
              <img src={`${IMGURL}/api/get/image/Cheap.png`} alt="Cheap" />
              Cheap
            </a>
          </li>
          <li>
            <a
              className="NavbarLink"
              onClick={handleNavigateToWedding}
              href="#!"
            >
              <img src={`${IMGURL}/api/get/image/Wedding.png`} alt="Wedding" />
              Wedding
            </a>
          </li>
        </ul>
      </nav>
      <hr />
    </>
  );
};

export default IconNavbar;
