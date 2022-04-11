package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pairs {
    public static void main(String[] args) {
        int k = 1;

        List<Integer> arr = Arrays.asList(363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793);

        int result = pairs(k, arr);

        System.out.println(result);
    }

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int numPairs = 0;

        Collections.sort(arr);

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (j - i == k)
                    numPairs++;
                if (j - i > k)
                    break;
            }
        }

        return numPairs;
    }
}
