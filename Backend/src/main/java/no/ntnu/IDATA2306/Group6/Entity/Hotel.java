package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotelID")
    private String hotelID;

    private String name;

    private String address;

    private String website;

    private String phoneNumber;

    private String locationType;

    private String roomTypeAvailable;

    private String extraFeatures;

    public Hotel(String hotelId, String name, String address, String website,
            String phoneNumber, String locationType, String roomTypeAvailable, String extraFeatures) {
        this.hotelID = hotelId;
        this.name = name;
        this.address = address;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.locationType = locationType;
        this.roomTypeAvailable = roomTypeAvailable;
        this.extraFeatures = extraFeatures;
    }

    public String getHotelID() {
        return hotelID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getRoomTypeAvailable() {
        return roomTypeAvailable;
    }

    public String getExtraFeatures() {
        return extraFeatures;
    }

}
