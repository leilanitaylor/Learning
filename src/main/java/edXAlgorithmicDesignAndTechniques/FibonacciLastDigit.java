package edXAlgorithmicDesignAndTechniques;
/*
-----------------------------------------------------------------------------
Problem Introduction:
Your goal in this problem is to find the last digit of n-th fibonacci number.
Recall that Fibonacci numbers grow exponentially fast. For example,
    F(200( = 280,571,172,992,510,140,037,611,932,413,038,677,189,525
Therefore, a solution like:
    F[0] = 0
    F[1] = 1
    for i from 2 to n:
        F[i] = F[i-1] + F[i-2]
    print(F[n] mod 10)
will turn out to be too slow, because as i grows the i-th iteration fo the
loop computes the sum of longer and longer numbers. Also, for example, F(1000)
does not fit into the standard C++ int type. To overcome this difficulty, you
may want to store in F[i] not the i-th Fibonacci number itself, but just it's
last digit (that is, F(i) mod 10). Computing the last digit of F(i) is easy:
it is jut the last digit of the sum of the last digits of F(i-1) and F(i-2):
    F[i] = (F[i-1] + F[i-2])mod10
This way, all F[i]'s area just digits, so they fit perfectly into any
standard integer type, and computing a sum of F[i-1] and F[i-2] is performed
very quickly.
------------------------------------------------------------------------------
Problem Description:
    Task: Given an integer n, find the last digit of the n-th Fibonacci
          number F(n) (that is, F(n)mod10)
    Input Format: The input consists of a single integer n
    Constraints: 0 <= n <= 10^7
    Output Format: Output the last digit of F(n)

Sample 1:
    Input:
        3
    Output:
        2
    F(3) = 2

Sample 2:
    Input:
        331
    Output:
        9
    F(331) = 668,996,615,388,005,031,531,000,081,241,745,415,306,766,517,246,774,551,964,595,229,186,469

Sample 3:
    Input:
        327305
    Output:
        5
    F(327305) does not fit in one line, but it's last digit is equal to 5
 */
import java.util.*;

public class FibonacciLastDigit {
    public static int getFibonacciLastDigit(int n) {
        if (n <= 1)
            return n;

        int[] lastDigitArray = new int[n+1];
        lastDigitArray[0] = 0;
        lastDigitArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            lastDigitArray[i] = (lastDigitArray[i-1] + lastDigitArray[i-2]) % 10;
        }

        return lastDigitArray[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

