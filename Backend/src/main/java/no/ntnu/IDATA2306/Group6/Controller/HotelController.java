/**
 * The HotelController class handles HTTP requests related to hotels.
 * It provides endpoints for retrieving hotels.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Entity.Hotel;
import no.ntnu.IDATA2306.Group6.Repo.HotelRepo;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepo hotelRepo;

    /**
     * Retrieves all hotels.
     *
     * @return A collection of all hotels
     */
    @GetMapping
    public Collection<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    /**
     * Retrieves a hotel by its ID.
     *
     * @param hotelId The ID of the hotel to retrieve
     * @return ResponseEntity containing the hotel if found, otherwise not found status
     */
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Optional<Hotel> hotel = hotelRepo.findById(hotelId);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
