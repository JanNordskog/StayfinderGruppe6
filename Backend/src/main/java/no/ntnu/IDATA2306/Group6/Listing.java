package no.ntnu.IDATA2306.Group6;

import java.util.Date;

public class Listing {
    private String listingID;
    private String hotelID;
    private String agencyID;
    private Date arrivalDate;
    private Date departureDate;
    private double price;

    // Constructors
    public Listing() {
        // Default constructor
    }

    public Listing(String listingID, String hotelID, String agencyID, Date arrivalDate, Date departureDate, double price) {
        this.listingID = listingID;
        this.hotelID = hotelID;
        this.agencyID = agencyID;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
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

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
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


    @Override
    public String toString() {
        return "Listing{" +
                "listingID='" + listingID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", agencyID='" + agencyID + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", price=" + price +
                '}';
    }
}
