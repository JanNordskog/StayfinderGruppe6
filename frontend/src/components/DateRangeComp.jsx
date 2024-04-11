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
    setOpen(false); // Optionally close the picker after selection
  };

  return (
    <div className="calendarWrap">
      <input
        value={`Fra ${format(range[0].startDate, "dd/MM/yyyy")} Til ${format(
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
