package no.ntnu.IDATA2306.Group6;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final Map<Integer, User> users = new HashMap<>();
    private int userIdCounter = 1;

    public UserController(){
        initializeData();
    }

    private void initializeData() {
        createUser(new User("Jan", "123"));
        createUser(new User("Test", "test"));
      }

 @GetMapping
  public Collection<User> getAll() {
    return users.values();
  }


    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        int userId = userIdCounter++;
        users.put(userId, newUser);
        return newUser;
    }

    // Retrieve a user by ID
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return users.get(userId);
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        users.put(userId, updatedUser);
        return updatedUser;
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        users.remove(userId);
    }
}
