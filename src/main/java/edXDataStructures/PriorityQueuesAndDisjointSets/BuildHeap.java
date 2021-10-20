package edXDataStructures.PriorityQueuesAndDisjointSets;
/*
Problem: Convert array into heap
---------------------------------------------------------------------------------------------
Problem Introduction:
In this problem you will convert an array of integers into a heap. This is the crucial step
of the sorting algorithm called HeapSort. it has guaranteed worst-case running time of
O(nlogn) as opposed to QuickSort's average running time of O(nlogn). QuickSort is usually
used in practice, because typically it is faster, but HeapSort is used for external sort when
you need to sort when you need to sort huge files that don't fit into memory of your computer.
---------------------------------------------------------------------------------------------
Problem Description:
    Task: The first step of the HeapSort algorithm is to create a heap from the array you
        want to sort. By the way, did you know that algorithms based on Heaps are widely
        used for external sort, when you need to sort huge files that don't fit into memory
        of a computer?
    Input Format: The first line of the input contains single integer n. The next line
        contains n space-separated integers ai.
    Constraints: 1 <= n <= 100,000; 0 <= i,j <= n-1; 0 <= a0, a1, ..., a(n-1) <= 10^9. All
        ai are distinct.
    Output Format: The first line of the output should contain single integer m - the total
        number of swaps. m must satisfy conditions 0 <= m <= 4n. The next m lines should
        contain the swap operations used to convert the array a into a heap. Each swap is
        described by a pair of integers i, j - the 0-based indices of the elements to be
        swapped. After applying all the swaps in the specified order the array must become
        a heap, that is, for each i where 0 <= i <= n-1 the following conditions must be
        true:
            1) If 2i+1 <= n-1, then ai < a(2i+1).
            2) If 2i+2 <= n-1, then ai < a(2i+2).
        Note that all the elements of the elements of the input array are distinct. Note
        that any sequence of swaps that has length at most 4n and after which your initial
        array becomes a correct heap will be graded as correct.
    Time Limits: 3 sec.
    Memory Limit: 512 MB.

Sample 1:
    Input:
        5
        5 4 3 2 1
    Output:
        3
        1 4
        0 1
        1 3
    After swapping elements 4 in position 1 and 1 in position 4 the array becomes 5 1 3 2 4.
    After swapping elements 5 in position 0 and 1 in position 1 the array becomes 1 5 3 2 4.
    After swapping elements 5 in position 1 and 2 in position 3 the array becomes 1 2 3 5 4,
    which is already a heap, because a0 = 1 < 2 = a1, a0 = 1 < 3 = a2, a1 = 2 < 5 = a3,
    a1 = 2 < 4 = a4.

Sample 2:
    Input:
        5
        1 2 3 4 5
    Output:
        0
    The input array is already a heap, because it is sorted in increasing order.

Starter Files:
    There are starter solutions only for C++, Java, an dPython3, and if you use other
    languages, you need to implement solution from scratch. Starter solutions read the array
    from the input, use a quadratic time algorithm to convert it to a heap and use O(n^2)
    swaps to do that, then write the output. You need to replace the O(n^2) implementation
    with an O(n) implementation using no more than 4n swaps to convert the array into heap.

What to Do:
    Change the BuildHeap algorithm from the lecture to account for min-heap instead of
    max-heap and for 0-based indexing.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    public int[] data;
    public List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<>();
        // The following naive implementation just sorts the given sequence using selection sort algorithm and saves
        // the resulting sequence of swaps. This turns the given array into a heap, but in the worst case gives a
        // quadratic number of swaps.
        //
        // to do: replace by a more efficient implementation
        for (int i = 0; i < data.length; ++i) {
            for (int j = i+1; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    swaps.add(new Swap(i, j));
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public void genSwaps() {
        swaps = new ArrayList<>();
        for (int i = data.length/2 - 1; i >=0; i--) {
            shiftDown(i);
        }
    }

    public void shiftDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        if (left < data.length && data[left] < data[minIndex]) {
            minIndex = left;
        }
        int right = rightChild(i);
        if (right < data.length && data[right] < data[minIndex]) {
            minIndex = right;
        }
        if (i != minIndex) {
            swaps.add(new Swap(i, minIndex));
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
            shiftDown(minIndex);
        }
    }

    public int leftChild(int i) {
        return 2*i + 1;
    }

    public int rightChild(int i) {
        return 2*i + 2;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        // generateSwaps();
        genSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
