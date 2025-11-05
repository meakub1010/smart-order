package com.smart.order.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.order.management.model.Order;
import com.smart.order.management.service.OrderService;
import com.smart.order.management.service.impl.DiscountPricingStrategy;
import com.smart.order.management.service.impl.RegularPricingStrategy;
import com.smart.order.management.service.PricingStrategy;

import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order, @RequestParam(required = false) Double discount) {
        PricingStrategy pricingStrategy = new RegularPricingStrategy();
        if(discount != null) {
            return orderService.saveOrder(order, new DiscountPricingStrategy(discount));
        }
        return orderService.saveOrder(order, pricingStrategy);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/search")
    public List<Order> searchOrdersByItemName(@RequestParam String itemName){
        return orderService.findOrdersByItemName(itemName);
    }
    
    
}
