package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "credit_card", nullable = false)
  private String creditCard;

  @Column(name = "expiry_date", nullable = false)
  private String expiryDate;

  @Column(name = "cvv", nullable = false)
  private String cvv;

  @Column(name = "hotel_id", nullable = false)
  private String hotelId;

  @Column(name = "destination", nullable = false)
  private String destination;

  @Column(name = "guests", nullable = false)
  private int guests;

  @Column(name = "arrival_date", nullable = false)
  private Date arrivalDate;

  @Column(name = "departure_date", nullable = false)
  private Date departureDate;

  @Column(name = "price", nullable = false)
  private double price;

  // Getters and setters

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getGuests() {
    return guests;
  }

  public void setGuests(int guests) {
    this.guests = guests;
  }

  public Date getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
