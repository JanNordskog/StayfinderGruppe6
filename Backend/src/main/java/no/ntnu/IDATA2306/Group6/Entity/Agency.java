/**
 * The Agency class represents an agency entity.
 */
package no.ntnu.IDATA2306.Group6.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agencyID")
    private String agencyID;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "website")
    private String website;

    /**
     * Constructs a new Agency object.
     *
     * @param agencyID    The ID of the agency
     * @param name        The name of the agency
     * @param email       The email of the agency
     * @param phoneNumber The phone number of the agency
     * @param website     The website of the agency
     */
    public Agency(String agencyID, String name, String email, String phoneNumber, String website) {
        this.agencyID = agencyID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    /**
     * Constructs a new empty Agency object.
     */
    public Agency() {
    }

    /**
     * Gets the ID of the agency.
     *
     * @return The agency ID
     */

    /**
     *
     * test
     */

    public String getAgencyID() {

        return agencyID;
    }

    /**
     * Gets the name of the agency.
     *
     * @return The agency name
     */

    public String getName() {

        return name;
    }

    /**
     * Gets the email of the agency.
     *
     * @return The agency email
     */
    public String getEmail() {

        return email;
    }

    /**
     * Gets the phone number of the agency.
     *
     * @return The agency phone number
     */


    public String getPhoneNumber() {

        return phoneNumber;
    }

    /**
     * Gets the website of the agency.
     *
     * @return The agency website
     */

    public String getWebsite() {

        return website;
    }
}
