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

    private int grade;

    private String sourceLink;

    public HotelImages() {
    }

    public HotelImages(String imageID, Hotel hotel, int grade, String sourceLink) {
        this.imageID = imageID;
        this.hotel = hotel;
        this.grade = grade;
        this.sourceLink = sourceLink;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getHotelID() {
        return hotel.getHotelID();
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

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
