package com.example.Order_Processing_API.controller;

import com.example.Order_Processing_API.model.OrderEntity;
import com.example.Order_Processing_API.model.OrderStatus;
import com.example.Order_Processing_API.model.StatusUpdateRequest;
import com.example.Order_Processing_API.service.OrderService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEntity orderEntity) {
        OrderEntity createdOrderEntity = orderService.createOrder(orderEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order created successfully with ID: " + createdOrderEntity.getId());
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orderEntities = orderService.getAllOrders();
        return ResponseEntity.ok(orderEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
        OrderEntity orderEntity = orderService.getOrderById(id);
        return ResponseEntity.ok(orderEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrderStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateRequest statusUpdateRequest) {
        OrderEntity updatedOrderEntity = orderService.updateOrderStatus(id, statusUpdateRequest.getStatus());
        return ResponseEntity.ok("Order status updated successfully for ID: " + updatedOrderEntity.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully with ID: " + id);
    }

    @GetMapping("/history")
    public ResponseEntity<List<OrderEntity>> getOrderHistory(@RequestParam String customer) {
        List<OrderEntity> orderEntities = orderService.getOrderHistory(customer);
        return ResponseEntity.ok(orderEntities);
    }
}
