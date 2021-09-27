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

    private static Random random = new Random();

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

        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        sortPoints(points, 0, points.length-1);

        double distance = getDistance(points, 0, points.length-1);

        double minDistance = Math.round(distance * 10000) / 10000D;

        return minDistance;
    }

    public static void sortPoints(Point[] points, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        sortPoints(points, left, mid);
        sortPoints(points, mid+1, right);
        mergePoints(points, left, mid, right);
    }

    private static void mergePoints(Point[] points, int left, int mid, int right) {
        Point[] pointsLeft = Arrays.copyOfRange(points, left, mid+1);
        Point[] pointsRight = Arrays.copyOfRange(points, mid+1, right+1);
        int i = 0;
        int j = 0;
        int sortIndex = left;
        while (i < pointsLeft.length && j < pointsRight.length) {
            if (pointsLeft[i].x < pointsRight[j].x) {
                points[sortIndex++] = pointsLeft[i++];
            } else {
                points[sortIndex++] = pointsRight[j++];
            }
        }
        while (i < pointsLeft.length) {
            points[sortIndex++] = pointsLeft[i++];
        }
        while (j < pointsRight.length) {
            points[sortIndex++] = pointsRight[j++];
        }
    }

    public static double getDistance(Point[] points, int left, int right) {
        if (right - left < 3) {
            return bruteForce(points, left, right);
        }
        int mid = ((right - left) / 2) + left;
        Point midPoint = points[mid];
        double currentMin = Double.POSITIVE_INFINITY;
        currentMin = Math.min(getDistance(points, left, mid), getDistance(points, mid+1, right));

        List<Point> ptsToCheck = new ArrayList<>();
        int i = mid - 1;
        while (i >= left && (Math.abs(points[i].x - midPoint.x)) < currentMin) {
            ptsToCheck.add(points[i]);
            i--;
        }
        int j = mid +1;
        while (j <= right && (Math.abs(points[j].x - midPoint.x)) < currentMin) {
            ptsToCheck.add(points[j]);
            j++;
        }

        sortPtsToCheck(ptsToCheck, 0, ptsToCheck.size()-1);

        filterPtsToCheck(ptsToCheck, currentMin);

        Point[] midPtsToCheck = new Point[ptsToCheck.size()];
        for (int k = 0; k < ptsToCheck.size(); k++) {
            midPtsToCheck[k] = ptsToCheck.get(k);
        }

        double minToCheck = bruteForce(midPtsToCheck, 0, midPtsToCheck.length-1);

        double minDistance = Math.min(currentMin, minToCheck);

        return minDistance;
    }

    public static double bruteForce(Point[] points, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < right - left; i++) {
            for (int j = i+1; j <= right - left; j++) {
                double distance = dist(points[i], points[j]);
                if (distance < min) {
                    min = distance;
                }
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

    public static void sortPtsToCheck(List<Point> points, int left, int right) {
        if (left >= right) return;

        int k = random.nextInt(right - left + 1) + left;
        Point temp = points.get(left);
        points.set(left, points.get(k));
        points.set(k, temp);

        int[] x = partition3(points, left, right);
        sortPtsToCheck(points, left, x[0] - 1);
        sortPtsToCheck(points, x[1] + 1, right);
    }

    private static int[] partition3(List<Point> points, int left, int right) {
        double a = points.get(left).y;
        int m1 = left;
        int m2 = partition2(points, left, right);

        for (int i = left; i < m2; i++) {
            if (points.get(i).y < a) {
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
        double b = points.get(left).y;
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (points.get(i).y < b) {
                j++;
                Point temp = points.get(i);
                points.set(i, points.get(j));
                points.set(j, temp);
            }
        }

        Point temp = points.get(left);
        points.set(left, points.get(j));
        points.set(j, temp);
        return j;
    }

    public static void filterPtsToCheck(List<Point> ptsToCheck, double currentMin) {
        for (int i = 0; i < ptsToCheck.size(); i++) {
            if (i == 0) {
                if ((Math.abs(ptsToCheck.get(i).y - ptsToCheck.get(i + 1).y)) > currentMin) {
                    ptsToCheck.remove(i--);
                } else {
                    i++;
                    continue;
                }
            }
            else if (i == ptsToCheck.size() - 1) {
                if (Math.abs((ptsToCheck.get(i).y) - ptsToCheck.get(i - 1).y) > currentMin) {
                    ptsToCheck.remove(i);
                } else {
                    return;
                }
            }
            else if (Math.abs(ptsToCheck.get(i).y - ptsToCheck.get(i+1).y) < currentMin) {
                i++;
                if (i >= ptsToCheck.size()) return;
            } else if (Math.abs(ptsToCheck.get(i).y - ptsToCheck.get(i-1).y) > currentMin) {
                ptsToCheck.remove(i--);
            }
        }
    }

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
}
