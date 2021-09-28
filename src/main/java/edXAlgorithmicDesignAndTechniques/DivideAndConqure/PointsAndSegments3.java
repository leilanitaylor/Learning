package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.util.HashMap;
import java.util.Scanner;

public class PointsAndSegments3 {

    public static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

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

        int runningTotal = 0;
        for (int i = minVal; i <= maxVal; i++) {
            runningTotal += segmentIntersections.getOrDefault(i, 0);
            segmentIntersections.put(i, runningTotal);
        }

        for (int i = 0; i < points.length; i++) {
            countPoints[i] = segmentIntersections.getOrDefault(points[i], 0);
        }

        return countPoints;
    }
}
