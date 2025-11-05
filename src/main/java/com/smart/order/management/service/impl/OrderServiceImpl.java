package com.smart.order.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.order.management.model.Order;
import com.smart.order.management.repository.OrderRepository;
import com.smart.order.management.service.OrderService;
import com.smart.order.management.service.PricingStrategy;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public List<Order> getAllOrders() {
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
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findOrdersByItemName(String itemName) {
        return orderRepository.findByItemName(itemName);
    }
    
}
