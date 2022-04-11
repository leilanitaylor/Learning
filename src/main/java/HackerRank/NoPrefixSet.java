package HackerRank;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NoPrefixSet {
    static class Result {

        /*
         * Complete the 'noPrefix' function below.
         *
         * The function accepts STRING_ARRAY words as parameter.
         */

        public static void noPrefix(List<String> words) {
            // Write your code here
            boolean badSet = false;

            List<List<String>> allSubstrings = new ArrayList<>();
            allSubstrings.add(new ArrayList<>());
            Map<Integer, List<String>> prevWords = new HashMap<>();

            for (int i = 0; i < words.size(); i++) {
                if (badSet)
                    break;

                String currentWord = words.get(i);

                if (currentWord.length() < allSubstrings.size()) {
                    List<String> checkSubstrings = allSubstrings.get(currentWord.length());

                    if (checkSubstrings.contains(currentWord)) {
                        System.out.println("BAD SET");
                        System.out.println(currentWord);
                        badSet = true;
                        break;
                    }
                }

                for (int j = 1; j <= currentWord.length(); j++) {
                    if (badSet)
                        break;
                    String currentSubstring = currentWord.substring(0, j);
                    List<String> substringList = new ArrayList<>();
                    if (allSubstrings.size() <= j) {
                        substringList.add(currentSubstring);
                        allSubstrings.add(substringList);
                    } else {
                        if (prevWords.containsKey(j)) {
                            if (prevWords.get(j).contains(currentSubstring)) {
                                System.out.println("BAD SET");
                                System.out.println(currentWord);
                                badSet = true;
                                break;
                            }
                        }
                        substringList = allSubstrings.get(j);
                        substringList.add(currentSubstring);
                        allSubstrings.set(j, substringList);
                    }
                }


                List<String> wordLengthList = new ArrayList<>();
                if (prevWords.containsKey(currentWord.length()))
                    wordLengthList = prevWords.get(currentWord.length());
                wordLengthList.add(currentWord);
                prevWords.put(currentWord.length(), wordLengthList);
            }

            if (!badSet)
                System.out.println("GOOD SET");
        }


    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            Path path = Paths.get("src/main/resources").resolve("NoPrefixSet.txt");
            File noPrefixFile = path.toFile();

            Scanner sc = new Scanner(noPrefixFile);

            int n = Integer.parseInt(String.valueOf(sc.nextInt()));

            List<String> words = IntStream.range(0, n).mapToObj(i -> {
                        return sc.next();
                    })
                    .collect(toList());

            Result.noPrefix(words);

            sc.close();
        }
    }

    /*
    // Attempt 1
    static class Result {


        // * Complete the 'noPrefix' function below.
         //*
         //* The function accepts STRING_ARRAY words as parameter.


        public static void noPrefix(List<String> words) {
            // Write your code here
            List<WordLength> wordLengths = new ArrayList<>();

            for (int i = 0; i < words.size(); i++) {
                wordLengths.add(new WordLength(words.get(i), i));
            }

            wordLengths = sortWordLengths(wordLengths);

            boolean badSet = false;

            for (int i = 0; i < words.size(); i++) {
                if (badSet)
                    break;
                for (int j = 0; j < wordLengths.size(); j++) {
                    if (wordLengths.get(j).index == i)
                        continue;
                    if (wordLengths.get(j).length > words.get(i).length())
                        break;
                    if (wordLengths.get(j).word.equals(words.get(i).substring(0, wordLengths.get(j).length))) {
                        System.out.println("BAD SET");
                        System.out.println(words.get(i));
                        badSet = true;
                        break;
                    }
                }
            }

            if (!badSet)
                System.out.println("GOOD SET");
        }

        public static List<WordLength> sortWordLengths(List<WordLength> wordLengths) {
            for (int i = 1; i < wordLengths.size(); i++) {
                int currentIndex = i;
                while (currentIndex > 0 && wordLengths.get(currentIndex).length < wordLengths.get(currentIndex-1).length) {
                    WordLength temp = wordLengths.get(currentIndex);
                    wordLengths.set(currentIndex, wordLengths.get(currentIndex-1));
                    wordLengths.set(currentIndex-1, temp);
                    currentIndex--;
                }
            }

            return wordLengths;
        }



        public static class WordLength {
            int length;
            String word;
            int index;

            public WordLength (String word, int index) {
                length = word.length();
                this.word = word;
                this.index = index;
            }
        }
    }
    */

    /*
    // Attempt 2
    static class Result {


         //* Complete the 'noPrefix' function below.
         //*
         //* The function accepts STRING_ARRAY words as parameter.


        public static void noPrefix(List<String> words) {
            // Write your code here

            boolean badSet = false;

            Map<Integer, List<String>> prevWords = new HashMap<>();

            for (int i = 0; i < words.size(); i++) {
                if (badSet)
                    break;

                for (int j = 1; j <= words.get(i).length(); j++) {
                    if (prevWords.containsKey(j)) {
                        List<String> checkStrings = prevWords.get(j);
                        badSet = checkStrings.contains(words.get(i).substring(0, j));
                        if (badSet) {
                            System.out.println("BAD SET");
                            System.out.println(words.get(i));
                            break;
                        }
                    }
                }
                List<String> currentList = new ArrayList<>();
                if (prevWords.containsKey(words.get(i).length()))
                    currentList = prevWords.get(words.get(i).length());
                currentList.add(words.get(i));
                prevWords.put(words.get(i).length(), currentList);
            }

            if (!badSet)
                System.out.println("GOOD SET");
        }

    }

     */

    /*
    // attempt 3
    static class Result {


         //* Complete the 'noPrefix' function below.
         //*
         //* The function accepts STRING_ARRAY words as parameter.


    public static void noPrefix(List<String> words) {
        // Write your code here
        boolean badSet = false;

        Map<Integer, List<String>> prevWords = new HashMap<>();
        List<Integer> wordLengths = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (badSet)
                break;

            String currentWord = words.get(i);
            for (int j = 0; j < wordLengths.size(); j++) {
                if (badSet)
                    break;
                int lengthToCheck = wordLengths.get(j);
                List<String> listToCheck = prevWords.get(lengthToCheck);
                if (lengthToCheck == currentWord.length()) {
                    if (listToCheck.contains(currentWord)) {
                        System.out.println("BAD SET");
                        System.out.println(currentWord);
                        badSet = true;
                        break;
                    }
                } else if (lengthToCheck < currentWord.length()) {
                    String substringToCheck = currentWord.substring(0, lengthToCheck);
                    if (listToCheck.contains(substringToCheck)) {
                        System.out.println("BAD SET");
                        System.out.println(currentWord);
                        badSet = true;
                        break;
                    }
                } else if (lengthToCheck > currentWord.length()) {
                    for (int k = 0; k < listToCheck.size(); k++) {
                        String substringToCheck = listToCheck.get(k).substring(0, currentWord.length());
                        if (substringToCheck.equals(currentWord)) {
                            System.out.println("BAD SET");
                            System.out.println(currentWord);
                            badSet = true;
                            break;
                        }
                    }
                }
            }

            List<String> newList = new ArrayList<>();
            if (wordLengths.contains(currentWord.length())) {
                newList = prevWords.get(currentWord.length());
            } else {
                wordLengths.add(currentWord.length());
            }
            newList.add(currentWord);
            prevWords.put(currentWord.length(), newList);

        }

        if (!badSet)
            System.out.println("GOOD SET");
    }


}
     */
}
