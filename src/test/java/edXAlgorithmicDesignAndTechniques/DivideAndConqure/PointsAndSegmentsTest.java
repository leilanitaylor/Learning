package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsAndSegmentsTest {

    PointsAndSegments test;
    @BeforeEach
    public void setUp() {test = new PointsAndSegments(); }

    @Test
    void testSample1NaiveCountSegments() {
        int[] starts = {0, 7};
        int[] ends = {5, 10};
        int[] points = {1, 6, 11};
        int[] expected = {1, 0, 0};
        int[] result = test.naiveCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2NaiveCountSegments() {
        int[] starts = {-10};
        int[] ends = {10};
        int[] points = {-100, 100, 0};
        int[]  expected = {0, 0, 1};
        int[] result = test.naiveCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample3NaiveCountSegments() {
        int[] starts = {0, -3, 7};
        int[] ends = {5, 2, 10};
        int[] points = {1, 6};
        int[] expected = {2, 0};
        int[] result = test.naiveCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample1CountSegments() {
        int[] starts = {0, 7};
        int[] ends = {5, 10};
        int[] points = {1, 6, 11};
        int[] expected = {1, 0, 0};
        int[] result = test.fastCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2CountSegments() {
        int[] starts = {-10};
        int[] ends = {10};
        int[] points = {-100, 100, 0};
        int[]  expected = {0, 0, 1};
        int[] result = test.fastCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample3CountSegments() {
        int[] starts = {0, -3, 7};
        int[] ends = {5, 2, 10};
        int[] points = {1, 6};
        int[] expected = {2, 0};
        int[] result = test.fastCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test1CountSegments() {
        int[] starts = {0, 1, 3};
        int[] ends = {3, 3, 8};
        int[] points = {-1, 3, 8};
        int[] expected = {0, 3, 1};
        int[] result = test.fastCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test2CountSegments() {
        int[] starts = {1, 2, 5};
        int[] ends = {3, 4, 7};
        int[] points = {0, 2, 5};
        int[] expected = {0, 2, 1};
        int[] result = test.fastCountSegments(starts, ends, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}