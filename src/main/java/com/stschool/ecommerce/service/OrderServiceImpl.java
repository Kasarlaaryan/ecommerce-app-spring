package com.stschool.ecommerce.service;

import com.stschool.ecommerce.entity.Order;
import com.stschool.ecommerce.exceptions.OrderAlreadyExistsException;
import com.stschool.ecommerce.exceptions.OrderNotFoundException;
import com.stschool.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository)  {
        this.orderRepository = orderRepository;
    }

    // Save Order
    @Override
    public Order saveOrder(Order order) throws OrderAlreadyExistsException {

        if (orderRepository.existsById(order.getId())) {
            throw new OrderAlreadyExistsException(
                    "Order already exists with id : " + order.getId()
            );
        }

        return orderRepository.save(order);
    }

    // Get All Orders
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order By Id
    @Override
    public Optional<Order> getOrderById(int id) throws OrderNotFoundException {

        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            throw new OrderNotFoundException(
                    "Order not found with id : " + id
            );
        }

        return order;
    }

    // Update Order
    @Override
    public Order updateOrder(int id, Order order) throws OrderNotFoundException {

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with id : " + id
                        )
                );

        existingOrder.setPayment(order.getPayment());

        return orderRepository.save(existingOrder);
    }

    // Delete Order
    @Override
    public void deleteOrder(int id) throws OrderNotFoundException {

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with id : " + id
                        )
                );

        orderRepository.delete(existingOrder);
    }

}

