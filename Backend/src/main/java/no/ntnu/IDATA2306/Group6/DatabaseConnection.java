package no.ntnu.IDATA2306.Group6;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import no.ntnu.IDATA2306.Group6.Entity.Agency;
import no.ntnu.IDATA2306.Group6.Entity.Hotel;
import no.ntnu.IDATA2306.Group6.Entity.HotelImages;
import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Entity.User;

public class DatabaseConnection {

    private String dbUrl = "jdbc:mysql://localhost:3306/stayfinder";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private Statement st;

    public DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, username, password);
        this.st = connection.createStatement();
    }

    public List<User> getUsers() {
        try {
            String query = "SELECT * FROM users";
            ResultSet result = st.executeQuery(query);
            List<User> users = new ArrayList<>();
            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                String password = result.getString("password");
                String address = result.getString("address");
                String gender = result.getString("gender");
                String phone = result.getString("phone");
                String dob = result.getString("dob");
                User user = new User(name, email, password, address, gender, phone, dob);
                users.add(user);
            }
            result.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(String name, String email, String password, String address, String gender, String phone,
            String dob, int userPerm) throws SQLException {
        String query = "INSERT INTO Users(name, email, password, address, gender, phone, dob, userPerm) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, hashPassword(password));
            pst.setString(4, address);
            pst.setString(5, gender);
            pst.setString(6, phone);
            pst.setString(7, dob);
            pst.setInt(8, userPerm);
            pst.executeUpdate();
        }
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        // String result = encoder.encode(password;
        // assertTrue(encoder.matches("myPassword", result));
        String result = encoder.encode(password);
        System.out.println(result);
        return result;
    }

    public List<Hotel> getHotels() {
        try {
            String query = "SELECT * FROM hotels";
            ResultSet result = st.executeQuery(query);
            List<Hotel> hotels = new ArrayList<>();
            while (result.next()) {
                String hotelID = result.getString("hotelID");
                String name = result.getString("name");
                String address = result.getString("address");
                String website = result.getString("website");
                String phoneNumber = result.getString("phoneNumber");
                String locationType = result.getString("locationType");
                String roomTypeAvailable = result.getString("roomTypeAvailable");
                String extraFeatures = result.getString("extraFeatures");
                Hotel hotel = new Hotel(hotelID, name, address, website, phoneNumber, locationType, roomTypeAvailable,
                        extraFeatures);
                hotels.add(hotel);
            }
            result.close();
            return hotels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHotel(String hotelID, String name, String address, String website, String phoneNumber,
            String locationType, String roomTypeAvailable, String extraFeatures) throws SQLException {
        String query = "INSERT INTO hotels(hotelID, name, address, website, phoneNumber, locationType, roomTypeAvailable, extraFeatures) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, hotelID);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, website);
            pst.setString(5, phoneNumber);
            pst.setString(6, locationType);
            pst.setString(7, roomTypeAvailable);
            pst.setString(8, extraFeatures);
            pst.executeUpdate();
        }
    }

    public List<Agency> getAgencies() {
        try {
            String query = "SELECT * FROM agencies";
            ResultSet result = st.executeQuery(query);
            List<Agency> agencies = new ArrayList<>();
            while (result.next()) {
                String agencyID = result.getString("agencyID");
                String name = result.getString("name");
                String email = result.getString("email");
                String phoneNumber = result.getString("phoneNumber");
                String website = result.getString("website");
                Agency agency = new Agency(agencyID, name, email, phoneNumber, website);
                agencies.add(agency);
            }
            result.close();
            return agencies;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addAgency(String agencyID, String name, String email, String phoneNumber, String website)
            throws SQLException {
        String query = "INSERT INTO agencies(agencyID, name, email, phoneNumber, website) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, agencyID);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, phoneNumber);
            pst.setString(5, website);
            pst.executeUpdate();
        }
    }

    public boolean deleteListing(String listingID) throws SQLException {
        String query = "DELETE FROM listing WHERE listingID = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, listingID);
            int deletedRows = pst.executeUpdate();
            return deletedRows > 0;
        }
    }

    public List<HotelImages> getHotelImages() {
        try {
            String query = "SELECT * FROM hotelimages";
            ResultSet result = st.executeQuery(query);
            List<HotelImages> hotelImagesList = new ArrayList<>();
            while (result.next()) {
                String imageID = result.getString("imageID");
                String hotelID = result.getString("hotelID");
                int grade = result.getInt("grade");
                String sourceLink = result.getString("sourceLink");

            }
            result.close();
            return hotelImagesList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHotelImage(String imageID, String hotelID, int grade, String sourceLink) throws SQLException {
        String query = "INSERT INTO hotelimages (imageID, hotelID, grade, sourceLink) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, imageID);
            pst.setString(2, hotelID);
            pst.setInt(3, grade);
            pst.setString(4, sourceLink);
            pst.executeUpdate();
        }
    }

    public HotelImages getHotelImage(String imageID) throws SQLException {
        String query = "SELECT * FROM hotelimages WHERE imageID = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, imageID);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                String hotelID = result.getString("hotelID");
                int grade = result.getInt("grade");
                String sourceLink = result.getString("sourceLink");

            }
            result.close();
        }
        return null;
    }

    public void updateHotelImage(String imageID, HotelImages updatedHotelImage) throws SQLException {
        String query = "UPDATE hotelimages SET hotelID = ?, grade = ?, sourceLink = ? WHERE imageID = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, updatedHotelImage.getHotelID());
            pst.setInt(2, updatedHotelImage.getGrade());
            pst.setString(3, updatedHotelImage.getSourceLink());
            pst.setString(4, imageID);
            pst.executeUpdate();
        }
    }

}
