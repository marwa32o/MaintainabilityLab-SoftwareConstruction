package com.uet.billing.maintainabilitylab;

import java.util.Objects;

public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = Objects.requireNonNull(discountPolicy, "Discount policy required");
    }

    public double calculateTotal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return discountPolicy.apply(amount);
    }
}