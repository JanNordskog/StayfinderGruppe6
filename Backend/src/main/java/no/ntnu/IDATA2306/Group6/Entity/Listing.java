/**
 * The Listing class represents a hotel listing entity.
 */
package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "listingid")
    private String listingID;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelID", referencedColumnName = "hotelID")
    private Hotel hotel;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    private Agency agency;

    @Temporal(TemporalType.DATE)
    @Column(name = "arrivalDate")
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "departureDate")
    private Date departureDate;

    @Column(name = "price")
    private double price;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageID", referencedColumnName = "imageID")
    private HotelImages hotelImages;

    @Column(name = "visible", nullable = false, columnDefinition = "integer default 1")
    private int visible;

    /**
     * Constructs a new Listing object.
     */
    public Listing() {
    }

    /**
     * Constructs a new Listing object with specified parameters.
     *
     * @param listingID     The ID of the listing
     * @param hotel         The hotel associated with the listing
     * @param agency        The agency associated with the listing
     * @param arrivalDate   The arrival date for the listing
     * @param departureDate The departure date for the listing
     * @param price         The price of the listing
     * @param hotelImages   The hotel images associated with the listing
     */
    public Listing(String listingID, Hotel hotel, @NotNull Agency agency, Date arrivalDate, Date departureDate,
            double price, HotelImages hotelImages) {
        this.listingID = listingID;
        this.hotel = hotel;
        this.agency = agency;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.hotelImages = hotelImages;
        this.visible = 1;
    }

    /**
     * Gets the visibility status of the listing.
     *
     * @return The visibility status (1 for visible, 0 for hidden)
     */
    public int getVisible() {

        return visible;
    }

    /**
     * Sets the visibility status of the listing.
     *
     * @param visible The visibility status to set
     */
    public void setVisible(int visible) {

        this.visible = visible;
    }

    /**
     * Gets the ID of the listing.
     *
     * @return The listing ID
     */
    public String getListingID() {

        return listingID;
    }

    /**
     * Gets the name of the agency associated with the listing.
     *
     * @return The agency name
     */
    public String getAgencyName() {

        return agency.getName();
    }

    /**
     * Sets the ID of the listing.
     *
     * @param listingID The listing ID to set
     */
    public void setListingID(String listingID) {

        this.listingID = listingID;
    }

    /**
     * Gets the ID of the hotel associated with the listing.
     *
     * @return The hotel ID
     */
    public String getHotelID() {
        return hotel.getHotelID(); // This method delegates the call to the Hotel object
    }

    /**
     * Gets the name of the hotel associated with the listing.
     *
     * @return The hotel name
     */
    public String getHotelName() {

        return hotel.getName();
    }

    /**
     * Gets the description of the hotel associated with the listing.
     *
     * @return The hotel description
     */
    public String getHotelDescription() {

        return hotel.getDescription();
    }

    /**
     * Gets the address of the hotel associated with the listing.
     *
     * @return The hotel address
     */
    public String getHotelAddress() {

        return hotel.getAddress();
    }

    /**
     * Gets the room type available in the hotel associated with the listing.
     *
     * @return The room type available
     */
    public String getRoomTypeAvailable() {

        return hotel.getRoomTypeAvailable();
    }

    /**
     * Gets the extra features of the hotel associated with the listing.
     *
     * @return The extra features
     */
    public String getExtraFeatures() {

        return hotel.getExtraFeatures();
    }

    /**
     * Gets the arrival date for the listing.
     *
     * @return The arrival date
     */
    public Date getArrivalDate() {

        return arrivalDate;
    }

    /**
     * Gets the departure date for the listing.
     *
     * @return The departure date
     */
    public Date getDepartureDate() {

        return departureDate;
    }

    /**
     * Gets the price of the listing.
     *
     * @return The price
     */
    public double getPrice() {

        return price;
    }

    /**
     * Gets the image link associated with the listing.
     *
     * @return The image link
     */
    public String getImageLink() {

        return hotelImages.getSourceLink();
    }

    @Override
    public String toString() {
        return "Listing [listingID=" + listingID + ", hotelID=" + hotel + ", agency=" + agency + ", arrivalDate="
                + arrivalDate + ", departureDate="
                + departureDate + ", price=" + price + ", imageLink=" + hotelImages + ", visible=" + visible + "]";
    }

    /**
     * Gets the agency associated with the listing.
     *
     * @return The agency
     */
    public Agency getAgency() {

        return agency;
    }

    /**
     * Sets the agency associated with the listing.
     *
     * @param agency The agency to set
     */
    public void setAgency(Agency agency) {

        this.agency = agency;
    }

}
