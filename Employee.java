package com.jah.srp.original;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private String type;  
    private double hoursWorked;

    public Employee(String name, String type, double hoursWorked) {
        this.name = name;
        this.type = type;
        this.hoursWorked = hoursWorked;
    }

    public BigDecimal calculatePay() {
        double regularHrs = regularHours();
        return BigDecimal.valueOf(regularHrs * 50);
    }

    public BigDecimal reportHours() {
        double regularHrs = regularHours();
        return BigDecimal.valueOf(regularHrs);
    }

    public void save() {
        System.out.println("Saving employee [" + name + "] to database...");
    }

    private double regularHours() {
        if ("FULL_TIME".equals(type)) {
            return hoursWorked > 40 ? 40 : hoursWorked;
        }
        return hoursWorked;
    }

    public String getName()        { return name; }
    public String getType()        { return type; }
    public double getHoursWorked() { return hoursWorked; }
}
