package AdventOfCode.AdventOfCode2020;
/*
Day 1:
    Part 1: Find two entries that sum to 2020 and then multiply those two numbers
        together
    Part 2: Find three entries that sum to 2020 and multiply those numbers together
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> expenses = readFile();

        List<Integer> sumTo2020 = new ArrayList<>();
        int howManyToSum = 3;
        sumTo2020 = findIntsSumTo2020(expenses, howManyToSum);

        int productOfExpenses = findProduct(sumTo2020);

        System.out.println(productOfExpenses);
    }

    protected static int findProduct(List<Integer> sumTo2020) {
        int product = sumTo2020.get(0);

        for (int i = 1; i < sumTo2020.size(); i++) {
            product *= sumTo2020.get(i);
        }

        return product;
    }

    protected static List<Integer> findIntsSumTo2020(List<Integer> expenses, int howManyToSum) {
        List<Integer> intsWithSum = new ArrayList<>();
        int[] intsCheck = new int[howManyToSum];

        for (int i = 0; i < expenses.size() - 2; i++) {
            intsCheck[0] = expenses.get(i);
            for (int j = i+1; j < expenses.size() - 1; j++) {
                intsCheck[1] = expenses.get(j);
                for (int k = j + 1; k < expenses.size(); k++) {
                    intsCheck[2] = expenses.get(k);
                    int sumOfInts = findSum(intsCheck);
                    if (sumOfInts == 2020) {
                        for (int l = 0; l < intsCheck.length; l++) {
                            intsWithSum.add(intsCheck[l]);
                        }
                    }
                }
            }
        }
        return intsWithSum;
    }

    protected static int findSum(int[] intsToCheck) {
        int sumOfInts = 0;
        for (int i = 0; i < intsToCheck.length; i++) {
            sumOfInts += intsToCheck[i];
        }
        return sumOfInts;
    }

    private static List<Integer> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day1InputFile.txt");
        File expenseReport = path.toFile();
        List<Integer> expenses = new ArrayList<>();

        Scanner sc = new Scanner(expenseReport);
        while (sc.hasNextLine()) {
            expenses.add(Integer.parseInt(sc.nextLine()));
        }

        return expenses;
    }

}
