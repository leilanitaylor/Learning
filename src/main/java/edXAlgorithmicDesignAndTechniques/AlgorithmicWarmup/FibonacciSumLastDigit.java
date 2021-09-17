package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;
/*
Last Digit of the Sum of Fibonacci Numbers
--------------------------------------------------------------------------------------------
Problem Instructions:
The goal in this problem is to find the last digit of a sum of the first n Fibonacci numbers.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Given an integer n, find the last digit of the sum of F(0) + F(1) + ... + F(n)
    Input Format: The input consists of a single integer n
    Constraints: 0 <= n <= 10^14
    Output Format: Output the last digit of F(0) + F(1) + ... + F(n)

Sample 1:
    Input: 3
    Output: 4
    F(0) + F(1) + F(2) + F(3) = 0 + 1 + 1 + 2 = 4

Sample 2:
    Input: 100
    Output: 5
    The sum is equal to 927,372,692,193,078,999,175, the last digit is 5

What to do:
Insted of computing this sum in a loop, try to come up with a formula for
F(0) + F(1) + F(2) + ... + F(n). For this, play with small values of n. Then use a solution
for the previous problem.
 */


import java.util.Scanner;

public class FibonacciSumLastDigit {

    public static long getFibonacciSum(long n) {
        if (n <= 1) return n;

        long pisanoPeriodLength = getPisanoPeriodLength(10);
        //System.out.println("Pisano Period: " +pisanoPeriodLength);
        //long periodSum = (getPisanoPeriodSum(pisanoPeriodLength));
        //System.out.println("Pisano period sum: " + periodSum);
        //long numPisanoPeriods = n / pisanoPeriodLength;
        //System.out.println("Number of Pisano periods: " + numPisanoPeriods);
        long pisanoRemainder = n % pisanoPeriodLength;
        //System.out.println("Pisano remainder: " + pisanoRemainder);
        if (pisanoRemainder <= 1)
            return pisanoRemainder;
        long remainderSum = (getRemainderSum(pisanoRemainder, pisanoPeriodLength));
        //System.out.println("Remainder sum: " + remainderSum);
        long lastDigitSum = remainderSum % 10;


        /*
        int previous = 0;
        int current = 1;
        int sumLastDigit = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = (current + previous) % 10;
            previous = temp;
            sumLastDigit += current;
        }
        return sumLastDigit % 10;
        */
        return lastDigitSum;
    }

    public static long getPisanoPeriodLength(long m) {
        long prev = 0;
        long current = 1;
        long res = 0;
        for (int i = 0; i < m * m; i++) {
            long temp = current;
            current = (prev + current) % m;
            prev = temp;
            if (prev == 0 && current == 1) return i + 1;
        }
        return res;
    }

    public static long getRemainderSum(long r, long p) {
        long remainderSum = 1;
        long prev = 0;
        long current = 1;
        for (long i = 2; i <= r; i++) {
            //System.out.println("Current i: " + i);
            long temp = current;
            current = (prev + current) % p;
            prev = temp;
            remainderSum = (remainderSum + current);
            //System.out.println("Current: " + current + ", Sum: " + remainderSum);
        }
        return remainderSum;
    }


    public static long getFibonacciLastDigit(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 2; i < n + 1; i++) {
            long temp = current;
            current = (current + previous) % 10;
            previous = temp;
        }

        return current;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}
