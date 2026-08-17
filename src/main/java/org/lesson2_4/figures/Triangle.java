package org.lesson2_4.figures;

public class Triangle extends BaseShape  {
    private double a;
    private double b;
    private double c;


    public Triangle(double a, double b, double c, String fillColor, String  borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;

    }

    @Override
    public double getArea(){
        double p = getPerimeter() / 2;

        return Math.sqrt(
                p * (p - a) * (p - b) * (p - c)
        );
    }

    @Override
    public double getPerimeter(){
        return a + b + c;
    }

    @Override
    public String getFillColor(){
        return fillColor;
    }

    @Override
    public String getBorderColor(){
        return borderColor;
    }
}
