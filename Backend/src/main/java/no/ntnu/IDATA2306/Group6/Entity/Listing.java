package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "listingID")
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

    public Listing() {
    }

    public Listing(String listingID, Hotel hotel, @NotNull Agency agency, Date arrivalDate, Date departureDate,
            double price, HotelImages hotelImages) {
        this.listingID = listingID;
        this.hotel = hotel;
        this.agency = agency;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.hotelImages = hotelImages;
        this.visible = 1; // Setting default value in constructor
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getListingID() {
        return listingID;
    }

    public String getAgencyName() {
        return agency.getName();
    }

    public void setListingID(String listingID) {
        this.listingID = listingID;
    }

    public String getHotelID() {
        return hotel.getHotelID(); // This method delegates the call to the Hotel object
    }

    public String getHotelName() {
        return hotel.getName();
    }

    public String getHotelAddress() {
        return hotel.getAddress();
    }

    public String getRoomTypeAvailable() {
        return hotel.getRoomTypeAvailable();
    }

    public String getExtraFeatures() {
        return hotel.getExtraFeatures();
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public double getPrice() {
        return price;
    }

    public String getImageLink() {
        return hotelImages.getSourceLink();
    }

    @Override
    public String toString() {
        return "Listing [listingID=" + listingID + ", hotelID=" + hotel + ", agency=" + agency + ", arrivalDate="
                + arrivalDate + ", departureDate="
                + departureDate + ", price=" + price + ", imageLink=" + hotelImages + ", visible=" + visible + "]";
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

}
