
package no.ntnu.IDATA2306.Group6.Controller;

    import no.ntnu.IDATA2306.Group6.Entity.Order;
    import no.ntnu.IDATA2306.Group6.Repo.OrderRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.mail.SimpleMailMessage;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderRepo orderRepository;

  @Autowired
  private JavaMailSender mailSender;

  @PostMapping
  public Order createOrder(@RequestBody Order order) {
    Order savedOrder = orderRepository.save(order);
    sendOrderSummaryEmail(savedOrder);
    return savedOrder;
  }

  private void sendOrderSummaryEmail(Order order) {
    System.out.println("Sending email to: " + order.getEmail()); // Debug log
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(order.getEmail());
    message.setSubject("Order Confirmation");
    message.setText("Thank you for your booking. Here are the details: \n" +
        "Name: " + order.getName() + "\n" +
        "Hotel ID: " + order.getHotelId() + "\n" +
        "Destination: " + order.getDestination() + "\n" +
        "Guests: " + order.getGuests() + "\n" +
        "Arrival Date: " + order.getArrivalDate() + "\n" +
        "Departure Date: " + order.getDepartureDate() + "\n" +
        "Price: $" + order.getPrice());
    mailSender.send(message);
    System.out.println("Email sent"); // Debug log
  }
}

