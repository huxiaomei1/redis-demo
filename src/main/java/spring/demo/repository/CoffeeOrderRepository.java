package spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.model.CoffeeOrder;


public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
