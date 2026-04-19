package com.jah.ocp.original;

public class AreaCalculator {

    public double area(Object[] shapes) {
        double area = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                area += rectangle.width * rectangle.height;
            } else if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                area += circle.radius * circle.radius * Math.PI;
            }
            
        }
        return area;
    }
}
