package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
Organizing a Lottery
------------------------------------------------------------------------------------------------
Problem Introduction:
You are organizing an online lottery. To participate, a person bets on a single integer. You
then draw several ranges of consecutive integers at random. A participant's payoff then is
proportional to the number of ranges that contain the participant's number minus the number
of ranges that does not contain it. You need an efficient algorithm for computing the payoffs
for all participants. A naive way to do this is to simply scan, for all participants, the
list of all ranges. However, your lottery is very popular: you have thousands of participants
and thousands of ranges. For this reason, you cannot afford a slow naive algorithm.
-----------------------------------------------------------------------------------------------
Problem Description:
    Task: You are given a set of points on a line and a set of segments on a line. The goal is
        to compute, for each point, the number of segments that contain this point.
    Input Format: The first line contains two non-negative integers s and p defining the number
        of segments and the number of points on a line, respectively. The next s lines contain
        two integers ai, bi defining the i-th segment [ai, bi]. The next line contains p
        integers defining points x1, x2, ... xp.
    Constraints: 1 <= s, p <= 50000; -10^8 <=ai <= bi <= 10^8 for all 0 <= i < s;
        -10^8 <= xj <= 10^8 for all 0 <= j < p.
    Output Format: Output p non-negative integers k0, k1, ..., k(p-1) where ki is the number of
        segments which contain xi. More formally, ki = |{j: aj <= xi <= bj}|

Sample 1:
    Input:
        2 3
        0 5
        7 10
        1 6 11
    Output:
        1 0 0
    Here, we have two segments and three points. The first point lies only in the first segment
    while the remaining two points are outside of all the given segments.

Sample 2:
    Input:
        1 3
        -10 10
        -100 100 0
    Output:
        0 0 1

Sample 3:
    Input:
        3 2
        0 5
        -3 2
        7 10
        1 6
    Output:
        2 0
 */

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    public static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] countPoints = new int[points.length];
        Segment[] segments = new Segment[starts.length];
        for (int i = 0; i < starts.length; i++) {
            segments[i] = new Segment(starts[i], ends[i]);
        }
        //Segment[] sortedSeg = sortedSegments(segments);
        mergeSortSegments(segments, 0, segments.length-1);
        Point[] pointsArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsArray[i] = new Point(points[i], i);
        }
        //Point[] sortedPoints = pointsSort(pointsSeg);
        mergeSortPoints(pointsArray, 0, pointsArray.length-1);

        int count;
        for (int i = 0; i < pointsArray.length; i++) {
            count = 0;
            int x = pointsArray[i].point;
            int j = segments.length-1;
            while (j >= 0 && x <= segments[j].end) {
                if (x >= segments[j].start) {
                    count++;
                }
                j--;
            }
            countPoints[pointsArray[i].index] = count;
        }

        return countPoints;
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

    public static Point[] pointsSort(Point[] pointsSeg) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < pointsSeg.length-1; i++) {
                if (pointsSeg[i].point > pointsSeg[i+1].point) {
                    Point temp = pointsSeg[i];
                    pointsSeg[i] = pointsSeg[i+1];
                    pointsSeg[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return pointsSeg;
    }

    public static void mergeSortSegments(Segment[] segments, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        mergeSortSegments(segments, left, mid);
        mergeSortSegments(segments, mid+1, right);
        mergeSegments(segments, left, mid, right);
    }

    public static void mergeSegments(Segment[] segments, int left, int mid, int right) {
        Segment[] segmentLeft = Arrays.copyOfRange(segments, left, mid+1);
        Segment[] segmentRight = Arrays.copyOfRange(segments, mid+1, right+1);
        Segment[] mergedSegment = new Segment[segmentLeft.length + segmentRight.length];
        int i = 0;
        int j = 0;
        int mergedIndex = 0;
        while (i < segmentLeft.length && j < segmentRight.length) {
            if (segmentLeft[i].end <= segmentRight[j].end) {
                mergedSegment[mergedIndex] = segmentLeft[i];
                mergedIndex++;
                i++;
            } else {
                mergedSegment[mergedIndex] = segmentRight[j];
                mergedIndex++;
                j++;
            }
        }
        if (i < segmentLeft.length) {
            for (int k = i; k < segmentLeft.length; k++) {
                mergedSegment[mergedIndex] = segmentLeft[k];
                mergedIndex++;
            }
        } else {
            for (int k = j; k < segmentRight.length; k++) {
                mergedSegment[mergedIndex] = segmentRight[k];
                mergedIndex++;
            }
        }

        for (int k = left, l = 0; k <= right; k++, l++) {
            segments[k] = mergedSegment[l];
        }
    }

    public static void mergeSortPoints(Point[] pointsArray, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        mergeSortPoints(pointsArray, left, mid);
        mergeSortPoints(pointsArray, mid+1, right);
        mergePoints(pointsArray, left, mid, right);
    }

    public static void mergePoints(Point[] pointsArray, int left, int mid, int right) {
        Point[] pointsLeft = Arrays.copyOfRange(pointsArray, left, mid+1);
        Point[] pointsRight = Arrays.copyOfRange(pointsArray, mid+1, right+1);
        Point[] sortedPoints = new Point[pointsLeft.length + pointsRight.length];
        int i =0;
        int j = 0;
        int sortedIndex = 0;
        while(i < pointsLeft.length && j < pointsRight.length) {
            if (pointsLeft[i].point <= pointsRight[j].point) {
                sortedPoints[sortedIndex] = pointsLeft[i];
                sortedIndex++;
                i++;
            } else {
                sortedPoints[sortedIndex] = pointsRight[j];
                sortedIndex++;
                j++;
            }
        }
        if (i < pointsLeft.length) {
            for (int k = j; k < pointsLeft.length; k++) {
                sortedPoints[sortedIndex] = pointsLeft[k];
                sortedIndex++;
            }
        }
        if (j < pointsRight.length) {
            for (int k = j; k < pointsRight.length; k++) {
                sortedPoints[sortedIndex] = pointsRight[k];
                sortedIndex++;
            }
        }

        for (int k = left, l = 0; k <= right; k++, l++) {
            pointsArray[k] = sortedPoints[l];
        }
    }

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

    public static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] count = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        // use fastCountSegments
        int[] count = naiveCountSegments(starts, ends, points);
        for (int x: count) {
            System.out.print(x + " ");
        }
    }
}
