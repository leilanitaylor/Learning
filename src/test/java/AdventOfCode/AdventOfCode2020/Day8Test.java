package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    Day8 d8;
    @BeforeEach
    public void setUp() {d8 = new Day8();}

    @Test
    void test1setRule() {
        List<String> instructions = Arrays.asList("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -1", "acc -99", "acc +1", "jmp -4", "acc +6");
        int index = 0;
        Day8.Rule expected = new Day8.Rule("nop", '+', 0);
        Day8.Rule result = d8.setRule(instructions, index);
        Assertions.assertEquals(expected.operation, result.operation);
        Assertions.assertEquals(expected.direction, result.direction);
        Assertions.assertEquals(expected.increment, result.increment);
    }

    @Test
    void test1checkForRule() {
        HashSet<Integer> sampleExecuted = new HashSet<>();
        sampleExecuted.add(0);
        d8.setInstructionsExecuted(sampleExecuted);
        boolean expected = true;
        boolean result = d8.checkForRule();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2checkForRule() {
        HashSet<Integer> sampleExecuted = new HashSet<>();
        sampleExecuted.add(0);
        d8.setInstructionsExecuted(sampleExecuted);
        d8.setIndex(1);
        boolean expected = false;
        boolean result = d8.checkForRule();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1accOperation() {
        Day8.Rule currentRule = new Day8.Rule("acc", '+', 3);
        d8.accOperation(currentRule);
        int expectedAcc = 3;
        int expectedIndex = 1;
        int resultAcc = d8.getAccumulator();
        int resultIndex = d8.getIndex();
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedIndex, resultIndex);
    }

    @Test
    void test2accOperation() {
        Day8.Rule currentRule = new Day8.Rule("acc", '+', -2);
        d8.setAccumulator(5);
        int expectedAcc = 3;
        int expectedIndex = 1;
        d8.accOperation(currentRule);
        int resultAcc = d8.getAccumulator();
        int resultIndex = d8.getIndex();
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedIndex, resultIndex);
    }

    @Test
    void test1jmpOperation() {
        Day8.Rule currentRule = new Day8.Rule("jmp", '+', 5);
        d8.jmpOperation(currentRule);
        int expectedIndex = 5;
        int expecteAcc = 0;
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expecteAcc, resultAcc);
    }

    @Test
    void test2jmpOperation() {
        Day8.Rule currentRule = new Day8.Rule("jmp", '+', -5);
        d8.setIndex(10);
        d8.jmpOperation(currentRule);
        int expectedIndex = 5;
        int expectedAcc = 0;
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
    }

    @Test
    void test1nopOperation() {
        Day8.Rule currentRule = new Day8.Rule("nop", '+', 5);
        d8.nopOperation(currentRule);
        int expectedIndex = 1;
        int expectedAcc = 0;
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
    }

    @Test
    void test1executeRule() {
        Day8.Rule currentRule = new Day8.Rule("acc", '+', 3);
        d8.executeRule(currentRule);
        int expectedIndex = 1;
        int expectedAcc = 3;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(0);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test2executeRule() {
        Day8.Rule currentRule = new Day8.Rule("acc", '-', 3);
        d8.executeRule(currentRule);
        int expectedIndex = 1;
        int expectedAcc = -3;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(0);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test3executeRule() {
        Day8.Rule currentRule = new Day8.Rule("jmp", '+', 5);
        d8.executeRule(currentRule);
        int expectedIndex = 5;
        int expectedAcc = 0;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(0);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test4executeRule() {
        Day8.Rule currentRule = new Day8.Rule("jmp", '-', 3);
        d8.setIndex(5);
        d8.executeRule(currentRule);
        int expectedIndex = 2;
        int expectedAcc = 0;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(5);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test5executeRule() {
        Day8.Rule currentRule = new Day8.Rule("nop", '+', 25);
        d8.executeRule(currentRule);
        int expectedIndex = 1;
        int expectedAcc = 0;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(0);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test6executeRule() {
        Day8.Rule currentRule = new Day8.Rule("nop", '-', 2);
        d8.executeRule(currentRule);
        int expectedIndex = 1;
        int expectedAcc = 0;
        HashSet<Integer> expectedExecuted = new HashSet<>();
        expectedExecuted.add(0);
        int resultIndex = d8.getIndex();
        int resultAcc = d8.getAccumulator();
        HashSet<Integer> resultExecuted = d8.getInstructionsExecuted();
        Assertions.assertEquals(expectedIndex, resultIndex);
        Assertions.assertEquals(expectedAcc, resultAcc);
        Assertions.assertEquals(expectedExecuted.size(), resultExecuted.size());
        for (Integer rule : expectedExecuted)
            Assertions.assertTrue(resultExecuted.contains(rule));
    }

    @Test
    void test1findAccB4Loop() {
        List<String> instructions = Arrays.asList("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -1", "acc -99", "acc +1", "jmp -4", "acc +6");
        int expectedAcc = 5;
        int resultAcc = d8.findAccB4Loop(instructions);
        Assertions.assertEquals(expectedAcc, resultAcc);
    }
}