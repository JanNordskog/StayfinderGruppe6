package no.ntnu.IDATA2306.Group6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            pst.setString(3, password);
            pst.setString(4, address);
            pst.setString(5, gender);
            pst.setString(6, phone);
            pst.setString(7, dob);
            pst.setInt(8, userPerm);
            pst.executeUpdate();
        }
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
                Hotel hotel = new Hotel(hotelID, name, address, website, phoneNumber, locationType, roomTypeAvailable, extraFeatures);
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
        String query = "INSERT INTO hotels(hotelID, name, address, website, phoneNumber, locationType, roomTypeAvailable, extraFeatures) " +
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

   

}
