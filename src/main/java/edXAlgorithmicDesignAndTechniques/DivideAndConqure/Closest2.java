package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Closest2 {

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    private static Random random = new Random();

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);

        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }

        System.out.println(minimalDistance(x, y));;
        writer.close();
    }

    static class Point implements Comparable<Point> {
        Long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            //return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
            return this.y.compareTo(o.y);
        }

        @Override
        public boolean equals(Object o) {
            Point obj = (Point)o;
            return this.y.equals(obj.y);
        }
    }

    static double minimalDistance(int[] x, int[] y) {

        // convert arrays of x coordinates and y coordinates into a single array of objects Point that pairs them together
        Point[] pointsX = convertPtsToSingleArray(x, y);
        Point[] pointsY = Arrays.copyOfRange(pointsX, 0, pointsX.length);

        // sort the pointsX according to x values
        xSortPoints(pointsX, 0, pointsX.length-1);
        
        // sort the pointsY according to y values
        //ySortPoints(pointsY, 0, pointsY.length-1);
        Arrays.sort(pointsY);
        
        double distance = getDistance(pointsX, pointsY, 0, pointsX.length-1);

        // round to four decimal points
        double minDistance = Math.round(distance * 10000) / 10000D;

        return minDistance;
    }

    public static double getDistance(Point[] pointsX, Point[] pointsY, int left, int right) {
        // base case: if less than three points, use brute force to find minimal distance
        if (right - left < 3) {
            return bruteForce(pointsX, left, right);
        }

        // find the mid-point of the array
        int mid = ((right - left) / 2) + left;

        // find the point at the mid-point of the x-sorted array
        Point midPoint = pointsX[mid];

        // Divide points in the y sorted array around the vertical line of the midpoint
        List<Point[]> yPoints = splitPointsY(pointsY, midPoint, left, right);

        // consider the vertical line passing through the mid-point, calculate the smallest distance distLeft
        // on left of mid-point and distRight on right side
        double distLeft = getDistance(pointsX, yPoints.get(0), left, mid);
        double distRight = getDistance(pointsX, yPoints.get(1), mid+1, right);

        // find min distance
        double minDist = Math.min(distLeft, distRight);

        // create a list of additional points to check: ones whose x value is within the current min distance of
        // the midline it is possible that these are within a smaller distance to a point in the other half than
        // the current min distance
        List<Point> ptsToCheck = findPtsToCheck(pointsY, midPoint, minDist);

        // find the closest points in the middle strip we just created
        minDist = stripClosest(ptsToCheck, minDist);

        return minDist;
    }

    private static List<Point[]> splitPointsY(Point[] pointsY, Point midPoint, int left, int right) {
        // Divide points in the y sorted array around the vertical line of the midpoint
        List<Point[]> yPoints = new ArrayList<>();
        Point[] pointsYLeft = new Point[((right - left) / 2) + 1];
        Point[] pointsYRight = new Point[pointsY.length - pointsYLeft.length];
        // indices of the left and right subarrays
        int leftLength = pointsYLeft.length;
        int rightLength = pointsYRight.length;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < pointsY.length; index++) {
            if (pointsY[index].x < midPoint.x || (pointsY[index].x == midPoint.x && pointsY[index].y <= midPoint.y)) {
                pointsYLeft[leftIndex++] = pointsY[index];
            } else {
                pointsYRight[rightIndex++] = pointsY[index];
            }
        }
        yPoints.add(pointsYLeft);
        yPoints.add(pointsYRight);
        return yPoints;
    }

    public static double stripClosest(List<Point> ptsToCheck, double minDist) {
        for (int firstIndex = 0; firstIndex < ptsToCheck.size()-1; firstIndex++) {
            for (int secondIndex = firstIndex+1; secondIndex < ptsToCheck.size(); secondIndex++) {
                if (ptsToCheck.get(secondIndex).y - ptsToCheck.get(firstIndex).y < minDist) {
                    double distance = dist(ptsToCheck.get(firstIndex), ptsToCheck.get(secondIndex));
                    minDist = Math.min(minDist, distance);
                }
            }
        }
        return minDist;
    }

    public static List<Point> findPtsToCheck(Point[] pointsY, Point midPoint, double minDist) {
        List<Point> ptsToCheck = new ArrayList<>();

        for (int index = 0; index < pointsY.length; index++) {
            if (Math.abs(pointsY[index].x - midPoint.x) < minDist) {
                ptsToCheck.add(pointsY[index]);
            }
        }
        return ptsToCheck;
    }

    public static double bruteForce(Point[] pointsX, int left, int right) {
        double min = Double.POSITIVE_INFINITY;

        // iterate through points array
        for (int firstIndex = left; firstIndex < right; firstIndex++) {
            // iterate through remaining point of the array
            for (int secondIndex = firstIndex+1; secondIndex <= right; secondIndex++) {
                // calculate the distance between two given points
                double distance = dist(pointsX[firstIndex], pointsX[secondIndex]);
                // if new calculation is less than current min, set min to current distance
                min = Math.min(min, distance);
            }
        }
        return min;
    }

    public static double dist(Point a, Point b) {
        double diffX = (double)a.x - (double)b.x;
        double diffY = (double)a.y - (double)b.y;
        double xDiffSq = Math.pow(diffX, 2);
        double yDiffSq = Math.pow(diffY, 2);
        double distance = Math.sqrt(xDiffSq + yDiffSq);
        return distance;
    }

    public static void xSortPoints(Point[] pointsX, int left, int right) {
        // base case
        if (left >= right) return;

        // find mid-point
        int mid = ((right - left) / 2) + left;

        // recursively sort the left half of the array
        xSortPoints(pointsX, left, mid);
        // recursively sort the right half of the array
        xSortPoints(pointsX, mid+1, right);

        // merge the sorted arrays
        xMergePoints(pointsX, left, mid, right);
    }

    private static void xMergePoints(Point[] pointsX, int left, int mid, int right) {
        // create temp array of the left half of array
        Point[] pointsLeft = Arrays.copyOfRange(pointsX, left, mid+1);
        // create temp array of the right half of array
        Point[] pointsRight = Arrays.copyOfRange(pointsX, mid+1, right+1);

        // current index to evaluate of the left array and right array
        int leftIndex = 0;
        int rightIndex = 0;

        // index in the original array to place sorted value at
        int sortIndex = left;

        // while not at the end of both temp arrays:
        while (leftIndex < pointsLeft.length && rightIndex < pointsRight.length) {
            // if the value of the current index of the left array is less than the value at the current
            // index of the right array, insert at given (sorted) index in the original array
            if (pointsLeft[leftIndex].x < pointsRight[rightIndex].x) {
                pointsX[sortIndex++] = pointsLeft[leftIndex++];
            } // if x left and x right equal, if y left less than y right, insert into sorted array
            else if (pointsLeft[leftIndex].x == pointsRight[rightIndex].x && pointsLeft[leftIndex].y < pointsRight[rightIndex].y) {
                pointsX[sortIndex++] = pointsLeft[leftIndex++];
            } // otherwise, insert the right array value at sorted index in original array 
            else {
                pointsX[sortIndex++] = pointsRight[rightIndex++];
            }
        }
        
        // if at end of right temp array and left temp still has values, insert remaining values into sorted indices
        while (leftIndex < pointsLeft.length) {
            pointsX[sortIndex++] = pointsLeft[leftIndex++];
        }
        
        // if at end of left temp array and right temp still has values, insert remaining values into sorted indices
        while(rightIndex < pointsRight.length) {
            pointsX[sortIndex++] = pointsRight[rightIndex++];
        }
    }

    public static Point[] convertPtsToSingleArray(int[] x, int[] y) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        return points;
    }

}
