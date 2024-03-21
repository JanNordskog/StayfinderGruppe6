package no.ntnu.IDATA2306.Group6;

import java.util.Objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a resource: a User. We store user objects in the application
 * state.
 */

public final class User {

  private String email;
  private String password;
  private String hashedPassword;
  private String address;
  private String gender;
  private String phone;
  private String dob;
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  User(String email, String password, String address, String gender, String phone, String dob) {
    this.email = email;
    this.password = password;

    this.password = hashedPassword;
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
    if (obj == this)
      return true;
    if (obj == null || obj.getClass() != this.getClass())
      return false;
    var that = (User) obj;
    return Objects.equals(this.email, that.email) && Objects.equals(this.password, that.password)
        && Objects.equals(this.address, that.address) && Objects.equals(this.gender, that.gender)
        && Objects.equals(this.phone, that.phone) && Objects.equals(this.dob, that.dob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, address, gender, phone, dob);
  }

  @Override
  public String toString() {
    return "User[" + "email=" + email + ", " + "password=" + hashedPassword + ", " + "address=" + address + ", "
        + "gender=" + gender + ", " + "phone=" + phone + ", " + "dob=" + dob + ']';
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

  public String hashPassword() {
    hashedPassword = encoder.encode(this.password);
    return hashedPassword;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public boolean matchPassword(String rawPassword) {
    return encoder.matches(rawPassword, this.password);
  }
}
