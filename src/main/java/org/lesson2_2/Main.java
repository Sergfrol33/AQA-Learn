package org.lesson2_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TestTask testTask = new TestTask();
        testTask.printThreeWords();
        testTask.checkSumSign();
        testTask.printColor();
        testTask.compareNumbers();
        System.out.println(testTask.compareNumbersRange(10,19));
        testTask.isPositiveNumberPrint(3);
        System.out.println(testTask.isPositiveNumberBool(3));
        testTask.printTextUntil(4,"anime otstoi");
        System.out.println(testTask.isLeapYear(2012));
        testTask.updateArray();
        testTask.mapArray();
        testTask.createMatrix();
        System.out.println(Arrays.toString(testTask.createFillArray(4,1)));
    }

}