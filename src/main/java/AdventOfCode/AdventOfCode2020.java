package AdventOfCode;
/*
Day 1:
    Part 1: Find two entries that sum to 2020 and then multiply those two numbers
        together
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode2020 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> expenses = readFile();

        List<Integer> sumTo2020 = new ArrayList<>();
        sumTo2020 = findIntsSumTo2020(expenses);

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

    protected static List<Integer> findIntsSumTo2020(List<Integer> expenses) {
        List<Integer> IntsWithSum = new ArrayList<>();

        for (int i = 0; i < expenses.size() - 1; i++) {
            int firstExpense = expenses.get(i);
            for (int j = i+1; j < expenses.size(); j++) {
                int secondExpense = expenses.get(j);
                int sumOfInts = findSum(firstExpense, secondExpense);
                if (sumOfInts == 2020) {
                    IntsWithSum.add(firstExpense);
                    IntsWithSum.add(secondExpense);
                }
            }
        }
        return IntsWithSum;
    }

    protected static int findSum(Integer firstExpense, Integer secondExpense) {
        return firstExpense + secondExpense;
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
