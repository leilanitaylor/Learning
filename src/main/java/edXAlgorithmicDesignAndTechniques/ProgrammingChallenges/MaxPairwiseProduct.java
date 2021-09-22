package edXAlgorithmicDesignAndTechniques.ProgrammingChallenges;

/*
-------------------------------------------------------------------------------------------------------------
Maximum Pairwise Product:
Find the maximum product of two distinct numbers in a sequence of non-negative integers.
    Input: A sequence of non-negative integers
    Output: The maximum value that can be obtained by multiplying two different elements from the sequence
-------------------------------------------------------------------------------------------------------------
Given a sequence of non-negative integers a1, ..., an, compute
        max ai * aj
    1<=i!=j<=n

 Note that i an dj should be different, though it may be the case that ai = aj.

 Input format: The first line contains an integer n. The next line contains n non-negative integers a1, ..., an (separated by spaces)
 Output format: The maximum pairwise product
 Constraints: 2 <= n <= 2 * 10^5; 0 <= a1, ..., an, <= 2 * 10^5

 Sample 1:
    Input:
        3
        1 2 3
    Output:
    6

 Sample 2:
    Input:
        10
        7 5 14 2 8 8 10 1 2 3
    Output:
        140

Time limits (sec.):
    C   C++     Java    Python  Haskell     JavaScript  Scala
    1   1       1.5     5       2           5           3

Memory Limit: 512 Mb
 */

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result;
        int n = numbers.length;
        int currentMax;
        int currentNextMax;
        if (numbers[0] > numbers[1]) {
            currentMax = numbers[0];
            currentNextMax = numbers[1];
        } else {
            currentMax = numbers[1];
            currentNextMax = numbers [0];
        }
       // System.out.println("Max: " + currentMax + " , nextMax: " + currentNextMax);
        for (int i = 2; i < n; i++) {
            if (numbers[i] > currentMax) {
                currentNextMax = currentMax;
                currentMax = numbers[i];
                //System.out.println("Current value: " + numbers[i] + " Current Max: " + currentMax + " Current Next Max: " + currentNextMax);
            } else if (numbers[i] > currentNextMax) {
                currentNextMax = numbers[i];
               // System.out.println("Current value: " + numbers[i] + " Current Max: " + currentMax + " Current Next Max: " + currentNextMax);
            }
        }
        result = (long)currentMax * (long)currentNextMax;
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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
