package org.lesson2_4.figures;

public class BaseShape implements Shape {

    protected String fillColor;
    protected String borderColor;

    public BaseShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return Shape.super.getPerimeter();
    }

    @Override
    public String getFillColor() {
        return "";
    }

    @Override
    public String getBorderColor() {
        return "";
    }
}
