/**
 * The Favorites class represents a favorite entity.
 */
package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteID")
    private Integer favoriteID;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", nullable = false, referencedColumnName = "userId")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listingid", nullable = false, referencedColumnName = "listingid")
    private Listing listing;

    /**
     * Constructs a new Favorites object.
     */
    public Favorites() {
    }

    /**
     * Constructs a new Favorites object with user and listing.
     *
     * @param user    The user associated with the favorite
     * @param listing The listing associated with the favorite
     */
    public Favorites(User user, Listing listing) {
        this.user = user;
        this.listing = listing;
    }

    /**
     * Gets the ID of the favorite.
     *
     * @return The favorite ID
     */
    public Integer getFavoriteID() {

        return favoriteID;
    }

    /**
     * Sets the ID of the favorite.
     *
     * @param favoriteID The favorite ID to set
     */
    public void setFavoriteID(Integer favoriteID) {
        this.favoriteID = favoriteID;
    }

    /**
     * Gets the user associated with the favorite.
     *
     * @return The user associated with the favorite
     */
    public User getUser() {

        return user;
    }

    /**
     * Sets the user associated with the favorite.
     *
     * @param user The user to set
     */
    public void setUser(User user) {

        this.user = user;
    }

    /**
     * Gets the listing associated with the favorite.
     *
     * @return The listing associated with the favorite
     */
    public Listing getListing() {

        return listing;
    }

    /**
     * Sets the listing associated with the favorite.
     *
     * @param listing The listing to set
     */
    public void setListing(Listing listing) {

        this.listing = listing;
    }

    /**
     * Returns a string representation of the Favorites object.
     *
     * @return A string representation of the Favorites object
     */
    @Override
    public String toString() {
        return "Favorites{" +
                "favoriteID=" + favoriteID +
                ", user=" + user +
                ", listing=" + listing +
                '}';
    }
}
