package com.uet.billing.maintainabilitylab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    @DisplayName("Calculate Total Applies VIP Discount Without Touching Database")
    public void calculateTotal_appliesVipDiscount_withoutTouchingDatabase() {
        // 1. ARRANGE
        DiscountPolicy vipDiscount = new VipDiscount();
        OrderService orderService = new OrderService(vipDiscount);
        double inputAmount = 100.0;
        double expectedTotal = 80.0;

        // 2. ACT
        double actualTotal = orderService.calculateTotal(inputAmount);

        // 3. ASSERT
        Assertions.assertEquals(expectedTotal, actualTotal, 0.001, 
                "VIP Discount should apply 20% off to the total amount");
    }

    @Test
    @DisplayName("Calculate Total Throws Exception For Invalid Amount")
    public void calculateTotal_throwsException_whenAmountIsZeroOrNegative() {
        // 1. ARRANGE
        DiscountPolicy vipDiscount = new VipDiscount();
        OrderService orderService = new OrderService(vipDiscount);

        // 2. ACT & 3. ASSERT
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.calculateTotal(-50.0);
        }, "Should throw IllegalArgumentException when amount is negative");
    }
}