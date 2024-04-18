package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.hash.Hashing;

import no.ntnu.IDATA2306.Group6.Entity.User;
import no.ntnu.IDATA2306.Group6.Repo.UserRepo;

import java.nio.charset.StandardCharsets;
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
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            //String userPsw = ;
            String hashedPsw = hashPassword(newUser.getPassword());
            newUser.setPassword(hashedPsw);

            User savedUser = userRepo.save(newUser); // Save the new user to the database
            return ResponseEntity.ok(savedUser); // Return the saved user with an OK status
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Return an Internal Server Error status
        }
    }
    
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("uname") String name, @RequestParam("psw") String password) {
        // Ideally, you would hash the password here before comparing it with database
        // entries
        password = hashPassword(password);
        User user = userRepo.findByEmailAndPassword(name, password);
        System.out.println(name + password);
        System.out.println(user);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

        private String hashPassword(String password)
        {
            String sha256hex = Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();
            return sha256hex;
        }
}
