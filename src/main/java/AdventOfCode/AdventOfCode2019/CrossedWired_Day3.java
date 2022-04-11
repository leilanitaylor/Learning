package AdventOfCode.AdventOfCode2019;

import java.util.HashMap;
import java.util.Map;

public class CrossedWired_Day3 {

    public static void main(String[] args) {


        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int key = 2;

        Map<Character, Character> cyper = new HashMap<>();

        for (int i = 0; i < characters.length; i++) {
            cyper.put(characters[i], characters[(i+key) % 26]);
        }

        String text = "example";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i ++) {
            result.append(cyper.get(text.charAt(i)));
        }

        System.out.println(result);
    }
}


