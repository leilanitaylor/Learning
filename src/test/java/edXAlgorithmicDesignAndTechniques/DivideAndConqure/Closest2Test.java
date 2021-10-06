package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Closest2Test {

    Closest2 ct;
    @BeforeEach
    public void setUp() {ct = new Closest2(); }

    @Test
    void test1Dist() {
        Closest2.Point a = new Closest2.Point(-1, -1);
        Closest2.Point b = new Closest2.Point(-2, -2);
        double expected = 1.4142;
        double result = ct.dist(a, b);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2Dist() {
        Closest2.Point a = new Closest2.Point(7, 7);
        Closest2.Point b = new Closest2.Point(7, 7);
        double expected = 0.0;
        double result = ct.dist(a, b);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1BruteForce() {
        Closest2.Point[] points = new Closest2.Point[3];
        points[0] = new Closest2.Point(7, 7);
        points[1] = new Closest2.Point(1, 100);
        points[2] = new Closest2.Point(7, 7);
        double expected = 0.0;
        double result = ct.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2BruteForce() {
        Closest2.Point[] points = new Closest2.Point[3];
        points[0] = new Closest2.Point(7, 7);
        points[1] = new Closest2.Point(1, 100);
        points[2] = new Closest2.Point(4, 8);
        double expected = 3.1623;
        double result = ct.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3BruteForce() {
        Closest2.Point[] points = new Closest2.Point[2];
        points[0] = new Closest2.Point(0, 0);
        points[1] = new Closest2.Point(3, 4);
        double expected = 5.0;
        double result = ct.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4BruteForce() {
        Closest2.Point[] points = new Closest2.Point[4];
        points[0] = new Closest2.Point(0, 0);
        points[1] = new Closest2.Point(7, 2);
        points[2] = new Closest2.Point(3, 4);
        points[3] = new Closest2.Point(5, 6);
        double expected = 2.8284;
        double result = ct.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5BruteForce() {
        Closest2.Point[] points = new Closest2.Point[3];
        points[0] = new Closest2.Point(2, 2);
        points[1] = new Closest2.Point(4, 2);
        points[2] = new Closest2.Point(4, 7);
        double expected = 2D;
        double result = ct.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1xSortPoints() {
        Closest2.Point[] points = new Closest2.Point[2];
        points[0] = new Closest2.Point(0, 0);
        points[1] = new Closest2.Point(3, 4);
        Closest2.Point[] expected = new Closest2.Point[2];
        expected[0] = new Closest2.Point(0, 0);
        expected[1] = new Closest2.Point(3, 4);
        ct.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample2xSortPoints() {
        Closest2.Point[] points = new Closest2.Point[4];
        points[0] = new Closest2.Point(7, 7);
        points[1] = new Closest2.Point(1, 100);
        points[2] = new Closest2.Point(4, 8);
        points[3] = new Closest2.Point(7, 7);
        Closest2.Point[] expected = new Closest2.Point[4];
        expected[0] = new Closest2.Point(1, 100);
        expected[1] = new Closest2.Point(4, 8);
        expected[2] = new Closest2.Point(7, 7);
        expected[3] = new Closest2.Point(7, 7);
        ct.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample3xSortPoints() {
        Closest2.Point[] points = new Closest2.Point[11];
        points[0] = new Closest2.Point(4, 4);
        points[1] = new Closest2.Point(-2, -2);
        points[2] = new Closest2.Point(-3, -4);
        points[3] = new Closest2.Point(-1, 3);
        points[4] = new Closest2.Point(2, 3);
        points[5] = new Closest2.Point(-4, 0);
        points[6] = new Closest2.Point(1, 1);
        points[7] = new Closest2.Point(-1, -1);
        points[8] = new Closest2.Point(3, -1);
        points[9] = new Closest2.Point(-4, 2);
        points[10] = new Closest2.Point(-2, 4);
        Closest2.Point[] expected = new Closest2.Point[11];
        expected[0] = new Closest2.Point(-4, 0);
        expected[1] = new Closest2.Point(-4, 2);
        expected[2] = new Closest2.Point(-3, -4);
        expected[3] = new Closest2.Point(-2, -2);
        expected[4] = new Closest2.Point(-2, 4);
        expected[5] = new Closest2.Point(-1, -1);
        expected[6] = new Closest2.Point(-1, 3);
        expected[7] = new Closest2.Point(1, 1);
        expected[8] = new Closest2.Point(2, 3);
        expected[9] = new Closest2.Point(3, -1);
        expected[10] = new Closest2.Point(4, 4);
        ct.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void test1xSortPoints() {
        Closest2.Point[] points = new Closest2.Point[4];
        points[0] = new Closest2.Point(0, 0);
        points[1] = new Closest2.Point(5, 6);
        points[2] = new Closest2.Point(3, 4);
        points[3] = new Closest2.Point(7, 2);
        Closest2.Point[] expected = new Closest2.Point[4];
        expected[0] = new Closest2.Point(0, 0);
        expected[1] = new Closest2.Point(3, 4);
        expected[2] = new Closest2.Point(5, 6);
        expected[3] = new Closest2.Point(7, 2);
        ct.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void test2xSortPoints() {
        Closest2.Point[] points = new Closest2.Point[6];
        points[0] = new Closest2.Point(4, 7);
        points[1] = new Closest2.Point(8, 5);
        points[2] = new Closest2.Point(5, 2);
        points[3] = new Closest2.Point(5, 8);
        points[4] = new Closest2.Point(4, 2);
        points[5] = new Closest2.Point(2, 2);
        Closest2.Point[] expected = new Closest2.Point[6];
        expected[0] = new Closest2.Point(2, 2);
        expected[1] = new Closest2.Point(4, 2);
        expected[2] = new Closest2.Point(4, 7);
        expected[3] = new Closest2.Point(5, 2);
        expected[4] = new Closest2.Point(5, 8);
        expected[5] = new Closest2.Point(8, 5);
        ct.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample1ySortPoints() {
        Closest2.Point[] points = new Closest2.Point[2];
        points[0] = new Closest2.Point(0, 0);
        points[1] = new Closest2.Point(3, 4);
        Closest2.Point[] expected = new Closest2.Point[2];
        expected[0] = new Closest2.Point(0, 0);
        expected[1] = new Closest2.Point(3, 4);
        ct.ySortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample2ySortPoints() {
        Closest2.Point[] points = new Closest2.Point[4];
        points[0] = new Closest2.Point(7, 7);
        points[1] = new Closest2.Point(1, 100);
        points[2] = new Closest2.Point(4, 8);
        points[3] = new Closest2.Point(7, 7);
        Closest2.Point[] expected = new Closest2.Point[4];
        expected[0] = new Closest2.Point(7, 7);
        expected[1] = new Closest2.Point(7, 7);
        expected[2] = new Closest2.Point(4, 8);
        expected[3] = new Closest2.Point(1, 100);
        ct.ySortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample3ySortPoints() {
        Closest2.Point[] points = new Closest2.Point[11];
        points[0] = new Closest2.Point(4, 4);
        points[1] = new Closest2.Point(-2, -2);
        points[2] = new Closest2.Point(-3, -4);
        points[3] = new Closest2.Point(-1, 3);
        points[4] = new Closest2.Point(2, 3);
        points[5] = new Closest2.Point(-4, 0);
        points[6] = new Closest2.Point(1, 1);
        points[7] = new Closest2.Point(-1, -1);
        points[8] = new Closest2.Point(3, -1);
        points[9] = new Closest2.Point(-4, 2);
        points[10] = new Closest2.Point(-2, 4);
        Closest2.Point[] expected = new Closest2.Point[11];
        expected[0] = new Closest2.Point(-3, -4);
        expected[1] = new Closest2.Point(-2, -2);
        expected[2] = new Closest2.Point(-1, -1);
        expected[3] = new Closest2.Point(3, -1);
        expected[4] = new Closest2.Point(-4, 0);
        expected[5] = new Closest2.Point(1, 1);
        expected[6] = new Closest2.Point(-4, 2);
        expected[7] = new Closest2.Point(2, 3);
        expected[8] = new Closest2.Point(-1, 3);
        expected[9] = new Closest2.Point(4, 4);
        expected[10] = new Closest2.Point(-2, 4);
        ct.ySortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void test1ySortPoints() {
        Closest2.Point[] points = new Closest2.Point[6];
        points[0] = new Closest2.Point(4, 7);
        points[1] = new Closest2.Point(8, 5);
        points[2] = new Closest2.Point(5, 2);
        points[3] = new Closest2.Point(5, 8);
        points[4] = new Closest2.Point(4, 2);
        points[5] = new Closest2.Point(2, 2);
        Closest2.Point[] expected = new Closest2.Point[6];
        expected[0] = new Closest2.Point(4, 2);
        expected[1] = new Closest2.Point(2, 2);
        expected[2] = new Closest2.Point(5, 2);
        expected[3] = new Closest2.Point(8, 5);
        expected[4] = new Closest2.Point(4, 7);
        expected[5] = new Closest2.Point(5, 8);
        ct.ySortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length-1; i++) {
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample1GetDistance() {
        Closest2.Point[] pointsX = new Closest2.Point[2];
        pointsX[0] = new Closest2.Point(0, 0);
        pointsX[1] = new Closest2.Point(3, 4);
        Closest2.Point[] pointsY = new Closest2.Point[2];
        pointsY[0] = new Closest2.Point(0, 0);
        pointsY[1] = new Closest2.Point(3, 4);
        double expected = 5.0;
        double result = ct.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetDistance() {
        Closest2.Point[] pointsX = new Closest2.Point[4];
        pointsX[0] = new Closest2.Point(1, 100);
        pointsX[1] = new Closest2.Point(4, 8);
        pointsX[2] = new Closest2.Point(7, 7);
        pointsX[3] = new Closest2.Point(7, 7);
        Closest2.Point[] pointsY = new Closest2.Point[4];
        pointsY[0] = new Closest2.Point(7, 7);
        pointsY[1] = new Closest2.Point(7, 7);
        pointsY[2] = new Closest2.Point(4, 8);
        pointsY[3] = new Closest2.Point(1, 100);
        double expected = 0.0;
        double result = ct.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3GetDistance() {
        Closest2.Point[] pointsX = new Closest2.Point[11];
        pointsX[0] = new Closest2.Point(-4, 0);
        pointsX[1] = new Closest2.Point(-4, 2);
        pointsX[2] = new Closest2.Point(-3, -4);
        pointsX[3] = new Closest2.Point(-2, -2);
        pointsX[4] = new Closest2.Point(-2, 4);
        pointsX[5] = new Closest2.Point(-1, -1);
        pointsX[6] = new Closest2.Point(-1, 3);
        pointsX[7] = new Closest2.Point(1, 1);
        pointsX[8] = new Closest2.Point(2, 3);
        pointsX[9] = new Closest2.Point(3, -1);
        pointsX[10] = new Closest2.Point(4, 4);
        Closest2.Point[] pointsY = new Closest2.Point[11];
        pointsY[0] = new Closest2.Point(-3, -4);
        pointsY[1] = new Closest2.Point(-2, -2);
        pointsY[2] = new Closest2.Point(-1, -1);
        pointsY[3] = new Closest2.Point(3, -1);
        pointsY[4] = new Closest2.Point(-4, 0);
        pointsY[5] = new Closest2.Point(1, 1);
        pointsY[6] = new Closest2.Point(-4, 2);
        pointsY[7] = new Closest2.Point(-1, 3);
        pointsY[8] = new Closest2.Point(2, 3);
        pointsY[9] = new Closest2.Point(-2, 4);
        pointsY[10] = new Closest2.Point(4, 4);
        double expected = 1.4142;
        double result = ct.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetDistance() {
        Closest2.Point[] pointsX = new Closest2.Point[4];
        pointsX[0] = new Closest2.Point(0, 0);
        pointsX[1] = new Closest2.Point(3, 4);
        pointsX[2] = new Closest2.Point(5, 6);
        pointsX[3] = new Closest2.Point(7, 2);
        Closest2.Point[] pointsY = new Closest2.Point[4];
        pointsY[0] = new Closest2.Point(0, 0);
        pointsY[1] = new Closest2.Point(7, 2);
        pointsY[2] = new Closest2.Point(3, 4);
        pointsY[3] = new Closest2.Point(5, 6);
        double expected = 2.8284;
        double result = ct.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GetDistance() {
        Closest2.Point[] pointsX = new Closest2.Point[6];
        pointsX[0] = new Closest2.Point(2, 2);
        pointsX[1] = new Closest2.Point(4, 2);
        pointsX[2] = new Closest2.Point(4, 7);
        pointsX[3] = new Closest2.Point(5, 2);
        pointsX[4] = new Closest2.Point(5, 8);
        pointsX[5] = new Closest2.Point(8, 5);
        Closest2.Point[] pointsY = new Closest2.Point[6];
        pointsY[0] = new Closest2.Point(2, 2);
        pointsY[1] = new Closest2.Point(4, 2);
        pointsY[2] = new Closest2.Point(5, 2);
        pointsY[3] = new Closest2.Point(8, 5);
        pointsY[4] = new Closest2.Point(4, 7);
        pointsY[5] = new Closest2.Point(5, 8);
        double expected = 1D;
        double result = ct.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1MinimalDistance() {
        int[] x = {0, 3};
        int[] y = {0, 4};
        double expected = 5.0;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2MinimalDistance() {
        int[] x = {7, 1, 4, 7};
        int[] y = {7, 100, 8, 7};
        double expected = 0.0;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3MinimalDistance() {
        int[] x = {4, -2, -3, -1, 2, -4, 1, -1, 3, -4, -2};
        int[] y = {4, -2, -4, 3, 3, 0, 1, -1, -1, 2, 4};
        double expected = 1.4142;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1MinimalDistance() {
        int[] x = {0, 5, 3, 7};
        int[] y = {0, 6, 4, 2};
        double expected = 2.8284;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2MinimalDistance() {
        int[] x = {4, 8, 5, 5, 4, 2};
        int[] y = {7, 5, 2, 8, 2, 2};
        double expected = 1D;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3MinimalDistance() {
        int[] x = {4, 5, 8, 2, 5, 4};
        int[] y = {7, 1, 5, 2, 7, 2};
        double expected = 1D;
        double result = ct.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4MinimalDistance() {
        int numTests = 100000;
        int[] xPoints = new int[numTests];
        int[] yPoints = new int[numTests];
        for (int i = 0; i < numTests; i++) {
            int x = (int)(Math.random() * 10000000);
            int y = (int)(Math.random() * 10000000);
            x -= 5000000;
            y -= 5000000;
            xPoints[i] = x;
            yPoints[i] = y;
        }
        Closest2.Point[] points = ct.convertPtsToSingleArray(xPoints, yPoints);
        double naive = ct.bruteForce(points, 0, points.length-1);
        naive = Math.round(naive * 10000) / 10000D;
        double result = ct.minimalDistance(xPoints, yPoints);
        Assertions.assertNotNull(naive);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(naive, result);
    }
}