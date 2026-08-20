package org;

import org.junit.jupiter.api.Test;
import org.lesson2_7.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void addPositive() {

        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    void addNegative() {

        int result = calculator.add(-4, 3);

        assertEquals(-1, result);
    }

    @Test
    void addZero() {

        int result = calculator.add(-2, 2);

        assertEquals(0, result);
    }

    @Test
    void addByOne() {

        int result = calculator.add(0, 1);

        assertEquals(1, result);
    }

    @Test
    void subtractPositive() {

        int result = calculator.subtract(2, -1);

        assertEquals(3, result);
    }

    @Test
    void subtractNegative() {

        int result = calculator.subtract(-4, 4);

        assertEquals(-8, result);
    }

    @Test
    void subtractZero() {

        int result = calculator.subtract(2, 2);

        assertEquals(0, result);
    }

    @Test
    void subtractByOne() {

        int result = calculator.subtract(0, 1);

        assertEquals(-1, result);
    }

    @Test
    void dividePositive() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void divideByOne() {
        assertEquals(10, calculator.divide(10, 1));
    }

    @Test
    void divideZero() {
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    void divideNegative() {
        assertEquals(-5, calculator.divide(-10, 2));
    }

    @Test
    void divideByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @Test
    void multiplyPositive() {
        assertEquals(20, calculator.multiply(10, 2));
    }

    @Test
    void multiplyByOne() {
        assertEquals(2, calculator.multiply(2, 1));
    }

    @Test
    void multiplyZero() {
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    void multiplyNegative() {
        assertEquals(-20, calculator.multiply(-10, 2));
    }

    @Test
    void factorialPositive() {
        int result = calculator.factorial(4);

        assertEquals(24,result);
    }

    @Test
    void factorialZero() {
        int result = calculator.factorial(0);

        assertEquals(1,result);
    }

    @Test
    void factorialNegative() {
        int result = calculator.factorial(-2);

        assertEquals(1,result);
    }

    @Test
    void factorialMin() {
        int result = calculator.factorial(1);

        assertEquals(1,result);
    }

    @Test
    void factorialMax() {
        int result = calculator.factorial(35);
        System.out.println(result);
        assertEquals(0,result);
    }

    @Test
    void getTriangleAreaPositive() {
        var result = calculator.getTriangleArea(7, 8, 9);
        assertEquals(26.83, Math.round(result * 100.0) / 100.0);
    }

    @Test
    void getTriangleAreaZero() {
        assertThrows(
                IllegalArgumentException.class,
                () ->  calculator.getTriangleArea(0, 8, 9)
        );
    }

    @Test
    void getTriangleAreaNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () ->  calculator.getTriangleArea(-3, 8, 9)
        );
    }

    @Test
    void comparePositive() {
        int result = calculator.compare(3, 2);

        assertEquals(1, result);
    }
    @Test
    void compareEqual() {
        int result = calculator.compare(3, 3);

        assertEquals(0, result);
    }
    @Test
    void compareZero() {
        int result = calculator.compare(0, 2);

        assertEquals(-1, result);
    }
    @Test
    void compareNegative() {
        int result = calculator.compare(-4, 2);

        assertEquals(-1, result);
    }
}
