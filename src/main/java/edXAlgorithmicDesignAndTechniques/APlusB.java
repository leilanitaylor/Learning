package edXAlgorithmicDesignAndTechniques;

/*
----------------------------------------------
Sum of Two Digits Problem:
Compute the sum of two single digit numbers
    Input: two single digit numbers
    Output: The sum of these numbers
----------------------------------------------
We start from this ridiculously simple problem to show you the pipeline of reading the problem statement,
designing an algorithm, implementing it, testing and debugging your program, and submitting it to the grading system.

Input format: Integers a and b on the same line (separated by a space)
Output format: The sum of a and b
Constrains: 0 <= a, b <= 9

Sample:
    Input:
        9 7
    Output:
        16

Time limits (sec.):
    C   C++     Java    Python  Haskell     JavaScript  Scala
    1   1       1.5     5       2           5           3

Memory Limit: 512 Mb
 */

import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(a + b);
    }
}
