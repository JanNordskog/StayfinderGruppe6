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

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("uname");
        String password = credentials.get("psw"); // This should ideally be hashed

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        try {
            User savedUser = userRepo.save(newUser);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
