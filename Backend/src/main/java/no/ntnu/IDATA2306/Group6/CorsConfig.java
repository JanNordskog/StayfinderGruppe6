package no.ntnu.IDATA2306.Group6;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/user/**") // Specify the URL pattern
        .allowedOrigins("http://localhost:3000") // Allow requests from any origin (you can restrict this)
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
        .allowedHeaders("*") // Allow all headers
        .maxAge(3600); // Set max age for preflight requests (in seconds)
  }
}
