/**
 * The HotelImages class represents hotel images associated with a hotel entity.
 */
package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hotelimages")
public class HotelImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "imageID")
    private String imageID;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelID", referencedColumnName = "hotelID")
    private Hotel hotel;
    @Column(name = "grade")
    private int grade;
    @Column(name = "sourceLink")
    private String sourceLink;

    /**
     * Constructs a new HotelImages object.
     */
    public HotelImages() {
    }

    /**
     * Constructs a new HotelImages object with specified parameters.
     *
     * @param imageID    The ID of the image
     * @param hotel      The hotel associated with the image
     * @param grade      The grade of the image
     * @param sourceLink The source link of the image
     */
    public HotelImages(String imageID, Hotel hotel, int grade, String sourceLink) {
        this.imageID = imageID;
        this.hotel = hotel;
        this.grade = grade;
        this.sourceLink = sourceLink;
    }

    /**
     * Gets the ID of the image.
     *
     * @return The image ID
     */
    public String getImageID() {
        return imageID;
    }

    /**
     * Sets the ID of the image.
     *
     * @param imageID The image ID to set
     */
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    /**
     * Gets the ID of the hotel associated with the image.
     *
     * @return The hotel ID
     */
    public String getHotelID() {
        return hotel.getHotelID();
    }

    /**
     * Gets the grade of the image.
     *
     * @return The image grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the image.
     *
     * @param grade The grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Gets the source link of the image.
     *
     * @return The image source link
     */
    public String getSourceLink() {
        return sourceLink;
    }

    /**
     * Sets the source link of the image.
     *
     * @param sourceLink The source link to set
     */
    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    /**
     * Returns a string representation of the HotelImages object.
     *
     * @return A string representation of the HotelImages object
     */
    @Override
    public String toString() {
        return "HotelImages{" +
                "imageID='" + imageID + '\'' +
                ", hotelID='" + hotel + '\'' +
                ", grade=" + grade +
                ", sourceLink='" + sourceLink + '\'' +
                '}';
    }
}
