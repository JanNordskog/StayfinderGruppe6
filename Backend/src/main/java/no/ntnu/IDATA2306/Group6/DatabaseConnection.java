package no.ntnu.IDATA2306.Group6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

  private String dbUrl = "jdbc:mysql://localhost:3306/stayfinder";
  private String username = "root";
  private String password = "";
  private Connection connection;
  Statement st;

  public DatabaseConnection() throws SQLException {
    this.connection = DriverManager.getConnection(dbUrl, username, password);
    this.st = connection.createStatement();
  }

  /**
   * Gets all users.
   *
   * @return all users.
   */
  public List<User> getUsers() {
    try {
        String query = """
            SELECT * FROM users
            """;

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
            User user = new User(name, email, password, address, gender, phone, dob); // Update constructor
            users.add(user);
        }
        result.close();
        st.close();
        connection.close();
        return users;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


  public void addUser(String name, String email, String password, String address, String gender, String phone,
  String dob, int userPerm) throws SQLException {
// Your existing code to insert into the database remains the same
String query = """
  INSERT INTO Users(name, email, password, address, gender, phone, dob, userPerm)
  VALUES (?, ?, ?, ?, ?, ?, ?, ?)
  """;

try (PreparedStatement pst = connection.prepareStatement(query)) {
  pst.setString(1, name);
  pst.setString(2, email);
  pst.setString(3, password);
  pst.setString(4, address);
  pst.setString(5, gender);
  pst.setString(6, phone);
  pst.setString(7, dob);
  pst.setInt(8, userPerm); // Set int value here
  pst.executeUpdate();
}
}
}