package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DotProductTest {

    DotProduct dotProduct;
    @BeforeEach
    public void setUp() {dotProduct = new DotProduct(); }

    @Test
    void testSample1aSort() {
        int[] c = {23};
        int[] expected = {23};
        int[] result = dotProduct.sort(c);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample1bSort() {
        int[] c = {39};
        int[] expected = {39};
        int[] result = dotProduct.sort(c);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2aSort() {
        int[] c = {1, 3, -5};
        int[] expected = {3, 1, -5};
        int[] result = dotProduct.sort(c);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2bSort() {
        int[] c = {-2, 4, 1};
        int[] expected = {4, 1, -2};
        int[] result = dotProduct.sort(c);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test1Sort() {
        int[] c = {10, 3, 5, -200, 30, 45, -20, 300, 30, -5000, 3000};
        int[] expected = {3000, 300, 45, 30, 30, 10, 5, 3, -20, -200, -5000};
        int[] result = dotProduct.sort(c);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample1MaxDotProduct() {
        int[] a = {23};
        int[] b = {39};
        long expected = 897L;
        long result = dotProduct.maxDotProduct(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2MaxDotProduct() {
        int[] a = {1, 3, -5};
        int[] b = {-2, 4, 1};
        long expected = 23L;
        long result = dotProduct.maxDotProduct(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

}