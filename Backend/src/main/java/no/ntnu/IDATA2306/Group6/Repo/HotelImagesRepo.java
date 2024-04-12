package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.HotelImages;

public interface HotelImagesRepo extends JpaRepository<HotelImages, String> {
    // This interface can be extended with custom methods if necessary.
}
