/**
 * The extrafeatureController class handles HTTP requests related to extra features of listings.
 * It provides an endpoint for retrieving listings based on extra features.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;
import no.ntnu.IDATA2306.Group6.Entity.Listing;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/extra")
public class extrafeatureController {

    @Autowired
    private ListingRepo listingRepo;
    /**
     * Retrieves listings based on extra features.
     *
     * @param extraFeatures The extra features to search for in listings
     * @return ResponseEntity containing the list of listings matching the extra features,
     *         or internal server error if an exception occurs
     */
    @GetMapping
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
