package no.ntnu.IDATA2306.Group6.Entity;

public class HotelImages {
    private String imageID;
    private String hotelID;
    private int grade;
    private String sourceLink;

    public HotelImages(String imageID, String hotelID, int grade, String sourceLink) {
        this.imageID = imageID;
        this.hotelID = hotelID;
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
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
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
                ", hotelID='" + hotelID + '\'' +
                ", grade=" + grade +
                ", sourceLink='" + sourceLink + '\'' +
                '}';
    }
}
