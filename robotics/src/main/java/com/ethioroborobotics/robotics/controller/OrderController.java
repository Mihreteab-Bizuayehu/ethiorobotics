package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Order;
import com.ethioroborobotics.robotics.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> addToCart(@RequestBody Order order){

        Order createdOrder=orderService.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders(){

        List<Order> orders=orderService.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Optional<Order>> getCartItemById(@PathVariable("id") Long orderId){

        Optional<Order> order=orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long orderId){

        orderService.deleteOrder(orderId);

    }
}
