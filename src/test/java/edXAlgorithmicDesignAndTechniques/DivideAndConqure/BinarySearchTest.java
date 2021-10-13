package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch bs;
    @BeforeEach
    public void setUp() {bs = new BinarySearch(); }

    @Test
    void testSample1aBinarySearch() {
        int[] a = {1, 5, 8, 12, 13};
        int x = 8;
        int result = bs.binarySearch(a, 0, a.length-1, x);
        int expected = 2;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1bBinarySearch() {
        int[] a = {1, 5, 8, 12, 13};
        int x = 1;
        int result = bs.binarySearch(a, 0, a.length-1, x);
        int expected = 0;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1cBinarySearch() {
        int[] a = {1, 5, 8, 12, 13};
        int x = 23;
        int result = bs.binarySearch(a, 0, a.length-1, x);
        int expected = -1;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1dBinarySearch() {
        int[] a = {1, 5, 8, 12, 13};
        int x = 11;
        int result = bs.binarySearch(a, 0, a.length-1, x);
        int expected = -1;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1BinarySearch() {
        int[] a = {1, 5, 8, 12, 13};
        int[] b = {8, 1, 23, 1, 11};
        for (int i = 0; i < b.length; i++) {
            int x = b[i];
            int result = bs.binarySearch(a, 0, a.length-1, x);
            int expected = bs.linearSearch(a, x);
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected, result);
        }
    }
}