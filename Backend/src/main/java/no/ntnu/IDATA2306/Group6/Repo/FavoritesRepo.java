package no.ntnu.IDATA2306.Group6.Repo;

import com.fasterxml.jackson.databind.JsonNode;
import no.ntnu.IDATA2306.Group6.Entity.Hotel;
import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import java.util.Date;
import java.util.List;

public interface FavoritesRepo extends JpaRepository<Favorites, Integer> {

    // Additional custom queries can be defined here
//   @Query("SELECT hotelID FROM listing INNER JOIN favorites ON listing.listingid = favorites.listingid INNER JOIN users ON favorites.userid LIKE %:userid%")
//    @Query("SELECT hotelID FROM listing INNER JOIN favorites ON listing.listingid = favorites.listingid INNER JOIN users ON favorites.userid = users.userid")
//    Old query for finding all hotels faved by a userid
//    @Query("SELECT hotelID FROM listing WHERE listing.listingid IN (SELECT favorites.listingid FROM favorites WHERE favorites.userid IN (SELECT users.userid FROM users))")
//    query above rewritten to use nested queries
//    @Query("SELECT l.hotelID FROM Listing l WHERE l.listingid IN (SELECT f.listingid FROM Favorites f WHERE f.userid IN (SELECT u.userid FROM Users u)))")
//    query above rewritten in jpql


    List<Favorites> findFavoritesByUserId(Integer userid);
}