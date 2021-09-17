package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;
/*
--------------------------------------------------------------------------------------------------------------------
Problem Introduction:
The greatest common divisor GCD(a, b) of two non-negative integers a and b (which are not both equal to 0) is the
greatest integer d that divides both a and b. Your goal in this problem is to implement the euclidean algorithm for
computing the greatest common divisor.
Efficient algorithm for computing the greatest common divisor is an important basic primitive of commonly used
cryptographic algorithms like RSA.
      GCD(1344, 217)
    = GCD(217, 42)
    = GCD(42, 7)
    = GCD(7, 0)
    = 7
---------------------------------------------------------------------------------------------------------------------
Problem Description:
    Task: Given two integers a and b, find their greatest common divisor
    Input Format: The two integers a, b are given in the same line separated by space
    Constraint: 1 <= a, b <= 2 * 10^9
    Output Format: Output GCD(a, b)

Sample 1:
    Input:
        18 35
    Output:
        1
    18 and 35 do not have common non-trivial divisors

Sample 2:
    Input:
        28851538 1183019
    Output:
        17657
    28851538 = 17657 * 1634, 1183019 = 17657 * 67
 */

import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b) {
        if (b ==0) {
            return a;
        } else {
            int aPrime = a % b;
            return gcd(b, aPrime);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
    }
}
