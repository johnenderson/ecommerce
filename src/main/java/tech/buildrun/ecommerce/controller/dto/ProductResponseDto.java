package tech.buildrun.ecommerce.controller.dto;

import tech.buildrun.ecommerce.entities.ProductEntity;
import tech.buildrun.ecommerce.entities.TagEntity;

import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 List<TagResponseDto> tags) {

    public static ProductResponseDto fromEntity(ProductEntity product) {
        return new ProductResponseDto(
                product.getProductId(),
                product.getProductName(),
                getTags(product.getTags())
        );
    }

    private static List<TagResponseDto> getTags(List<TagEntity> tags) {
        return tags.stream()
                .map(TagResponseDto::fromEntity)
                .toList();

    }
}
