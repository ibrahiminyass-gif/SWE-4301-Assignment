package com.jah.srp.refactored;

import java.math.BigDecimal;

public class PayCalculator {

    private final EmployeeData employeeData;

    public PayCalculator(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    public BigDecimal calculatePay() {
        double regularHrs = regularHours();
        return BigDecimal.valueOf(regularHrs * 50);
    }

    private double regularHours() {
        if ("FULL_TIME".equals(employeeData.getType())) {
            double h = employeeData.getHoursWorked();
            return h > 40 ? 40 : h;
        }
        return employeeData.getHoursWorked();
    }
}
