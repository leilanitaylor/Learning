package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;
/*
Maximizing Loot
--------------------------------------------------------------------------------------------
Problem Introduction:
A thief finds much more loot than his bag can fit. Help him to find the most valuable
combination of items assuming that any fraction of a loot item can be put into his bag.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: The goal of this code problem is to implement an algorithm for the fractional
        knapsack problem
    Input Format: The first line of the input contains the number of n items and the
        capacity W of the knapsack. The next n lines define the values and the weights
        of the items. The i-th line contains integers v(i) and w(i) - the value and weight
        of the i-th item, respectively
    Constraints: 1 <= n <=^3, 0 <= W <= 2 * 10^6; 0 <= v(i) <= 2 *  10^6,
        0 <= w(i) <= 2 * 10^6, for all 1 <= i <= n. All the numbers are integers.
    Output Format: Output the maximal value of fractions of items that fit into the
        knapsack. The absolute value of the difference between the answer of your program
        and the optimal value should be at most 10^(-3). To ensure this, output your answer
        with at least four digits after the decimal point (otherwise your answer, while
        being computed correctly, can turn out to be wrong because of rounding issues.

Sample 1:
    Input:
        3 50
        60 20
        100 50
        120 30
    Output:
        180.0000
    To achieve the value 180, we take the first item and the third item into the bag.

Sample 2:
    Input:
        1 10
        500 30
    Output:
        166.6667
    Here, we just take one third of the only available item.
 */

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    //private static DecimalFormat df = new DecimalFormat("#.####");

    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        for (int i = 0; i < values.length; i++) {
            if (capacity == 0) {
                double valueRound = Math.round(value * 10000);
                double totalValue = valueRound / 10000;
                //System.out.println(Math.round(valueRound));
                //System.out.println(valueRound / 10000);
                return totalValue;
            } else {
                System.out.println("Start capacity: " + capacity);
                int j = bestItem(values, weights);
                System.out.println("Best Item: " + j);
                double a = Math.min(weights[j], capacity);
                System.out.println("A: " + a);
                value += a * ((double)values[j] / (double)weights[j]);
                System.out.println("Current Value: " + value);
                weights[j] -= a;
                System.out.println("Current weight at Best Item: " + weights[j]);
                capacity -= a;
                System.out.println("End capacity: " + capacity);
            }
        }

/*
        String stringTotalValue = df.format(value);
        System.out.println("Total Value: " + stringTotalValue);
        double totalValue = Double.parseDouble(stringTotalValue);

 */
        //Double totalValue = Double.valueOf((Math.round(value * 10000)) / 10000);
        double valueRound = Math.round(value * 10000);
        double totalValue = valueRound / 10000;
        //System.out.println(Math.round(valueRound));
        //System.out.println(valueRound / 10000);

        return totalValue;
    }

    public static int bestItem(int[] values, int[] weights) {
        double maxValuePerWeight = 0;
        int bestItem = 0;
        //System.out.println("Values: " + Arrays.toString(values));
        //System.out.println("Weights: " + Arrays.toString(weights));
        for (int i = 0; i < values.length; i++) {
            if (weights[i] > 0) {
                //System.out.println("Current value: " + values[i] + ", Current weight: " + weights[i]);
                //System.out.println("Current value per weight: " + ((double)values[i] / (double)weights[i]));
                //System.out.println("Current max value per weight: " + maxValuePerWeight);
                if ((double)values[i] / (double)weights[i] > maxValuePerWeight)  {
                    //System.out.println("Current best item: " + bestItem);
                    maxValuePerWeight = (double)values[i] / (double)weights[i];
                    bestItem = i;
                    //System.out.println("New best item: " + bestItem + ", New max value per weight: " + maxValuePerWeight);
                }
            }
        }
        return bestItem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int [n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
