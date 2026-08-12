package org.lesson2_4.figures;

public interface Shape {
    double getArea();

    default double getPerimeter() {
        return 0;
    }

    String getFillColor();

    String getBorderColor();
}
