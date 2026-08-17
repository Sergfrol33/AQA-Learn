package org.lesson2_4.figures;

public class Rectangle extends BaseShape {

    private double width;
    private double height;

    public Rectangle(String fillColor, String borderColor, double width, double height) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }


    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
