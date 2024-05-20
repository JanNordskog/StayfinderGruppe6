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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping
    @Operation(summary = "Retrieve all favorites", description = "Fetches a list of all favorites.")
    @ApiResponse(responseCode = "200", description = "List of all favorites", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Favorites.class)))
    public List<Favorites> getAllFavorites() {
        return favoritesRepo.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a favorite by ID", description = "Fetches a single favorite by its unique identifier.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Favorite found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Favorites.class))),
        @ApiResponse(responseCode = "404", description = "Favorite not found")
    })
    public ResponseEntity<Favorites> getFavoriteById(@PathVariable Integer id) {
        Optional<Favorites> favorite = favoritesRepo.findById(id);
        return favorite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listing/{userid}")
    @Operation(summary = "Retrieve all favorites by user ID", description = "Fetches all favorites associated with a specific user.")
    @ApiResponse(responseCode = "200", description = "Favorites list for user retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Favorites.class)))
    public List<Favorites> getAllUserFavorites(@PathVariable int userid) {
        //System.out.print(userid);
        log.debug(favoritesRepo.findFavoritesByUserId(userid).toString());
        return favoritesRepo.findFavoritesByUserId(userid);
    }

    @PostMapping
    @Operation(summary = "Add a new favorite", description = "Adds a new favorite to the database.")
    @ApiResponse(responseCode = "201", description = "Favorite added successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Favorites.class)))
    public Favorites addFavorite(@RequestBody Favorites favorite) {
        return favoritesRepo.save(favorite);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a favorite by ID", description = "Deletes a favorite based on its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Favorite deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Favorite not found")
    })
    public ResponseEntity<?> deleteFavorite(@PathVariable Integer id) {
        if (favoritesRepo.existsById(id)) {
            favoritesRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
