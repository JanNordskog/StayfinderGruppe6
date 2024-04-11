package no.ntnu.IDATA2306.Group6;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/extra")
public class extrafeatureController {

    @GetMapping(params = "extraFeatures")
    public ResponseEntity<List<Listing>> getListingsByExtraFeatures(@RequestParam String extraFeatures) {
        try {
            // Assuming you have a method in DatabaseConnection that fetches listings by
            // extra features
            List<Listing> listings = new DatabaseConnection().getListingsByHotelExtraFeatures(extraFeatures);

            return ResponseEntity.ok(listings);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
