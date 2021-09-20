package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTest {

    Change coins;
    @BeforeEach
    public void setUP() {coins = new Change(); }

    @Test
    void testSample1GetChange() {
        int m = 2;
        int expected = 2;
        int result = coins.getChange(m);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetChange() {
        int m = 28;
        int expected = 6;
        int result = coins.getChange(m);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetChange() {
        int m = 1;
        int expected = 1;
        int result = coins.getChange(m);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GetChange() {
        int m = 1000;
        int expected = 100;
        int result = coins.getChange(m);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

}