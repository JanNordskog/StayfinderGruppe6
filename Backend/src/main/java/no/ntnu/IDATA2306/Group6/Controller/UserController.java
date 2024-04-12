package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.DatabaseConnection;
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
    public User createUser(@RequestBody User newUser) {
        System.out.println("New user created");
        try {

            new DatabaseConnection().addUser(
                    newUser.getName(),
                    newUser.getEmail(),
                    newUser.getPassword(),
                    newUser.getAddress(),
                    newUser.getGender(),
                    newUser.getPhone(),
                    newUser.getDob(),
                    0);
            return newUser;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return users.get(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        users.put(userId, updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        users.remove(userId);
    }

}
