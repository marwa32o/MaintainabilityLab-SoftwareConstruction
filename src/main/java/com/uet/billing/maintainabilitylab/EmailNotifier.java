package com.uet.billing.maintainabilitylab;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}