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

  public Review() {
  }

  public Review(User user, Listing listing, int rate, String textReview) {
    this.user = user;
    this.listing = listing;
    this.rate = rate;
    this.textReview = textReview;
  }

  public Long getReviewID() {
    return reviewID;
  }

  public void setReviewID(Long reviewID) {
    this.reviewID = reviewID;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Listing getListing() {
    return listing;
  }

  public void setListing(Listing listing) {
    this.listing = listing;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  public String getTextReview() {
    return textReview;
  }

  public void setTextReview(String textReview) {
    this.textReview = textReview;
  }

  @Override
  public String toString() {
    return "Review [reviewID=" + reviewID + ", userID=" + user + ", listingID=" + listing +
        ", rate=" + rate + ", textReview=" + textReview + "]";
  }
}
