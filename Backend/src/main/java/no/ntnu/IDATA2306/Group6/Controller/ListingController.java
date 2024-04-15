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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
    public Collection<Listing> getAll() {
        return listingRepo.findAll();
    }

    // This method only gets called when the 'address' parameter is provided
    @GetMapping(params = { "destination", "arrivalDate", "departureDate" })
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

}
