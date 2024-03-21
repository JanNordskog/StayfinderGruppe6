package no.ntnu.IDATA2306.Group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This is the main application class. It calls SprintApplication.run() where
 * all the magic starts to happen.
 */
@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("configs.xml");
    JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    String insertSQL = "INSERT INTO employee (Id, Name) VALUES (?, ?)";
    int result = jdbcTemplate.update(insertSQL, 1, "Syes Arshad");

    System.out.println("Rows affected: " + result);

    ctx.close();
  }

}
