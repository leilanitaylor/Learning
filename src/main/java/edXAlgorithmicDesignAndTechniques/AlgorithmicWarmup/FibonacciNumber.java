package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;
/*
----------------------------------------------------------------------------
Problem Introduction:
The definition of Fibonacci sequence: F(0) = 0, F(1) = 1, and
F(i) = F(i-1) + F(i-2) for i >= 2. Your goal in this problem is to implement
an efficient algorithm for computing Fibonacci numbers. The starter files
for this problem contain an implementation fo the following naive recursive
algorithm for computing Fibonacci numbers.
    Fibonacci(n):
    if n <= 1:
        return n
    return Fibonacci(n-1) + Fibonacci(n-2)
-----------------------------------------------------------------------------
Problem Description:
    Task: Given an integer n, find the nth Fibonacci number F(n)
    Input Format: The input consists of a single integer n
    Constraints: 0  <= n <= 45
    Output Format: Output F(n)

Sample:
    Input:
        10
    Output:
        55
 */


import java.util.Scanner;

public class FibonacciNumber {
    public static long calcFib(int n) {
        long fibNumber;
        long[] fibList = new long[n + 1];
        if (n == 0) {
            fibNumber = 0;
        } else {
            fibList[0] = 0;
            fibList[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibList[i] = fibList[i - 1] + fibList[i - 2];
            }
            fibNumber = fibList[n];
        }
        return fibNumber;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFib(n));
    }
}