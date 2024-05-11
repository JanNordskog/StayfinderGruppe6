/**
 * The ReviewRepo interface provides access to review data in the database.
 */
package no.ntnu.IDATA2306.Group6.Repo;


import no.ntnu.IDATA2306.Group6.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}