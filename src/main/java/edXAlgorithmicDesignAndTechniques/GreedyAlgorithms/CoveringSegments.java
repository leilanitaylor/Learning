package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;
/*
Collecting Signatures
--------------------------------------------------------------------------------------------
Problem Introduction:
You are responsible for collecting signatures from all tenants of a certain building. For
each tenant, you know a  period of time when he or she is at home. You would like to collect
all signatures by visiting the building as few times as possible.
The mathematical model for this problem is the following. You are  give a set of segments on
a line and your goal is to mark as few points on a line as possible so that each segment
contains at least  one marked point.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Given a set of n segments {[a0, b0], [a1, b1], ..., [a(n-1), b(n-1)]} with integer
        coordinates on a line, find the minimum number m of points such that each segment
        contains at least one point. That is, find a set of integers X of the minimum size
        such that for any segment [ai, bi] there is a point x (contained in) X such that
        ai <= x <= bi.
    Input Format: The first line of the input contains the number n of segments. each of the
        following n lines contains two integers ai and bi (separated by a space) defining
        the coordinates of endpoints of the i-th segment.
    Constraints: 1 <= n <= 100; 0 <= ai <= bi <= 10^9 for all 0 <= i <= n.
    Output Format: Output the minimum number m of points on the first line and the integer
        coordinates of m points (separated by spaces) on teh second line. You can output the
        points in any order. If there are many such sets of points, you can output any set.
        (It is not difficult to see that there always exists a set of points of the minimum
        size such that all the coordinates of the points are integers.)

Sample 1:
    Input:
        3
        1 3
        2 5
        3 6
    Output:
        1
        3
    In this sample, we have three segments: [1, 3], [2, 5], [3, 6] (of length 2, 3, 3
        respectively.) All of them contain the point with coordinate 3: 1 <= 3 <= 3,
        2 <= 3 <= 5, 3 <= 3 <= 6.

Sample 2:
    Input:
        4
        4 7
        1 3
        2 5
        5 6
     Output:
        2
        3 6
     The second and third segments contain the point with coordinate 3 while the first and
     fourth segments contain the point with coordinate 6. All the four segments cannot be
     covered by a single point, since the segments [1, 3] and [5, 6] are disjoint.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    public static int[] optimalPoints(Segment[] segments) {
        List<Integer> pointsList = new ArrayList<>();
        //int[] points = new int[2 * segments.length];
        Segment[] sortedSeg = sortedSegments(segments);
        int point = sortedSeg[0].end;
        pointsList.add(point);
        for (int i = 1; i < sortedSeg.length; i++) {
            if (point < sortedSeg[i].start || point > sortedSeg[i].end) {
                point = sortedSeg[i].end;
                pointsList.add(point);
            }

            /*
            System.out.println(segments[i].start + " " + segments[i].end);
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;

             */
        }
        int[] points = new int[pointsList.size()];
        //System.out.println("PointsList size: " + pointsList.size());
        for (int i = 0; i < points.length; i++) {
            points[i] = pointsList.get(i);
        }
        //System.out.println(Arrays.toString(points));
        return points;
    }

    public static Segment[] sortedSegments(Segment[] segments) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < segments.length - 1; i++) {
                if (segments[i].end > segments[i+1].end) {
                    Segment temp = segments[i];
                    segments[i] = segments[i+1];
                    segments[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return segments;
    }

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
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.println(point + " ");
        }
    }
}
