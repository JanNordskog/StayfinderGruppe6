/**
 * The FavoritesController class handles HTTP requests related to favorites.
 * It provides endpoints for retrieving, adding, and deleting favorites.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import jakarta.websocket.server.PathParam;
import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import no.ntnu.IDATA2306.Group6.Repo.FavoritesRepo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesRepo favoritesRepo;
    private Logger log = LoggerFactory.getLogger("FavoritesController");

    /**
     * Constructor for FavoritesController.
     *
     * @param favoritesRepo The repository for managing favorites
     */
    public FavoritesController(FavoritesRepo favoritesRepo) {
        this.favoritesRepo = favoritesRepo;
    }

    /**
     * Retrieves all favorites.
     *
     * @return A list of all favorites
     */
    @GetMapping
    public List<Favorites> getAllFavorites() {
        return favoritesRepo.findAll();
    }

    /**
     * Retrieves a favorite by its ID.
     *
     * @param id The ID of the favorite to retrieve
     * @return ResponseEntity containing the favorite if found, otherwise not found status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Favorites> getFavoriteById(@PathVariable Integer id) {
        Optional<Favorites> favorite = favoritesRepo.findById(id);
        return favorite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all favorites belonging to a specific user.
     *
     * @param userid The ID of the user
     * @return A list of all favorites belonging to the user
     */
    @GetMapping("/listing/{userid}")
    public List<Favorites> getAllUserFavorites(@PathVariable int userid) {
        //System.out.print(userid);
        log.debug(favoritesRepo.findFavoritesByUserId(userid).toString());
        return favoritesRepo.findFavoritesByUserId(userid);
    }

    /**
     * Adds a new favorite.
     *
     * @param favorite The favorite to add
     * @return The added favorite
     */
    @PostMapping
    public Favorites addFavorite(@RequestBody Favorites favorite) {
        return favoritesRepo.save(favorite);
    }

    /**
     * Deletes a favorite by its ID.
     *
     * @param id The ID of the favorite to delete
     * @return ResponseEntity indicating success or failure of the deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Integer id) {
        if (favoritesRepo.existsById(id)) {
            favoritesRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
