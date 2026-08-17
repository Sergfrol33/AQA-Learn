package org.lesson2_4.bowl;

public class Bowl {

    private int food = 20;
    private boolean isEmpty = false;

    public Bowl(){}

    public Bowl(int food) {
        this.food = food;
    }

    public int getSomeFood(int value) {
        int given;
        if (food >= value) {
            given = value;
            food -= value;
        } else {
            given = food;
            food = 0;
        }
        if (food <= 0){
            isEmpty = true;
        }
        System.out.println("Осталось " + food + " еды");
        return given;
    }

    public int getFood() {
        return food;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setFood(int value) {
        if (value > 0) {
            food += value;
            isEmpty = false;
        }
    }
}
