package spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
