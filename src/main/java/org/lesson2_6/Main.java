package org.lesson2_6;

import java.util.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>(List.of(new Student[]{
            new Student("Арина","ае",3, new int[]{4, 4, 3, 4}),
            new Student("Максим","ае",4, new int[]{3, 2, 1, 4}),
            new Student("Максим","ае",1, new int[]{4, 4, 4, 4}),
    }));

    public static void main(String[] args) {
        students.add(new Student("Олег","ае",1, new int[]{4, 4, 3, 4}));
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (isLowRating(student.getAssessments())){
                deduct(i);
                i--;
            } else {
                student.goToNewCourse();
            }
        }
        printStudents(new HashSet<>(students), 2);

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Сергей","12321332232");
        telephoneDirectory.add("Сергей","12341332232");
        telephoneDirectory.add("Андрей","8922123322");
        telephoneDirectory.get("Андрей");
    }

    static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    static boolean isLowRating(int[] arr ){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        sum = sum / arr.length;
        return sum < 3;
    }

   static void deduct(int i){
        students.remove(i);
   }
}