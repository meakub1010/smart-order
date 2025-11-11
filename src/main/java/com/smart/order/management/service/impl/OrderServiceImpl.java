package com.smart.order.management.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.order.management.model.Order;
import com.smart.order.management.repository.OrderRepository;
import com.smart.order.management.service.OrderService;
import com.smart.order.management.service.PricingStrategy;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;

    OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        logger.info("Order repo injected");
    }

    @Override
    public List<Order> getAllOrders() {
        logger.info("getting all order");
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public Order saveOrder(Order order, PricingStrategy pricingStrategy) {
        double finalPrice = pricingStrategy.calculatePrice(order.getPrice(), order.getQuantity());
        order.setPrice(finalPrice);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        logger.info("deleting order {}", id);
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findOrdersByItemName(String itemName) {
        logger.info("find order by name {}", itemName);
        return orderRepository.findByItemName(itemName);
    }

}
