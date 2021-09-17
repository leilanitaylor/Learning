package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup.FibonacciNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciNumberTest {

    FibonacciNumber fibNum;
    @BeforeEach
    public void setUp() {fibNum = new FibonacciNumber(); }

    @Test
    void testCalcFib() {
        int n = 20;
        long result = fibNum.calcFib(n);
        long expected = 6765;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test0CalcFib() {
        int n = 0;
        long result = fibNum.calcFib(n);
        long expected = 0;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1CalcFib() {
        int n = 1;
        long result = fibNum.calcFib(n);
        long expected = 1;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void stressTestCalcFib() {
        int n = (int) (Math.random() * 46);
        long result = fibNum.calcFib(n);
        long expected = calc_fib_naive(n);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(expected);
        Assertions.assertEquals(expected, result);
    }

    private static long calc_fib_naive(int n) {
        if (n <= 1)
            return n;

        return calc_fib_naive(n - 1) + calc_fib_naive(n - 2);
    }
}

