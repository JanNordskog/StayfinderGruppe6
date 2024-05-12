/**
 * The CorsConfig class configures CORS (Cross-Origin Resource Sharing) settings for the application.
 */
package no.ntnu.IDATA2306.Group6;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  /**
   * Configures CORS mappings for specific endpoints.
   *
   * @param registry The CORS registry.
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {

    // Configure CORS for "/user/**" endpoints
    registry.addMapping("/user/**")
        .allowedOrigins("http://localhost:3000") // Allow requests from this origin
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified HTTP methods
        .allowedHeaders("*") // Allow all headers
        .maxAge(3600); // Set max age of preflight request in seconds

    // Configure CORS for "/api/**" endpoints
    registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:3000") // Allow requests from this origin
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified HTTP methods
            .allowedHeaders("*") // Allow all headers
            .maxAge(3600); // Set max age of preflight request in seconds

  }
}