package no.ntnu.IDATA2306.Group6;

import java.util.Objects;

/**
 * Represents a resource: a User. We store user objects in the application state.
 */
public final class User {
    
    private final String email;
    private final String password;
    private final String address;
    private final String gender;
    private final String phone;
    private final String dob;

    User(String email, String password, String address, String gender, String phone, String dob) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String address() {
        return address;
    }

    public String gender() {
        return gender;
    }

    public String phone() {
        return phone;
    }

    public String dob() {
        return dob;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.email, that.email) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.phone, that.phone) &&
                Objects.equals(this.dob, that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, address, gender, phone, dob);
    }

    @Override
    public String toString() {
        return "User[" +
                "email=" + email + ", " +
                "password=" + password + ", " +
                "address=" + address + ", " +
                "gender=" + gender + ", " +
                "phone=" + phone + ", " +
                "dob=" + dob + ']';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }
}
