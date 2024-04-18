package no.ntnu.IDATA2306.Group6.Repo;

import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FavoritesRepo extends JpaRepository<Favorites, Long> {
    // Additional custom queries can be defined here
    @Query("SELECT l FROM Listing l JOIN (l.hotel h WHERE (h.address LIKE %:address% OR h.name LIKE %:address%) AND l.visible = 1")
    List<Listing> findFavorites(Long userid);
}
