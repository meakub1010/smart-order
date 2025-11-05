package com.smart.order.management.service;

import java.util.List;

import com.smart.order.management.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order saveOrder(Order order, PricingStrategy pricingStrategy);
    void deleteOrder(Long id);

    List<Order> findOrdersByItemName(String itemName);
}
