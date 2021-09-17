package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciHugeTest {

    FibonacciHuge fibHuge;
    @BeforeEach
    public void setUP() {fibHuge = new FibonacciHuge(); }


    @Test
    void test1PisanoPeriod() {
        long m = 4L;
        long result = fibHuge.getPisanoPeriod(m);
        long expected = 6L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2PisanoPeriod() {
        long m = 10L;
        long result = fibHuge.getPisanoPeriod(m);
        long expected = 60L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3PisanoPeriod() {
        long m = 25L;
        long result = fibHuge.getPisanoPeriod(m);
        long expected = 100L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4PisanoPeriod() {
        long m = 67L;
        long result = fibHuge.getPisanoPeriod(m);
        long expected = 136L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }



    @Test
    void testSample1GetFibonacciHuge() {
        long n = 239L;
        long m = 1000L;
        long result = fibHuge.getFibonacciHuge(n, m);
        long expected = 161L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetFibonacciHuge() {
        long n = 2816213588L;
        long m = 239L;
        long result = fibHuge.getFibonacciHuge(n, m);
        long expected = 151L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }



}