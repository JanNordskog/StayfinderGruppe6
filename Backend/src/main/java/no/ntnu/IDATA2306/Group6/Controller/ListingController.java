/**
 * The ListingController class handles HTTP requests related to listings.
 * It provides endpoints for retrieving, searching, hiding, and showing listings.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Collection;
import java.util.Date;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingRepo listingRepo;
    /**
     * Constructor for ListingController.
     *
     * @param listingRepo The repository for managing listings
     */
    public ListingController(ListingRepo listingRepo) {

        this.listingRepo = listingRepo;
    }
    /**
     * Retrieves all listings.
     *
     * @return A collection of all listings
     */

    @GetMapping
    public Collection<Listing> getAll() {

        return listingRepo.findAll();
    }
    /**
     * Searches for listings based on destination and date.
     *
     * @param destination   The destination of the listing
     * @param arrivalDate   The arrival date
     * @param departureDate The departure date
     * @return A collection of listings matching the destination and date criteria
     */

    @GetMapping(value = "/engine", params = { "destination", "arrivalDate", "departureDate" })
    public Collection<Listing> searchListings(@RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date arrivalDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate) {
        Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(destination + sdf.format(arrivalDate) + sdf.format(departureDate));

        if (sdf.format(arrivalDate).equals(sdf.format(today)) && sdf.format(departureDate).equals(sdf.format(today))) {
            return listingRepo.findByHotelAddress(destination);
        } else {
            return listingRepo.findByDestinationAndDate(destination, arrivalDate, departureDate);
        }
    }
    /**
     * Hides a listing by its ID.
     *
     * @param id The ID of the listing to hide
     * @return ResponseEntity indicating success or failure of the operation
     */
    @PutMapping("/{id}/hide")
    public ResponseEntity<Listing> hideListing(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        if (listing.isPresent()) {
            Listing updatedListing = listing.get();
            updatedListing.setVisible(0); // Assuming `setVisible` is a method in your Listing entity to update
                                          // visibility
            listingRepo.save(updatedListing);
            return ResponseEntity.ok(updatedListing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Shows a listing by its ID.
     *
     * @param id The ID of the listing to show
     * @return ResponseEntity indicating success or failure of the operation
     */

    @PutMapping("/{id}/show")
    public ResponseEntity<Listing> showListing(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        if (listing.isPresent()) {
            Listing updatedListing = listing.get();
            updatedListing.setVisible(1); // Assuming `setVisible` is a method in your Listing entity to update
                                          // visibility
            listingRepo.save(updatedListing);
            return ResponseEntity.ok(updatedListing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Retrieves a listing by its ID.
     *
     * @param id The ID of the listing to retrieve
     * @return ResponseEntity containing the listing if found, otherwise not found status
     */

    @GetMapping("/getlistingByID/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        return listing.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
