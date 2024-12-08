package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
