package AdventOfCode.AdventOfCode2020;
/*
Day 6:
    Part 1: Form asks 26 yes or no questions marked a through z. Each group's answers
        are separatd by a blank line, and within each group, each person's answers
        are on a single line (the ones they answered yes). Duplicates within a group
        only count once.
        What is the sum of those counts?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> answers = readFile();

        List<String> groups = setGroups(answers);

        List<HashSet<Character>> groupAnswers = getGroupAnswers(groups);

        int sumOfCounts = getCounts(groupAnswers);

        System.out.println("Sum of Counts: " + sumOfCounts);
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
