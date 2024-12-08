package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
