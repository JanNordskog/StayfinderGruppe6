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

    @GetMapping
    public Collection<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Optional<Hotel> hotel = hotelRepo.findById(hotelId);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
