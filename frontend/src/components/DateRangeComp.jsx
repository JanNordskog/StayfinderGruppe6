import { useEffect, useRef, useState } from 'react'
import { DateRange } from 'react-date-range'

import format from 'date-fns/format'
import { addDays } from 'date-fns'

import 'react-date-range/dist/styles.css'
import 'react-date-range/dist/theme/default.css'
import "./DateRangeCalendar.css";

const DateRangeComp = () => {

  // date state
  const [range, setRange] = useState([
    {
      startDate: new Date(),
      endDate: addDays(new Date(), 0),
      key: 'selection'
    }
  ])

  // open close
  const [open, setOpen] = useState(false)

  // get the target element to toggle 
  const refOne = useRef(null)

  useEffect(() => {
    // event listeners
    document.addEventListener("keydown", hideOnEscape, true)
    document.addEventListener("click", hideOnClickOutside, true)
  }, [])

  // hide dropdown on ESC press
  const hideOnEscape = (e) => {
    // console.log(e.key)
    if( e.key === "Escape" ) {
      setOpen(false)
    }
  }

  // Hide on outside click
  const hideOnClickOutside = (e) => {
    // console.log(refOne.current)
    // console.log(e.target)
    if( refOne.current && !refOne.current.contains(e.target) ) {
      setOpen(false)
    }
  }

  return (
    <div className="calendarWrap">

      <input
        value={`Fra ${format(range[0].startDate, "dd/MMM/yy")} Til ${format(range[0].endDate, "dd/MMM/yy")}`}
        readOnly
        className="inputBox"
        placeholder="Datoer"
        onClick={ () => setOpen(open => !open) }
      />

      <div ref={refOne} className='DateRange'>
        {open && 
          <DateRange
            onChange={item => setRange([item.selection])}
            editableDateInputs={true}
            moveRangeOnFirstSelection={false}
            ranges={range}
            months={1}
            direction="horizontal"
            className="calendarElement"
          />
        }
      </div>

    </div>
  )
}

export default DateRangeComp