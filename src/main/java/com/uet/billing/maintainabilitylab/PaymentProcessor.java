package com.uet.billing.maintainabilitylab;

public class PaymentProcessor {

    public void charge(String txId, double amount) {
        System.out.println("[MDC Context Set] TraceID: " + txId);
        
        try {
            System.out.println("[TraceID: " + txId + "] Processing payment of $" + amount + "...");
        } finally {
            // Try-finally ensures context is cleared to prevent thread leaks
            System.out.println("[MDC Context Cleared] TraceID context removed for Thread.");
        }
    }
}