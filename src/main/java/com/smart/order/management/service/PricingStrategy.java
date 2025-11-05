package com.smart.order.management.service;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int quantity);
}
