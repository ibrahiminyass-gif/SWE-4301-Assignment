package com.jah.srp.refactored;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SrpRefactoredTest {

    @Test
    void fullTimeEmployee_shouldCapRegularHoursAt40() {
        EmployeeData emp = new EmployeeData("Alice", "FULL_TIME", 50);
        PayCalculator calculator = new PayCalculator(emp);

        BigDecimal pay = calculator.calculatePay();

        assertEquals(BigDecimal.valueOf(2000.0), pay);
    }

    @Test
    void partTimeEmployee_shouldUseAllHoursForPay() {
        EmployeeData emp = new EmployeeData("Bob", "PART_TIME", 20);
        PayCalculator calculator = new PayCalculator(emp);

        BigDecimal pay = calculator.calculatePay();

        assertEquals(BigDecimal.valueOf(1000.0), pay);
    }

    @Test
    void fullTimeEmployee_shouldReportCappedRegularHours() {
        EmployeeData emp = new EmployeeData("Alice", "FULL_TIME", 50);
        HourReporter reporter = new HourReporter(emp);

        BigDecimal hours = reporter.reportHours();

        assertEquals(BigDecimal.valueOf(40.0), hours);
    }

    @Test
    void partTimeEmployee_shouldReportActualHours() {
        EmployeeData emp = new EmployeeData("Bob", "PART_TIME", 15);
        HourReporter reporter = new HourReporter(emp);

        BigDecimal hours = reporter.reportHours();

        assertEquals(BigDecimal.valueOf(15.0), hours);
    }

    @Test
    void employeeSaver_shouldNotThrow() {
        EmployeeData emp = new EmployeeData("Charlie", "FULL_TIME", 40);
        EmployeeSaver saver = new EmployeeSaver();

        assertDoesNotThrow(() -> saver.save(emp));
    }

    @Test
    void employeeData_shouldReturnCorrectFields() {
        EmployeeData emp = new EmployeeData("Dave", "PART_TIME", 25);

        assertEquals("Dave", emp.getName());
        assertEquals("PART_TIME", emp.getType());
        assertEquals(25.0, emp.getHoursWorked());
    }
}
