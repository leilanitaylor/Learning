package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    Sorting sort;
    @BeforeEach
    public void setUp() {sort = new Sorting(); }

    @Test
    void testSample1RandomizedQuickSort() {
        int[] a = {3, 2, 9, 2, 2};
        int l = 0;
        int r = a.length - 1;
        int[] expected = {2, 2, 2, 3, 9};
        sort.randomizedQuickSort(a, l, r);
        Assertions.assertNotNull(a);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test1RandomizedQuickSort() {
        int[] a = {2, 3, 9, 2, 2, 1};
        int l = 0;
        int r = a.length - 1;
        int[] expected = {1, 2, 2, 2, 3, 9};
        sort.randomizedQuickSort(a, l, r);
        Assertions.assertNotNull(a);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test2RandomizedQuickSort() {
        int[] a = {3, 2, 9, 3, 2, 1, 8, 3, 3, 2};
        int l = 0;
        int r = a.length - 1;
        int[] expected = {1, 2, 2, 2, 3, 3, 3, 3, 8, 9};
        sort.randomizedQuickSort(a, l, r);
        Assertions.assertNotNull(a);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test3RandomizedQuickSort() {
        int[] a = {3, 3, 9, 3, 2, 1, 8, 3, 3, 2};
        int l = 0;
        int r = a.length - 1;
        int[] expected = {1, 2, 2, 3, 3, 3, 3, 3, 8, 9};
        sort.randomizedQuickSort(a, l, r);
        Assertions.assertNotNull(a);
        for (int i = 0; i < a.length - 1; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }
}