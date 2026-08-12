package org.lesson2_4.animals;

public class Cat extends Animal {

    private static int count;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int value) {
        if (value > 200){
            System.out.println(this.name + " не может больше");
        } else{
            super.run(value);
        }
    }

    @Override
    public void swim(int value) {
        System.out.println(this.name + " не умеет плавать");
    }

    public int eat(int value) {
        return value;
    }

    public void isSatiety(int value) {
        if (value > 0){
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCount() {
        return count;
    }
}
