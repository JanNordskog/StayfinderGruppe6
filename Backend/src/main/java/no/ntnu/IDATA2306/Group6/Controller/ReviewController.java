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

  @GetMapping
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
    Optional<Review> review = reviewRepository.findById(id);
    return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Review createReview(@RequestBody Review review) {
    return reviewRepository.save(review);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
    return reviewRepository.findById(id).map(existingReview -> {
      existingReview.setRate(reviewDetails.getRate());
      existingReview.setTextReview(reviewDetails.getTextReview());
      return ResponseEntity.ok(reviewRepository.save(existingReview));
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
    return reviewRepository.findById(id).map(review -> {
      reviewRepository.delete(review);
      return ResponseEntity.ok().<Void>build();
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
