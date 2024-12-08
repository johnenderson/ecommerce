package tech.buildrun.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.ecommerce.controller.dto.CreateOrderDTO;
import tech.buildrun.ecommerce.service.OrderService;

import java.net.URI;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO dto) {

       var order =  orderService.createOrder(dto);

       return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();

    }
}
