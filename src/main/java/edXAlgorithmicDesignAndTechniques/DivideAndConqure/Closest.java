package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
Finding the Closest Pair of Points
--------------------------------------------------------------------------------------------
Problem Introduction:
In this problem, your goal is to find the closest pair of points among the give n points.
This is a basic primitive in computations geometry having applications in, for example
graphics, computer vision, traffic-control systems.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Given n points on a plane, find the smallest distance between a pair of two
        (different) points. Recall that the distance between two points (x1, y1) and
        (x2, y2) is equal to ((x1 - x2)^2 + (y1-y2)^2)^(1/2).
    Input Format: The first line contains the number n of points. Each of the following n
        lines defines a point (xi, yi).
    Constraints: x <= n <= 10^5; =10^9 <= xi, yi <= 10^9 are integers.
    Output Format: Output the minimum distance. The absolute value of the difference between
        the answer of your program and the optimal value should be at most 10^-3. To ensure
        this, output your answer with at least four digits after the decimal point
        (otherwise your answer, while being computed correctly, can turn out to be wrong
        because of rounding issues).

Sample 1:
    Input:
        2
        0 0
        3 0
    Output:
        5.0
    There are only two points here. This distance between them is 5.

Sample 2:
    Input:
        4
        7 7
        1 100
        4 8
        7 7
    Output:
        0.0
   There are two coinciding points among the four given points. Thus the minimum distance
   is zero.

Sample 3:
    Input:
        11
        4 4
        -2 -2
        -3 -4
        -1 3
        2 3
        -4 0
        1 1
        -1 -1
        3 -1
        -4 2
        -2 4
    Output:
        1.414213
    The smallest distance is 2^(1/2). There are two pairs of points at this distance:
    (-1, -1) and (-2, -2); (-2, 4) and (-1, 3).

