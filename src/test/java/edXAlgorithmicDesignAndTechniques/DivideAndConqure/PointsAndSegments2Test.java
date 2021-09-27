package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsAndSegments2Test {

    PointsAndSegments2 pointCount;
    @BeforeEach
    public void setUp() {pointCount = new PointsAndSegments2(); }

    @Test
    void testSample1CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[2];
        segments[0] = new PointsAndSegments2.Segments(0, 5);
        segments[1] = new PointsAndSegments2.Segments(7, 10);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(1, 0);
        points[1] = new PointsAndSegments2.Points(6, 1);
        points[2] = new PointsAndSegments2.Points(11, 2);
        int[] expected = {1, 0, 0};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[1];
        segments[0] = new PointsAndSegments2.Segments(-10, 10);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(-100, 0);
        points[1] = new PointsAndSegments2.Points(100, 1);
        points[2] = new PointsAndSegments2.Points(0, 2);
        int[] expected = {0, 0, 1};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample3CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[3];
        segments[0] = new PointsAndSegments2.Segments(0, 5);
        segments[1] = new PointsAndSegments2.Segments(-3, 2);
        segments[2] = new PointsAndSegments2.Segments(7, 10);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[2];
        points[0] = new PointsAndSegments2.Points(1, 0);
        points[1] = new PointsAndSegments2.Points(6, 1);
        int[] expected = {2, 0};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test1CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[3];
        segments[0] = new PointsAndSegments2.Segments(0, 3);
        segments[1] = new PointsAndSegments2.Segments(1, 3);
        segments[2] = new PointsAndSegments2.Segments(3, 8);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(-1, 0);
        points[1] = new PointsAndSegments2.Points(3, 1);
        points[2] = new PointsAndSegments2.Points(8, 2);
        int[] expected = {0, 3, 1};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test2CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[3];
        segments[0] = new PointsAndSegments2.Segments(1, 3);
        segments[1] = new PointsAndSegments2.Segments(2, 4);
        segments[2] = new PointsAndSegments2.Segments(5, 7);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(0, 0);
        points[1] = new PointsAndSegments2.Points(2, 1);
        points[2] = new PointsAndSegments2.Points(5, 2);
        int[] expected = {0, 2, 1};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test3CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[3];
        segments[0] = new PointsAndSegments2.Segments(1, 3);
        segments[1] = new PointsAndSegments2.Segments(2, 4);
        segments[2] = new PointsAndSegments2.Segments(5, 7);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(2, 0);
        points[1] = new PointsAndSegments2.Points(2, 1);
        points[2] = new PointsAndSegments2.Points(5, 2);
        int[] expected = {2, 2, 1};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test4CountSegments() {
        PointsAndSegments2.Segments[] segments = new PointsAndSegments2.Segments[3];
        segments[0] = new PointsAndSegments2.Segments(1, 3);
        segments[1] = new PointsAndSegments2.Segments(2, 4);
        segments[2] = new PointsAndSegments2.Segments(5, 7);
        PointsAndSegments2.Points[] points = new PointsAndSegments2.Points[3];
        points[0] = new PointsAndSegments2.Points(2, 0);
        points[1] = new PointsAndSegments2.Points(5, 1);
        points[2] = new PointsAndSegments2.Points(2, 2);
        int[] expected = {2, 1, 2};
        int[] result = pointCount.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}