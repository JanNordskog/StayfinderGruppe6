package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Agency; // Ensure this import statement is correct

public interface AgencyRepo extends JpaRepository<Agency, String> {
    // You can define custom query methods here if needed.
}
