package no.ntnu.IDATA2306.Group6;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/user/**") 
        .allowedOrigins("http://localhost:3000") 
        .allowedMethods("GET", "POST", "PUT", "DELETE") 
        .allowedHeaders("*") 
        .maxAge(3600); 
  }
}