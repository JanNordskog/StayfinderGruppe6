package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @GetMapping
    public Collection<User> getAll() {

        return userRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            // String userPsw = ;
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
        User user = userRepo.findOneByEmailOrName(name, name);
        System.out.println(name + password);
        System.out.println(user);
        if (user == null || new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.status(200).body(user);
    }

    private String hashPassword(String password) {
        String sha256hex = new BCryptPasswordEncoder().encode(password);
        return sha256hex;
    }

    @GetMapping("/{id}/permissions")
    public ResponseEntity<?> getUserPermForIdreturn(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getUserperm());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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
