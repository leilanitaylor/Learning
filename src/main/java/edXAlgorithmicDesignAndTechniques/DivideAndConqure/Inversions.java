package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
Number of Inversions
--------------------------------------------------------------------------------------------
Problem Introduction:
An inversion of a sequence a0, a1, ..., a(n-1) is a pair of indices 0 <= i< j < n such that
ai > aj. The number of inversions of a sequence in some sense measures how close the
sequence is to being sorted. For example, a sorted (in non-descending order) sequence
contains no inversions at all, while in a sequence sorted in descending order any two
elements constitute an inversion (for a total of n(n - 1)/2 inversions).
--------------------------------------------------------------------------------------------
Problem Description:
    Task: The goal in this problem is to count the number of inversions of a give sequence.
    Input Format: The first line contains an integer n, the next one contains a sequence of
        integers a0, a1, ..., a(n-1).
    Constraints: 1 <= n <= 10^5, 1 <= ai <= 10^9 for all 0 <= i < n.
    Output Format: Output the number of inversions in the sequence.

Sample 1:
    Input:
        5
        2 3 9 2 9
    Output:
        2
    The two inversions here are (1, 3) (a1 = 3 > 2 = a3) and (2, 3) (a2 = 9 > 2 = a3).

What To Do:
This problem can be solved by modifying the merge sort algorithm. For this, we change both
the Merge and MergeSort procedures as follows:
    - Merge(B, C) returns the resulting sorted array and the number of pairs (b, c) such
      that b (contained in) B, c (contained in) C, and b > c;
    - mergeSort(A) returns a sorted array Aand the number of inversions in A.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Inversions {


    public static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        /*
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        numberOfInversions += merge(a, left, ave, right);

         */
        if (left >= right) {
            return numberOfInversions;
        }
        int mid = ((right - left) / 2) + left;
        numberOfInversions += getNumberOfInversions(a, b, left, mid);
        numberOfInversions += getNumberOfInversions(a, b, mid+1, right);
        numberOfInversions += mergeNumInversions(a, left, mid, right);

        return numberOfInversions;
    }

    public static long mergeNumInversions(int[] a, int left, int mid, int right) {
        int numberOfInversions = 0;
        int[] b = Arrays.copyOfRange(a, left,mid + 1);
        int[] c = Arrays.copyOfRange(a, mid+1, right+1);
        int[] d = new int[b.length + c.length];
        int i = 0;
        int j = 0;
        int dIndex = 0;
        while (i < b.length && j < c.length) {
            if (b[i] <= c[j]) {
                d[dIndex] = b[i];
                dIndex++;
                i++;
            } else {
                numberOfInversions += (mid + 1) - (left + i);
                d[dIndex] = c[j];
                dIndex++;
                j++;
            }
        }
        if (i < b.length) {
            for (int k = i; k < b.length; k++) {
                //numberOfInversions += (mid + 1) - (left + i);
                d[dIndex] = b[k];
                dIndex++;
            }
        } else {
            for (int k = j; k < c.length; k++) {
                //numberOfInversions += (mid + 1) - (left + i);
                d[dIndex] = c[k];
                dIndex++;
            }
        }
        for (int k = left, l = 0; k <= right; k++, l++){
            a[k] = d[l];
        }
        return numberOfInversions;
    }


    public static void mergeSort(int[] a, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = ((right - left) / 2) + left;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        //int[] b = Arrays.copyOfRange(a, left, mid+1);
        //int[] c = Arrays.copyOfRange(a, mid+1, right+1);
        //int[] aSorted = merge(a, left, mid, right);
        merge(a, left, mid, right);
        //return a;
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] b = Arrays.copyOfRange(a, left,mid + 1);
        int[] c = Arrays.copyOfRange(a, mid+1, right+1);
        int[] d = new int[b.length + c.length];
        int i = 0;
        int j = 0;
        int dIndex = 0;
        while (i < b.length && j < c.length) {
            if (b[i] <= c[j]) {
                d[dIndex] = b[i];
                dIndex++;
                i++;
            } else {
                d[dIndex] = c[j];
                dIndex++;
                j++;
            }
        }
        if (i < b.length) {
            for (int k = i; k < b.length; k++) {
                d[dIndex] = b[k];
                dIndex++;
            }
        } else {
            for (int k = j; k < c.length; k++) {
                d[dIndex] = c[k];
                dIndex++;
            }
        }

        for (int k = left, l = 0; k <= right; k++, l++){
            a[k] = d[l];
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }

}
