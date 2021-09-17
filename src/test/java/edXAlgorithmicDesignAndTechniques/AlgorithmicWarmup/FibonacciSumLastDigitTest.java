package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSumLastDigitTest {

    FibonacciSumLastDigit fibSumLast;
    @BeforeEach
    public void setUP() {fibSumLast = new FibonacciSumLastDigit(); }


    @Test
    void testGetFibonacciLastDigit() {
        int numTests = 20;
        for (int i = 0; i < numTests; i++) {
            int n = (int) (Math.random() * 1000000000);
            int expected = getFibonacciLastDigit(n);
            int result = (int) (fibSumLast.getFibonacciLastDigit(n));
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(expected, result);
        }
    }

    @Test
    void test1GetFibonacciLastDigit() {
        long n = 240L;
        long expected = 0L;
        long result = fibSumLast.getFibonacciLastDigit(n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }



    @Test
    void testSample1GetFibonacciSum() {
        long n = 3L;
        long expected = 4L;
        long result = fibSumLast.getFibonacciSum(n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetFibonacciSum() {
        long n = 100L;
        long expected = 5L;
        long result = fibSumLast.getFibonacciSum(n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetFibonacciSum() {
        long n = 240L;
        //long expected = getFibonacciSumNaive(n);
        long expected = 0L;
        long result = fibSumLast.getFibonacciSum(n);
        //Assertions.assertNotNull(expected);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }



    public static int getFibonacciLastDigit(int n) {
        if (n <= 1)
            return n;

        int[] lastDigitArray = new int[n+1];
        lastDigitArray[0] = 0;
        lastDigitArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            lastDigitArray[i] = (lastDigitArray[i-1] + lastDigitArray[i-2]) % 10;
        }

        return lastDigitArray[n];
    }

    // naive method
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1) return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long temp_previous = previous;
            previous = current;
            current = temp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

}