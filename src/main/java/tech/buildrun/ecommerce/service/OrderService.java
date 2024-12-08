package tech.buildrun.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.buildrun.ecommerce.controller.dto.CreateOrderDTO;
import tech.buildrun.ecommerce.controller.dto.OrderItemDTO;
import tech.buildrun.ecommerce.entities.OrderEntity;
import tech.buildrun.ecommerce.entities.OrderItemEntity;
import tech.buildrun.ecommerce.entities.OrderItemId;
import tech.buildrun.ecommerce.entities.ProductEntity;
import tech.buildrun.ecommerce.entities.UserEntity;
import tech.buildrun.ecommerce.exception.CreateOrderException;
import tech.buildrun.ecommerce.repository.OrderItemRepository;
import tech.buildrun.ecommerce.repository.OrderRepository;
import tech.buildrun.ecommerce.repository.ProductRepository;
import tech.buildrun.ecommerce.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public OrderService(UserRepository userRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDTO dto) {

        var order = new OrderEntity();

        // 1. Validate User
        var user = validateUser(dto);

        // 2. Validate Order Itens
        var orderItems = validateOrderItems(order, dto);

        // 3. Calculate Order Total
        var total = calculateOrderTotal(orderItems);

        // 4. Map to Entity
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItems(orderItems);
        order.setTotal(total);

        // 5. Repository save
        return  orderRepository.save(order);
    }

    private UserEntity validateUser(CreateOrderDTO dto) {
        return userRepository.findById(dto.userId())
                .orElseThrow(() -> new CreateOrderException("user not found"));
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order,
                                                     CreateOrderDTO dto) {

        if (dto.items().isEmpty()) {
            throw new CreateOrderException("order items is empty");
        }

        return dto.items()
                .stream()
                .map(orderItemDTO -> getOrderItem(order, orderItemDTO))
                .toList();
    }

    private OrderItemEntity getOrderItem(OrderEntity order,
                                         OrderItemDTO orderItemDTO) {

        var orderItemEntity = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(orderItemDTO.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItemEntity.setId(id);
        orderItemEntity.setQuantity(orderItemDTO.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CreateOrderException("product not found"));

    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> items) {
        // 1. Price x Quantity

        return items.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
