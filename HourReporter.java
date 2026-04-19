package com.jah.srp.refactored;

import java.math.BigDecimal;

public class HourReporter {

    private final EmployeeData employeeData;

    public HourReporter(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    public BigDecimal reportHours() {
        return BigDecimal.valueOf(regularHours());
    }

    private double regularHours() {
        if ("FULL_TIME".equals(employeeData.getType())) {
            double h = employeeData.getHoursWorked();
            return h > 40 ? 40 : h;
        }
        return employeeData.getHoursWorked();
    }
}
