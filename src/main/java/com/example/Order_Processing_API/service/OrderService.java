package com.example.Order_Processing_API.service;

import com.example.Order_Processing_API.model.OrderEntity;
import com.example.Order_Processing_API.model.OrderStatus;
import com.example.Order_Processing_API.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderEntity orderEntity) {
        orderEntity.setStatus(OrderStatus.PENDING);
        orderEntity.setOrderDate(LocalDateTime.now());
        return orderRepository.save(orderEntity);
    }

    public OrderEntity updateOrderStatus(Long id, OrderStatus status) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderEntity.setStatus(status);
        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getOrderHistory(String customer) {
        return orderRepository.findByCustomer(customer);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
