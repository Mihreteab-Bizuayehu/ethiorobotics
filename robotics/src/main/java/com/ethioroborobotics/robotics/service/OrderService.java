package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Order;
import com.ethioroborobotics.robotics.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId){
        return orderRepository.findById(orderId);
    }

    public void deleteOrder(Long orderId){
        orderRepository.deleteById(orderId);
    }
}
