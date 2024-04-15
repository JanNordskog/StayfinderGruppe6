package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import no.ntnu.IDATA2306.Group6.Entity.User;
import no.ntnu.IDATA2306.Group6.Repo.UserRepo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<User> createUser(@RequestBody User newUser)
    {
        try {
            String userPsw = newUser.getPassword().toString();
            newUser.setPassword(hashPassword(userPsw));

            User savedUser = userRepo.save(newUser); // Save the new user to the database
            return ResponseEntity.ok(savedUser); // Return the saved user with an OK status
        } catch (Exception e)
        {
            System.out.println(newUser.getPassword());
            return ResponseEntity.internalServerError().build(); // Return an Internal Server Error status

        }
    }




    /*@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("uname");
        String password = credentials.get("psw"); // This should ideally be hashed

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }*/

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("uname") String name, @RequestParam("psw") String password) {
        // Ideally, you would hash the password here before comparing it with database
        String hashedPsw = hashPassword(password);
        // entries
        User user = userRepo.findByEmailAndPassword(name, hashedPsw);
        System.out.println(name + hashedPsw);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        // String result = encoder.encode(password;
        // assertTrue(encoder.matches("myPassword", result));
        String result = encoder.encode(password);
        System.out.println(result);
        return result;
    }

}
