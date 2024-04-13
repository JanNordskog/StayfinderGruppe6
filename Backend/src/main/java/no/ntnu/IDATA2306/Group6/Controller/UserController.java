package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Entity.User;
import no.ntnu.IDATA2306.Group6.Repo.UserRepo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final Map<Integer, User> users = new HashMap<>();
    @Autowired
    private UserRepo userRepo;

    public UserController() {

    }

    @GetMapping
    public Collection<User> getAll() {

        return userRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            User savedUser = userRepo.save(newUser); // Save the new user to the database
            return ResponseEntity.ok(savedUser); // Return the saved user with an OK status
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Return an Internal Server Error status
        }
    }

}
