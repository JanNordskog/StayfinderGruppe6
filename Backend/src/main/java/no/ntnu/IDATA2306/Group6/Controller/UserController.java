/**
 * The UserController class handles HTTP requests related to users.
 * It provides endpoints for retrieving, creating, and authenticating users,
 * as well as managing user permissions.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import no.ntnu.IDATA2306.Group6.Entity.User;
import no.ntnu.IDATA2306.Group6.Repo.UserRepo;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    public UserController() {

    }
    /**
     * Retrieves all users.
     *
     * @return A collection of all users
     */
    @GetMapping
    public Collection<User> getAll() {

        return userRepo.findAll();
    }
    /**
     * Creates a new user.
     *
     * @param newUser The user to create
     * @return ResponseEntity containing the created user if successful, otherwise internal server error status
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            String hashedPsw = hashPassword(newUser.getPassword());
            newUser.setPassword(hashedPsw);

            User savedUser = userRepo.save(newUser); // Save the new user to the database
            return ResponseEntity.ok(savedUser); // Return the saved user with an OK status
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Return an Internal Server Error status
        }
    }
    /**
     * Authenticates a user.
     *
     * @param name     The username or email of the user
     * @param password The password of the user
     * @return ResponseEntity containing the authenticated user if successful, otherwise unauthorized status
     */
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("uname") String name, @RequestParam("psw") String password) {
        // Ideally, you would hash the password here before comparing it with database
        // entries
        password = hashPassword(password);
        User user = userRepo.findOneByEmailOrName(name, name);
        System.out.println(name + password);
        System.out.println(user);
        if (user == null || new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.status(200).body(user);
    }
    /**
     * Hashes a password using BCrypt.
     *
     * @param password The password to hash
     * @return The hashed password
     */
    private String hashPassword(String password) {
        String sha256hex = new BCryptPasswordEncoder().encode(password);
        return sha256hex;
    }
    /**
     * Retrieves the permissions of a user by ID.
     *
     * @param id The ID of the user
     * @return ResponseEntity containing the permissions if the user is found, otherwise not found status
     */
    @GetMapping("/{id}/permissions")
    public ResponseEntity<?> getUserPermForIdreturn(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getUserperm());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Checks if a user is an admin.
     *
     * @param id The ID of the user
     * @return ResponseEntity containing true if the user is an admin, otherwise false or not found status
     */
    @GetMapping("/{id}/is-admin")
    public ResponseEntity<Boolean> getUserPermForId(@PathVariable Integer id) {
        try {
            User user = userRepo.findById(id).orElse(null); // Fetch the user by ID
            if (user != null) {
                boolean isAdmin = user.getUserperm().equals(1); // Check if userperm is 1
                return ResponseEntity.ok(isAdmin); // Return the boolean result
            } else {
                return ResponseEntity.notFound().build(); // Return 404 if the user is not found
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Return 500 in case of exceptions
        }
    }

}
