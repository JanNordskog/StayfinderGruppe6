package no.ntnu.IDATA2306.Group6;

import java.sql.SQLException;
import java.util.List;
/*
 * This class is used for testing the database connection and retrieve the different table
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            // Fetch users
            List<User> userList = new DatabaseConnection().getUsers();

            // Print user details
            System.out.println("User Details:");
            for (User user : userList) {
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Address: " + user.getAddress());
                System.out.println("Gender: " + user.getGender());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("DOB: " + user.getDob());
                System.out.println("\n");
            }

            // Fetch hotels
            List<Hotel> hotelList = new DatabaseConnection().getHotels();

            // Print hotel details
            System.out.println("Hotel Details:");
            for (Hotel hotel : hotelList) {
                System.out.println("Hotel ID: " + hotel.getHotelID());
                System.out.println("Name: " + hotel.getName());
                System.out.println("Address: " + hotel.getAddress());
                System.out.println("Website: " + hotel.getWebsite());
                System.out.println("Phone Number: " + hotel.getPhoneNumber());
                System.out.println("Location Type: " + hotel.getLocationType());
                System.out.println("Room Type Available: " + hotel.getRoomTypeAvailable());
                System.out.println("Extra Features: " + hotel.getExtraFeatures());
                System.out.println("\n");
            }

            // Fetch agencies
            List<Agency> agencyList = new DatabaseConnection().getAgencies();

            // Print agency details
            System.out.println("Agency Details:");
            for (Agency agency : agencyList) {
                System.out.println("Agency ID: " + agency.getAgencyID());
                System.out.println("Name: " + agency.getName());
                System.out.println("Email: " + agency.getEmail());
                System.out.println("Phone Number: " + agency.getPhoneNumber());
                System.out.println("Website: " + agency.getWebsite());
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
