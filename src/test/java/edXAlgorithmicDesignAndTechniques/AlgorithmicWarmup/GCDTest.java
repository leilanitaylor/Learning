package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup.GCD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GCDTest {
    GCD gcdTest;
    @BeforeEach
    public void setUP() {gcdTest = new GCD(); }

    @Test
    void testSample1GCD() {
        int a = 18;
        int b = 35;
        int expected = 1;
        int result = gcdTest.gcd(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GCD() {
        int a = 28851538;
        int b = 1183019;
        int expected = 17657;
        int result = gcdTest.gcd(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GCD() {
        int a = 9;
        int b = 27;
        int expected = 9;
        int result = gcdTest.gcd(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GCD() {
        int a = 2000000000;
        int b = 1999999999;
        int expected = 1;
        int result = gcdTest.gcd(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3GCD() {
        int numTests = 45;
        for (int i = 0; i < numTests; i++) {
            int a = (int) (Math.random() * 2000000000) + 1;
            int b = (int) (Math.random() * 2000000000) + 1;
            int result = gcdTest.gcd(a, b);
            int expected = gcd_naive(a, b);
            boolean passTest = result == expected;
            System.out.println("Int A: " + a + ", Int B: " + b + ", GCD Fast: " + result + ", GCD Slow: " + expected + ", Passed: " + passTest);
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected, result);
        }
    }


    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {

            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }
        return current_gcd;
    }

}