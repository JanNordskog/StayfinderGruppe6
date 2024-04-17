package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteID")
    private Long favoriteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelID", nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listingID", nullable = false)
    private Listing listing;

    // Constructors
    public Favorites() {
    }

    public Favorites(Hotel hotel, Listing listing) {
        this.hotel = hotel;
        this.listing = listing;
    }

    // Getter and Setter for favoriteID
    public Long getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(Long favoriteID) {
        this.favoriteID = favoriteID;
    }

    // Getter and Setter for hotel
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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
                ", hotel=" + hotel +
                ", listing=" + listing +
                '}';
    }
}
