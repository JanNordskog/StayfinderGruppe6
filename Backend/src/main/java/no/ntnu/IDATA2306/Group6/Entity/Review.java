/**
 * The Review class represents a review entity with details such as ID, user, listing, rating, and text review.
 */
package no.ntnu.IDATA2306.Group6.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "review")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "reviewID")
  private Long reviewID;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "userID", referencedColumnName = "userID")
  private User user;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "listingID", referencedColumnName = "listingID")
  private Listing listing;

  @NotNull
  @Min(0)
  @Max(5)
  @Column(name = "rate")
  private int rate;

  @NotNull
  @Size(max = 500)
  @Column(name = "textReview", length = 500)
  private String textReview;

  /**
   * Default constructor for Review.
   */
  public Review() {
  }

  /**
   * Constructor for Review with parameters.
   *
   * @param user       The user who made the review.
   * @param listing    The listing that was reviewed.
   * @param rate       The rating given in the review (0-5).
   * @param textReview The text content of the review.
   */
  public Review(User user, Listing listing, int rate, String textReview) {
    this.user = user;
    this.listing = listing;
    this.rate = rate;
    this.textReview = textReview;
  }

  /**
   * Retrieves the review ID.
   *
   * @return The review ID.
   */
  public Long getReviewID() {

    return reviewID;
  }

  /**
   * Sets the review ID.
   *
   * @param reviewID The review ID to set.
   */
  public void setReviewID(Long reviewID) {

    this.reviewID = reviewID;
  }

  /**
   * Retrieves the user who made the review.
   *
   * @return The user who made the review.
   */
  public User getUser() {

    return user;
  }

  /**
   * Sets the user who made the review.
   *
   * @param user The user to set.
   */
  public void setUser(User user) {

    this.user = user;
  }

  /**
   * Retrieves the listing that was reviewed.
   *
   * @return The listing that was reviewed.
   */
  public Listing getListing() {

    return listing;
  }

  /**
   * Sets the listing that was reviewed.
   *
   * @param listing The listing to set.
   */
  public void setListing(Listing listing) {

    this.listing = listing;
  }

  public int getRate() {

    return rate;
  }

  /**
   * Retrieves the rating given in the review.
   *
   * @return The rating given in the review (0-5).
   */
  public void setRate(int rate) {

    this.rate = rate;
  }

  public String getTextReview() {

    return textReview;
  }

  /**
   * Retrieves the text content of the review.
   *
   * @return The text content of the review.
   */
  public void setTextReview(String textReview) {

    this.textReview = textReview;
  }

  /**
   * Returns a string representation of the Review object.
   *
   * @return A string representation of the Review object.
   */
  @Override
  public String toString() {
    return "Review [reviewID=" + reviewID + ", userID=" + user + ", listingID=" + listing +
        ", rate=" + rate + ", textReview=" + textReview + "]";
  }
}
