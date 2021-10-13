package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversionsTest {

    Inversions invert;
    @BeforeEach
    public void setUp() {invert = new Inversions(); }

    @Test
    void test1Merge() {
        int[] a = {1, 3, 5, 2, 4, 6};
        int left = 1;
        int right = 3;
        int mid = ((right - left) / 2) + left;
        int[] expected = {1, 2, 3, 5, 4, 6};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test2Merge() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int left = 0;
        int right = 2;
        int mid = ((right - left) / 2) + left;
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test3Merge() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int left = 0;
        int right = 1;
        int mid = ((right - left) / 2) + left;
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test4Merge() {
        int[] a = {4, 5, 6, 1, 2, 3};
        int left = 2;
        int right = 3;
        int mid = ((right - left) / 2) + left;
        int[] expected = {4, 5, 1, 6, 2, 3};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test5Merge() {
        int[] a = {4, 5, 6, 1, 2, 3};
        int left = 0;
        int right = a.length-1;
        int mid = ((right - left) / 2) + left;
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test6Merge() {
        int[] a = {4, 5, 6, 1, 2, 4, 9};
        int left = 2;
        int right = 3;
        int mid = ((right - left) / 2) + left;
        int[] expected = {4, 5, 1, 6, 2, 4, 9};
        invert.merge(a, left, mid, right);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }


    @Test
    void test1MergeSort() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test2MergeSort() {
        int[] a = {1, 3, 5, 2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test3MergeSort() {
        int[] a = {4, 5, 6, 1, 2, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test4MergeSort() {
        int[] a = {4, 5, 6, 1, 2, 4, 9};
        int[] expected = {1, 2, 4, 4, 5, 6, 9};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test5MergeSort() {
        int[] a = {2, 3, 9, 2, 9};
        int[] expected = {2, 2, 3, 9, 9};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void testSample1GetNumberOfInversions() {
        int[] a = {2, 3, 9, 2, 9};
        int[] b = new int[a.length];
        long expected = 2L;
        long result = invert.getNumberOfInversions(a, b, 0, a.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetNumberOfInversions() {
        int[] a = {1, 2, 3, 4};
        int[] b = new int[a.length];
        long expected = 0L;
        long result = invert.getNumberOfInversions(a, b, 0, a.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6MergeSort() {
        int[] a = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        invert.mergeSort(a, 0, a.length-1);
        Assertions.assertNotNull(a);
        Assertions.assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            Assertions.assertEquals(expected[i], a[i]);
        }
    }

    @Test
    void test2GetNumberOfInversions() {
        int[] a = {9, 8, 7, 3, 2, 1};
        int[] b = new int[a.length];
        long expected = 15;
        long result = invert.getNumberOfInversions(a, b, 0, a.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}