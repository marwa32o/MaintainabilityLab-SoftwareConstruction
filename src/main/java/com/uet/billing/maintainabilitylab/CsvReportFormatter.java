package com.uet.billing.maintainabilitylab;

public class CsvReportFormatter implements ReportFormatter {
    @Override
    public void formatAndWrite(String content) {
        System.out.println("Writing CSV: " + content);
    }
}