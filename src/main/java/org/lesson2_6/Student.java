package org.lesson2_6;

public class Student {

    private String name;
    private String group;
    private int course;
    private int[] assessments;

    public Student(String name, String group, int course, int[] assessments) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.assessments = assessments;
    }


    public int getCourse() {
        return course;
    }

    public int[] getAssessments() {
        return assessments;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
    public void goToNewCourse(){
        course++;
    }
}
