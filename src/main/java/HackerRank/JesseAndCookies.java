package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JesseAndCookies {
    public static void main(String[] args) {
        int k = 10;

        List<Integer> A = Arrays.asList(1, 1, 1);
        //int newCookie = 38;

       //insertNewCookie(A, newCookie, 0, A.size()-1);

        int iterations = cookies(k, A);

        System.out.println(iterations);
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int numInterations = 0;

        Collections.sort(A);

        while (A.size() > 1) {
            if (A.get(0) < k) {
                A = increaseSweetness(A);
                numInterations++;
            } else return numInterations;
        }

        return -1;
    }

    public static List<Integer> increaseSweetness(List<Integer> A) {
        int newCookie = A.get(0) + (2 * A.get(1));

        List<Integer> newA = new ArrayList<>();
        for (int i = 2; i < A.size(); i++) {
            newA.add(A.get(i));
        }
        //A.remove(0);
        //A.remove(0);

        A = insertNewCookie(newA, newCookie, 0, newA.size()-1);

        return A;
    }

    public static List<Integer> insertNewCookie(List<Integer> A, int newCookie, int start, int end) {
        if (A.size() < 1) {
            A.add(newCookie);
            return A;
        }
        if (end - start <= 0) {
            if (newCookie > A.get(start)) {
                A.add(start+1, newCookie);
            } else A.add(start, newCookie);
            return A;
        }

        int mid = ((end - start) / 2) + start;

        if (newCookie <= A.get(mid))
            return insertNewCookie(A, newCookie, start, mid-1);
        return insertNewCookie(A, newCookie, mid+1, end);
    }

}
