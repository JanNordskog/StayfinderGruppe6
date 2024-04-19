package no.ntnu.IDATA2306.Group6.Controller;

import jakarta.websocket.server.PathParam;
import no.ntnu.IDATA2306.Group6.Entity.Listing;
import no.ntnu.IDATA2306.Group6.Repo.ListingRepo;
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

    public FavoritesController(FavoritesRepo favoritesRepo) {this.favoritesRepo = favoritesRepo; }


    // Get all favorites
    @GetMapping
    public List<Favorites> getAllFavorites() {
        return favoritesRepo.findAll();
    }

    // Get a specific favorite by
    @GetMapping("/{id}")
    public ResponseEntity<Favorites> getFavoriteById(@PathVariable Integer id) {
        Optional<Favorites> favorite = favoritesRepo.findById(id);
        return favorite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Get all favorites from a specific user ID
    @GetMapping("/listing")
    public Collection<Favorites> getAllUserFavorites(@PathParam("userid") Integer userid)
    {
        System.out.print(userid);
        return favoritesRepo.findFavoritesByUserId(userid);
    }

    // Add a new favorite
    @PostMapping
    public Favorites addFavorite(@RequestBody Favorites favorite) {
        return favoritesRepo.save(favorite);
    }

    // Delete a favorite
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Integer id) {
        if (favoritesRepo.existsById(id)) {
            favoritesRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
