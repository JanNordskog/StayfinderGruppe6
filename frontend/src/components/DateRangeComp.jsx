import { useEffect, useRef, useState } from "react";
import { DateRange } from "react-date-range";

import format from "date-fns/format";
import { addDays } from "date-fns";

import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import "./DateRangeCalendar.css";

const DateRangeComp = ({ range, setRange }) => {
  // State to manage the visibility of the DateRange picker
  const [open, setOpen] = useState(false);

  const handleSelect = (ranges) => {
    setRange([ranges.selection]);
    //setOpen(false); // Close picker after selection
  };

  // When opening the date picker, initialize with today's date if no date has been selected
  const handleClick = () => {
    if (!range[0].startDate || !range[0].endDate) {
      setRange([
        {
          startDate: new Date(),
          endDate: new Date(),
          key: "selection",
        },
      ]);
    }
    setOpen(!open);
  };

  // Adjust the input value to display dates only if they are selected
  const displayValue =
    range[0].startDate && range[0].endDate
      ? `From ${format(range[0].startDate, "dd/MM/yyyy")} To ${format(
          range[0].endDate,
          "dd/MM/yyyy"
        )}`
      : "";

  // Use handleClick for the onClick handler
  <input
    value={displayValue}
    readOnly
    className="inputBox"
    placeholder="Datoer"
    onClick={handleClick}
  />;

  return (
    <div className="calendarWrap">
      <input
        value={`From ${format(range[0].startDate, "dd/MM/yyyy")} To ${format(
          range[0].endDate,
          "dd/MM/yyyy"
        )}`}
        readOnly
        className="inputBox"
        placeholder="Datoer"
        onClick={() => setOpen(!open)} // Toggles the visibility of the DateRange picker
      />

      {open && ( // Only render the DateRange picker if 'open' is true
        <DateRange
          editableDateInputs={true}
          onChange={handleSelect}
          moveRangeOnFirstSelection={false}
          ranges={range}
          months={2} // Adjust based on your requirement
          direction="horizontal"
          className="calendarElement"
        />
      )}
    </div>
  );
};
export default DateRangeComp;
