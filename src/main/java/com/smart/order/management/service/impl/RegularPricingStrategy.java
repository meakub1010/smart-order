package com.smart.order.management.service.impl;

import com.smart.order.management.service.PricingStrategy;

public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int quantity) {
        return basePrice * quantity;
    }
}
