import { useEffect, useRef, useState } from "react";
import { DateRange } from "react-date-range";
import format from "date-fns/format";
import { addDays } from "date-fns"; // Import addDays from date-fns
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import "./DateRangeCalendar.css";

const DateRangeComp = ({ range, setRange, min = null, max = null, bookedDates = [] }) => {
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

  

  const displayValue = () => {
    if (range[0].startDate && range[0].endDate) {
      try {
        const startDate = format(range[0].startDate, "dd/MM/yyyy");
        const endDate = format(range[0].endDate, "dd/MM/yyyy");
        return `From ${startDate} To ${endDate}`;
      } catch (error) {
        console.error("Invalid date format", error);
        return "";
      }
    }
    return "";
  };

  const validDate = (date) => {
    return date instanceof Date && !isNaN(date);
  };

  const getValidMinDate = () => {
    return validDate(min) ? min : new Date();
  };

  const getValidMaxDate = () => {
    return validDate(max) ? max : addDays(new Date(), 365);
  };

  return (
      <div className="calendarWrap">
        <input
            value={displayValue()}
            readOnly
            className="inputBox"
            placeholder="From ddMMyyy To ddMMyyyy"
            onClick={() => setOpen(!open)}
        />

        <div ref={pickerRef}>
          {open && (
              <DateRange
                  minDate={getValidMinDate()}
                  maxDate={getValidMaxDate()}
                  editableDateInputs={true}
                  onChange={handleSelect}
                  moveRangeOnFirstSelection={false}
                  ranges={range}
                  months={2}
                  direction="horizontal"
                  className="calendarElement"
                  disabledDates={bookedDates}
              />
          )}
        </div>
      </div>
  );
};

export default DateRangeComp;
