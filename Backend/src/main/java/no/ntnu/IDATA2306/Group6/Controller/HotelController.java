/**
 * The HotelController class handles HTTP requests related to hotels.
 * It provides endpoints for retrieving hotels.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Retrieve all hotels", description = "Retrieves a collection of all available hotels in the repository.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "All hotels retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    public Collection<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @GetMapping("/{hotelId}")
    @Operation(summary = "Retrieve a hotel by ID", description = "Fetches a single hotel by its unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Optional<Hotel> hotel = hotelRepo.findById(hotelId);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
