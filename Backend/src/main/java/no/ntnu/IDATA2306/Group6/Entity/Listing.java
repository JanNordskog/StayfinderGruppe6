package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "listingID")
    private String listingID;

    @Column(name = "hotelID")
    private String hotelID;

    @Column(name = "hotelName")
    private String hotelName;

    @Column(name = "hotelAddress")
    private String hotelAddress;

    @Column(name = "roomTypeAvailable")
    private String roomTypeAvailable;

    @Column(name = "extraFeatures")
    private String extraFeatures;

    @Column(name = "agencyID")
    private String agencyID;

    @Column(name = "agencyName")
    private String agencyName;

    @Temporal(TemporalType.DATE)
    @Column(name = "arrivalDate")
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "departureDate")
    private Date departureDate;

    @Column(name = "price")
    private double price;

    @Column(name = "imageLink")
    private String imageLink;

    public Listing() {
    }

    public Listing(String listingID, String hotelID, String hotelName, String hotelAddress, String roomTypeAvailable,
            String extraFeatures, String agencyID, String agencyName, Date arrivalDate, Date departureDate,
            double price, String imageLink) { // Added imageLink parameter
        this.listingID = listingID;
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.roomTypeAvailable = roomTypeAvailable;
        this.extraFeatures = extraFeatures;
        this.agencyID = agencyID;
        this.agencyName = agencyName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.imageLink = imageLink; // Initialize imageLink
    }

    public String getListingID() {
        return listingID;
    }

    public void setListingID(String listingID) {
        this.listingID = listingID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getRoomTypeAvailable() {
        return roomTypeAvailable;
    }

    public void setRoomTypeAvailable(String roomTypeAvailable) {
        this.roomTypeAvailable = roomTypeAvailable;
    }

    public String getExtraFeatures() {
        return extraFeatures;
    }

    public void setExtraFeatures(String extraFeatures) {
        this.extraFeatures = extraFeatures;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingID='" + listingID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", roomTypeAvailable='" + roomTypeAvailable + '\'' +
                ", extraFeatures='" + extraFeatures + '\'' +
                ", agencyID='" + agencyID + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", price=" + price +
                ", imageLink='" + imageLink + '\'' + // Include imageLink in toString
                '}';
    }

}
