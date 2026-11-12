package com.uet.billing.maintainabilitylab;

public class PdfReportFormatter implements ReportFormatter {
    @Override
    public void formatAndWrite(String content) {
        System.out.println("Writing PDF: " + content);
    }
}