package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    public ListingController(ListingRepo listingRepo) {
        this.listingRepo = listingRepo;
    }

    @GetMapping
    @Operation(summary = "Get all listings", description = "Retrieves all listings from the repository.")
    public Collection<Listing> getAll() {
        return listingRepo.findAll();
    }

   @GetMapping(value = "/engine", params = { "destination", "openDate", "closedDate" })
    @Operation(summary = "Search listings by date and destination", description = "Search listings based on destination and date range.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listings found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class)))
    })
    public Collection<Listing> searchListings(@RequestParam String destination,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date openDate,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date closedDate) {
        Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(destination + sdf.format(openDate) + sdf.format(closedDate));

        if (sdf.format(openDate).equals(sdf.format(today)) && sdf.format(closedDate).equals(sdf.format(today))) {
            return listingRepo.findByHotelAddress(destination);
        } else {
            return listingRepo.findByDestinationAndDate(destination, openDate, closedDate);
        }
    }

    @PutMapping("/{id}/hide")
    @Operation(summary = "Hide a listing", description = "Marks a listing as not visible.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listing hidden successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class))),
            @ApiResponse(responseCode = "404", description = "Listing not found")
    })
    public ResponseEntity<Listing> hideListing(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        if (listing.isPresent()) {
            Listing updatedListing = listing.get();
            updatedListing.setVisible(0);
            listingRepo.save(updatedListing);
            return ResponseEntity.ok(updatedListing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/show")
    @Operation(summary = "Show a listing", description = "Marks a listing as visible.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listing shown successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class))),
            @ApiResponse(responseCode = "404", description = "Listing not found")
    })
    public ResponseEntity<Listing> showListing(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        if (listing.isPresent()) {
            Listing updatedListing = listing.get();
            updatedListing.setVisible(1);
            listingRepo.save(updatedListing);
            return ResponseEntity.ok(updatedListing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getlistingByID/{id}")
    @Operation(summary = "Get listing by ID", description = "Retrieves a listing by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listing found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class))),
            @ApiResponse(responseCode = "404", description = "Listing not found")
    })
    public ResponseEntity<Listing> getListingById(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        return listing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getopendates/{id}")
    @Operation(summary = "Get open dates of a listing", description = "Retrieves available dates for a specific listing.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Open dates retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Listing.class)))
    })
    public ResponseEntity<Listing> getOpenDates(@PathVariable String id) {
        Listing listing = listingRepo.getAvailableDates(id);
        return new ResponseEntity<>(listing, HttpStatus.OK);
    }
}
