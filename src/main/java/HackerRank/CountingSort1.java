package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort1 {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 3, 2, 1);

        List<Integer> frequencyArray = Result.countingSort(arr);

        System.out.println(frequencyArray);
    }

    static class Result {


        /*
         * Complete the 'countingSort' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> countingSort(List<Integer> arr) {
            // Write your code here
            List<Integer> frequencyArray = new ArrayList<>();

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > frequencyArray.size() - 1) {
                    frequencyArray = expandFrequencyArray(frequencyArray, arr.get(i));
                }
                frequencyArray.set(arr.get(i), frequencyArray.get(arr.get(i))+1);
            }

            return frequencyArray;
        }

        public static List<Integer> expandFrequencyArray(List<Integer> frequencyArray, int desiredSize) {
            frequencyArray.add(0);

            if (frequencyArray.size() - 1 == desiredSize) {
                return frequencyArray;
            }

            return expandFrequencyArray(frequencyArray, desiredSize);
        }
    }
}
