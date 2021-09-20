package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

/*
Money Change
--------------------------------------------------------------------------------------------
Problem Introduction:
In this problem, you will design and implement an elementary greed algorithm used by
cashiers all over the world millions of times per day
--------------------------------------------------------------------------------------------
Problem Description:
    Task: The goal in this problem is to find the minimum number of coins needed to change
        the input value (an integer) into coins with denominations 1, 5, and 10.
    Input Format: The input consists of a single integer m.
    Constraints: 1 <= m <= 10^3
    Output Format: Output the minimum number of coins with denominations 1, 5, 10 that
        changes m.

Sample 1:
    Input: 2
    Output: 2
    2 = 1 + 1

Sample 2:
    Input: 28
    Output: 6
    28 = 10 + 10 + 5 + 1 + 1 + 1
 */

import java.util.Scanner;

public class Change {

    public static int getChange(int m) {
        int numCoins = 0;
        int amtLeft = m;
        while (amtLeft > 0) {
            if (amtLeft - 10 >= 0) {
                amtLeft -= 10;
                numCoins++;
            } else if (amtLeft - 5 >= 0) {
                amtLeft -= 5;
                numCoins++;
            } else {
                amtLeft--;
                numCoins++;
            }
        }
        return numCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
