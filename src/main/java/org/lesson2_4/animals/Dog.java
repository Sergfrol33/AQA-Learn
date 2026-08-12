package org.lesson2_4.animals;

public class Dog extends Animal{

    private static int count;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int value) {
        if (value > 500){
            System.out.println(this.name + "не может больше");
        } else{
            super.run(value);
        }
    }

    @Override
    public void swim(int value) {
        if (value > 10){
            System.out.println(this.name + " не может больше");
        } else{
            super.swim(value);
        }
    }

    public static int getCount() {
        return count;
    }
}
