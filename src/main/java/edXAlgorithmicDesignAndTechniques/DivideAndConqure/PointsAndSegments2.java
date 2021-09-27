package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
reworked PointsAndSegments to reduce temp tables used in order to try to improve runtime
 */

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments2 {

    public static int[] countSegments(Segments[] segments, Points[] points) {
        int[] countPoints = new int[points.length];

        sortSegments(segments, 0, segments.length-1);
        sortPoints(points, 0, points.length-1);

        int count;
        for (int i = 0; i < points.length; i++) {
            if (i > 0 && points[i].point == points[i-1].point) {
                count = countPoints[points[i-1].index];
            } else {
                count = 0;
                int x = points[i].point;
                int j = segments.length - 1;
                while (j >= 0 && x <= segments[j].end) {
                    if (x >= segments[j].start) {
                        count++;
                    }
                    j--;
                }
            }
            countPoints[points[i].index] = count;
        }

        return countPoints;
    }

    private static void sortSegments(Segments[] segments, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        sortSegments(segments, left, mid);
        sortSegments(segments, mid+1, right);
        mergeSeg(segments, left, mid, right);
    }

    public static void mergeSeg(Segments[] segments, int left, int mid, int right) {
        Segments[] segmentLeft = Arrays.copyOfRange(segments, left, mid + 1);
        Segments[] segmentRight = Arrays.copyOfRange(segments, mid+1, right+1);
        int i = 0;
        int j = 0;
        int sortIndex = left;
        while (i < segmentLeft.length && j < segmentRight.length) {
            if (segmentLeft[i].end <= segmentRight[j].end) {
                segments[sortIndex++] = segmentLeft[i++];
            } else {
                segments[sortIndex++] = segmentRight[j++];
            }
        }
        while (i < segmentLeft.length) {
            segments[sortIndex++] = segmentLeft[i++];
        }
        while (j < segmentRight.length) {
            segments[sortIndex++] = segmentRight[j++];
        }
    }

    public static void sortPoints(Points[] points, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        sortPoints(points, left, mid);
        sortPoints(points, mid+1, right);
        mergePts(points, left, mid, right);
    }

    public static void mergePts(Points[] points, int left, int mid, int right) {
        Points[] pointsLeft = Arrays.copyOfRange(points, left, mid+1);
        Points[] pointsRight = Arrays.copyOfRange(points, mid+1, right+1);
        int i = 0;
        int j = 0;
        int sortedIndex = left;
        while (i < pointsLeft.length && j < pointsRight.length) {
            if (pointsLeft[i].point <= pointsRight[j].point) {
                points[sortedIndex++] = pointsLeft[i++];
            } else {
                points[sortedIndex++] = pointsRight[j++];
            }
        }
        while (i < pointsLeft.length) {
            points[sortedIndex++] = pointsLeft[i++];
        }
        while (j < pointsRight.length) {
            points[sortedIndex++] = pointsRight[j++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Segments[] segments = new Segments[n];
        Points[] points = new Points[m];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segments(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            points[i] = new Points(scanner.nextInt(), i);
        }
        int[] count = countSegments(segments, points);
        for (int x : count) {
            System.out.print(x + " ");
        }
    }

    public static class Segments {
        int start, end;

        Segments(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Points {
        int point, index;

        Points(int point, int index) {
            this.point = point;
            this.index = index;
        }
    }
}
