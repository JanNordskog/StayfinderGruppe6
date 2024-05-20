package no.ntnu.IDATA2306.Group6.Controller;

import no.ntnu.IDATA2306.Group6.Entity.Order;
import no.ntnu.IDATA2306.Group6.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderRepo orderRepo;

  @Autowired
  private JavaMailSender emailSender;

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    Order savedOrder = orderRepo.save(order);
    sendOrderSummaryEmail(order);
    return ResponseEntity.ok(savedOrder);
  }

  private void sendOrderSummaryEmail(Order order) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(order.getEmail());
    message.setSubject("Booking Confirmation");
    message.setText("Thank you for your booking!\n\n" +
        "Hotel ID: " + order.getHotelId() + "\n" +
        "Destination: " + order.getDestination() + "\n" +
        "Guests: " + order.getGuests() + "\n" +
        "Dates: " + order.getArrivalDate() + " - " + order.getDepartureDate() + "\n" +
        "Price: $" + order.getPrice() + "\n\n" +
        "Please don't hesitate to contact us if you have any questions.");
    emailSender.send(message);
  }
}
