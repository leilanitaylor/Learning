package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

/*
Maximizing Revenue in Online Ad Placement
--------------------------------------------------------------------------------------------
Problem Introduction:
You have n ads to place on a popular Internet page. For each ad, you know how much is the
advertiser willing to pay for one click on this ad. You have set up n slots on your page
and estimated the expected number of clicks per day for each slot. Now, your goal is to
distribute the ads among the slots to maximize the total revenue.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: given two sequences a1, a2, ..., an (ai is the profit per click of the
        i-th ad) and b1, b2, ..., bn (bn is the average number of clicks per day of the i-th
        slot), we need to partition them into n pairs (ai, bj) such that the sum of their
        products is maximized.
    Input Format: The first line contains an integer n, the second one contains a sequence
        of integers a1, a2, ..., an, the third one contains a sequence of integers
        b1, b2, ..., bn.
    Constraints: 1 <= n <= 10^3; -10^5 <= ai, bi <= 10^5 for all 1 <= i <= n.
    Output Format: Output the maximum value of (sum from i = 1 to i = n) of (ai * ci),
        where c1, c2, ..., cn is a permutation of b1, b2, ..., bn.

Sample 1:
    Input:
        1
        23
        39
    Output:
        897
    897 = 23 * 39

Sample 2:
    Input:
        3
        1 3 -5
        -2 4 1
    Output:
        23
    23 = 3 * 4 + 1 * 1 + (-5) * (-2)
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotProduct {

    public static long maxDotProduct(int[] a, int[] b) {
        int[] aSorted = sort(a);
        int[] bSorted = sort(b);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long)aSorted[i] * (long)bSorted[i];
        }
        return result;
    }

    public static int[] sort(int[] c) {
        boolean swapped;
        do{
            swapped = false;
            for (int i = 0; i < c.length - 1; i++) {
                if(c[i] < c[i + 1]) {
                    int temp = c[i];
                    c[i] = c[i + 1];
                    c[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
