/**
 * The ListingRepo interface provides access to listing data in the database.
 */
package no.ntnu.IDATA2306.Group6.Repo;

import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import no.ntnu.IDATA2306.Group6.Entity.Listing;

import java.util.Date;
import java.util.List;

public interface ListingRepo extends JpaRepository<Listing, String> {

        /**
         * Retrieves listings by hotel address.
         *
         * @param address The address or name of the hotel
         * @return A list of listings matching the provided hotel address or name
         */
        @Query("SELECT l FROM Listing l JOIN l.hotel h WHERE (h.address LIKE %:address% OR h.name LIKE %:address%) AND l.visible = 1")
        List<Listing> findByHotelAddress(String address);

        /**
         * Retrieves listings by destination and date range.
         *
         * @param destination   The destination or name of the hotel
         * @param arrivalDate   The arrival date
         * @param departureDate The departure date
         * @return A list of listings matching the provided destination and date range
         */
        @Query("SELECT l FROM Listing l JOIN l.hotel h WHERE (h.address LIKE %:destination% OR h.name LIKE %:destination%) AND l.arrivalDate <= :departureDate AND l.departureDate >= :arrivalDate AND l.visible = 1")
        List<Listing> findByDestinationAndDate(@Param("destination") String destination,
                        @Param("arrivalDate") Date arrivalDate, @Param("departureDate") Date departureDate);

        /**
         * Retrieves listings by hotel extra features.
         *
         * @param extraFeatures The extra features of the hotel
         * @return A list of listings matching the provided extra features
         */
        @Query("SELECT l FROM Listing l WHERE l.hotel.extraFeatures LIKE %:extraFeatures% AND l.visible = 1")
        List<Listing> findByHotelExtraFeatures(@Param("extraFeatures") String extraFeatures);

//        @Query("SELECT hotelID FROM listing WHERE listing.listingid IN (SELECT favorites.listingid FROM favorites WHERE favorites.userid IN (SELECT users.userid FROM users))")
//        List<Favorites> findFavorites(@Param("userid") Integer userid);

}
