package AdventOfCode.AdventOfCode2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Intcode_Day2Test {
    Intcode_Day2 d2;
    @BeforeEach
    public void setUp() {d2 = new Intcode_Day2(); }

    @Test
    void test1setNewValues() {
        List<Integer> opcodes = Arrays.asList(1, 0, 0, 0, 99);
        List<Integer> expected = Arrays.asList(1, 12, 2, 0, 99);
        d2.setNewValues(opcodes, 12, 2);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test2setNewValues() {
        List<Integer> opcodes = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        List<Integer> expected = Arrays.asList(1, 12, 2, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        d2.setNewValues(opcodes, 12, 2);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test1addInputs() {
        int input1 = 30;
        int input2 = 40;
        int expected = 70;
        int result = d2.addInputs(input1, input2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2addInputs() {
        int input1 = 0;
        int input2 = 0;
        int expected = 0;
        int result = d2.addInputs(input1, input2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1multInputs() {
        int input1 = 70;
        int input2 = 50;
        int expected = 3500;
        int result = d2.multInputs(input1, input2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2multInputs() {
        int input1 = 0;
        int input2 = 0;
        int expected = 0;
        int result = d2.multInputs(input1, input2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3multInputs() {
        int input1 = 99;
        int input2 = 99;
        int expected = 9801;
        int result = d2.multInputs(input1, input2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1setSolution() {
        List<Integer> opcodes = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        List<Integer> expected = Arrays.asList(1, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
        int solutionIndex = 3;
        int solution = 70;
        d2.setSolution(opcodes, solutionIndex, solution);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test2setSolution() {
        List<Integer> opcodes = Arrays.asList(1, 0, 0, 0, 99);
        List<Integer> expected = Arrays.asList(2, 0, 0, 0, 99);
        int solutionIndex = 0;
        int solution = 2;
        d2.setSolution(opcodes, solutionIndex, solution);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test1runOpcode() {
        List<Integer> opcodes = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        List<Integer> expected = Arrays.asList(1, 9, 10, 70, 2, 3, 11, 0, 99, 30 ,40 ,50);
        int currentIndex = 0;
        d2.runOpcode(opcodes, currentIndex);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test2runOpcode() {
        List<Integer> opcodes = Arrays.asList(1, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
        List<Integer> expected = Arrays.asList(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
        int currentIndex = 4;
        d2.runOpcode(opcodes, currentIndex);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test1runProgram() {
        List<Integer> opcodes = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        List<Integer> expected = Arrays.asList(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
        d2.runProgram(opcodes);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test2runProgram() {
        List<Integer> opcodes = Arrays.asList(1, 0, 0, 0, 99);
        List<Integer> expected = Arrays.asList(2, 0, 0, 0, 99);
        d2.runProgram(opcodes);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test3runProgram() {
        List<Integer> opcodes = Arrays.asList(2, 3, 0, 3, 99);
        List<Integer> expected = Arrays.asList(2, 3, 0, 6, 99);
        d2.runProgram(opcodes);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test4runProgram() {
        List<Integer> opcodes = Arrays.asList(2, 4, 4, 5, 99, 0);
        List<Integer> expected = Arrays.asList(2, 4, 4, 5, 99, 9801);
        d2.runProgram(opcodes);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test5runProgram() {
        List<Integer> opcodes = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
        List<Integer> expected = Arrays.asList(30, 1, 1, 4, 2, 5, 6, 0, 99);
        d2.runProgram(opcodes);
        Assertions.assertNotNull(opcodes);
        Assertions.assertEquals(expected.size(), opcodes.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), opcodes.get(i));
        }
    }

    @Test
    void test1setUpTest() {
        List<Integer> opcodes = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
        List<Integer> opcodesTest = d2.setUpTest(opcodes);
        Assertions.assertNotNull(opcodesTest);
        Assertions.assertEquals(opcodes.size(), opcodesTest.size());
        for (int i = 0; i < opcodes.size(); i++) {
            Assertions.assertEquals(opcodes.get(i), opcodesTest.get(i));
        }
    }

    @Test
    void test2setUpTest() {
        List<Integer> opcodes = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
        List<Integer> opcodesTest = Arrays.asList(0, 0, 0, 5, 10, 2, 4, 9, 99);
        opcodesTest = d2.setUpTest(opcodes);
        Assertions.assertNotNull(opcodesTest);
        Assertions.assertEquals(opcodes.size(), opcodesTest.size());
        for (int i = 0; i < opcodes.size(); i++) {
            Assertions.assertEquals(opcodes.get(i), opcodesTest.get(i));
        }
    }
}