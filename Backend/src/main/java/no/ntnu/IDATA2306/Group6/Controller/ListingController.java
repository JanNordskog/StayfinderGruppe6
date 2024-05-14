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

    public ListingController(ListingRepo listingRepo) {
        this.listingRepo = listingRepo;
    }

    @GetMapping
    public Collection<Listing> getAll() {
        return listingRepo.findAll();
    }

    @GetMapping(value = "/engine", params = { "destination", "openDate", "closedDate" })
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
    public ResponseEntity<Listing> getListingById(@PathVariable String id) {
        Optional<Listing> listing = listingRepo.findById(id);
        return listing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
