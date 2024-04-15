import React from "react";
import { useLocation } from "react-router-dom";
import "./ControlPanel.css";

function ControlPanel() {
  const location = useLocation(); // Hook to access router state
  const user = location.state?.user; // Access user data passed in state

  return (
    <div className="Panel">
      <h1>Du har nå logget inn</h1>
      {user && (
        <div>
          <h2>Velkommen, {user.name}</h2>
          <p>Email: {user.email}</p>
          <p>Address: {user.address}</p>
          <p>Phone: {user.phone}</p>
          <p>Gender: {user.gender}</p>
          <p>Date of Birth: {user.dob}</p>
        </div>
      )}
    </div>
  );
}

export default ControlPanel;
