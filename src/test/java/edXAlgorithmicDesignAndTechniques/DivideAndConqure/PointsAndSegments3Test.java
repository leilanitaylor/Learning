package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class PointsAndSegments3Test {

    PointsAndSegments3 ps;
    @BeforeEach
    public void setUp() {ps = new PointsAndSegments3(); }

    @Test
    void testSample1CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[2];
        segments[0] = new PointsAndSegments3.Segment(0, 5);
        segments[1] = new PointsAndSegments3.Segment(7, 10);
        int[] points = {1, 6, 11};
        int[] expected = {1, 0, 0};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[1];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        int[] points = {-100, 100, 0};
        int[] expected = {0, 0, 1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample3CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(0, 5);
        segments[1] = new PointsAndSegments3.Segment(-3, 2);
        segments[2] = new PointsAndSegments3.Segment(7, 10);
        int[] points = {1, 6};
        int[] expected = {2, 0};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test1CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(0, 3);
        segments[1] = new PointsAndSegments3.Segment(1, 3);
        segments[2] = new PointsAndSegments3.Segment(3, 8);
        int[] points = {-1, 3, 8};
        int[] expected = {0, 3, 1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test2CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(1, 3);
        segments[1] = new PointsAndSegments3.Segment(2, 4);
        segments[2] = new PointsAndSegments3.Segment(5, 7);
        int[] points = {0, 2, 5};
        int[] expected = {0, 2, 1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test3CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(1, 3);
        segments[1] = new PointsAndSegments3.Segment(2, 4);
        segments[2] = new PointsAndSegments3.Segment(5, 7);
        int[] points = {2, 2, 5};
        int[] expected = {2, 2, 1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test4CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(5, 7);
        segments[1] = new PointsAndSegments3.Segment(1, 3);
        segments[2] = new PointsAndSegments3.Segment(2, 4);
        int[] points = {2, 5, 2};
        int[] expected = {2, 1, 2};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}