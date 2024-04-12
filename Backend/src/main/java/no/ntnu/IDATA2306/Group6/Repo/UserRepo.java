package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.User; // Ensure this import statement is correct

public interface UserRepo extends JpaRepository<User, Integer> {
}
