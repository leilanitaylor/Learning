package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ClosestTest {

    Closest close;
    @BeforeEach
    public void setUp() {close = new Closest(); }

    @Test
    void test1Dist() {
        Closest.Point a = new Closest.Point(-1, -1);
        Closest.Point b = new Closest.Point(-2, -2);
        double expected = 1.4142;
        double result = close.dist(a, b);
        result = Math.round(result *10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2Dist() {
        Closest.Point a = new Closest.Point(7, 7);
        Closest.Point b = new Closest.Point(7, 7);
        double expected = 0.0;
        double result = close.dist(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3Dist() {
        Closest.Point a = new Closest.Point(0, 0);
        Closest.Point b = new Closest.Point(3, 4);
        double expected = 5.0;
        double result = close.dist(a, b);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1BruteForce() {
        Closest.Point[] points = new Closest.Point[3];
        points[0] = new Closest.Point(7, 7);
        points[1] = new Closest.Point(1, 100);
        points[2] = new Closest.Point(7, 7);
        double expected = 0.0;
        double result = close.bruteForce(points, 0, points.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2BruteForce() {
        Closest.Point[] points = new Closest.Point[3];
        points[0] = new Closest.Point(7, 7);
        points[1] = new Closest.Point(1, 100);
        points[2] = new Closest.Point(4, 8);
        double expected = 3.1623;
        double result = close.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3BruteForce() {
        Closest.Point[] points = new Closest.Point[2];
        points[0] = new Closest.Point(0, 0);
        points[1] = new Closest.Point(3, 4);
        double expected = 5.0;
        double result = close.bruteForce(points, 0, points.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4BruteForce() {
        Closest.Point[] midPtsToCheck = new Closest.Point[4];
        midPtsToCheck[0] = new Closest.Point(0, 0);
        midPtsToCheck[1] = new Closest.Point(7, 2);
        midPtsToCheck[2] = new Closest.Point(3, 4);
        midPtsToCheck[3] = new Closest.Point(5, 6);
        double expected = 2.8284;
        double result = close.bruteForce(midPtsToCheck, 0, midPtsToCheck.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5BruteForce() {
        Closest.Point[] points = new Closest.Point[3];
        points[0] = new Closest.Point(2, 2);
        points[1] = new Closest.Point(4, 2);
        points[2] = new Closest.Point(4, 7);
        double expected = 2D;
        double result = close.bruteForce(points, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1SortPtsToCheck() {
        List<Closest.Point> points = new ArrayList<>();
        points.add(new Closest.Point(7, 7));
        points.add(new Closest.Point(1, 100));
        points.add(new Closest.Point(4, 8));
        points.add(new Closest.Point(7, 7));
        List<Closest.Point> expected = new ArrayList<>();
        expected.add(new Closest.Point(7, 7));
        expected.add(new Closest.Point(7, 7));
        expected.add(new Closest.Point(4, 8));
        expected.add(new Closest.Point(1, 100));
        close.sortPtsToCheck(points, 0, points.size()-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.size(), points.size());
        for (int i = 0; i < points.size(); i++) {
            Assertions.assertEquals(expected.get(i).x, points.get(i).x);
            Assertions.assertEquals(expected.get(i).y, points.get(i).y);
        }
    }

    @Test
    void test2SortPtsToCheck() {
        List<Closest.Point> points = new ArrayList<>();
        points.add(new Closest.Point(4, 4));
        points.add(new Closest.Point(-2, -2));
        points.add(new Closest.Point(-3, -4));
        points.add(new Closest.Point(-1, 3));
        points.add(new Closest.Point(2, 3));
        points.add(new Closest.Point(-4, 0));
        points.add(new Closest.Point(1, 1));
        points.add(new Closest.Point(-1, -1));
        points.add(new Closest.Point(3, -1));
        points.add(new Closest.Point(-4, 2));
        points.add(new Closest.Point(-2, 4));
        List<Closest.Point> expected = new ArrayList<>();
        expected.add(new Closest.Point(-3, -4));
        expected.add(new Closest.Point(-2, -2));
        expected.add(new Closest.Point(3, -1));
        expected.add(new Closest.Point(-1, -1));
        expected.add(new Closest.Point(-4, 0));
        expected.add(new Closest.Point(1, 1));
        expected.add(new Closest.Point(-4, 2));
        expected.add(new Closest.Point(-1, 3));
        expected.add(new Closest.Point(2, 3));
        expected.add(new Closest.Point(4, 4));
        expected.add(new Closest.Point(-2, 4));
        close.sortPtsToCheck(points, 0, points.size()-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.size(), points.size());
        for (int i = 0; i < points.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, points.get(i).y);
        }
    }

    @Test
    void test3SortPtsToCheck() {
        List<Closest.Point> ptsToCheck = new ArrayList<>();
        ptsToCheck.add(new Closest.Point(3, 4));
        ptsToCheck.add(new Closest.Point(0, 0));
        ptsToCheck.add(new Closest.Point(5, 6));
        ptsToCheck.add(new Closest.Point(7, 2));
        List<Closest.Point> expected = new ArrayList<>();
        expected.add(new Closest.Point(0, 0));
        expected.add(new Closest.Point(7, 2));
        expected.add(new Closest.Point(3, 4));
        expected.add(new Closest.Point(5, 6));
        close.sortPtsToCheck(ptsToCheck, 0, ptsToCheck.size()-1);
        Assertions.assertNotNull(ptsToCheck);
        Assertions.assertEquals(expected.size(), ptsToCheck.size());
        for (int i = 0; i < ptsToCheck.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, ptsToCheck.get(i).y);
        }
    }

    @Test
    void test1FilterPtsToCheck() {
        List<Closest.Point> ptsToCheck = new ArrayList<>();
        ptsToCheck.add(new Closest.Point(7, 7));
        ptsToCheck.add(new Closest.Point(7, 7));
        ptsToCheck.add(new Closest.Point(4, 8));
        ptsToCheck.add(new Closest.Point(1, 100));
        double currentMin = 3D;
        List<Closest.Point> expected = new ArrayList<>();
        expected.add(new Closest.Point(7, 7));
        expected.add(new Closest.Point(7, 7));
        expected.add(new Closest.Point(4, 8));
        close.filterPtsToCheck(ptsToCheck, currentMin);
        Assertions.assertEquals(expected.size(), ptsToCheck.size());
        for (int i = 0; i < ptsToCheck.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, ptsToCheck.get(i).y);
            Assertions.assertEquals(expected.get(i).x, ptsToCheck.get(i).x);
        }
    }

    @Test
    void test2FilterPtsToCheck() {
        List<Closest.Point> ptsToCheck = new ArrayList<>();
        ptsToCheck.add(new Closest.Point(-3, -4));
        ptsToCheck.add(new Closest.Point(-2, -2));
        ptsToCheck.add(new Closest.Point(3, -1));
        ptsToCheck.add(new Closest.Point(-1, -1));
        ptsToCheck.add(new Closest.Point(-4, 0));
        ptsToCheck.add(new Closest.Point(1, 1));
        ptsToCheck.add(new Closest.Point(-4, 2));
        ptsToCheck.add(new Closest.Point(-1, 3));
        ptsToCheck.add(new Closest.Point(2, 3));
        ptsToCheck.add(new Closest.Point(4, 4));
        ptsToCheck.add(new Closest.Point(-2, 4));
        double currentMin = 1D;
        List<Closest.Point> expected = new ArrayList<>();
        close.filterPtsToCheck(ptsToCheck, currentMin);
        Assertions.assertEquals(expected.size(), ptsToCheck.size());
        for (int i = 0; i < ptsToCheck.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, ptsToCheck.get(i).y);
            Assertions.assertEquals(expected.get(i).x, ptsToCheck.get(i).x);
        }
    }

    @Test
    void test3FilterPtsToCheck() {
        List<Closest.Point> ptsToCheck = new ArrayList<>();
        ptsToCheck.add(new Closest.Point(-3, -4));
        ptsToCheck.add(new Closest.Point(-2, -2));
        ptsToCheck.add(new Closest.Point(3, -1));
        ptsToCheck.add(new Closest.Point(-1, -1));
        ptsToCheck.add(new Closest.Point(-4, 0));
        ptsToCheck.add(new Closest.Point(1, 1));
        ptsToCheck.add(new Closest.Point(-1, 3));
        ptsToCheck.add(new Closest.Point(2, 3));
        ptsToCheck.add(new Closest.Point(4, 4));
        ptsToCheck.add(new Closest.Point(-2, 6));
        double currentMin = 1D;
        List<Closest.Point> expected = new ArrayList<>();
        close.filterPtsToCheck(ptsToCheck, currentMin);
        Assertions.assertEquals(expected.size(), ptsToCheck.size());
        for (int i = 0; i < ptsToCheck.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, ptsToCheck.get(i).y);
            Assertions.assertEquals(expected.get(i).x, ptsToCheck.get(i).x);
        }
    }

    @Test
    void test4FilterPtsToCheck() {
        List<Closest.Point> ptsToCheck = new ArrayList<>();
        ptsToCheck.add(new Closest.Point(0, 0));
        ptsToCheck.add(new Closest.Point(7, 2));
        ptsToCheck.add(new Closest.Point(3, 4));
        ptsToCheck.add(new Closest.Point(5, 6));
        double currentMin = 4.4721;
        List<Closest.Point> expected = new ArrayList<>();
        expected.add(new Closest.Point(7, 2));
        expected.add(new Closest.Point(3, 4));
        expected.add(new Closest.Point(5, 6));
        close.filterPtsToCheck(ptsToCheck, currentMin);
        Assertions.assertEquals(expected.size(), ptsToCheck.size());
        for (int i = 0; i < ptsToCheck.size(); i++) {
            Assertions.assertEquals(expected.get(i).y, ptsToCheck.get(i).y);
            Assertions.assertEquals(expected.get(i).x, ptsToCheck.get(i).x);
        }
    }

    @Test
    void testSample1SortPoints() {
        Closest.Point[] points = new Closest.Point[2];
        points[0] = new Closest.Point(0, 0);
        points[1] = new Closest.Point(3, 4);
        Closest.Point[] expected = new Closest.Point[2];
        expected[0] = new Closest.Point(0, 0);
        expected[1] = new Closest.Point(3, 4);
        close.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample2SortPoints() {
        Closest.Point[] points = new Closest.Point[4];
        points[0] = new Closest.Point(7, 7);
        points[1] = new Closest.Point(1, 100);
        points[2] = new Closest.Point(4, 8);
        points[3] = new Closest.Point(7, 7);
        Closest.Point[] expected = new Closest.Point[4];
        expected[0] = new Closest.Point(1, 100);
        expected[1] = new Closest.Point(4, 8);
        expected[2] = new Closest.Point(7, 7);
        expected[3] = new Closest.Point(7, 7);
        close.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void testSample3SortPoints() {
        Closest.Point[] points = new Closest.Point[11];
        points[0] = new Closest.Point(4, 4);
        points[1] = new Closest.Point(-2, -2);
        points[2] = new Closest.Point(-3, -4);
        points[3] = new Closest.Point(-1, 3);
        points[4] = new Closest.Point(2, 3);
        points[5] = new Closest.Point(-4, 0);
        points[6] = new Closest.Point(1, 1);
        points[7] = new Closest.Point(-1, -1);
        points[8] = new Closest.Point(3, -1);
        points[9] = new Closest.Point(-4, 2);
        points[10] = new Closest.Point(-2, 4);
        Closest.Point[] expected = new Closest.Point[11];
        expected[0] = new Closest.Point(-4, 0);
        expected[1] = new Closest.Point(-4, 2);
        expected[2] = new Closest.Point(-3, -4);
        expected[3] = new Closest.Point(-2, -2);
        expected[4] = new Closest.Point(-2, 4);
        expected[5] = new Closest.Point(-1, -1);
        expected[6] = new Closest.Point(-1, 3);
        expected[7] = new Closest.Point(1, 1);
        expected[8] = new Closest.Point(2, 3);
        expected[9] = new Closest.Point(3, -1);
        expected[10] = new Closest.Point(4, 4);
        close.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void test1SortPoints() {
        Closest.Point[] points = new Closest.Point[4];
        points[0] = new Closest.Point(0, 0);
        points[1] = new Closest.Point(5, 6);
        points[2] = new Closest.Point(3, 4);
        points[3] = new Closest.Point(7, 2);
        Closest.Point[] expected = new Closest.Point[4];
        expected[0] = new Closest.Point(0, 0);
        expected[1] = new Closest.Point(3, 4);
        expected[2] = new Closest.Point(5, 6);
        expected[3] = new Closest.Point(7, 2);
        close.xSortPoints(points, 0, points.length-1);
        Assertions.assertNotNull(points);
        Assertions.assertEquals(expected.length, points.length);
        for (int i = 0; i < points.length; i++) {
            Assertions.assertEquals(expected[i].x, points[i].x);
            Assertions.assertEquals(expected[i].y, points[i].y);
        }
    }

    @Test
    void test2xSortPoints() {
        Closest.Point[] pointsX = new Closest.Point[6];
        pointsX[0] = new Closest.Point(4, 7);
        pointsX[1] = new Closest.Point(8, 5);
        pointsX[2] = new Closest.Point(5, 2);
        pointsX[3] = new Closest.Point(5, 8);
        pointsX[4] = new Closest.Point(4, 2);
        pointsX[5] = new Closest.Point(2, 2);
        Closest.Point[] expected = new Closest.Point[6];
        expected[0] = new Closest.Point(2, 2);
        expected[1] = new Closest.Point(4, 2);
        expected[2] = new Closest.Point(4, 7);
        expected[3] = new Closest.Point(5, 2);
        expected[4] = new Closest.Point(5, 8);
        expected[5] = new Closest.Point(8, 5);
        close.xSortPoints(pointsX, 0, pointsX.length-1);
        Assertions.assertNotNull(pointsX);
        Assertions.assertEquals(expected.length, pointsX.length);
        for (int i = 0; i < pointsX.length; i++) {
            Assertions.assertEquals(expected[i].x, pointsX[i].x);
            Assertions.assertEquals(expected[i].y, pointsX[i].y);
        }
    }

    @Test
    void testSample1ySortPoints() {
        Closest.Point[] pointsY = new Closest.Point[2];
        pointsY[0] = new Closest.Point(0, 0);
        pointsY[1] = new Closest.Point(3, 4);
        Closest.Point[] expected = new Closest.Point[2];
        expected[0] = new Closest.Point(0, 0);
        expected[1] = new Closest.Point(3, 4);
        close.ySortPoints(pointsY, 0, pointsY.length-1);
        Assertions.assertNotNull(pointsY);;
        Assertions.assertEquals(expected.length, pointsY.length);
        for (int i = 0; i < pointsY.length; i++) {
            Assertions.assertEquals(expected[i].y, pointsY[i].y);
        }
    }

    @Test
    void testSample2ySortPoints() {
        Closest.Point[] pointsY = new Closest.Point[4];
        pointsY[0] = new Closest.Point(7, 7);
        pointsY[1] = new Closest.Point(1, 100);
        pointsY[2] = new Closest.Point(4, 8);
        pointsY[3] = new Closest.Point(7, 7);
        Closest.Point[] expected = new Closest.Point[4];
        expected[0] = new Closest.Point(7, 7);
        expected[1] = new Closest.Point(7, 7);
        expected[2] = new Closest.Point(4, 8);
        expected[3] = new Closest.Point(1, 100);
        close.ySortPoints(pointsY, 0, pointsY.length-1);
        Assertions.assertNotNull(pointsY);
        Assertions.assertEquals(expected.length, pointsY.length);
        for (int i = 0; i < pointsY.length; i++) {
            Assertions.assertEquals(expected[i].y, pointsY[i].y);
        }
    }

    @Test
    void test1ySortPoints() {
        Closest.Point[] pointsY = new Closest.Point[4];
        pointsY[0] = new Closest.Point(7, 7);
        pointsY[1] = new Closest.Point(1, 100);
        pointsY[2] = new Closest.Point(4, 8);
        pointsY[3] = new Closest.Point(7, 7);
        Closest.Point[] expected = new Closest.Point[4];
        expected[0] = new Closest.Point(7, 7);
        expected[1] = new Closest.Point(7, 7);
        expected[2] = new Closest.Point(4, 8);
        expected[3] = new Closest.Point(1, 100);
        close.ySortPoints(pointsY, 0, pointsY.length-1);
        Assertions.assertNotNull(pointsY);
        Assertions.assertEquals(expected.length, pointsY.length);
        for (int i = 0; i < pointsY.length; i++) {
            Assertions.assertEquals(expected[i].y, pointsY[i].y);
        }
    }

    @Test
    void test2ySortPoints() {
        Closest.Point[] pointsY = new Closest.Point[11];
        pointsY[0] = new Closest.Point(4, 4);
        pointsY[1] = new Closest.Point(-2, -2);
        pointsY[2] = new Closest.Point(-3, -4);
        pointsY[3] = new Closest.Point(-1, 3);
        pointsY[4] = new Closest.Point(2, 3);
        pointsY[5] = new Closest.Point(-4, 0);
        pointsY[6] = new Closest.Point(1, 1);
        pointsY[7] = new Closest.Point(-1, -1);
        pointsY[8] = new Closest.Point(3, -1);
        pointsY[9] = new Closest.Point(-4, 2);
        pointsY[10] = new Closest.Point(-2, 4);
        Closest.Point[] expected = new Closest.Point[11];
        expected[0] = new Closest.Point(-3, -4);
        expected[1] = new Closest.Point(-2, -2);
        expected[2] = new Closest.Point(-1, -1);
        expected[3] = new Closest.Point(3, -1);
        expected[4] = new Closest.Point(-4, 0);
        expected[5] = new Closest.Point(1, 1);
        expected[6] = new Closest.Point(-4, 2);
        expected[7] = new Closest.Point(-1, 3);
        expected[8] = new Closest.Point(2, 3);
        expected[9] = new Closest.Point(4, 4);
        expected[10] = new Closest.Point(-2, 4);
        close.ySortPoints(pointsY, 0, pointsY.length-1);
        Assertions.assertNotNull(pointsY);
        Assertions.assertEquals(expected.length, pointsY.length);
        for (int i = 0; i < pointsY.length; i++) {
            Assertions.assertEquals(expected[i].y, pointsY[i].y);
        }
    }

    @Test
    void test3ySortPoints() {
        Closest.Point[] pointsY = new Closest.Point[6];
        pointsY[0] = new Closest.Point(4, 7);
        pointsY[1] = new Closest.Point(8, 5);
        pointsY[2] = new Closest.Point(5, 2);
        pointsY[3] = new Closest.Point(5, 8);
        pointsY[4] = new Closest.Point(4, 2);
        pointsY[5] = new Closest.Point(2, 2);
        Closest.Point[] expected = new Closest.Point[6];
        expected[0] = new Closest.Point(4, 2);
        expected[1] = new Closest.Point(2, 2);
        expected[2] = new Closest.Point(5, 2);
        expected[3] = new Closest.Point(8, 5);
        expected[4] = new Closest.Point(4, 7);
        expected[5] = new Closest.Point(5, 8);
        close.ySortPoints(pointsY, 0, pointsY.length-1);
        Assertions.assertNotNull(pointsY);
        Assertions.assertEquals(expected.length, pointsY.length);
        for (int i = 0; i < pointsY.length; i++) {
            Assertions.assertEquals(expected[i].y, pointsY[i].y);
        }
    }

    @Test
    void testSample1GetDistance() {
        Closest.Point[] points = new Closest.Point[2];
        points[0] = new Closest.Point(0, 0);
        points[1] = new Closest.Point(3, 4);
        Closest.Point[] pointsY = new Closest.Point[2];
        pointsY[0] = new Closest.Point(0, 0);
        pointsY[1] = new Closest.Point(3, 4);
        double expected = 5.0;
        double result = close.getDistance(points, pointsY, 0, points.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetDistance() {
        Closest.Point[] points = new Closest.Point[4];
        points[0] = new Closest.Point(1, 100);
        points[1] = new Closest.Point(4, 8);
        points[2] = new Closest.Point(7, 7);
        points[3] = new Closest.Point(7, 7);
        Closest.Point[] pointsY = new Closest.Point[4];
        pointsY[0] = new Closest.Point(7, 7);
        pointsY[1] = new Closest.Point(7, 7);
        pointsY[2] = new Closest.Point(4, 8);
        pointsY[3] = new Closest.Point(1, 100);
        double expected = 0.0;
        double result = close.getDistance(points, pointsY, 0, points.length-1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3GetDistance() {
        Closest.Point[] points = new Closest.Point[11];
        points[0] = new Closest.Point(-4, 0);
        points[1] = new Closest.Point(-4, -2);
        points[2] = new Closest.Point(-3, -4);
        points[3] = new Closest.Point(-2, -2);
        points[4] = new Closest.Point(-2, 4);
        points[5] = new Closest.Point(-1, -1);
        points[6] = new Closest.Point(-1, 3);
        points[7] = new Closest.Point(1, 1);
        points[8] = new Closest.Point(2, 3);
        points[9] = new Closest.Point(3, -1);
        points[10] = new Closest.Point(4, 4);
        Closest.Point[] pointsY = new Closest.Point[11];
        pointsY[0] = new Closest.Point(-3, -4);
        pointsY[1] = new Closest.Point(-2, -2);
        pointsY[2] = new Closest.Point(-1, -1);
        pointsY[3] = new Closest.Point(3, -1);
        pointsY[4] = new Closest.Point(-4, 0);
        pointsY[5] = new Closest.Point(1, 1);
        pointsY[6] = new Closest.Point(-4, 2);
        pointsY[7] = new Closest.Point(-1, 3);
        pointsY[8] = new Closest.Point(2, 3);
        pointsY[9] = new Closest.Point(-2, 4);
        pointsY[10] = new Closest.Point(4, 4);
        double expected = 1.4142;
        double  result = close.getDistance(points, pointsY, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetDistance() {
        Closest.Point[] points = new Closest.Point[4];
        points[0] = new Closest.Point(0, 0);
        points[1] = new Closest.Point(3, 4);
        points[2] = new Closest.Point(5, 6);
        points[3] = new Closest.Point(7, 2);
        Closest.Point[] pointsY = new Closest.Point[4];
        pointsY[0] = new Closest.Point(0, 0);
        pointsY[1] = new Closest.Point(7, 2);
        pointsY[2] = new Closest.Point(3, 4);
        pointsY[3] = new Closest.Point(5, 6);
        double expected = 2.8284;
        double result = close.getDistance(points, pointsY, 0, points.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GetDistance() {
        Closest.Point[] pointsX = new Closest.Point[6];
        pointsX[0] = new Closest.Point(2, 2);
        pointsX[1] = new Closest.Point(4, 2);
        pointsX[2] = new Closest.Point(4, 7);
        pointsX[3] = new Closest.Point(5, 2);
        pointsX[4] = new Closest.Point(5, 8);
        pointsX[5] = new Closest.Point(8, 5);
        Closest.Point[] pointsY = new Closest.Point[6];
        pointsY[0] = new Closest.Point(2, 2);
        pointsY[1] = new Closest.Point(4, 2);
        pointsY[2] = new Closest.Point(5, 2);
        pointsY[3] = new Closest.Point(8, 5);
        pointsY[4] = new Closest.Point(4, 7);
        pointsY[5] = new Closest.Point(5, 8);
        double expected = 1D;
        double result = close.getDistance(pointsX, pointsY, 0, pointsX.length-1);
        result = Math.round(result * 10000) / 10000D;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }


    @Test
    void testSample1MinimalDistance() {
        int[] x = {0, 3};
        int[] y = {0, 4};
        double expected = 5.0;
        double result = close.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2MinimalDistance() {
        int[] x = {7, 1, 4, 7};
        int[] y = {7, 100, 8, 7};
        double expected = 0.0;
        double result = close.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3MinimalDistance() {
        int[] x = {4, -2, -3, -1, 2, -4, 1, -1, 3, -4, -2};
        int[] y = {4, -2, -4, 3, 3, 0, 1, -1, -1, 2, 4};
        double expected = 1.4142;
        double result = close.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1MinimalDistance() {
        int[] x = {0, 5, 3, 7};
        int[] y = {0, 6, 4, 2};
        double expected = 2.8284;
        double result = close.minimalDistance(x, y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2MinimalDistance() {
        int[] x = {4, 8, 5, 5, 4, 2};
        int[] y = {7, 5, 2, 8, 2, 2};
        double expected = 1D;
        double result = close.minimalDistance(x,y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3MinimalDistance() {
        int[] x = {4, 5, 8, 2, 5, 4};
        int[] y = {7, 1, 5, 2, 7, 2};
        double expected = 1D;
        double result = close.minimalDistance(x,y);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}