package org.lesson2_2;

import java.util.Arrays;

public class TestTask {

    public void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public void checkSumSign(){
        int a = 1;
        int b = 2;
        System.out.println(a + b > 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public void printColor(){
        int value = 101;
        if (value <= 0){
            System.out.println("Красный");
        } else if (value > 0 && value <= 100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers(){
        int a = 3;
        int b = 2;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public boolean compareNumbersRange(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    public void isPositiveNumberPrint(int number){
        System.out.println(number >= 0 ? "Позитивное число" : "Отрицательное число");
    }

    public boolean isPositiveNumberBool(int number){
        return !(number >= 0);
    }

    public void printTextUntil(int count, String text){
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public boolean isLeapYear(int year){
       return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public void updateArray(){
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }

    public void  mapArray(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6){
                array[i] *= 2;
            }
        }
    }

    public void createMatrix(){
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[matrix.length - i - 1][i] = 1;
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[] createFillArray(int len, int initialValue){
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        //или через цикл
//        for (int i = 0; i < array.length; i++) {
//            array[i] = initialValue;
//        }
        return array;
    }
}
