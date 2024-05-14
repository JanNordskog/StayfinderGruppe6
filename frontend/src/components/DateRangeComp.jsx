import { useEffect, useRef, useState } from "react";
import { DateRange } from "react-date-range";

import format from "date-fns/format";
import { addDays } from "date-fns";

import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import "./DateRangeCalendar.css";

const DateRangeComp = ({ range, setRange }) => {
  const [open, setOpen] = useState(false);
  const pickerRef = useRef(null);

  const handleClickOutside = (event) => {
    if (pickerRef.current && !pickerRef.current.contains(event.target)) {
      setOpen(false);
    }
  };

  useEffect(() => {
    if (open) {
      document.addEventListener("mousedown", handleClickOutside);
    } else {
      document.removeEventListener("mousedown", handleClickOutside);
    }
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [open]);

  const handleSelect = (ranges) => {
    setRange([ranges.selection]);
  };


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


  const displayValue =
    range[0].startDate && range[0].endDate
      ? `From ${format(range[0].startDate, "dd/MM/yyyy")} To ${format(
          range[0].endDate, "dd/MM/yyyy"
        )}`
      : "";


  return (
    <div className="calendarWrap">
      <input
        value={displayValue}
        readOnly
        className="inputBox"
        placeholder="From ddMMyyy To ddMMyyyy"
        onClick={() => setOpen(!open)} // Toggles the visibility of the DateRange picker
      />

      <div ref={pickerRef}>
        {open && (
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
    </div>
  );
};
export default DateRangeComp;
