package no.ntnu.IDATA2306.Group6;

import java.sql.SQLException;
import java.util.List;

public class TestMain {
  public static void main(String[] args) throws SQLException {
    List<User> userList = new DatabaseConnection().getUsers();

    userList.forEach((r) -> {
      System.out.println("Email: " + r.getEmail());
      System.out.println("Password: " + r.getPassword());
      System.out.println("Address: " + r.getAddress());
      System.out.println("Gender: " + r.getGender());
      System.out.println("Phone: " + r.getPhone());
      System.out.println("DOB: " + r.getDob());
      System.out.println("\n\n");

    });
  }

}
