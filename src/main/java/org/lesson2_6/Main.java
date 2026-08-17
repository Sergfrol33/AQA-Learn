package org.lesson2_6;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        var students = university.getStudents();
        university.addStudent(new Student("Олег","ае",1, new int[]{4, 4, 3, 4}));
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (university.isLowRating(student.getAssessments())){
                university.deduct(i);
                i--;
            } else {
                university.goToNewCourse(i);
            }
        }
        university.printStudents(new HashSet<>(students), 2);

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Сергей","12321332232");
        telephoneDirectory.add("Сергей","12321332232");
        telephoneDirectory.add("Андрей","8922123322");
        telephoneDirectory.get("Сергей");
    }
}