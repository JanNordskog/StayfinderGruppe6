package no.ntnu.IDATA2306.Group6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/listings")
public class ListingController {

    private final Map<String, Listing> listings = new HashMap<>();

    @GetMapping
    public Collection<Listing> getAllListings() {
        return listings.values();
    }

    @PostMapping
    public ResponseEntity<Listing> createListing(@RequestBody Listing newListing) {
        if (listings.containsKey(newListing.getListingID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        listings.put(newListing.getListingID(), newListing);
        return ResponseEntity.status(HttpStatus.CREATED).body(newListing);
    }

    @GetMapping("/{listingId}")
    public ResponseEntity<Listing> getListing(@PathVariable String listingId) {
        Listing listing = listings.get(listingId);
        if (listing != null) {
            return ResponseEntity.ok(listing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{listingId}")
    public ResponseEntity<Listing> updateListing(@PathVariable String listingId, @RequestBody Listing updatedListing) {
        if (!listings.containsKey(listingId)) {
            return ResponseEntity.notFound().build();
        }
        listings.put(listingId, updatedListing);
        return ResponseEntity.ok(updatedListing);
    }

    @DeleteMapping("/{listingId}")
    public ResponseEntity<Void> deleteListing(@PathVariable String listingId) {
        if (!listings.containsKey(listingId)) {
            return ResponseEntity.notFound().build();
        }
        listings.remove(listingId);
        return ResponseEntity.noContent().build();
    }
}
