package AdventOfCode.AdventOfCode2020;
/*
Day 6:
    Part 1: Form asks 26 yes or no questions marked a through z. Each group's answers
        are separatd by a blank line, and within each group, each person's answers
        are on a single line (the ones they answered yes). Duplicates within a group
        only count once.
        What is the sum of those counts?
    Part 2: You need to identify the questions to which everyone in the group answered
        "yes", not anyone. Find the new count.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> answers = readFile();

        /*
        List<String> groups = setGroups(answers);
        System.out.println("Number of groups: " + groups.size());

        List<HashSet<Character>> groupAnswers = getGroupAnswers(groups);

        int sumOfCounts = getCounts(groupAnswers);

        System.out.println("Sum of Counts: " + sumOfCounts);

         */

        int newCounts = sumGroupCounts(answers);
        System.out.println("New sum of counts: " + newCounts);
    }

    protected static int sumGroupCounts(List<String> answers) {
        List<String> currentGroup = new ArrayList<>();
        int count = 0;
        int numberOfGroups = 0;

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) != "") {
                currentGroup.add(answers.get(i));
            } else if (answers.get(i) == "") {
                int groupCount = getGroupCount(currentGroup);
                count += groupCount;
                numberOfGroups++;
                System.out.println("Current group count: " + groupCount);
                System.out.println("Current total count for " + numberOfGroups + ": " + count);
                while (currentGroup.size() != 0){
                    currentGroup.remove(0);
                }
            }
        }
        int groupCount = getGroupCount((currentGroup));
        count += groupCount;
        return count;
    }

    protected static int getGroupCount(List<String> currentGroup) {
        Map<Character, Integer> groupAnswers = new HashMap<>();
        int groupCount = 0;

        for (int i = 0; i < currentGroup.size(); i++) {
            String currentAnswers = currentGroup.get(i);
            for (int j = 0; j < currentAnswers.length(); j++) {
                int currentCount = groupAnswers.getOrDefault(currentAnswers.charAt(j), 0);
                groupAnswers.put(currentAnswers.charAt(j), currentCount+1);
            }
        }
        for (Map.Entry<Character, Integer> e : groupAnswers.entrySet()) {
            if (e.getValue() == currentGroup.size())
                groupCount++;
        }
        return groupCount;
    }

    protected static int getCounts(List<HashSet<Character>> groupAnswers) {
        int count = 0;
        for (int i = 0; i < groupAnswers.size(); i++) {
            count += groupAnswers.get(i).size();
        }
        return count;
    }

    protected static List<HashSet<Character>> getGroupAnswers(List<String> groups) {
        List<HashSet<Character>> groupAnswers = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            HashSet<Character> currentGroupAnswers = new HashSet<>();
            for (int j = 0; j < groups.get(i).length(); j++) {
                currentGroupAnswers.add(groups.get(i).charAt(j));
            }
            groupAnswers.add(currentGroupAnswers);
        }
        return groupAnswers;
    }

    protected static List<String> setGroups(List<String> answers) {
        List<String> groups = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            if (i+1 < answers.size() && answers.get(i+1) != "" && answers.get(i) != "") {
                answers.set(i+1, combineStrings(answers.get(i), answers.get(i+1)));
            } else if (answers.get(i) != "") {
                groups.add(answers.get(i));
            }
        }
        return groups;
    }

    protected static String combineStrings(String s, String s1) {
        StringBuilder combinedSB = new StringBuilder();
        combinedSB.append(s);
        combinedSB.append(s1);
        return combinedSB.toString();
    }

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day6InputFile.txt");
        File fileOfAnswers = path.toFile();
        List<String> answers = new ArrayList<>();

        Scanner sc = new Scanner(fileOfAnswers);
        while (sc.hasNextLine()) {
            String answer = sc.nextLine();
            answers.add(answer);
        }

        return answers;
    }
}
