package org.lesson2_5;

public class ErrorTest {

    public int checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4){
            throw new MyArraySizeException("Массив должен иметь 4 строки");
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Массив должен иметь размер 4x4");
            }
        }
        try {
            String outOfBound = arr[4][0];

            System.out.println("Этот текст не выполнится: " + outOfBound);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Индекс вышел за пределы массива");
            System.err.println("Причина: " + e.getMessage());
        }

        int sum = 0;
        for (String[] strings : arr) {
           for(String string : strings) {
               if (!isNumeric(string)){
                   throw new MyArrayDataException("Ячейка " + string + " не число");
               }
               sum += Integer.parseInt(string);
           }
        }
        return sum;
    }

    private boolean isNumeric(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
