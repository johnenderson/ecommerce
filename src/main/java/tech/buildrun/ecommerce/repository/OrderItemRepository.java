package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entities.OrderItemEntity;
import tech.buildrun.ecommerce.entities.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {
}
