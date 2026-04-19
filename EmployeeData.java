package com.jah.srp.refactored;

public class EmployeeData {

    private final String name;
    private final String type;   
    private final double hoursWorked;

    public EmployeeData(String name, String type, double hoursWorked) {
        this.name = name;
        this.type = type;
        this.hoursWorked = hoursWorked;
    }

    public String getName()        { return name; }
    public String getType()        { return type; }
    public double getHoursWorked() { return hoursWorked; }
}
