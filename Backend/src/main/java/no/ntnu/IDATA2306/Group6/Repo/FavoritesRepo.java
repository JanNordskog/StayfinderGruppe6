package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.IDATA2306.Group6.Entity.Favorites;

public interface FavoritesRepo extends JpaRepository<Favorites, Long> {
    // Additional custom queries can be defined here
}
