package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.DatabaseConnection;
import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingRepo listingRepo;

    @GetMapping
    public Collection<Listing> getAll() {
        System.out.println("nudawegrphnmfæmgåpmhsæll");
        return listingRepo.findAll();
    }

    @GetMapping(params = { "destination", "arrivalDate", "departureDate" })
    public ResponseEntity<List<Listing>> getListingsByDestinationAndDates(
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
        LocalDate today = LocalDate.now();
        List<Listing> listings = new ArrayList<>();

        // Check if both arrivalDate and departureDate are today
        if (arrivalDate.equals(today) && departureDate.equals(today)) {
            // Fetch listings without applying date filters, assuming the method exists
            // listings = new DatabaseConnection().getListingsByDestination(destination);
        } else {
            // Fetch listings with date filters
            // listings = new
            // DatabaseConnection().getListingsByDestinationAndDates(destination,
            // arrivalDate,
            // departureDate);
        }

        return ResponseEntity.ok(listings);
    }

    @GetMapping("/filter/byExtraFeatures")
    public ResponseEntity<List<Listing>> getListingsByHotelExtraFeatures(@RequestParam String extraFeatures) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            List<Listing> filteredListings = new ArrayList<>(); // dbConnection.getListingsByHotelExtraFeatures(extraFeatures);
            if (filteredListings != null && !filteredListings.isEmpty()) {
                return ResponseEntity.ok(filteredListings);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createListing(@RequestBody Listing newListing) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            // dbConnection.addListing(newListing);
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
            Optional<Listing> listing = listingRepo.findById(listingId); // dbConnection.getListing(listingId);
            if (listing.isPresent()) {
                return ResponseEntity.ok(listing.get());
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
            boolean updated = true; // dbConnection.updateListing(listingId, updatedListing);
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
