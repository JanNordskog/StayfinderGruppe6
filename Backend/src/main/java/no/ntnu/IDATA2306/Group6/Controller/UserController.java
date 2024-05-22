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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.IDATA2306.Group6.Entity.User;
import no.ntnu.IDATA2306.Group6.Repo.UserRepo;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    @Operation(summary = "Get all users", description = "Retrieves all users if the requester is an admin.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All users returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "403", description = "Access Denied: Only admins can perform this action."),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> getAll(@PathVariable Integer id) {
        try {
            User user = userRepo.findById(id).orElse(null);
            if (user != null && user.getUserperm().equals(1)) {
                return ResponseEntity.ok(userRepo.findAll());
            } else if (user != null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("Access Denied: Only admins can perform this action.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user with encrypted password.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            String hashedPsw = hashPassword(newUser.getPassword());
            newUser.setPassword(hashedPsw);

            User savedUser = userRepo.save(newUser);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/login")
    @Operation(summary = "Authenticate a user", description = "Authenticates user by username and password.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User authenticated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "401", description = "Invalid username or password")
    })
    public ResponseEntity<?> loginUser(@RequestParam("uname") String name, @RequestParam("psw") String password) {

        User user = userRepo.findOneByEmailOrName(name, name);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }


        String userpassword = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, userpassword)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        return ResponseEntity.ok(user);
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

    @GetMapping("/{id}/permissions")
    @Operation(summary = "Get user permissions", description = "Retrieves the permissions of a user by their ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissions retrieved", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> getUserPermForIdreturn(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getUserperm());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/is-admin")
    @Operation(summary = "Check if user is admin", description = "Checks if the user with given ID is an admin.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Admin status returned", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Boolean> getUserPermForId(@PathVariable Integer id) {
        try {
            User user = userRepo.findById(id).orElse(null);
            if (user != null) {
                boolean isAdmin = user.getUserperm().equals(1);
                return ResponseEntity.ok(isAdmin);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
