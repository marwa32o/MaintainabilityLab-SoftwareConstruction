package com.uet.billing.maintainabilitylab;

import java.util.List;
import java.util.Objects;

public class ReportManager {
    private final ReportFormatter formatter;
    private final Notifier notifier;

    // Fix Smell 4: Injectable interfaces replace static dependencies
    public ReportManager(ReportFormatter formatter, Notifier notifier) {
        this.formatter = Objects.requireNonNull(formatter, "Formatter required");
        this.notifier = Objects.requireNonNull(notifier, "Notifier required");
    }

    public void generate(String type, List<String> data, boolean sendEmail) {
        // Fix Smell 2: Null-safe type checking
        if ("PDF".equalsIgnoreCase(type) || "CSV".equalsIgnoreCase(type)) {
            // Fix Smell 1: String.join replaces inefficient loop string concatenation
            String output = String.join(",", data);
            
            // Fix Smell 3: Strategy interface replaces hardcoded conditionals
            formatter.formatAndWrite(output);

            if (sendEmail) {
                notifier.sendNotification("admin@company.com", output);
            }
        } else {
            throw new IllegalArgumentException("Unsupported report type: " + type);
        }
    }
}