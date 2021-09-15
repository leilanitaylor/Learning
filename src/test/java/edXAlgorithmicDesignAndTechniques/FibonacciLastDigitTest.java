package edXAlgorithmicDesignAndTechniques;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciLastDigitTest {
    FibonacciLastDigit fibLastDigit;
    @BeforeEach
    public void setUP() {fibLastDigit = new FibonacciLastDigit(); }

    @Test
    void test0GetFibonacciLastDigit() {
        int n = 0;
        int result = fibLastDigit.getFibonacciLastDigit(n);
        int expected = 0;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetFibonacciLastDigit() {
        int n = 1;
        int result = fibLastDigit.getFibonacciLastDigit(n);
        int expected = 1;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1GetFibonacciLastDigit() {
        int n = 3;
        int result = fibLastDigit.getFibonacciLastDigit(n);
        int expected = 2;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetFibonacciLastDigit() {
        int n = 331;
        int result = fibLastDigit.getFibonacciLastDigit(n);
        int expected = 9;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3GetFibonacciLastDigit() {
        int n = 327305;
        int result = fibLastDigit.getFibonacciLastDigit(n);
        int expected = 5;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void stressTestGetFibonacciLastDigit() {
        int numOfTests = (int)(Math.random() * 20);
        int[] testNums = new int[numOfTests];
        for (int i = 0; i < testNums.length; i++) {
            testNums[i] = (int)(Math.random() * 100);
        }
        for (int num : testNums) {
            System.out.println(num);
            int result = fibLastDigit.getFibonacciLastDigit(num);
            int expected = getFibonacciLastDigitNaive(num);
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected, result);
        }
    }


    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        int lastDigit = (int)(current % 10);

        return lastDigit;
    }
}