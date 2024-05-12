/**
 * The MainApplication class serves as the entry point for the Spring Boot application.
 */
package no.ntnu.IDATA2306.Group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MainApplication {

    /**
     * The main method to start the Spring Boot application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}