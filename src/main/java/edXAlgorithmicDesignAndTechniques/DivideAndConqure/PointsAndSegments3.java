package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PointsAndSegments3 {

    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static class Segment {
        // object to hold start and end point of a given segment
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Point implements Comparable<Point> {
        // object to pair a given point with its index in the original points array
        Integer point, index;

        Point(Integer point, Integer index) {
            this.point = point;
            this.index = index;
        }

        @Override
        public int compareTo(Point obj) {
            return this.point.compareTo(obj.point);
        }

        @Override
        public boolean equals(Object obj) {
            Point compareObj = (Point)obj;
            return this.point.equals(compareObj.point);
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

        HashMap<Integer, Integer> segmentIntersections = createIntersections(segments);

        // create a Coverage array to build running total how many segments cover a given
        // point within the total range of the segments
        Coverage[] coveredPts = calculateCoverage(segmentIntersections);
        //Coverage[] coveredPts = new Coverage[maxVal - minVal + 1];


        // convert points (int array) into a Point array to be able to sort the points
        // while keeping tack of the index of that point in the original points array
        Point[] pointsArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsArray[i] = new Point(points[i], i);
        }

        // sort the points for more efficient comparison to the covered segments array
        //sortPoints(pointsArray, 0, pointsArray.length-1);
        Arrays.sort(pointsArray);


        int[] countPoints = buildCountPoints(coveredPts, pointsArray);

        // return countPoints as final answer
        return countPoints;
    }

    private static int[] buildCountPoints(Coverage[] coveredPts, Point[] pointsArray) {
        int[] countPoints = new int[pointsArray.length];
        int coveredPtsIndex = 0;
        // iterate through all the points
        for (int i = 0; i < pointsArray.length; i++) {
            // if the point is less than the minVal or greater than the maxVal, it is outside
            // of the range of points covered by ANY segment, so it must be 0
            if (pointsArray[i].point < minVal || pointsArray[i].point >= maxVal) {
                countPoints[pointsArray[i].index] = 0;
            } else {
                while (pointsArray[i].point > coveredPts[coveredPtsIndex].point && coveredPtsIndex < coveredPts.length) {
                    coveredPtsIndex++;
                }
                if (pointsArray[i].point < coveredPts[coveredPtsIndex].point) {
                    if (coveredPtsIndex == 0)
                        countPoints[pointsArray[i].index] = 0;
                    else {
                        countPoints[pointsArray[i].index] = coveredPts[coveredPtsIndex - 1].numSegments;
                    }
                }
                else if (pointsArray[i].point == coveredPts[coveredPtsIndex].point) {
                    countPoints[pointsArray[i].index] = coveredPts[coveredPtsIndex].numSegments;
                } else {

                }
            }
        }
        return countPoints;
    }

    private static Coverage[] calculateCoverage(HashMap<Integer, Integer> segmentIntersections) {

        List<Integer> sortedSegPts = segmentIntersections.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        // keep track of how many segments currently cover a point

        Coverage[] coveredPts = new Coverage[sortedSegPts.size()];
        int runningTotal = 0;

        // iterate through range of segment coverage
        // i is value of the point, j is the index in the coveredPts array
        for (int i = 0; i < coveredPts.length; i++) {
            // use hash map values at given point to increase or decrease running total
            // as necessary
            runningTotal += segmentIntersections.get(sortedSegPts.get(i));
            coveredPts[i] = new Coverage(sortedSegPts.get(i), runningTotal);
        }
        return coveredPts;
    }

    public static HashMap<Integer, Integer> createIntersections(Segment[] segments) {
        HashMap<Integer, Integer> segmentIntersections = new HashMap<>();
        // create min and max value to keep track of range of segments coverage

        // create hash map to indicate when running total should be increased or decreased
        // based on start/end points of segments
        for (Segment segment : segments) {
            // get current value of key (start point), or set to 0 if doesn't currently exist
            int tempStart = segmentIntersections.getOrDefault(segment.start, 0);
            // increase value at start point of segment (will increase running total in next step)
            segmentIntersections.put(segment.start, tempStart + 1);
            // get current value of key (end point + 1), or set to 0 if it doesn't currently exist
            // using end+1 as key because we don't want to decrease the running total until after the end of the segment
            int tempEnd = segmentIntersections.getOrDefault(segment.end + 1, 0);
            // decrease the value at one past end point of segment (will decrease running total in next step)
            segmentIntersections.put(segment.end + 1, tempEnd - 1);
            // check start point is within current range or set min value to start point if not
            if (segment.start < minVal)
                minVal = segment.start;
            // check end point is within current range of set max value to end point if not
            if (segment.end + 1 > maxVal)
                maxVal = segment.end + 1;
        }
        return segmentIntersections;
    }
}



