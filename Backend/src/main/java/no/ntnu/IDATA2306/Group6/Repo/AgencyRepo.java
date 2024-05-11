/**
 * The AgencyRepo interface provides access to agency data in the database.
 */
package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Agency; // Ensure this import statement is correct

public interface AgencyRepo extends JpaRepository<Agency, String> {
  // Custom query methods can be defined here if necessary.
}
