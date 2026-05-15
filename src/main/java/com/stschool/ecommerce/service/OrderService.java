package com.stschool.ecommerce.service;

import com.stschool.ecommerce.entity.Order;
import com.stschool.ecommerce.exceptions.OrderAlreadyExistsException;
import com.stschool.ecommerce.exceptions.OrderNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService   {

    // Save Order
    Order saveOrder(Order order) throws OrderAlreadyExistsException;

    // Get All Orders
    List<Order> getAllOrders();

    // Get Order By Id
    Optional<Order> getOrderById(int id) throws OrderNotFoundException;

    // Update Order
    Order updateOrder(int id, Order order) throws OrderNotFoundException;

    // Delete Order
    void deleteOrder(int id) throws OrderNotFoundException;
}