What To Do:
This computational geometry problem has many applications in computer graphics and vision. A
naive algorithm with quadratic running time iterates through all pairs of points to find the
closest pair. Your goal is to design an O(nlogn) time divide and conquer algorithm.
To solve this problem in time O(nlogn), lets first split the given n points by an
appropriately chosen vertical line into two halves S1 and S2 of size n/2 (assume for
simplicity that all x-coordinates of the input points are different). By making two
recursive calls for the sets S1 and S2, we find the minimum distances d1 and d2 in these
subsets. Let d = min{d1, d2}.
It remains to check whether there exists points p1 contained in S1 and p2 contained in S2
such that the distance between them is smaller than d. We cannot afford to check all
possible such pairs since there are n/2 * n/2 = O(n^2) of them. To check this faster, we
first discard all points from S1 and S2 whose x-distance to the middle line is greater than
d. That is, we focus on the following strip:
Stop and think: Why can we narrow the search to this strip? Now, let's sort the points of
the strip by their y-coordinates and denote the resulting sorted list by P = |p1, ..., pk|.
It turns out that if |i-j| > 7, then the distance between points pi and pj is greater than
d for sure. This follows from te Exercise break below.
Exercise break: Partition the strip into d x d squares as shown below and show that each
such square contains at most four input points.
This results in the following algorithm. We first sort the given n points by their
x-coordinates and then split the resulting sorted list into two halves s1 and S2 of size
n/2. By making a recursive call for each of the sets S1 and S2, we find the minimum distance
d1 and d2 in them. Let d = min{d1, d2}. however, we are not done yet as we also need to find
the minimum distance between points from different sets (i.e. a point from S1 and a point
from S2) and check whether it is smaller than d. To perform such a check, we filter the
initial point set and keep only those points whose x-distance to the middle line does not
exceed d. Afterward, we sort the set of points in the resulting strip by their y-coordinates
and scan the resulting list of points. For each pint, we compute its distance to the seven
subsequent points in this list and compute d', the minimum distance that we encountered
during this scan. Afterwards, we return min{d, d'}.
The running time of the algoritm satisfies the recurrence relation:
    T(n) = 2 * T(n/2) + O(nlogn)
The O(nlogn) term comes from sorting the points in teh strip by their y-coordinates at
every iteration.
    Exercise break: Prove that T(n) = O(nlog^2(n)) by analyzing the recursion tree of the
        algorithm
    Exercise break: Show how to bringthe running time down to O(nlogn) by avoiding sorting
        at each recursive call.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Closest {

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

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int[] y) {

        // convert arrays of x coordinates and y coordinates into a single array of objects Point that that pairs them together
        Point[] pointsX = new Point[x.length];
        Point[] pointsY = new Point[y.length];
        for (int index = 0; index < x.length; index++) {
            pointsX[index] = new Point(x[index], y[index]);
            pointsY[index] = new Point(x[index], y[index]);
        }

        // sort the pointsX according to the x values
        xSortPoints(pointsX, 0, pointsX.length-1);

        // sort the pointsY according to the y values
        ySortPoints(pointsY, 0, pointsY.length-1);

        double distance = getDistance(pointsX, pointsY, 0, pointsX.length-1);

        // round to four decimal points
        double minDistance = Math.round(distance * 10000) / 10000D;

        return minDistance;
    }


    public static void xSortPoints(Point[] points, int left, int right) {
        // base case
        if (left >= right) return;

        // find mid-point
        int mid = ((right - left) / 2) + left;

        // recursively sort the left half of the array
        xSortPoints(points, left, mid);
        // recursively sort the right half of the array
        xSortPoints(points, mid+1, right);

        // merge the sorted arrays
        xMergePoints(points, left, mid, right);
    }

    private static void xMergePoints(Point[] points, int left, int mid, int right) {
        // create temp array of the left half of array
        Point[] pointsLeft = Arrays.copyOfRange(points, left, mid+1);
        // create temp array of the right half of the array
        Point[] pointsRight = Arrays.copyOfRange(points, mid+1, right+1);

        // current index to evaluate of the left array and right array
        int leftIndex = 0;
        int rightIndex = 0;

        // index in the original array to place sorted value at
        int sortIndex = left;

        // while not at the end of both temp arrays:
        while (leftIndex < pointsLeft.length && rightIndex < pointsRight.length) {
            // if the value at the current index of the left array is less than the value at the current index of
            // the right array, insert at given (sorted) index in the original array
            if (pointsLeft[leftIndex].x < pointsRight[rightIndex].x) {
                points[sortIndex++] = pointsLeft[leftIndex++];
            } else if (pointsLeft[leftIndex].x == pointsRight[rightIndex].x && pointsLeft[leftIndex].y < pointsRight[rightIndex].y){ // if x left and x right equal, if y left less than y right, insert into sorted array
                points[sortIndex++] = pointsLeft[leftIndex++];
            } else { // otherwise, insert the right array value at sorted index in original array
                points[sortIndex++] = pointsRight[rightIndex++];
            }
        }

        // if at end of right temp array and left temp still has values, insert remaining values into sorted indices
        while (leftIndex < pointsLeft.length) {
            points[sortIndex++] = pointsLeft[leftIndex++];
        }

        // if at end of left temp array and right temp still has values, insert remaining values into sorted indices
        while (rightIndex < pointsRight.length) {
            points[sortIndex++] = pointsRight[rightIndex++];
        }
    }



    /*
    public static void xSortPoints(Point[] pointsX, int left, int right) {
        // base case
        if (left >= right) return;

        // select random point to swap with the first (left) element and swap
        int rand = random.nextInt(right - left) + left;
        Point temp = pointsX[left];
        pointsX[left] = pointsX[rand];
        pointsX[rand] = temp;

        // use first element to sort into 3 partitions, less than the first element, equal to the first element
        // and greater than the first element.
        // int[] partition should be two integers, the index of the first occurrence of the target element
        // in this sorting, the second is the index of the last occurrence of the target element in the sorted list
        int[] partition = partition3x(pointsX, left, right);

        // sort the elements that were less than the target element
        xSortPoints(pointsX, left, partition[0]-1);
        // sort the elements that were greater than the target element
        xSortPoints(pointsX, partition[1]+1, right);
    }

    private static int[] partition3x(Point[] pointsX, int left, int right) {
        // x value of the point to be checked against
        double xTargetValue = pointsX[left].x;

        // index of the first occurrence of the target value in partitioned list
        int m1 = left;
        // index of the last occurrence of target value in the partitioned list
        int m2 = left;

        // iterate through all point sto place all values equal to target value in final position,
        // moving values less than target to left of m1
        for (int index = left+1; index <= right; index++) {
            if (pointsX[index].x < xTargetValue) {
                Point temp = pointsX[index];
                pointsX[index] = pointsX[++m2];
                pointsX[m2] = pointsX[m1];
                pointsX[m1++] = temp;
            } else if (pointsX[index].x == xTargetValue) {
                Point temp = pointsX[index];
                pointsX[index] = pointsX[++m2];
                pointsX[m2] = temp;
            }
        }

        if (m2 - m1 > 0) {
            ySortPoints(pointsX, m1, m2);
        }

        int[] partition = {m1, m2};
        return partition;
    }

     */

    public static void ySortPoints(Point[] pointsY, int left, int right) {
        // base case
        if (left >= right) return;

        // find mid-point
        int mid = ((right - left) / 2) + left;

        // recursively sort the left half of the array
        ySortPoints(pointsY, left, mid);
        // recursively sort the right half of the array
        ySortPoints(pointsY, mid+1, right);

        // merge the sorted arrays
        yMergePoints(pointsY, left, mid, right);
    }

    private static void yMergePoints(Point[] pointsY, int left, int mid, int right) {
        // create temp array of the left half of array
        Point[] pointsLeftY = Arrays.copyOfRange(pointsY, left, mid+1);
        // create temp array of the right half of the array
        Point[] pointsRightY = Arrays.copyOfRange(pointsY, mid+1, right+1);

        // current index to evaluate of the left array and right array
        int leftIndex = 0;
        int rightIndex = 0;

        // index in the original array to place sorted value at
        int sortIndex = left;

        // while not at the end of both temp arrays:
        while (leftIndex < pointsLeftY.length && rightIndex < pointsRightY.length) {
            // if the value at the current index of the left array is less than the value at the current index of
            // the right array, insert at given (sorted) index in the original array
            if (pointsLeftY[leftIndex].y < pointsRightY[rightIndex].y) {
                pointsY[sortIndex++] = pointsLeftY[leftIndex++];
            } else { // otherwise, insert the right array value at sorted index in original array
                pointsY[sortIndex++] = pointsRightY[rightIndex++];
            }
        }

        // if at the end of right temp array and left temp still has values, insert remaining values into sorted indices
        while (leftIndex < pointsLeftY.length) {
            pointsY[sortIndex++] = pointsLeftY[leftIndex++];
        }

        // if at the end of left temp array and right temp still has values, insert remaining values into sorted indices
        while (rightIndex < pointsRightY.length) {
            pointsY[sortIndex++] = pointsRightY[rightIndex++];
        }
    }

    /*
    public static void ySortPoints(Point[] pointsY, int left, int right) {
        // base case
        if (left >= right) return;

        // select random point to swap with the first (left) element and swap
        int rand = random.nextInt(right - left) + left;
        Point temp = pointsY[left];
        pointsY[left] = pointsY[rand];
        pointsY[rand] = temp;

        // use first element and sort into 3 partitions, less than the first element, equal to the first element
        // and greater than the first element.
        // int[] partition should be two integers, the first is the index of the first element in this sorting that is
        // equal to the target element, and the second is the last index of the sorted list that is equal
        // to the target element.
        int[] partition = partition3y(pointsY, left, right);

        // sort the elements that were less than the target element checked against
        ySortPoints(pointsY, left, partition[0]-1);
        // sort the elements that were greater than the element already checked against
        ySortPoints(pointsY, partition[1]+1, right);
    }

    private static int[] partition3y(Point[] pointsY, int left, int right) {
        // y value of point to be checked against
        double yTargetValue = pointsY[left].y;

        // index of first occurrence of target value in partitioned list
        int m1 = left;
        // index of last occurrence of target value in the partitioned list, found using standard quicksort method
        int m2 = left;

        // iterate through all points to place all values equal to target value in final position, moving values less
        // than target to left of m1
        for (int index = left+1; index <= right; index++) {
            if (pointsY[index].y < yTargetValue) {
                Point temp = pointsY[index];
                pointsY[index] = pointsY[++m2];
                pointsY[m2] = pointsY[m1];
                pointsY[m1++] = temp;
            } else if (pointsY[index].y == yTargetValue) {
                Point temp = pointsY[index];
                pointsY[index] = pointsY[++m2];
                pointsY[m2] = temp;
            }
        }

        int[] partition = {m1, m2};
        return partition;
    }

     */

    public static double getDistance(Point[] pointsX, Point[] pointsY, int left, int right) {
        // (base case) if less than three pointsX, use brute force to find minimal distance between any two pointsX
        if (right - left < 3) {
            return bruteForce(pointsX, left, right);
        }

        // find the mid-point of the array
        int mid = ((right - left) / 2) + left;

        // find the point at the mid-point of the array
        Point midPoint = pointsX[mid];

        /*
        // initialize a current min value to be compared to
        double currentMin = Double.POSITIVE_INFINITY;
         */


        // Divide points in y sorted array around the vertical line.
        Point[] pointsYLeft = new Point[((right - left) / 2) + 1]; //y sorted points left of the vertical line
        Point[] pointsYRight = new Point[pointsY.length - pointsYLeft.length]; //y sorted points right of the vertical line
        // indices of the left and right subarrays
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < pointsY.length; index++) {
            if (pointsY[index].x < midPoint.x || (pointsY[index].x == midPoint.x && pointsY[index].y <= midPoint.y)) { // && leftIndex < pointsYLeft.length) {
                pointsYLeft[leftIndex++] = pointsY[index];
            } else {
                pointsYRight[rightIndex++] = pointsY[index];
            }
        }



        // consider the vertical line passing through the middle point
        // calculate the smallest distance distLeft on left of middle point
        // and distRight on right side
        double distLeft = getDistance(pointsX, pointsYLeft, left, mid);
        double distRight = getDistance(pointsX, pointsYRight, mid+1, right);

        // find min distance
        double minDist = Math.min(distLeft, distRight);

        /*
        // recursively call getDistance comparing the distance calculated from the left half and right half
        currentMin = Math.min(getDistance(pointsX, pointsY, left, mid), getDistance(pointsX, pointsY, mid+1, right));
         */

        // create a list of additional pointsX to check: ones whose x value is within the current min distance of
        // the midline it is possible that these are within a smaller distance to a point in the other half than
        // the current min distance
        List<Point> ptsToCheck = new ArrayList<>();

        /*
        // add the mid-point to the list of pointsX to check
        ptsToCheck.add(midPoint);

        // since pointsX are sorted, starting with the point to the left of the mid-point, check if x distance to
        // mid-point is less than current min distance and add to list if it is. Once a point of greater distance,
        // we know all subsequent pointsX will also be greater
        int leftIndexToCheck = mid - 1;

        while (leftIndexToCheck >= left && (Math.abs(pointsX[leftIndexToCheck].x - midPoint.x)) < currentMin) {
            ptsToCheck.add(pointsX[leftIndexToCheck]);
            leftIndexToCheck--;
        }

        // starting with the point to the right of the mid-point, check if x distance to mid-point is less than current
        // min distance and add to list if it is. Can stop once difference is greater since pointsX are sorted,
        // everything after will also be greater
        int rightIndexToCheck = mid +1;
        while (rightIndexToCheck <= right && (Math.abs(pointsX[rightIndexToCheck].x - midPoint.x)) < currentMin) {
            ptsToCheck.add(pointsX[rightIndexToCheck]);
            rightIndexToCheck++;
        }

        // sort the pointsX in the checklist according to their y values
        sortPtsToCheck(ptsToCheck, 0, ptsToCheck.size()-1);

         */

        // iterate through y sorted array, if x value within current min distance of mid-point, add to list to check
        for (int index = 0; index < pointsY.length; index++) {
            if (Math.abs(pointsY[index].x - midPoint.x) < minDist) {
                ptsToCheck.add(pointsY[index]);
            }
        }

        /*
        // if the distance between a given y value and the y value on either side are both greater than the current
        // min distance, than the point can not be part of the pairs of min distance, so remove from the list
        filterPtsToCheck(ptsToCheck, minDist);

        // if two or more elements in ptsToCheck, convert to array and find min distance in that set, then compare
        // to current min distance
        if (ptsToCheck.size() > 1) {
            // convert list of pointsX to check to an array
            Point[] midPtsToCheck = new Point[ptsToCheck.size()];
            for (int index = 0; index < ptsToCheck.size(); index++) {
                midPtsToCheck[index] = ptsToCheck.get(index);
            }

            // use brute force method on remaining pointsX in midPtsToCheck array
            double minToCheck = bruteForce(midPtsToCheck, 0, midPtsToCheck.length - 1);

            // find minimum between current min distance and brute force of additional pointsX to check
            // (pointsX within current min distance of mid-point)
            minDist = Math.min(minDist, minToCheck);
        }
         */

        // Find the closets points in the middle strip we just created
        minDist = stripClosest(ptsToCheck, minDist);

        return minDist;
    }

    public static double bruteForce(Point[] points, int left, int right) {
        double min = Double.POSITIVE_INFINITY;

        // iterate through points array
        for (int firstIndex = left; firstIndex < right; firstIndex++) {
            // iterate through remaining points of the array
            for (int secondIndex = firstIndex+1; secondIndex <= right; secondIndex++) {
                // calculate the distance between two given points
                double distance = dist(points[firstIndex], points[secondIndex]);
                // if new calculation is less than current min, set min to current distance
                if (distance < min) {
                    min = distance;
                }
            }
        }
        return min;
    }

    public static double dist(Point a, Point b) {
        // difference of x values
        double diffX = (double)a.x - (double)b.x;
        // difference of y values
        double diffY = (double)a.y - (double)b.y;
        // difference of x values squared
        double xDiffSq = Math.pow(diffX, 2);
        // difference of y values squared
        double yDiffSq = Math.pow(diffY, 2);
        // square root of sum of (x differences squared) and (y differences squared)
        double distance = Math.sqrt(xDiffSq + yDiffSq);
        return distance;
    }

    public static double stripClosest(List<Point> strip, double currentMin) {
        for (int firstIndex = 0; firstIndex < strip.size()-1; firstIndex++) {
            for (int secondIndex = firstIndex+1; secondIndex < strip.size(); ++secondIndex) {
                if (strip.get(secondIndex).y - strip.get(secondIndex).y < currentMin) {
                    double distance = dist(strip.get(firstIndex), strip.get(secondIndex));
                    if (distance < currentMin) {
                        currentMin = distance;
                    }
                }
            }
        }
        return currentMin;
    }

    public static void sortPtsToCheck(List<Point> points, int left, int right) {
        // base case
        if (left >= right) return;

        // select random point to swap with first (left) element and swap
        int k = random.nextInt(right - left + 1) + left;
        Point temp = points.get(left);
        points.set(left, points.get(k));
        points.set(k, temp);

        // use first element and sort into 3 partitions, less than the first element, equal to the first element
        // and greater than the first element.
        // int[] x should be two integers, the first is the index of the first element in this sorting that is
        // equal to the target element, and the second is the last index of the sorted list that is equal
        // to the target element.
        int[] x = partition3(points, left, right);
        // sort the elements that were less than the target element checked against
        sortPtsToCheck(points, left, x[0] - 1);
        // sort the elements that were greater than the element already checked against
        sortPtsToCheck(points, x[1] + 1, right);
    }

    private static int[] partition3(List<Point> points, int left, int right) {
        // y value of point to be checked against
        double yTargetValue = points.get(left).y;
        // index of first occurrence of target value in partitioned list
        int m1 = left;
        // index of last occurrence of target value in the partitioned list, found using standard quicksort method
        int m2 = partition2(points, left, right);

        // iterate through all points to the left of the index of the checked value (which is now in its final position)
        // move all values less than target value to the left of m1, which should be the index of first point equal
        // to the target value
        for (int i = left; i < m2; i++) {
            if (points.get(i).y < yTargetValue) {
                Point temp = points.get(i);
                points.set(i, points.get(m1));
                points.set(m1, temp);
                m1++;
            }
        }

        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(List<Point> points, int left, int right) {
        // target value is set to first element of array, all values are checked against this and sorted
        double yTargetValue = points.get(left).y;
        // final index of where in the array the target value should be placed
        int finalIndexOfTargetVal = left;
        // iterate through all points in the array
        for (int index = left + 1; index <= right; index++) {
            // check if the current point is less than the target value
            if (points.get(index).y < yTargetValue) {
                // increase the final index, we know that the current point should be to the left of the target value
                finalIndexOfTargetVal++;
                // swap the location of the current point and the point at the current final index
                Point temp = points.get(index);
                points.set(index, points.get(finalIndexOfTargetVal));
                points.set(finalIndexOfTargetVal, temp);
            }
        }

        // place the target value in its final location by swapping with the element currently at the final index
        Point temp = points.get(left);
        points.set(left, points.get(finalIndexOfTargetVal));
        points.set(finalIndexOfTargetVal, temp);
        // return the final index, as this will be the right end of our partition (last index of target value)
        return finalIndexOfTargetVal;
    }

    public static void filterPtsToCheck(List<Point> ptsToCheck, double currentMin) {
        for (int index = 0; index < ptsToCheck.size(); index++) {
            // check if first element y value is within current min distance to next y value
            // and first element x value is within current min distance to the corresponding x value
            // if not, remove from list and decrease index count to not skip next value
            if (index == 0) {
                if (ptsToCheck.size() > 1
                        && ((Math.abs(ptsToCheck.get(index).y - ptsToCheck.get(index+1).y)) > currentMin
                        || (Math.abs(ptsToCheck.get(index).x - ptsToCheck.get(index+1).x)) > currentMin)) {
                    ptsToCheck.remove(index--);
                }
                // if only one element in ptsToCheck, remove as there are no points within current min distance
                // of each other to check
                else if (ptsToCheck.size() == 1) {
                    ptsToCheck.remove(index);
                    return;
                } else {
                    index++;
                    continue;
                }
            }
            else if (index == ptsToCheck.size()-1) {
                // if last element in the array, check that it is within current min distance to the previous y value
                // and within current min distance to the corresponding x value
                if (Math.abs((ptsToCheck.get(index).y) - ptsToCheck.get(index-1).y) > currentMin
                        || Math.abs(ptsToCheck.get(index).x - ptsToCheck.get(index-1).x) > currentMin) {
                    ptsToCheck.remove(index);
                    return;
                } else {
                    return;
                }
            }
            // if y value at current index is within current min distance of next y value and current index x
            // value is within current min distance of next x value, both can stay on the list
            // if not, remove current value, decrease index count to not skip checking next value
            else if (Math.abs(ptsToCheck.get(index).y - ptsToCheck.get(index+1).y) <= currentMin
                    && Math.abs(ptsToCheck.get(index).x - ptsToCheck.get(index+1).x) <= currentMin) {
                index++;
                if (index >= ptsToCheck.size()-1) return;
            } else if (Math.abs(ptsToCheck.get(index).y - ptsToCheck.get(index-1).y) <= currentMin
                    && Math.abs(ptsToCheck.get(index).x - ptsToCheck.get(index-1).x) <= currentMin) {
                continue;
            } else {
                ptsToCheck.remove(index--);
            }
        }
    }
}
