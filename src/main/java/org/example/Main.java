package org.example;

import org.example.animals.Cat;
import org.example.bowl.Bowl;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        Bowl bowl = new Bowl(21);
        cats[0] = new Cat("1");
        cats[1] = new Cat("2");
        cats[2] = new Cat("3");
        cats[3] = new Cat("4");

        for (Cat cat : cats) {
            cat.isSatiety(bowl.getSomeFood(cat.eat(7)));
            System.out.println(cat.isSatiety());
        }
    }

}