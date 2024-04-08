package no.ntnu.IDATA2306.Group6;

import java.sql.SQLException;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        try {
            
            List<User> userList = new DatabaseConnection().getUsers();

            
            System.out.println("User Details:");
            for (User user : userList) {
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Address: " + user.getAddress());
                System.out.println("Gender: " + user.getGender());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("DOB: " + user.getDob());
                System.out.println();
            }

           
            List<Hotel> hotelList = new DatabaseConnection().getHotels();

            
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
                System.out.println();
            }

           
            List<Agency> agencyList = new DatabaseConnection().getAgencies();

            
            System.out.println("Agency Details:");
            for (Agency agency : agencyList) {
                System.out.println("Agency ID: " + agency.getAgencyID());
                System.out.println("Name: " + agency.getName());
                System.out.println("Email: " + agency.getEmail());
                System.out.println("Phone Number: " + agency.getPhoneNumber());
                System.out.println("Website: " + agency.getWebsite());
                System.out.println();
            }

          
            List<Listing> listingList = new DatabaseConnection().getListings();

          
            System.out.println("Listing Details:");
            for (Listing listing : listingList) {
                System.out.println("Listing ID: " + listing.getListingID());
                System.out.println("Hotel ID: " + listing.getHotelID());
                System.out.println("Agency ID: " + listing.getAgencyID());
                System.out.println("Arrival Date: " + listing.getArrivalDate());
                System.out.println("Departure Date: " + listing.getDepartureDate());
                System.out.println("Price: " + listing.getPrice());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
