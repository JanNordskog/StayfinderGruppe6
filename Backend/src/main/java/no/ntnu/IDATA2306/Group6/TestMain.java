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
                System.out.println("\n");
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
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
