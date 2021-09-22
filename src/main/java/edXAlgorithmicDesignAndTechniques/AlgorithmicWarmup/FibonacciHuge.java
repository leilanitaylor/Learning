package edXAlgorithmicDesignAndTechniques.AlgorithmicWarmup;
/*
-------------------------------------------------------------------------------------------
Problem Introduction:
In this problem your goal is to compute F(n) modulo m, where n may be really huge: up to
10^18. For such values of n, an algorithm looping for n iterations will not fit into one
second for sure. Therefore, we need to avoid such a loop.
To get an idea how to solve this problem without going through all F(i) for i from 0 to n,
let's see what happens when m is small, say m = 2 or m = 3.
    ------------------------------------------------------------------------
    i       0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
    ------------------------------------------------------------------------
    f(i)    0   1   1   2   3   5   8   13  21  34  5   89  144 233 377 610
    f(i)%2  0   1   1   0   1   1   0   1   1   0   1   1   0   1   1   0
    f(i)%3  0   1   1   2   0   2   2   1   0   1   1   2   0   2   2   1
    ------------------------------------------------------------------------
 Take a detailed look at this table. Do you see? both these sequences are periodic! For
 m = 2, the period is 011 and has length 3, while for m = 3 the period is 01120221 and has
 length 8. Therefore, to compute say, F(2015)mod3 we just need to find the remainder of 2015
 when divided by 8. Since 2015 = 251 * 8 + 7, we conclude that F(2015)mod3 = F(7)mod3 = 1.
 This is true in general: for any integer m >=2, the sequence F(n)modm is periodic. The
 period always starts with 01 and is known as Pisano period.
 ------------------------------------------------------------------------------------------
 Problem Description:
    Task: Given two integers n and m, output F(n)modm (that is, the remainder of F(n) when
            divided by m)
    Input Format: The input consists of two integers n and m given on the same line
            (separated by a space)
    Constraints: 1 <= n <= 10^18, 2 <= m <= 10^5
    Output Format: Output F(n)modm

Sample 1:
    Input: 239 1000
    Output: 161
    F(239)mod1000 = 39,679,027,332,066,820,581,608,740,953,902,289,877,834,488,152,161)mod1000) = 161

Sample 2:
    Input: 2816213588 239
    Output: 151
    F(2816213588) does not fit into one page, but F(2816213588)mod239 = 151
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {

    // fibonacci number modulo m method
    public static long getFibonacciHuge(long n, long m) {

        long pisanoPeriod = getPisanoPeriod(m);
        long newBase = n % pisanoPeriod;

        long previous = 0;
        long current = 1;
        long temp;
        if (newBase == 0 || newBase == 1) return newBase;

        for (int i = 0; i < newBase - 1; i++) {
            temp = current;
            current = (previous + current) % m;
            previous = temp;
        }

        return current % m;
    }



    // pisano period calculation method
    public static long getPisanoPeriod(long m) {
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




    // fibonacci number calculation method
    public static long fibCalc(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; i++) {
            long temp = current;
            current = (previous + current);
            previous = temp;
        }
        System.out.println("Longest long: " + Long.MAX_VALUE);
        System.out.println("Fib Number: " + current);
        return current;
    }





    // main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        System.out.println(getFibonacciHuge(n,m));
    }
}
