package org.lesson2_4.bowl;

public class Bowl {
    private int food = 20;
    public Bowl(){}
    public Bowl(int food) {
        this.food = food;
    }

    public int getSomeFood(int value) {
        if (value <= food) {
            food = food - value;
            return value;
        }
        return 0;
    }
    public int getFood() {
        return food;
    }
    public void setFood(int value) {
        food = value;
    }
}
