package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.DatabaseConnection;
import no.ntnu.IDATA2306.Group6.Entity.HotelImages;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/hotelImages")
public class HotelImagesController {

    @GetMapping
    public List<HotelImages> getAllHotelImages() {

        List<HotelImages> hotelImages = new ArrayList<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            hotelImages = databaseConnection.getHotelImages();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return hotelImages;
    }

    @PostMapping
    public void createHotelImage(@RequestBody HotelImages newHotelImage) {
        try {

            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.addHotelImage(newHotelImage.getImageID(), newHotelImage.getHotelID(),
                    newHotelImage.getGrade(), newHotelImage.getSourceLink());
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @GetMapping("/{imageID}")
    public HotelImages getHotelImage(@PathVariable String imageID) {

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            return databaseConnection.getHotelImage(imageID);
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @PutMapping("/{imageID}")
    public void updateHotelImage(@PathVariable String imageID, @RequestBody HotelImages updatedHotelImage) {
        try {

            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.updateHotelImage(imageID, updatedHotelImage);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
