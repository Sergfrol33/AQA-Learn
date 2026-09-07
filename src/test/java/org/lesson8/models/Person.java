package org.lesson8.models;

public class Person {
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private String name;

    public Person( String name) {
        this.name = name;
    }
    public Person(String name, int id) {
        this.id = id;
        this.name = name;
    }
}
