package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;
/*
-------------------------------------------------------------------------------------------
Problem Introduction:
Now, we would like to find the last digit of a partial sum of Fibonacci numbers:
    F(m) + F(m+1) + ... F(n)
-------------------------------------------------------------------------------------------
Problem Description:
    Task: Given two non-negative integers m and n, where m <= n, find the last digit of
            the sum of F(m) + (F(m+1) + ... + F(n).
    Input Format: Teh input consists of two non-negative integers m and n separated by
            a space.
    Constraints: 0 <= m <= n <= 10^18
    Output Format: Output the last digit of F(m) + F(m+1) + ... + F(n).

Sample 1:
    Input: 3 7
    Output: 1
    F(3) + F(4) + F(5) + F(6) + F(7) = 2 + 3 + 5 + 8 + 13 = 31

Sample 2:
    Input: 10 10
    Output: 5
    F(10) = 55

Sample 3:
    Input: 10 200
    Output: 2
    F(10) + F(11) + ... + F(200) = 734,544,867,157,818,093,234,908,902,110,449,296,423,262
 */

import java.util.Scanner;

public class FibonacciPartialSum {

    public static long getFibonacciPartialSum(long from, long to) {
        //if(to == 0)
        //    return 0;

        long partialSum;
        if (from == 0) {
            partialSum = getFibonacciSum(to);
        } else {

            partialSum = getFibonacciSum(to) - getFibonacciSum(from - 1);
            System.out.println("Sum to: " + to + "Sum from-1: " + (from - 1));
            System.out.println("Sum to: " + getFibonacciSum(to) + ", Sum from-1: " + getFibonacciSum(from - 1) + ", Difference: " + partialSum);
        }
        long partialSumLastDigit = partialSum % 10;
            if(partialSumLastDigit < 0) {
                partialSumLastDigit += 10;
            }

        return partialSumLastDigit;
    }

    public static long getFibonacciSum(long n) {
        if (n <= 1)
            return n;

        long pisanoPeriodLength = getPisanoPeriodLength(10);
        long pisanoRemainder = n % pisanoPeriodLength;
        if (pisanoRemainder == 0)
            return 0;
        long remainderSum = (getRemainderSum(pisanoRemainder, pisanoPeriodLength));

        return remainderSum;
    }

    public static long getPisanoPeriodLength(long m) {
        long prev = 0;
        long current = 1;
        long res = 0;
        for (long i = 0; i < m * m; i++) {
            long temp = current;
            current = (prev + current) % m;
            prev = temp;
            if(prev == 0 && current == 1)
                return i + 1;
        }
        return res;
    }

    public static long getRemainderSum(long r, long p) {
        if (r == 0)
            return 0;
        long remainderSum = 1;
        long prev = 0;
        long current = 1;
        for (long i = 2; i <= r; i++) {
            long temp = current;
            current = (prev + current) % p;
            prev = temp;
            remainderSum += current;
        }
        return remainderSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
