package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agencyID")
    private String agencyID;

    private String name;

    private String email;

    private String phoneNumber;

    private String website;

    public Agency(String agencyID, String name, String email, String phoneNumber, String website) {
        this.agencyID = agencyID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }
}
