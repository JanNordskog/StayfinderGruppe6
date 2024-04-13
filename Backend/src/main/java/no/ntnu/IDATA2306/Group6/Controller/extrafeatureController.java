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
