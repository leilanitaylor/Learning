package main.juniorJavaDevClass.basics;

import java.util.Arrays;

public class Lab1 {
    public static void main(String[] args) {
    int n = 7;
    int[] array = {5, 3, 5, 7, 10, 16, 20, 25, 1, 100};

    System.out.println("Sum of 1 to " + n + " is: " + sum(n));
    System.out.println("Factorial of " + n + " is: " + factorial(n));
    System.out.println("Minimum of the array is: " + minimum((array)));
    System.out.println("The average value of the array is: " + average(array));
    System.out.println("Maximum of the array is: " + maximum(array));


    }

    // sum of numbers 1 to n
    public static int sum(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }
        else if (n > 1) {
            while (n > 1) {
                sum += n;
                n--;
            }
            return  sum;
        }
        return -1;
    }

    // factorial of n
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    // find minimum of an array of integers
    public static int minimum(int[] array) {
        int minimum = array[0];
        for(int i = 0; i < array.length; i++) {
           if (array[i] < minimum) {
             minimum = array[i];
           }
        }
        return  minimum;
    }

    // find the average of an array of integers
    public static double average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return  sum / array.length;
    }

    // find the maximum of an array of integers
    public static int maximum(int[] array) {
        int maximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array [i];
            }
        }
        return  maximum;
    }
}
