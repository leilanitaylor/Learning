package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments3 {

    public static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Point {
        int point, index;

        Point(int point, int index) {
            this.point = point;
            this.index = index;
        }
    }

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Segment[] segments = new Segment[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        int[] count = countSegments(segments, points);
        for (int x : count) {
            System.out.print(x + " ");
        }
    }

    public static int[] countSegments(Segment[] segments, int[] points) {
        int[] countPoints = new int[points.length];

        HashMap<Integer, Integer> segmentIntersections = new HashMap<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (Segment segment : segments) {
            int tempStart = segmentIntersections.getOrDefault(segment.start, 0);
            segmentIntersections.put(segment.start, tempStart + 1);
            int tempEnd = segmentIntersections.getOrDefault(segment.end+1, 0);
            segmentIntersections.put(segment.end+1, tempEnd - 1);
            if (segment.start < minVal)
                minVal = segment.start;
            if (segment.end+1 > maxVal)
                maxVal = segment.end+1;
        }

        /*
        int runningTotal = 0;
        for (int i = minVal; i <= maxVal; i++) {
            runningTotal += segmentIntersections.getOrDefault(i, 0);
            segmentIntersections.put(i, runningTotal);
        }

        for (int i = 0; i < points.length; i++) {
            countPoints[i] = segmentIntersections.getOrDefault(points[i], 0);
        }

         */

        Point[] pointsArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsArray[i] = new Point(points[i], i);
        }

        sortPoints(pointsArray, 0, pointsArray.length-1);

        Point[] coveredPts = new Point[maxVal - minVal + 1];
        int runningTotal = 0;
        for (int i = minVal, j = 0; j < coveredPts.length; i++, j++) {
            runningTotal += segmentIntersections.getOrDefault(i, 0);
            coveredPts[j] = new Point(i, runningTotal);
        }

        int x = 0;
        for (int i = 0; i < pointsArray.length; i++) {
            if (pointsArray[i].point < minVal || pointsArray[i].point > maxVal) {
                countPoints[pointsArray[i].index] = 0;
            } else {
                while (pointsArray[i].point > coveredPts[x].point) {
                    x++;
                }
                if (pointsArray[i].point == coveredPts[x].point) {
                    countPoints[pointsArray[i].index] = coveredPts[x].index;
                }
            }
        }

        return countPoints;
    }

    public static void sortPoints(Point[] points, int left, int right) {
        if (left >= right) return;
        int k = random.nextInt(right - left + 1) + left;
        Point temp = points[left];
        points[left] = points[k];
        points[k] = temp;

        int[] x = partition3(points, left, right);
        sortPoints(points, left, x[0]-1);
        sortPoints(points, x[1]+1, right);
    }

    private static int[] partition3(Point[] points, int left, int right) {
        int a = points[left].point;
        int m1 = left;
        int m2 = partition2(points, left, right);

        for (int i = left; i < m2; i++) {
            if (points[i].point < a) {
                Point temp = points[i];
                points[i] = points[m1];
                points[m1] = temp;
                m1++;
            }
        }

        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(Point[] points, int left, int right) {
        int b = points[left].point;
        int j = left;
        for (int i = left+1; i <= right; i++) {
            if (points[i].point < b) {
                j++;
                Point temp = points[i];
                points[i] = points[j];
                points[j] = temp;
            }
        }

        Point temp = points[left];
        points[left] = points[j];
        points[j] = temp;
        return j;
    }
}
