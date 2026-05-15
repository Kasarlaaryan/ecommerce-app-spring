package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.entity.Order;
import com.stschool.ecommerce.exceptions.OrderAlreadyExistsException;
import com.stschool.ecommerce.exceptions.OrderNotFoundException;
import com.stschool.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Save Order
    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order)
            throws OrderAlreadyExistsException {

        Order savedOrder = orderService.saveOrder(order);

        return ResponseEntity.ok(savedOrder);
    }

    // Get All Orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> orders = orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }

    // Get Order By Id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id)
            throws OrderNotFoundException {

        Order order = orderService.getOrderById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with id : " + id
                        )
                );

        return ResponseEntity.ok(order);
    }

    // Update Order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable int id,
            @RequestBody Order order)
            throws OrderNotFoundException {

        Order updatedOrder = orderService.updateOrder(id, order);

        return ResponseEntity.ok(updatedOrder);
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id)
            throws OrderNotFoundException {

        orderService.deleteOrder(id);

        return ResponseEntity.ok("Order deleted successfully");
    }
}
