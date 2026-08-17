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
        int received = bowl.getSomeFood(value);

        if (received < value) {
            int shortage = value - received;
            System.out.println(this.name + ": еды не хватило, докладываем " + shortage);
            bowl.setFood(shortage);
            received += bowl.getSomeFood(shortage);
        }
        isSatiety(received >= value);
    }

    private void isSatiety(boolean value) {
        satiety = value;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCount() {
        return count;
    }
}
