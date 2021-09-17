package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;

/*
--------------------------------------------------------------------------------------------
Problem Introduction:
The least common multiple of two positive integers a and b is the least positive integer m
that is divisible by both a and b.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Given two integers a and b, find their least common multiple
    Input Format: The two integers a and b are given in the same line separated by space
    Constraints: 1 <= a, b <= 2 * 10^9
    Output Format: Output the least common multiple of a and b

Sample 1:
    Input: 6 8
    Output: 24
    Among all the positive integers that are divisible by both 6 and 8 (e.g., 48, 48, 24),
    24 is the smallest

Sample 2:
    Input: 28851538 1183019
    Output: 1933053046
    1933053046 is the smallest positive integer divisible by both 28851538 and 1183019
 */

import java.util.Scanner;

public class LCM {

    public static long lcmCalc(int a, int b) {
        int gcd = gcdCalc(a, b);
        long intA = (long) a;
        long intB = (long) b;
        long lcm = (intA * intB) / gcd;
        return lcm;
    }

    public static int gcdCalc(int a, int b) {
        if (b ==0) {
            return a;
        } else {
            int aPrime = a % b;
            return gcdCalc(b, aPrime);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcmCalc(a, b));
    }

}
