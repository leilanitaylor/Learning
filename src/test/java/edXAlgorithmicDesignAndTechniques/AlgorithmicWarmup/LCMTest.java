package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup.LCM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LCMTest {
    LCM lcmTest;
    @BeforeEach
    public void setUP() {lcmTest = new LCM(); }

    @Test
    void testSample1LCM() {
        int a = 6;
        int b = 8;
        long expected = 24;
        long result = lcmTest.lcmCalc(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2LCM() {
        int a = 28851538;
        int b = 1183019;
        long expected = 1933053046;
        long result = lcmTest.lcmCalc(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1LCM() {
        int a = 2000000000;
        int b = 1999999999;
        long expected = 3999999998000000000L;
        long result = lcmTest.lcmCalc(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2LCM() {
        int numTests = 20;
        for (int i = 0; i < numTests; i++) {
            int a = (int)(Math.random() * 100000);
            int b = (int)(Math.random() * 100000);
            long expected = lcm_naive(a, b);
            long result = lcmTest.lcmCalc(a, b);
            boolean pass = expected == result;
            System.out.println("Int a: " + a + ", Int b: " + b + ", LCM Fast: " + result + ", LCM Slow: " + expected + ", Passed: " + pass);
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected, result);
        }
    }



    public static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l) {
            if (l % a == 0 && l % b == 0) {
                return l;
            }
        }
        return (long) a * b;
    }

}