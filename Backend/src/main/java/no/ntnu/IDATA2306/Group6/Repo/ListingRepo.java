package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Listing;

public interface ListingRepo extends JpaRepository<Listing, String> {
    // This interface can be extended with custom methods if necessary.
}
