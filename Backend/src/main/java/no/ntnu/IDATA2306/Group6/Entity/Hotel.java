/**
 * The Hotel class represents a hotel entity.
 */
package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")

/**
 * Constructs a new Hotel object.
 */
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotelID")
    private String hotelID;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "locationType")
    private String locationType;
    @Column(name = "roomTypeAvailable")
    private String roomTypeAvailable;
    @Column(name = "extraFeatures")
    private String extraFeatures;
    @Column(name = "description") // Added new column for description
    private String description;

    /**
     * Constructs a new Hotel object with specified parameters.
     *
     * @param hotelId          The ID of the hotel
     * @param name             The name of the hotel
     * @param address          The address of the hotel
     * @param website          The website of the hotel
     * @param phoneNumber      The phone number of the hotel
     * @param locationType     The location type of the hotel
     * @param roomTypeAvailable The room types available at the hotel
     * @param extraFeatures    The extra features provided by the hotel
     * @param description      The description of the hotel
     */
    public Hotel(String hotelId, String name, String address, String website,
            String phoneNumber, String locationType, String roomTypeAvailable,
            String extraFeatures, String description) {
        this.hotelID = hotelId;
        this.name = name;
        this.address = address;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.locationType = locationType;
        this.roomTypeAvailable = roomTypeAvailable;
        this.extraFeatures = extraFeatures;
        this.description = description; // Initialize new field
    }

    /**
     * Gets the description of the hotel.
     *
     * @return The hotel description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the ID of the hotel.
     *
     * @return The hotel ID
     */
    public String getHotelID() {
        return hotelID;
    }

    /**
     * Gets the name of the hotel.
     *
     * @return The hotel name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the address of the hotel.
     *
     * @return The hotel address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the website of the hotel.
     *
     * @return The hotel website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Gets the phone number of the hotel.
     *
     * @return The hotel phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the location type of the hotel.
     *
     * @return The hotel location type
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Gets the room types available at the hotel.
     *
     * @return The room types available
     */
    public String getRoomTypeAvailable() {
        return roomTypeAvailable;
    }

    /**
     * Gets the extra features provided by the hotel.
     *
     * @return The extra features
     */
    public String getExtraFeatures() {
        return extraFeatures;
    }

}
