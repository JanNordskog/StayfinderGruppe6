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

    public Listing() {
    }

    public Listing(String listingID, Hotel hotel, @NotNull Agency agency, Date arrivalDate, Date departureDate,
            double price,
            HotelImages hotelImages) {
        this.listingID = listingID;
        this.agency = agency;
        this.hotel = hotel;
        this.hotelImages = hotelImages;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
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
                + departureDate + ", price=" + price + ", imageLink=" + hotelImages + "]";
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

}
