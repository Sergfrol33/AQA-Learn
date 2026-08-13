package org.lesson2_4;

import org.lesson2_4.animals.Cat;
import org.lesson2_4.bowl.Bowl;
import org.lesson2_4.figures.Circle;
import org.lesson2_4.figures.Rectangle;
import org.lesson2_4.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        Bowl bowl = new Bowl(21);
        cats[0] = new Cat("1");
        cats[1] = new Cat("2");
        cats[2] = new Cat("3");
        cats[3] = new Cat("4");

        for (Cat cat : cats) {
            cat.eat(bowl,7);
            System.out.println(cat.isSatiety());
        }

        Circle circle = new Circle(
                "Красный",
                "Черный",
                5
        );
        Rectangle rectangle = new Rectangle(
                "Синий",
                "Черный",
                10,
                5
        );
        Triangle triangle = new Triangle(
                3,
                4,
                5,
                "Зеленый",
                "Белый"
        );

        System.out.println("Круг:");
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Заливка: " + circle.getFillColor());
        System.out.println("Граница: " + circle.getBorderColor());

        System.out.println("\nПрямоугольник:");
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Заливка: " + rectangle.getFillColor());
        System.out.println("Граница: " + rectangle.getBorderColor());

        System.out.println("\nТреугольник:");
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Заливка: " + triangle.getFillColor());
        System.out.println("Граница: " + triangle.getBorderColor());
    }
}