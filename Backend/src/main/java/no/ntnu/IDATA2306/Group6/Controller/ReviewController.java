package no.ntnu.IDATA2306.Group6.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.IDATA2306.Group6.Entity.Review;
import no.ntnu.IDATA2306.Group6.Repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  @Autowired
  private ReviewRepo reviewRepository;

  @GetMapping
  @Operation(summary = "Get all reviews", description = "Retrieves a list of all reviews")
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get review by ID", description = "Retrieves a review by its unique ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the review", content = @Content(schema = @Schema(implementation = Review.class))),
      @ApiResponse(responseCode = "404", description = "Review not found")
  })
  public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
    Optional<Review> review = reviewRepository.findById(id);
    return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  @Operation(summary = "Create a review", description = "Creates a new review")
  @RequestBody(description = "Review to be added", required = true, content = @Content(schema = @Schema(implementation = Review.class)))
  public Review createReview(@org.springframework.web.bind.annotation.RequestBody Review review) {
    return reviewRepository.save(review);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a review", description = "Updates an existing review by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Review updated successfully", content = @Content(schema = @Schema(implementation = Review.class))),
      @ApiResponse(responseCode = "404", description = "Review not found")
  })
  public ResponseEntity<Review> updateReview(@PathVariable Long id,
      @org.springframework.web.bind.annotation.RequestBody Review reviewDetails) {
    return reviewRepository.findById(id).map(existingReview -> {
      existingReview.setRate(reviewDetails.getRate());
      existingReview.setTextReview(reviewDetails.getTextReview());
      return ResponseEntity.ok(reviewRepository.save(existingReview));
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a review", description = "Deletes a review by its ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Review deleted successfully"),
      @ApiResponse(responseCode = "404", description = "Review not found")
  })
  public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
    return reviewRepository.findById(id).map(review -> {
      reviewRepository.delete(review);
      return ResponseEntity.ok().<Void>build();
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
