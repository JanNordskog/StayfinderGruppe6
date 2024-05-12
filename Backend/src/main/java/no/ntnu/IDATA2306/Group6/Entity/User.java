/**
 * The User class represents a user entity with details such as ID, name, email, password, address, gender, phone, date of birth, and user permission level.
 */
package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "userID")
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private String dob;

    @Column(nullable = false)
    private Integer userperm = 0; // default value is 0

    /**
     * Constructor for creating a User object with specified parameters.
     *
     * @param name     The name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @param address  The address of the user.
     * @param gender   The gender of the user.
     * @param phone    The phone number of the user.
     * @param dob      The date of birth of the user.
     */
    public User(String name, String email, String password, String address, String gender, String phone, String dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
    }

    /**
     * Default constructor for User.
     */
    public User() {
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return The ID of the user.
     */
    public Integer getId() {

        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The ID of the user to set.
     */
    public void setId(Integer id) {

        this.id = id;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name of the user to set.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {

        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address of the user to set.
     */
    public void setEmail(String email) {

        this.email = email;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {

        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user to set.
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * Retrieves the address of the user.
     *
     * @return The address of the user.
     */
    public String getAddress() {

        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The address of the user to set.
     */
    public void setAddress(String address) {

        this.address = address;
    }

    /**
     * Retrieves the gender of the user.
     *
     * @return The gender of the user.
     */
    public String getGender() {

        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender The gender of the user to set.
     */
    public void setGender(String gender) {

        this.gender = gender;
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhone() {

        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone The phone number of the user to set.
     */
    public void setPhone(String phone) {

        this.phone = phone;
    }

    /**
     * Retrieves the date of birth of the user.
     *
     * @return The date of birth of the user.
     */
    public String getDob() {

        return dob;
    }

    /**
     * Sets the date of birth of the user.
     *
     * @param dob The date of birth of the user to set.
     */
    public void setDob(String dob) {

        this.dob = dob;
    }

    /**
     * Retrieves the permission level of the user.
     *
     * @return The permission level of the user.
     */
    public Integer getUserperm() {

        return userperm;
    }

    /**
     * Sets the permission level of the user.
     *
     * @param userperm The permission level of the user to set.
     */
    public void setUserperm(Integer userperm) {

        this.userperm = userperm;
    }
}
