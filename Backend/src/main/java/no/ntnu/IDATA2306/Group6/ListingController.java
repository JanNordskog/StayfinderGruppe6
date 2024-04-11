package no.ntnu.IDATA2306.Group6;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/listings")
public class ListingController {

    @GetMapping
    public ResponseEntity<List<Listing>> getAllListings() {
        try {
            List<Listing> listings = new DatabaseConnection().getListings();
            System.out.println(listings);
            return ResponseEntity.ok(listings);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(params = "destination")
    public ResponseEntity<List<Listing>> getListingsByDestination(@RequestParam String destination) {
        try {
            System.out.println(destination);
            List<Listing> listings = new DatabaseConnection().getListingsByDestination(destination);
            return ResponseEntity.ok(listings);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createListing(@RequestBody Listing newListing) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            dbConnection.addListing(newListing);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{listingId}")
    public ResponseEntity<Listing> getListing(@PathVariable String listingId) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Listing listing = dbConnection.getListing(listingId);
            if (listing != null) {
                return ResponseEntity.ok(listing);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{listingId}")
    public ResponseEntity<?> updateListing(@PathVariable String listingId, @RequestBody Listing updatedListing) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            boolean updated = dbConnection.updateListing(listingId, updatedListing);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{listingId}")
    public ResponseEntity<Void> deleteListing(@PathVariable String listingId) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            boolean deleted = dbConnection.deleteListing(listingId);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
