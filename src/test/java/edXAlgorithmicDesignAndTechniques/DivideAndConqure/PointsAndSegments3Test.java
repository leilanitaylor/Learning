package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.Segment;


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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
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
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }



    @Test
    void test5CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {10, 3, -100, 3, -7, 25, 70};
        int[] expected = {2, 2, 0, 2, 1, 1, 0};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test6CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {1};
        int[] expected = {2};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test7CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {50};
        int[] expected = {1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test8CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {-10};
        int[] expected = {1};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test9CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {-20};
        int[] expected = {0};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test10CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(-10, 10);
        segments[1] = new PointsAndSegments3.Segment(0, 5);
        segments[2] = new PointsAndSegments3.Segment(10, 50);
        int[] points = {75};
        int[] expected = {0};
        int[] result = ps.countSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void test11CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[1];
        segments[0] = new PointsAndSegments3.Segment(1, 1);
        int[] points = {-10, 1, 15};
        int[] expected = {0, 1, 0};
        int[] result = ps.countSegments(segments, points);
        int[] naive = naiveCountSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
            Assertions.assertEquals(naive[i], result[i]);
        }
    }

    @Test
    void test12CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(1, 3);
        segments[1] = new PointsAndSegments3.Segment(2, 2);
        segments[2] = new PointsAndSegments3.Segment(1, 3);
        int[] points = {-10, 3, 5, 2, 3, 4};
        int[] expected = {0, 2, 0, 3, 2, 0};
        int[] result = ps.countSegments(segments, points);
        int[] naive = naiveCountSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        Assertions.assertEquals(naive.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
            Assertions.assertEquals(naive[i], result[i]);
            Assertions.assertTrue(result[i] >= 0 && result[i] <= 50000);
        }
    }

    @Test
    void test14CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[3];
        segments[0] = new PointsAndSegments3.Segment(0, 0);
        segments[1] = new PointsAndSegments3.Segment(1, 1);
        segments[2] = new PointsAndSegments3.Segment(2, 2);
        int[] points = {-1, 0, 1, 2, 3};
        int[] expected = {0, 1, 1, 1, 0};
        int[] result = ps.countSegments(segments, points);
        int[] naive = naiveCountSegments(segments, points);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(points.length, result.length);
        Assertions.assertEquals(naive.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
            Assertions.assertEquals(naive[i], result[i]);
            Assertions.assertTrue(result[i] >= 0 && result[i] <= 50000);
        }
    }

    @Test
    void test13CountSegments() {
        int numTests = 50000;
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[numTests];
        int[] points = new int[numTests];
        for (int i = 0; i < numTests; i++) {
            int a = (int)(Math.random() * 10000000);
            int b = (int)(Math.random() * (10000000 - a)) + a;
            a -= 5000000;
            b -= 5000000;
            Assertions.assertTrue(b >=a);
            segments[i] = new PointsAndSegments3.Segment(a, b);
            int point = (int)(Math.random() * 10000000);
            point -= 5000000;
            points[i] = point;
        }
        int[] result = ps.countSegments(segments, points);
        int[] naive = naiveCountSegments(segments, points);
        Assertions.assertEquals(naive.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(naive);
            Assertions.assertEquals(naive[i], result[i]);
            Assertions.assertTrue(result[i] >= 0 && result[i] <= 50000);
        }
    }

    @Test
    void test15CountSegments() {
        PointsAndSegments3.Segment[] segments = new PointsAndSegments3.Segment[5];
        segments[0] = new PointsAndSegments3.Segment(-100000000, 100000000);
        segments[1] = new PointsAndSegments3.Segment(-50000, 60000);
        segments[2] = new PointsAndSegments3.Segment(-100000000, -100000000);
        segments[3] = new PointsAndSegments3.Segment(0, 0);
        segments[4] = new PointsAndSegments3.Segment(100000000, 100000000);
        int[] points = {-100000000, -50000, -100, 0, 500, 600000, 70000, 100000000};
        int[] result = ps.countSegments(segments, points);
        int[] naive = naiveCountSegments(segments, points);
        Assertions.assertEquals(naive.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertNotNull(result);
            Assertions.assertNotNull(naive);
            Assertions.assertEquals(naive[i], result[i]);
            Assertions.assertTrue(result[i] >= 0 && result[i] <= 50000);
        }
    }


    private static int[] naiveCountSegments(PointsAndSegments3.Segment[] segments, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < segments.length; j++) {
                if (segments[j].start <= points[i] && points[i] <= segments[j].end) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
}