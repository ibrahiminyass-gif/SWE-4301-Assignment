package com.jah.ocp.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OcpRefactoredTest {

    private final AreaCalculator calculator = new AreaCalculator();

    @Test
    void rectangle_shouldCalculateAreaCorrectly() {
        Shape[] shapes = { new Rectangle(4, 5) };
        assertEquals(20.0, calculator.area(shapes), 0.001);
    }

    @Test
    void circle_shouldCalculateAreaCorrectly() {
        Shape[] shapes = { new Circle(7) };
        double expected = 7 * 7 * Math.PI;
        assertEquals(expected, calculator.area(shapes), 0.001);
    }

    @Test
    void triangle_shouldCalculateAreaCorrectly() {
        Shape[] shapes = { new Triangle(6, 8) };
        
        assertEquals(24.0, calculator.area(shapes), 0.001);
    }

    @Test
    void mixedShapes_shouldSumAreasCorrectly() {
        Shape[] shapes = {
            new Rectangle(3, 4),    
            new Circle(1),          
            new Triangle(6, 4)      
        };
        double expected = 12 + Math.PI + 12;
        assertEquals(expected, calculator.area(shapes), 0.001);
    }

    @Test
    void emptyShapes_shouldReturnZero() {
        assertEquals(0.0, calculator.area(new Shape[0]), 0.001);
    }
}
