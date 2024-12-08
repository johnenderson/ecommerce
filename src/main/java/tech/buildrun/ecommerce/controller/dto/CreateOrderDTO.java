package tech.buildrun.ecommerce.controller.dto;

import java.util.List;
import java.util.UUID;

public record CreateOrderDTO(UUID userId,
                             List<OrderItemDTO> items) {
}
