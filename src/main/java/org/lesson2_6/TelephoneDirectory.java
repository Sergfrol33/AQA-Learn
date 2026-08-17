package org.lesson2_6;

import java.util.HashMap;
import java.util.LinkedList;

public class TelephoneDirectory {

    private final HashMap<String, LinkedList<String>> directory = new HashMap<>();

    public void add(String name, String phone) {
        LinkedList<String> list = directory.computeIfAbsent(
                name,
                key -> new LinkedList<>()
        );
        if (list.contains(phone)) {
            System.out.println("Телефон уже существует");
            return;
        }
        list.add(phone);
    }

    public void get(String name) {
        LinkedList<String> phones = directory.get(name);
        if (phones.size() > 1) {
            for (String student : phones) {
                System.out.println(student);
            }
        } else {
            System.out.println(phones.getFirst());
        }
    }
}
