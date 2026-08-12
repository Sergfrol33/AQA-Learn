package org.lesson2_6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TelephoneDirectory {

    private HashMap<String, LinkedList<String>> directory = new HashMap<>();

    public void add(String name, String phone){
        if (directory.containsKey(name)){
            directory.get(name).add(phone);
        } else {
            directory.put(name, new LinkedList<>(List.of(phone)));
        }
    }

    public void get(String name){
        LinkedList<String> phones = directory.get(name);
        if (phones.size() > 1){
            for (String student : phones) {
                System.out.println(student);
            }
        } else{
            System.out.println(phones.getFirst());
        }
    }
}
