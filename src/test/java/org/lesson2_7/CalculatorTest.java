package org.lesson2_7;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {2, 3, 5},
                {0, 0, 0},
                {-4, 10, 6},
                {-5, -7, -12}
        };
    }

    @Test(dataProvider = "addData")
    public void addTest(int a, int b, int expected) {
        Assert.assertEquals(calculator.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {10, 4, 6},
                {0, 5, -5},
                {-3, -8, 5}
        };
    }

    @Test(dataProvider = "subtractData")
    public void subtractTest(int a, int b, int expected) {
        Assert.assertEquals(calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] multiplyData() {
        return new Object[][]{
                {3, 4, 12},
                {0, 100, 0},
                {-2, 5, -10},
                {-3, -3, 9}
        };
    }

    @Test(dataProvider = "multiplyData")
    public void multiplyTest(int a, int b, int expected) {
        Assert.assertEquals(calculator.multiply(a, b), expected);
    }

    @Test
    public void divideReturnsQuotient() {
        Assert.assertEquals(calculator.divide(10, 2), 5);
        Assert.assertEquals(calculator.divide(7, 2), 3);
        Assert.assertEquals(calculator.divide(-9, 3), -3);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroThrowsArithmeticException() {
        calculator.divide(10, 0);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {-3, 1}
        };
    }

    @Test(dataProvider = "factorialData")
    public void factorialTest(int n, int expected) {
        Assert.assertEquals(calculator.factorial(n), expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][]{
                {5.0, 2.0, 1},
                {1.5, 3.5, -1},
                {4.0, 4.0, 0}
        };
    }

    @Test(dataProvider = "compareData")
    public void compareTest(double a, double b, int expected) {
        Assert.assertEquals(calculator.compare(a, b), expected);
    }

    @Test
    public void getTriangleAreaPositive() {
        Assert.assertEquals(calculator.getTriangleArea(3, 4, 5), 6.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Размер не может быть меньше нуля")
    public void getTriangleAreaZero() {
        calculator.getTriangleArea(0, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void getTriangleAreaNegative() {
        calculator.getTriangleArea(-3, 4, 5);
    }
}
