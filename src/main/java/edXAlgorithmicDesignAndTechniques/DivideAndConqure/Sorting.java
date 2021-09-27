package edXAlgorithmicDesignAndTechniques.DivideAndConqure;
/*
Improving Quick Sort:
--------------------------------------------------------------------------------------------
Problem Introduction:
The goal in this problem is to redesign a given implementation of the randomized quick sort
algorithm so that it works fast even on sequences containing many equal elements.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: To force the given implementation of the quick sort algorithm to efficiently
        process sequences with few unique elements, your goal is to replace a 2-way
        partition. That is, your new partition procedure should partition the array into
        three parts: < x part, = x part, and > x part.
    Input Format: The first line of the input contains an integer n. The next line contains
        a sequence of n integers a0, a1, ..., a(n-1).
    Constraints: 1 <= n, <= 10^5; 1 <= ai <= 10^9 for all 0 <= i < n.
    Output Format: Output this sequence sorted in non-decreasing order.

Sample 1:
    Input:
        5
        2 3 9 2 2
    Output:
        2 2 2 3 9

Starter Files:
In the starter files, you are given an implementation of the randomized quick sort algorithm
using a 2-way partion procedure. This procedure partitions the given array into two parts
with respect to a pivot x: <= x part and > x part. As discussed in the video lectures, such
an implementation has O(n^2) running time on sequences containing a single unique element.
Indeed, the partition procedure in this case splits the array into two parts, one of which
is empty and the other one contains n-1 elements. It spends cn time on this. The overall
running time is then
    cn + c(n - 1) + c(n - 2) + ... = O(n^2).

What To Do:
Implement a 3-way partition procedure and then replace a call to the 2-way partition
procedure by a call to the 3-way partition procedure.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {

    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        int x = a[l];
        int m1 = l;
        int m2 = partition2(a, l, r);

        for (int i = l; i < m2; i++) {
            if (a[i] < x) {
                int t = a[i];
                a[i] = a[m1];
                a[m1] = t;
                m1++;
            }
        }

        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        // use partition3
        /*
        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
         */
        int[] x = partition3(a, l, r);
        randomizedQuickSort(a, l, x[0] - 1);
        randomizedQuickSort(a, x[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n;i++) {
            System.out.println(a[i] + " ");
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
