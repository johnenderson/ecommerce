package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entities.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
