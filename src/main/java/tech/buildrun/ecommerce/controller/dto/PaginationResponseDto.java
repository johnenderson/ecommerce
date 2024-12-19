package tech.buildrun.ecommerce.controller.dto;

public record PaginationResponseDto(Integer page,
                                    Integer pageSize,
                                    Long totalElements,
                                    Integer totalPages) {
}
