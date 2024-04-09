package no.ntnu.IDATA2306.Group6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    /**
     * Responds to HTTP GET requests for /hello.
     *
     * @return a greeting message
     */
    @GetMapping("/hello")
    public String greetingHello() {
        return "Hello, World!";
    }


    @GetMapping("/hei")
    public ResponseEntity<String> greetingHei() {
        // Redirect to a new location with status code 301
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("Location", "/hello")
                .body("This endpoint has moved permanently to /hello");
    }

    @DeleteMapping("/hello")
    public ResponseEntity<String> deleteHello() {
        // Respond with status code 401 - Unauthorized
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

}