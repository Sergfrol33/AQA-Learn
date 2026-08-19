package org.lesson2_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class University {
    private ArrayList<Student> students = new ArrayList<>(List.of(new Student[]{
            new Student("Арина","ае",3, new int[]{4, 4, 3, 4}),
            new Student("Максим","ае",4, new int[]{3, 2, 1, 4}),
            new Student("Максим","ае",1, new int[]{4, 4, 4, 4}),
    }));

    public University() {

    }

    public University(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean isLowRating(int[] arr ){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        sum = sum / arr.length;
        return sum < 3;
    }

    public void deduct(int i){
        students.remove(i);
    }

    public void goToNewCourse(int i){
        var student = students.get(i);
        student.setCourse(student.getCourse() + 1);
    }
}
