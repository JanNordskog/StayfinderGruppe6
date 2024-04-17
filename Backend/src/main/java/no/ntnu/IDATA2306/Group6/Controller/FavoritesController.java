package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Entity.Favorites;
import no.ntnu.IDATA2306.Group6.Repo.FavoritesRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesRepo favoritesRepo;

    // Get all favorites
    @GetMapping
    public List<Favorites> getAllFavorites() {
        return favoritesRepo.findAll();
    }

    // Get a specific favorite by ID
    @GetMapping("/{id}")
    public ResponseEntity<Favorites> getFavoriteById(@PathVariable Long id) {
        Optional<Favorites> favorite = favoritesRepo.findById(id);
        return favorite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new favorite
    @PostMapping
    public Favorites addFavorite(@RequestBody Favorites favorite) {
        return favoritesRepo.save(favorite);
    }

    // Delete a favorite
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Long id) {
        if (favoritesRepo.existsById(id)) {
            favoritesRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
