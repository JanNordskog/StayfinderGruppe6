package no.ntnu.IDATA2306.Group6;

import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/hotelImages")
public class HotelImagesController {

    @GetMapping
    public List<HotelImages> getAllHotelImages() {
        // Implement logic to retrieve all hotel images from the database
        List<HotelImages> hotelImages = new ArrayList<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            hotelImages = databaseConnection.getHotelImages();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return hotelImages;
    }

    @PostMapping
    public void createHotelImage(@RequestBody HotelImages newHotelImage) {
        try {
            // Implement logic to add a new hotel image to the database
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.addHotelImage(newHotelImage.getImageID(), newHotelImage.getHotelID(),
                    newHotelImage.getGrade(), newHotelImage.getSourceLink());
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    @GetMapping("/{imageID}")
    public HotelImages getHotelImage(@PathVariable String imageID) {
        // Implement logic to retrieve a specific hotel image from the database
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            return databaseConnection.getHotelImage(imageID);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
            return null;
        }
    }

    @PutMapping("/{imageID}")
    public void updateHotelImage(@PathVariable String imageID, @RequestBody HotelImages updatedHotelImage) {
        try {
            // Implement logic to update a hotel image in the database
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.updateHotelImage(imageID, updatedHotelImage);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

}
