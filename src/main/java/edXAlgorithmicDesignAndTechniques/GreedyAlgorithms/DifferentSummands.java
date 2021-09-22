package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;
/*
Maximum Number of Prizes
--------------------------------------------------------------------------------------------
Problem Introduction:
You are organizing a funny competition for children. As a prize you have n candies. You
would like to use these candies for top k places in a competition with a natural restriction
that a higher place gets a larger number of candies. To make as many children happy as
possible, you are going to find the largest value of k for which it is possible.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: The goal of this problem is to represent a given positive integer n as a sum of as
        many pairwise distinct positive integers as possible. That is, to find the maximum
        k such that n can be written as a1 + a2 + ... + ak where a1, ..., ak are positive
        integers and ai != aj for all 1 <= i < j <= k.
    Input Format: The input consists of a single integer n.
    Constraints: 1 <= n <= 10^9.
    Output Format: In the first line, output the maximum number k such that n can be
        represented as a sum of k pairwise distinct positive integers. In the second line,
        output k pairwise distinct positive integers that sum up to n (if there are many
        such representations, output any of them).

Sample 1:
    Input: 6
    Output:
        3
        1 2 3

Sample 2:
    Input: 8
    Output:
        3
        1 2 5

Sample 3:
    Input: 2
    Output:
        1
        2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    public static List<Integer> optinalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        //int start = 1;
        //int newNumber = n;

        if (n <= 2) {
            summands.add(n);
            return summands;
        }

        for (int newNumber = n, start = 1; newNumber > 0; start++) {
            //System.out.print("Summands at start: [");
            //for (int i = 0; i < summands.size(); i++) {
            //    System.out.print(summands.get(i) + " ");
            //}
            //System.out.println("]");
            if (newNumber <= 2 * start) {
                summands.add(newNumber);
                //System.out.print("Summands after add: [");
                //for (int i = 0; i < summands.size(); i++) {
                //    System.out.print(summands.get(i) + " ");
                //}
                //System.out.println("]");
                newNumber -= newNumber;
            } else {
                summands.add(start);
                //System.out.print("Summands after add: [");
                //for (int i = 0; i < summands.size(); i++) {
                //    System.out.print(summands.get(i) + " ");
                //}
                //System.out.println("]");
                newNumber -= start;
            }
        }
        /*
        int summandsTotal = 0;
        for (int i = 0; i < summands.size(); i++) {
            summandsTotal += summands.get(i);
        }
        System.out.println("Summands total: " + summandsTotal + ", Original n: " + n);
        if(summandsTotal > n) {
            int amountToRemove = summandsTotal - n;
            if (summands.contains(amountToRemove)) {
                for (int i = 0; i < summands.size(); i++) {
                    if (summands.get(i) == amountToRemove) {
                        System.out.println("Item to remove: " + summands.get(i));
                        summands.remove(i);
                        break;
                    }
                }
            } else {

            }
        }

         */
        return summands;

/*
        while (true) {
            if (summands.contains(newNumber - start)) {
                start++;
                continue;
            } else {
                newNumber -= start;
                summands.add(start);
                start++;
            }

            if (newNumber <= 0) {
                return summands;
            }
        }
 */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optinalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.println(summand + " ");
        }
    }
}
