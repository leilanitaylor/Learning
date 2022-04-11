package HackerRank;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(11, 2, 4);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(10, 8, -12);

        List<List<Integer>> arr = Arrays.asList(list1, list2, list3);

        int diagonalDistance = diagonalDifference(arr);

        System.out.println(diagonalDistance);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            System.out.println("Primary Sum: " + primaryDiagonalSum + ", value added: " + arr.get(i).get(i));
        }

        int j = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            secondaryDiagonalSum += arr.get(j).get(i);
            System.out.println("Secondary Sum: " + secondaryDiagonalSum + ", value added: " + arr.get(j).get(i));
            j++;
        }

        int diagonalDifference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println("Primary Sum: " + primaryDiagonalSum + ", Secondary Sum: " + secondaryDiagonalSum + ", Difference: " + diagonalDifference);

        return diagonalDifference;
    }
}
