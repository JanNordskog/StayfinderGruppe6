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

    
    private String hashPassword(String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        //String result = encoder.encode(password;
        //assertTrue(encoder.matches("myPassword", result));
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

    public List<Listing> getListings() {
        List<Listing> listings = new ArrayList<>();
        // Adjusted query to use the correct column name 'sourceLink' for the image URL
        String query = "SELECT l.listingID, l.hotelID, h.name AS hotelName, h.address AS hotelAddress, h.roomTypeAvailable, h.extraFeatures, "
                +
                "l.agencyID, a.name AS agencyName, l.arrivalDate, l.departureDate, l.price, i.sourceLink AS imageLink "
                + // Use 'i.sourceLink'
                "FROM listing l " +
                "JOIN hotels h ON l.hotelID = h.hotelID " +
                "JOIN agencies a ON l.agencyID = a.agencyID " +
                "JOIN hotelimages i ON l.hotelID = i.hotelID"; // Ensure 'hotelimages' is correctly joined

        try (PreparedStatement pst = connection.prepareStatement(query);
                ResultSet result = pst.executeQuery()) {

            while (result.next()) {
                String listingID = result.getString("listingID");
                String hotelID = result.getString("hotelID");
                String hotelName = result.getString("hotelName");
                String hotelAddress = result.getString("hotelAddress");
                String roomTypeAvailable = result.getString("roomTypeAvailable");
                String extraFeatures = result.getString("extraFeatures");
                String agencyID = result.getString("agencyID");
                String agencyName = result.getString("agencyName");
                Date arrivalDate = result.getDate("arrivalDate");
                Date departureDate = result.getDate("departureDate");
                double price = result.getDouble("price");
                String imageLink = result.getString("imageLink"); // This now correctly fetches the image URL from
                                                                  // 'sourceLink'

                Listing listing = new Listing(listingID, hotelID, hotelName, hotelAddress, roomTypeAvailable,
                        extraFeatures, agencyID, agencyName, arrivalDate, departureDate, price, imageLink); // Pass the
                                                                                                            // imageLink
                listings.add(listing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listings;
    }

    public void addListing(Listing listing) throws SQLException {
        String query = "INSERT INTO listing (listingID, hotelID, agencyID, arrivalDate, departureDate, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, listing.getListingID());
            pst.setString(2, listing.getHotelID());
            pst.setString(3, listing.getAgencyID());
            pst.setDate(4, new java.sql.Date(listing.getArrivalDate().getTime()));
            pst.setDate(5, new java.sql.Date(listing.getDepartureDate().getTime()));
            pst.setDouble(6, listing.getPrice());

            pst.executeUpdate();
        }
    }

    public Listing getListing(String listingID) throws SQLException {
        String query = "SELECT * FROM listing WHERE listingID = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, listingID);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                String hotelID = result.getString("hotelID");
                String hotelName = result.getString("hotelName");
                String hotelAddress = result.getString("hotelAddress");
                String roomTypeAvailable = result.getString("roomTypeAvailable");
                String extraFeatures = result.getString("extraFeatures");
                String agencyID = result.getString("agencyID");
                String agencyName = result.getString("agencyName");
                Date arrivalDate = result.getDate("arrivalDate");
                Date departureDate = result.getDate("departureDate");
                double price = result.getDouble("price");
                String imageLink = result.getString("sourceLink");
                // Create a new Listing object with the fetched data
                return new Listing(listingID, hotelID, hotelName, hotelAddress, roomTypeAvailable,
                        extraFeatures, agencyID, agencyName, arrivalDate, departureDate, price, imageLink);
            }
            result.close();
        }
        return null;
    }

    public boolean updateListing(String listingID, Listing listing) throws SQLException {
        String query = "UPDATE listing SET hotelID = ?, agencyID = ?, arrivalDate = ?, departureDate = ?, price = ? WHERE listingID = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, listing.getHotelID());
            pst.setString(2, listing.getAgencyID());
            pst.setDate(3, new java.sql.Date(listing.getArrivalDate().getTime()));
            pst.setDate(4, new java.sql.Date(listing.getDepartureDate().getTime()));
            pst.setDouble(5, listing.getPrice());
            pst.setString(6, listingID);
            int updatedRows = pst.executeUpdate();
            return updatedRows > 0;
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
                HotelImages hotelImage = new HotelImages(imageID, hotelID, grade, sourceLink);
                hotelImagesList.add(hotelImage);
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

                return new HotelImages(imageID, hotelID, grade, sourceLink);
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

    public List<Listing> getListingsByDestination(String destination) throws SQLException {
        List<Listing> listings = new ArrayList<>();
        String query = "SELECT l.listingID, l.hotelID, h.name AS hotelName, h.address AS hotelAddress, h.roomTypeAvailable, h.extraFeatures, l.agencyID, a.name AS agencyName, l.arrivalDate, l.departureDate, l.price, i.sourceLink AS imageLink FROM listing l JOIN hotels h ON l.hotelID = h.hotelID JOIN agencies a ON l.agencyID = a.agencyID JOIN hotelimages i ON l.hotelID = i.hotelID WHERE h.address LIKE ? OR h.name LIKE ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, "%" + destination + "%");
            pst.setString(2, "%" + destination + "%"); // Assuming destination might also match hotelName
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                // Extract data from the result set
                String listingID = result.getString("listingID");
                String hotelID = result.getString("hotelID");
                String hotelName = result.getString("hotelName");
                String hotelAddress = result.getString("hotelAddress");
                String roomTypeAvailable = result.getString("roomTypeAvailable");
                String extraFeatures = result.getString("extraFeatures");
                String agencyID = result.getString("agencyID");
                String agencyName = result.getString("agencyName");
                Date arrivalDate = result.getDate("arrivalDate");
                Date departureDate = result.getDate("departureDate");
                double price = result.getDouble("price");
                String imageLink = result.getString("imageLink");

                // Create a new Listing object
                Listing listing = new Listing(listingID, hotelID, hotelName, hotelAddress, roomTypeAvailable,
                        extraFeatures, agencyID, agencyName, arrivalDate, departureDate, price, imageLink);
                listings.add(listing);
            }
        }
        return listings;
    }

    public List<Listing> getListingsByDestinationAndDates(String destination, LocalDate arrivalDate,
            LocalDate departureDate) throws SQLException {
        List<Listing> listings = new ArrayList<>();
        String query = "SELECT l.listingID, l.hotelID, h.name AS hotelName, h.address AS hotelAddress, " +
                "h.roomTypeAvailable, h.extraFeatures, l.agencyID, a.name AS agencyName, l.arrivalDate, " +
                "l.departureDate, l.price, i.sourceLink AS imageLink FROM listing l JOIN hotels h ON " +
                "l.hotelID = h.hotelID JOIN agencies a ON l.agencyID = a.agencyID JOIN hotelimages i ON " +
                "l.hotelID = i.hotelID WHERE (h.address LIKE ? OR h.name LIKE ?) AND l.arrivalDate " +
                "<= ? AND l.departureDate >= ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, "%" + destination + "%");
            pst.setString(2, "%" + destination + "%"); // Assumes destination might match hotelName or address
            pst.setDate(3, java.sql.Date.valueOf(arrivalDate)); // Assumes arrivalDate is inclusive
            pst.setDate(4, java.sql.Date.valueOf(departureDate)); // Assumes departureDate is inclusive

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String listingID = result.getString("listingID");
                String hotelID = result.getString("hotelID");
                String hotelName = result.getString("hotelName");
                String hotelAddress = result.getString("hotelAddress");
                String roomTypeAvailable = result.getString("roomTypeAvailable");
                String extraFeatures = result.getString("extraFeatures");
                String agencyID = result.getString("agencyID");
                String agencyName = result.getString("agencyName");
                Date listingArrivalDate = result.getDate("arrivalDate"); // Renamed for clarity
                Date listingDepartureDate = result.getDate("departureDate"); // Renamed for clarity
                double price = result.getDouble("price");
                String imageLink = result.getString("imageLink");

                Listing listing = new Listing(listingID, hotelID, hotelName, hotelAddress, roomTypeAvailable,
                        extraFeatures, agencyID, agencyName, listingArrivalDate, listingDepartureDate, price,
                        imageLink);
                listings.add(listing);
            }

        }
        return listings;
    }

    public List<Listing> getListingsByHotelExtraFeatures(String extraFeaturesFilter) {
        List<Listing> filteredListings = new ArrayList<>();
        String query = "SELECT l.*, h.name AS hotelName, h.address AS hotelAddress, h.roomTypeAvailable, h.extraFeatures, "
                +
                "a.name AS agencyName, i.sourceLink AS imageLink " +
                "FROM listing l " +
                "JOIN hotels h ON l.hotelID = h.hotelID " +
                "JOIN agencies a ON l.agencyID = a.agencyID " +
                "JOIN hotelimages i ON l.hotelID = i.hotelID " +
                "WHERE h.extraFeatures LIKE ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            // Set the parameter in the query to match the extra features filter
            pst.setString(1, "%" + extraFeaturesFilter + "%");

            try (ResultSet result = pst.executeQuery()) {
                while (result.next()) {
                    String listingID = result.getString("listingID");
                    String hotelID = result.getString("hotelID");
                    String hotelName = result.getString("hotelName");
                    String hotelAddress = result.getString("hotelAddress");
                    String roomTypeAvailable = result.getString("roomTypeAvailable");
                    String extraFeatures = result.getString("extraFeatures");
                    String agencyID = result.getString("agencyID");
                    String agencyName = result.getString("agencyName");
                    Date arrivalDate = result.getDate("arrivalDate");
                    Date departureDate = result.getDate("departureDate");
                    double price = result.getDouble("price");
                    String imageLink = result.getString("imageLink");

                    Listing listing = new Listing(listingID, hotelID, hotelName, hotelAddress, roomTypeAvailable,
                            extraFeatures, agencyID, agencyName, arrivalDate, departureDate, price, imageLink);
                    filteredListings.add(listing);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // In real application, consider better exception handling
        }

        return filteredListings;
    }

}
