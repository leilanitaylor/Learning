package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionalKnapsackTest {

    FractionalKnapsack knapsack;
    @BeforeEach
    public void setUp() {knapsack = new FractionalKnapsack(); }

    @Test
    void testSample1BestItem() {
        int[] values = {60, 100, 120};
        int[] weights = {50, 50, 30};
        int expected = 2;
        int result = knapsack.bestItem(values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2BestItem() {
        int[] values = {500};
        int[] weights = {30};
        int expected = 0;
        int result = knapsack.bestItem(values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1BestItem() {
        int[] values = {30, 24, 28};
        int[] weights = {5, 3, 4};
        int expected = 1;
        int result = knapsack.bestItem(values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2BestItem() {
        int[] values = {10, 16, 28};
        int[] weights = {5, 6, 10};
        int expected = 2;
        int result = knapsack.bestItem(values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSampe1GetOptimalValue() {
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {20, 50, 30};
        double expected = 180.0000;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetOptimalValue() {
        int capacity = 10;
        int[] values = {500};
        int[] weights = {30};
        double expected = 166.6667;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetOptimalValue() {
        int capacity = 9;
        int[] values = {30, 24, 28};
        int[] weights = {5, 3, 4};
        double expected = 64.0000;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GetOptimalValue() {
        int capacity = 60;
        int[] values = {280, 100, 120, 120};
        int[] weights = {40, 10, 20, 24};
        double expected = 440.0000;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3GetOptimalValue() {
        int capacity = 19;
        int[] values = {20, 16, 8};
        int[] weights = {14, 6, 10};
        double expected = 34.5714;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4GetOptimalValue() {
        int capacity = 11;
        int[] values = {10, 16, 28};
        int[] weights = {5, 6, 10};
        double expected = 30.6667;
        double result = knapsack.getOptimalValue(capacity, values, weights);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}