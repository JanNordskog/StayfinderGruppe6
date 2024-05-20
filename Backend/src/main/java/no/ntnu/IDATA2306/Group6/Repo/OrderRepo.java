package no.ntnu.IDATA2306.Group6.Repo;

import no.ntnu.IDATA2306.Group6.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
