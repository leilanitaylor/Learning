package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;
/*
Maximum Salary
--------------------------------------------------------------------------------------------
Problem Introduction:
As the last question of a successful interview, you boss gives you a few pieces of paper
with numbers on it and asks you to compose a largest number from these numbers. The
resulting number is going to be your salary, so you are very much interested in maximizing
this number. How can you do this?
In the lectures, we considered the following algorithm for composing the largest number out
of the given single-digit numbers.
    LargestNumber(Digits):
    answer <- empty string
    while Digits is not empty:
        maxDigit <- negative infinity
        for digit in Digits:
            if digit >= maxDigit:
                maxDigit <- digit
        append maxDigit to answer
        remove maxDigit from Digits
    return answer

Unfortunately, this algorithm works on in case the input consists of single-digit numbers.
For example, for an input consisting of two integers 23 and 3 (23 is not a single-digit
number!) it returns 233, while the largest number is in fact 323. In other words, using the
largest number from the input as the first number is not a safe move.
Your goal in this problem is to tweak the algorithm so that it works not only for
single-digit numbers, but for arbitrary positive integers.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Compose the largest number out of a set of integers.
    Input Format: The first line of the input contains and integer n. The second line
        contains integers a1, a2, ..., an.
    Constraints: 1 <=n <= 100; 1 <= ai <= 10^3 for all 1 <= i <= n.
    Output Format: Output the largest number that can be composed out of a1, a2, ..., an.

Sample 1:
    Input:
        2
        21 2
    Output:
        221
    Note that in this case the algorithm also returns an incorrect answer 212.

Sample 2:
    Input:
        5
        9 4 6 1 9
    Output:
        99641
    In this case, the input consists of single-digit numbers only, so the algorithm above
        computes the right answer.

Sample 3:
    Input:
        3
        23 39 92
    Output:
        923923
    As a coincidence, for this input the above algorithm produces the right result, though
        the input does not have any single-digit numbers.

What To Do:
Interestingly, for solving this problem, all you need to do is to replace the check
digit >= maxDigit with a call IsGreaterOrEqual(digit, maxDigit) for an appropriately
implemented function IsGreaterOrEqual.
For example, IsGreaterOrEqual(2, 21) should return True.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {

    public static String largestNumber(String[] a) {
        String result = "";
        String[] aSorted = sortStrings(a);
        for (int i = 0; i < a.length; i++) {
            result += aSorted[i];
        }
        return result;
    }

    public static String[] sortStrings(String[] aUnsorted) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < aUnsorted.length - 1; i++) {
                String xy = aUnsorted[i] + aUnsorted[i+1];
                String yx = aUnsorted[i+1] + aUnsorted[i];
                if (Integer.parseInt(xy) < Integer.parseInt(yx)) {
                    String temp = aUnsorted[i];
                    aUnsorted[i] = aUnsorted[i+1];
                    aUnsorted[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return aUnsorted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
