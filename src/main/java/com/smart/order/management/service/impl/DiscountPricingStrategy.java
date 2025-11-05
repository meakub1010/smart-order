package com.smart.order.management.service.impl;

import com.smart.order.management.service.PricingStrategy;

public class DiscountPricingStrategy implements PricingStrategy {
    private double discountRate;

    public DiscountPricingStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculatePrice(double basePrice, int quantity) {
        double totalPrice = basePrice * quantity;
        return totalPrice - (totalPrice * (discountRate/100));
    }

}
