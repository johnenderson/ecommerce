package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entities.BillingAddressEntity;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
