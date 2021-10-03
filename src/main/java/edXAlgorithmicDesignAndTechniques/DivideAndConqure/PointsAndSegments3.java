package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments3 {

    public static class Segment {
        // object to hold start and end point of a given segment
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Point {
        // object to pair a given point with its index in the original points array
        int point, index;

        Point(int point, int index) {
            this.point = point;
            this.index = index;
        }
    }

    public static class Coverage {
        // object to keep track of how many segments cover a given point
        int point, numSegments;

        Coverage(int point, int runningTotal) {
            this.point = point;
            this.numSegments = runningTotal;
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
        // create int array to hold answer
        int[] countPoints = new int[points.length];

        HashMap<Integer, Integer> segmentIntersections = new HashMap<>();
        // create min and max value to keep track of range of segments coverage
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // create hash map to indicate when running total should be increased or decreased
        // based on start/end points of segments
        for (Segment segment : segments) {
            // get current value of key (start point), or set to 0 if doesn't currently exist
            int tempStart = segmentIntersections.getOrDefault(segment.start, 0);
            // increase value at start point of segment (will increase running total in next step)
            segmentIntersections.put(segment.start, tempStart + 1);
            // get current value of key (end point + 1), or set to 0 if it doesn't currently exist
            // using end+1 as key because we don't want to decrease the running total until after the end of the segment
            int tempEnd = segmentIntersections.getOrDefault(segment.end+1, 0);
            // decrease the value at one past end point of segment (will decrease running total in next step)
            segmentIntersections.put(segment.end+1, tempEnd - 1);
            // check start point is within current range or set min value to start point if not
            if (segment.start < minVal)
                minVal = segment.start;
            // check end point is within current range of set max value to end point if not
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

        // convert points (int array) into a Point array to be able to sort the points
        // while keeping tack of the index of that point in the original points array
        Point[] pointsArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsArray[i] = new Point(points[i], i);
        }

        // sort the points for more efficient comparison to the covered segments array
        sortPoints(pointsArray, 0, pointsArray.length-1);

        // create a Coverage array to build running total how many segments cover a given
        // point within the total range of the segments
        Coverage[] coveredPts = new Coverage[maxVal - minVal + 1];
        // keep track of how many segments currently cover a point
        int runningTotal = 0;

        // iterate through range of segment coverage
        // i is value of the point, j is the index in the coveredPts array
        for (int i = minVal, j = 0; j < coveredPts.length; i++, j++) {
            // use hash map values at given point to increase or decrease running total
            // as necessary
            runningTotal += segmentIntersections.getOrDefault(i, 0);
            coveredPts[j] = new Coverage(i, runningTotal);
        }

        int coveredPtsIndex = 0;
        // iterate through all the points
        for (int i = 0; i < pointsArray.length; i++) {
            // if the point is less than the minVal or greater than the maxVal, it is outside
            // of the range of points covered by ANY segment, so it must be 0
            if (pointsArray[i].point < minVal || pointsArray[i].point > maxVal) {
                countPoints[pointsArray[i].index] = 0;
            } else {
                // if the current point in the points array is greater than the current point in
                // the coveredPts array, increase the index of the coveredPts array to check the
                // next covered point
                while (pointsArray[i].point > coveredPts[coveredPtsIndex].point) {
                    coveredPtsIndex++;
                }
                // if the current point in the points array equals the current point in the
                // coveredPts array, place the number of segments calculated from the running
                // total into the countPoints array (answer) at the index of the point in the
                // original points array
                if (pointsArray[i].point == coveredPts[coveredPtsIndex].point) {
                    countPoints[pointsArray[i].index] = coveredPts[coveredPtsIndex].numSegments;
                }
            }
        }

        // return countPoints as final answer
        return countPoints;
    }

    public static void sortPoints(Point[] points, int left, int right) {
        if (left >= right) return;
        // select a random element within the index range to swap with the first element
        int k = random.nextInt(right - left + 1) + left;
        // swap the point at the given index with the first element
        Point temp = points[left];
        points[left] = points[k];
        points[k] = temp;

        // use first element and sort into 3 partitions, less than the first element, equal to the first element
        // and greater than the first element.
        // int[] x should be two integers, the first is the index of the first element in this sorting that is
        // equal to the (formerly) first element, and the second is the index of the sorted list that is equal
        // to the (formerly) first element.
        int[] x = partition3(points, left, right);
        // sort the elements that were less than the element already checked against
        sortPoints(points, left, x[0]-1);
        // sort the elements that were greater than the element already checked against
        sortPoints(points, x[1]+1, right);
    }

    private static int[] partition3(Point[] points, int left, int right) {
        // point to be checked against
        int targetValue = points[left].point;
        // index of first occurrence of target value in partitioned list
        int m1 = left;
        // index of last occurrence of target value in the partitioned list, found using standard quicksort method
        int m2 = partition2(points, left, right);

        // iterate through all points to the left of the index of the checked value (which is now in its final position)
        // move all values less than target value to the left of m1, which should be the index of first point equal
        // to the target value
        for (int i = left; i < m2; i++) {
            if (points[i].point < targetValue) {
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
        // target value is set to first element of array, all values are checked against this and sorted
        int targetValue = points[left].point;
        // final index of where in the array the target value should be placed
        int finalIndexOfTargetValue = left;
        // iterate through all points in the array
        for (int i = left+1; i <= right; i++) {
            // check if the current point is less than the target value
            if (points[i].point < targetValue) {
                // increase the final index, we know that the current point should be to the left of the target value
                finalIndexOfTargetValue++;
                // swap the location of the current point and the point at the current final index
                Point temp = points[i];
                points[i] = points[finalIndexOfTargetValue];
                points[finalIndexOfTargetValue] = temp;
            }
        }

        // place the target value in its final location by swapping with the element currently at the final index
        Point temp = points[left];
        points[left] = points[finalIndexOfTargetValue];
        points[finalIndexOfTargetValue] = temp;
        // return the final index, as this will be the right end of our partition (last index of target value)
        return finalIndexOfTargetValue;
    }
}



