package org.lesson2_7;

import org.lesson2_4.figures.Triangle;

public class Calculator {
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public double getTriangleArea(int a, int b, int c){
        if (a * b * c <= 0) {
            throw new IllegalArgumentException("Размер не может быть меньше нуля");
        }
        return new Triangle(a,b,c, "as", "s").getArea();
    }

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return a / b;
    }


    public int compare(double a,  double b){
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}
