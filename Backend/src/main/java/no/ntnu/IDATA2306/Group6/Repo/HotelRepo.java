/**
 * The HotelRepo interface provides access to hotel data in the database.
 */
package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {
    // Custom query methods can be defined here if necessary.
}
