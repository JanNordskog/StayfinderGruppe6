/**
 * The UserRepo interface provides access to user data in the database.
 */
package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import no.ntnu.IDATA2306.Group6.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

  /**
   * Retrieves a user by their email and password.
   *
   * @param name     The email or username of the user
   * @param password The password of the user
   * @return The user matching the provided email/username and password
   */
    @Query("SELECT u FROM User u WHERE (u.name = :name or u.email = :name) AND u.password = :password")
    User findByEmailAndPassword(String name, String password);

    /**
   * Retrieves a user by their email.
   *
   * @param name The email of the user
   * @return The user matching the provided email
   */
    User findByEmail(String name);

  /**
   * Retrieves a user by their email or username.
   *
   * @param name The email or username of the user
   * @param email The email of the user
   * @return The user matching the provided email or username
   */
  User findOneByEmailOrName(String name, String email);
}
