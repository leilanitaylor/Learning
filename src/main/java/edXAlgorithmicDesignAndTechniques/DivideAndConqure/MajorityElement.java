package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
Majority Element
--------------------------------------------------------------------------------------------
Problem Introduction:
Majority rule is a decision rule that selects the alternative which has a majority, that is,
mor than half the votes.
Given a sequence of elements a1, a2, ..., an, you would like to check whether it contains
an element that appears mre than n/2 times. A naive way to do this is the following.
    MajorityElement(a1, a2, ..., an):
    for i from 1 to n:
        currentElement <- ai
        count <- 0
        for j from 1 to n:
            if aj = currentElement:
                count <- count + 1
            if count > n/2:
                return ai
        return "no majority element"
The running time of this algorithm is quadratic. Your goal is to use divide and conquer
technique to design an O(nlogn) algorithm.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: The goal in this code problem is to check whether an input sequence contains a
        majority element
    Input Format: The first line contains an integer n, the next on contains a sequence of
        n non-negative integers a0, a1, ..., a(n-1).
    Constraints: 1 <= n <= 10^5; 0 <=ai <= 10^9 for all 0 <= i < n.
    Output Format: Output 1 if the sequence contains an element that appears strictly more
        than n/2 times, and 0 otherwise.

Sample 1:
    Input:
        5
        2 3 9 2 2
    Output:
        1
    2 is the majority element.

Sample 2:
    Input:
        4
        1 2 3 4
    Output:
        0
    There is no majority element in this sequence.

Sample 3:
    Input:
        4
        1 2 3 1
    Output:
        0
    This sequence also does not have a majority element (note that the element 1 appears
    twice and hence is not a majority element.

What To Do:
As you might have already guessed, this problem can be solved by the divide-and-conquer
algorithm in time O(nlogn). Indeed, if a sequence of length n contains a majority element,
then the same element is also a majority element for one of its halves. Thus, to solve this
problem you first split a give sequence into halves and make two recursive calls. Do you
see how to combine the results of the two recursive calls?
It is interesting to note that this problem can also be solved in O(n) time by a more
advanced (non-divide and conquer) algorithm that just scans the give sequence twice.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement {

    public static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int mid = ((right - left) / 2) + left;
        int leftMajority = getMajorityElement(a, left, mid);
        int rightMajority = getMajorityElement(a, mid + 1, right);
        if (leftMajority == rightMajority) {
            return leftMajority;
        } else {
            int leftMajorityCount = majorityCount(a, left, right, leftMajority);
            int rightMajorityCount = majorityCount(a, left, right, rightMajority);
            if (leftMajorityCount == rightMajorityCount) {
                return -1;
            } else if (leftMajorityCount > rightMajorityCount && leftMajorityCount >= ((right + 1 - left) / 2) + 1) {
                return leftMajority;
            } else if (rightMajorityCount > leftMajorityCount && rightMajorityCount >= ((right + 1 - left) / 2) + 1) {
                return rightMajority;
            }
            return -1;
        }
    }

    public static int majorityCount(int[] a, int left, int right, int majority) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (a[i] == majority) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
