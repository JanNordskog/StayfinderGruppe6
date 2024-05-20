/**
 * The extrafeatureController class handles HTTP requests related to extra features of listings.
 * It provides an endpoint for retrieving listings based on extra features.
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
import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;
import no.ntnu.IDATA2306.Group6.Entity.Listing;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/extra")
public class extrafeatureController {

    @Autowired
    private ListingRepo listingRepo;

    @GetMapping
    @Operation(summary = "Retrieve listings by extra features", description = "Searches for listings that match specified extra features.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listings retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Listing>> getListingByExtraFeatures(@RequestParam String extraFeatures) {
        try {
            List<Listing> listings = listingRepo.findByHotelExtraFeatures(extraFeatures);
            return ResponseEntity.ok(listings);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
