package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    MergeSort ms;
    @BeforeEach
    public void setUp() {ms = new MergeSort();}

    @Test
    void test1Merge() {
        int[] a = {1, 3, 5, 2, 4, 6};
        int left = 1;
        int right = 3;
        int mid = ((right - left) / 2) + left;
        int[] expected = {1, 2, 3, 5, 4, 6};
        ms.merge(a, left, mid, right);
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
        ms.merge(a, left, mid, right);
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
        ms.merge(a, left, mid, right);
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
        ms.merge(a, left, mid, right);
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
        ms.merge(a, left, mid, right);
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
        ms.merge(a, left, mid, right);
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
        ms.mergeSort(a, 0, a.length-1);
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
        ms.mergeSort(a, 0, a.length-1);
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
        ms.mergeSort(a, 0, a.length-1);
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
        ms.mergeSort(a, 0, a.length-1);
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
        ms.mergeSort(a, 0, a.length-1);
        assertNotNull(a);
        assertEquals(expected.length, a.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(expected[i], a[i]);
        }
    }
}