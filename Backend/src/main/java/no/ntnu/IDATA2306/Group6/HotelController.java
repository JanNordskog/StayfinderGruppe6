package no.ntnu.IDATA2306.Group6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/hotels")
public class HotelController {


    private final Map<String, Hotel> hotels = new HashMap<>();

    @GetMapping
    public Collection<Hotel> getAllHotels() {
        return hotels.values();
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel newHotel) {

        if (hotels.containsKey(newHotel.getHotelID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        hotels.put(newHotel.getHotelID(), newHotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        Hotel hotel = hotels.get(hotelId);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel updatedHotel) {
        if (!hotels.containsKey(hotelId)) {
            return ResponseEntity.notFound().build();
        }
        hotels.put(hotelId, updatedHotel);
        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String hotelId) {
        if (!hotels.containsKey(hotelId)) {
            return ResponseEntity.notFound().build();
        }
        hotels.remove(hotelId);
        return ResponseEntity.noContent().build();
    }
}
