# Lab 08: Software Maintenance in Software Construction

**Institution:** University of Engineering & Technology (UET), Abbottabad Campus  
**Department:** Department of Software Engineering  
**Course:** Software Construction  

---

## Overview

This repository demonstrates enterprise software maintainability, defensive programming, observability, and automated quality gates in Java using **Apache Maven** and **JUnit 5**.

---

## Implemented Tasks

### Task 1: Code Smell Refactoring (`ReportManager`)
- **Problem Addressed:** Eliminated loop string concatenation, null-pointer vulnerabilities, and rigid `if/else` conditionals.
- **Solution:** Applied the **Strategy Pattern** and **Dependency Injection** by decoupling formatting (`ReportFormatter`, `PdfReportFormatter`, `CsvReportFormatter`) and delivery (`Notifier`, `EmailNotifier`) from `ReportManager`.

### Task 2: Defensive Programming & Immutability (`BankTransfer`)
- **Problem Addressed:** Prevented invalid financial states and post-construction mutation.
- **Solution:** Implemented fail-fast constructor validation (rejecting negative/zero amounts and null accounts) and enforced object immutability.

### Task 3: Structured Tracing & Observability (`PaymentProcessor`)
- **Problem Addressed:** Ensured end-to-end transaction traceability across multi-threaded execution without memory/context leaks.
- **Solution:** Injected unique Correlation IDs (`TraceID`) into the Mapped Diagnostic Context (MDC) at entry points and guaranteed cleanup inside a `try-finally` block.

### Task 4: Automated Quality Gate (`OrderServiceTest`)
- **Problem Addressed:** Verified core pricing and discount logic (`OrderService`, `DiscountPolicy`, `VipDiscount`) independently of external infrastructure.
- **Solution:** Created isolated **JUnit 5** unit tests following the **Arrange-Act-Assert (AAA)** pattern.

---

## Project Structure

```text
MaintainabilityLab/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/uet/billing/maintainabilitylab/
    │   ├── BankTransfer.java
    │   ├── CsvReportFormatter.java
    │   ├── DiscountPolicy.java
    │   ├── EmailNotifier.java
    │   ├── MaintainabilityLab.java
    │   ├── Notifier.java
    │   ├── OrderService.java
    │   ├── PaymentProcessor.java
    │   ├── PdfReportFormatter.java
    │   ├── ReportFormatter.java
    │   ├── ReportManager.java
    │   └── VipDiscount.java
    └── test/java/com/uet/billing/maintainabilitylab/
        └── OrderServiceTest.java
