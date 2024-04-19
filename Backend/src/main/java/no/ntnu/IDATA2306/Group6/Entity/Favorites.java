package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteID")
    private Integer favoriteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false) 
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listingID", nullable = false)
    private Listing listing;

    // Constructors
    public Favorites() {
    }

    public Favorites(User user, Listing listing) {
        this.user = user;
        this.listing = listing;
    }

    // Getter and Setter for favoriteID
    public Integer getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(Integer favoriteID) {
        this.favoriteID = favoriteID;
    }

    // Getter and Setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and Setter for listing
    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    // To String method
    @Override
    public String toString() {
        return "Favorites{" +
                "favoriteID=" + favoriteID +
                ", user=" + user +
                ", listing=" + listing +
                '}';
    }
}
