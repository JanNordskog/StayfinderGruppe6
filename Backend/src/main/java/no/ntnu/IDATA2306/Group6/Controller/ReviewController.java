/**
 * The ReviewController class handles HTTP requests related to reviews.
 * It provides endpoints for retrieving, creating, updating, and deleting reviews.
 */
package no.ntnu.IDATA2306.Group6.Controller;

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

  /**
   * Retrieves all reviews.
   *
   * @return A list of all reviews
   */
  @GetMapping
  public List<Review> getAllReviews() {

    return reviewRepository.findAll();
  }

  /**
   * Retrieves a review by its ID.
   *
   * @param id The ID of the review to retrieve
   * @return ResponseEntity containing the review if found, otherwise not found status
   */
  @GetMapping("/{id}")
  public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
    Optional<Review> review = reviewRepository.findById(id);
    return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Creates a new review.
   *
   * @param review The review to create
   * @return The created review
   */
  @PostMapping
  public Review createReview(@RequestBody Review review) {

    return reviewRepository.save(review);
  }

  /**
   * Updates an existing review.
   *.
   * @param id            The ID of the review to update
   * @param reviewDetails The updated review details
   * @return ResponseEntity containing the updated review if found, otherwise not found status
   */
  @PutMapping("/{id}")
  public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
    return reviewRepository.findById(id).map(existingReview -> {
      existingReview.setRate(reviewDetails.getRate());
      existingReview.setTextReview(reviewDetails.getTextReview());
      return ResponseEntity.ok(reviewRepository.save(existingReview));
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Deletes a review by its ID.
   *
   * @param id The ID of the review to delete
   * @return ResponseEntity indicating success or failure of the deletion
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
    return reviewRepository.findById(id).map(review -> {
      reviewRepository.delete(review);
      return ResponseEntity.ok().<Void>build();
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
