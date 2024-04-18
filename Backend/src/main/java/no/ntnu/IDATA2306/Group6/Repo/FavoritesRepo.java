package no.ntnu.IDATA2306.Group6.Repo;

import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FavoritesRepo extends JpaRepository<Favorites, Integer> {
    // Additional custom queries can be defined here
    @Query("SELECT hotelID FROM listing INNER JOIN favorites ON listing.listingid = favorites.listingid INNER JOIN users ON favorites.userid = users.userid")
    List<Favorites> findFavorites(Integer userid);
}