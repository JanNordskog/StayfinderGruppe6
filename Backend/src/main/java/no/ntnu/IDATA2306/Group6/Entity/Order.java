package no.ntnu.IDATA2306.Group6.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public final class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
  @SequenceGenerator(name = "order_seq", sequenceName = "orders_seq", allocationSize = 1)
  @Column(name = "order_id")
  private Integer orderId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(name = "credit_card", nullable = false)
  private String creditCard;

  @Column(name = "expiry_date", nullable = false)
  private String expiryDate;

  @Column(nullable = false)
  private String cvv;

  @Column(name = "hotel_id", nullable = false)
  private String hotelId;

  @Column(nullable = false)
  private String destination;

  @Column(nullable = false)
  private Integer guests;

  @Column(name = "arrival_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date arrivalDate;

  @Column(name = "departure_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date departureDate;

  @Column(nullable = false)
  private Double price;

  public Order() {}

  public Order(String name, String email, String creditCard, String expiryDate, String cvv, String hotelId,
               String destination, Integer guests, Date arrivalDate, Date departureDate, Double price) {
    this.name = name;
    this.email = email;
    this.creditCard = creditCard;
    this.expiryDate = expiryDate;
    this.cvv = cvv;
    this.hotelId = hotelId;
    this.destination = destination;
    this.guests = guests;
    this.arrivalDate = arrivalDate;
    this.departureDate = departureDate;
    this.price = price;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
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

  public Integer getGuests() {
    return guests;
  }

  public void setGuests(Integer guests) {
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderId=" + orderId +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", creditCard='" + creditCard + '\'' +
        ", expiryDate='" + expiryDate + '\'' +
        ", cvv='" + cvv + '\'' +
        ", hotelId='" + hotelId + '\'' +
        ", destination='" + destination + '\'' +
        ", guests=" + guests +
        ", arrivalDate=" + arrivalDate +
        ", departureDate=" + departureDate +
        ", price=" + price +
        '}';
  }
}
