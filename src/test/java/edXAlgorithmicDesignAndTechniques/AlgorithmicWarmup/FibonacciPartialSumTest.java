package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FibonacciPartialSumTest {

    FibonacciPartialSum partialSumTest;
    @BeforeEach
    public void setUP() {partialSumTest = new FibonacciPartialSum(); }

    @Test
    void testSample1GetFibonacciPartialSum() {
        long m = 3L;
        long n = 7L;
        long expected = 1L;
        long result = partialSumTest.getFibonacciPartialSum(m, n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetFibonacciPartialSum() {
        long m = 10L;
        long n = 10L;
        long expected = 5L;
        long result = partialSumTest.getFibonacciPartialSum(m, n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3GetFibonacciPartialSum() {
        long m = 10L;
        long n = 200L;
        long expected = 2L;
        long result = partialSumTest.getFibonacciPartialSum(m, n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetFibonacciPartialSum() {
        int numTests = 20;
        for (int i = 0; i < numTests; i++) {
            long m = (long)(Math.random() * 100000L);
            System.out.println("m value: " + m);
            long n = (long)(Math.random() * (100000L - m)) + m;
            System.out.println("n value: " + n);
            long expected = getFibonacciPartialSumNaive(m, n);
            long result = partialSumTest.getFibonacciPartialSum(m, n);
            System.out.println("Sum Fast: " + result + ", Sum Slow: " + expected);
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(expected, result);
        }
    }

    @Test
    void test2GetFibonacciPartialSum() {
        long m = 0L;
        long n = 0L;
        long expected = 0L;
        long result = partialSumTest.getFibonacciPartialSum(m, n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3GetFibonacciPartialSum() {
        long m = 0L;
        long n = 1L;
        long expected = 1L;
        long result = partialSumTest.getFibonacciPartialSum(m, n);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }


    // Fibonacci partial sum naive
    private static long getFibonacciPartialSumNaive(long from, long to) {
        BigInteger sum = new BigInteger("0");

        BigInteger current = BigInteger.valueOf(0);
        BigInteger next = BigInteger.valueOf(1);

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum = sum.add(current);
                //System.out.println("Current: " + current + ", Sum: " + sum);
            }

            BigInteger new_current = next;
            next = next.add(current);
            current = new_current;
        }
        System.out.println("Sum: " + sum);
        BigInteger sumLastDigit = sum.remainder(BigInteger.valueOf(10));
        long lastDigit = sumLastDigit.longValue();
        return lastDigit;
    }
}