package org.lesson2_3;

import java.util.ArrayList;

public class Park {
    private final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

    public Park() {
    }

    public class Attraction {
        private final String name;
        private final String workingHours;
        private final int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
            attractions.add(this);
        }
    }

    public void getAttractions(){
        for (Attraction attraction : attractions) {
            System.out.println("Название: " + attraction.name);
            System.out.println("Время работы: " + attraction.workingHours);
            System.out.println("Стоимость: " + attraction.price);
            System.out.println();
        }
    }
}