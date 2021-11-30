package AdventOfCode.AdventOfCode2020;
/*
Day 8:
    Part 1: Code represented as a text file with one instruction per line of text.
        Each instruction consists of an operation (acc, jmp, or nop) and an argument
        (a signed number like +4 or -20).
            - acc increases or decreases a single global value called the accumulator
              by the value given in the argument. The accumulator starts at 0. After
              an acc instruction, the instruction immediately below it is executed
              next.
            - jmp jumps to a new instruction relative to itself. For example, jmp +2
              would skip the next line and continue the instruction immediately below
              it, and jmp -20 would cause the instructions 20 lines above to be
              executed next.
            - nop stands for No OPeration - it does nothing. The instruction
            immediately below it is executed next.
        The input data causes an infinite loop. The moment the program tries to run any
        instruction a second time, you know it will never terminate.
        Immediately before the program would run an instruction a second time, what
        value is in the accumulator?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    static private int accumulator = 0;
    static private int index = 0;
    static private HashSet<Integer> instructionsExecuted = new HashSet<>();
    static private boolean hasRuleBeenExecuted = false;

    public static void main(String[] args) throws FileNotFoundException {
        List<String> instructions = readFile();

        int accBeforeLoop = findAccB4Loop(instructions);

        System.out.println("Value of accumulator before start of loop is: " + accBeforeLoop);

    }

    protected static int findAccB4Loop(List<String> instructions) {
        Integer accBeforeLoop = null;

        while (!hasRuleBeenExecuted) {
            hasRuleBeenExecuted = checkForRule();

            if (hasRuleBeenExecuted) {
                accBeforeLoop = accumulator;
            }

            Rule currentRule = setRule(instructions, index);

            executeRule(currentRule);
        }
        return accBeforeLoop;
    }

    protected static void executeRule(Rule currentRule) {
        instructionsExecuted.add(index);
        if (currentRule.operation.equals("acc"))
            accOperation(currentRule);
        if (currentRule.operation.equals("jmp"))
            jmpOperation(currentRule);
        if (currentRule.operation.equals("nop"))
            nopOperation(currentRule);

    }

    protected static void nopOperation(Rule currentRule) {
        index++;
    }

    protected static void jmpOperation(Rule currentRule) {
        if (currentRule.direction == '+')
            index += currentRule.increment;
        else index -= currentRule.increment;
    }

    protected static void accOperation(Rule currentRule) {
        if (currentRule.direction == '+')
            accumulator += currentRule.increment;
        else accumulator -= currentRule.increment;
        index++;
    }

    protected static boolean checkForRule() {
        boolean currentRuleInList = instructionsExecuted.contains(index);
        return currentRuleInList;
    }

    protected static Rule setRule(List<String> instructions, int index) {
        String ruleAsString = instructions.get(index);

        String operation = ruleAsString.substring(0, 3);
        char direction = ruleAsString.charAt(4);
        int increment = Integer.parseInt(ruleAsString.substring(5));

        Rule currentRule = new Rule(operation, direction, increment);
        return currentRule;
    }

    public static int getAccumulator() {
        return accumulator;
    }

    public static void setAccumulator(int accumulator) {
        Day8.accumulator = accumulator;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Day8.index = index;
    }

    public static HashSet<Integer> getInstructionsExecuted() {
        return instructionsExecuted;
    }

    public static void setInstructionsExecuted(HashSet<Integer> instructionsExecuted) {
        Day8.instructionsExecuted = instructionsExecuted;
    }

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day8InputFile.txt");
        File instructionsFile = path.toFile();
        List<String> instructions = new ArrayList<>();

        Scanner sc = new Scanner(instructionsFile);
        while (sc.hasNextLine()) {
            String instruction = sc.nextLine();
            instructions.add(instruction);
        }
        return instructions;
    }

    static class Rule {
        String operation;
        char direction;
        int increment;

        Rule(String operation, char direction, int increment) {
            this.operation = operation;
            this.direction = direction;
            this.increment = increment;
        }
    }
}
