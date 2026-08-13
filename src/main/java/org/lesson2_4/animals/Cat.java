package org.lesson2_4.animals;

import org.lesson2_4.bowl.Bowl;

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

    public void eat(Bowl bowl, int value) {
        isSatiety(bowl.getSomeFood(value));
    }

    private void isSatiety(int value) {
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
