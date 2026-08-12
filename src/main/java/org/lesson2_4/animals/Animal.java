package org.lesson2_4.animals;

public class Animal {
    protected String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int value){
        if (value < 0){
            System.out.println("Неправильное значение");
        }
        System.out.println(this.name + " пробежал " + value + "м");
    }

    public void swim(int value){
        if (value < 0){
            System.out.println("Неправильное значение");
        }
        System.out.println(this.name + " проплыл " + value + "м");
    }

    public static int getCount() {
        return count;
    }
}
