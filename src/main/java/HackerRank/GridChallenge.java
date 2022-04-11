package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridChallenge {
    public static void main(String[] args) {
        List<String> grid = Arrays.asList("mpxz", "abcd", "wlmf");

        String response = gridChallenge(grid);

        System.out.println(response);
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<List<Integer>> asciiGrid = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            List<Integer> currentString = new ArrayList<>();
            for (int j = 0; j < grid.get(i).length(); j++) {
                int currentCharacter = grid.get(i).charAt(j);
                currentString.add(currentCharacter);
            }
            Collections.sort(currentString);
            asciiGrid.add(currentString);
        }

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if (asciiGrid.get(j).get(i) > asciiGrid.get(j+1).get(i))
                    return "NO";
            }
        }

        return "YES";
    }

}
