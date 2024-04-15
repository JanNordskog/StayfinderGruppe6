package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import no.ntnu.IDATA2306.Group6.Entity.Listing;

import java.util.Date;
import java.util.List;

public interface ListingRepo extends JpaRepository<Listing, String> {
        @Query("SELECT l FROM Listing l JOIN l.hotel h WHERE (h.address LIKE %:address% OR h.name LIKE %:address%) AND l.visible = 1")
        List<Listing> findByHotelAddress(String address);

        @Query("SELECT l FROM Listing l JOIN l.hotel h WHERE (h.address LIKE %:destination% OR h.name LIKE %:destination%) AND l.arrivalDate <= :departureDate AND l.departureDate >= :arrivalDate AND l.visible = 1")
        List<Listing> findByDestinationAndDate(@Param("destination") String destination,
                        @Param("arrivalDate") Date arrivalDate, @Param("departureDate") Date departureDate);

        @Query("SELECT l FROM Listing l WHERE l.hotel.extraFeatures LIKE %:extraFeatures% AND l.visible = 1")
        List<Listing> findByHotelExtraFeatures(@Param("extraFeatures") String extraFeatures);
}
