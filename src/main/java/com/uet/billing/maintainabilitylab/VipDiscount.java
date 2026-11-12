package com.uet.billing.maintainabilitylab;

public class VipDiscount implements DiscountPolicy {
    @Override
    public double apply(double amount) {
        return amount * 0.80; // 20% discount
    }
}