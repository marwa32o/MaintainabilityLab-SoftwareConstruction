package com.uet.billing.maintainabilitylab;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MaintainabilityLab {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  LAB TASK 1: Refactored Report Manager (Clean Code)");
        System.out.println("==================================================");
        List<String> reportData = Arrays.asList("Header", "Row1", "Row2", "Summary");
        ReportFormatter pdfFormatter = new PdfReportFormatter();
        Notifier emailNotifier = new EmailNotifier();
        ReportManager manager = new ReportManager(pdfFormatter, emailNotifier);
        
        manager.generate("PDF", reportData, true);

        System.out.println("\n==================================================");
        System.out.println("  LAB TASK 2: Defensive Fail-Fast Validation");
        System.out.println("==================================================");
        try {
            System.out.println("Attempting to create BankTransfer with negative amount (-500.00)...");
            new BankTransfer("ACC-101", "ACC-202", new BigDecimal("-500.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("\n[SUCCESSFULLY CAUGHT EXCEPTION]");
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n==================================================");
        System.out.println("  LAB TASK 3: Structured Tracing (MDC Context)");
        System.out.println("==================================================");
        PaymentProcessor processor = new PaymentProcessor();
        processor.charge("TX-99843-UUID", 250.75);
    }
}