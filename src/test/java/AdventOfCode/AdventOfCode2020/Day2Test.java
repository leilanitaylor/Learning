package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    Day2 d2;
    @BeforeEach
    public void setUp() {d2 = new Day2(); }

    @Test
    void test1testValidity() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(1, 3, 'a', "abcde");
        boolean expected = true;
        boolean result = d2.testValidity(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2testValidity() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(1, 3, 'b', "cdefg");
        boolean expected = false;
        boolean result = d2.testValidity(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3testValidity() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(2, 9, 'c', "ccccccccc");
        boolean expected = true;
        boolean result = d2.testValidity(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1countValid() {
        List<Day2.pwPolicy> passwords = new ArrayList<>();
        passwords.add(new Day2.pwPolicy(1, 3, 'a', "abcde"));
        passwords.add(new Day2.pwPolicy(1, 3, 'b', "cdefg"));
        passwords.add(new Day2.pwPolicy(2, 9, 'c', "ccccccccc"));
        int expected = 2;
        int result = d2.countValid(passwords);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1newValidityTest() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(1, 3, 'a', "abcde");
        boolean expected = true;
        boolean result = d2.newValidityTest(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2newValidityTest() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(1, 3, 'b', "cdefg");
        boolean expected = false;
        boolean result = d2.newValidityTest(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3newValidityTest() {
        Day2.pwPolicy testPw = new Day2.pwPolicy(2, 9, 'c', "ccccccccc");
        boolean expected = false;
        boolean result = d2.newValidityTest(testPw);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1newCountValid() {
        List<Day2.pwPolicy> passwords = new ArrayList<>();
        passwords.add(new Day2.pwPolicy(1, 3, 'a', "abcde"));
        passwords.add(new Day2.pwPolicy(1, 3, 'b', "cdefg"));
        passwords.add(new Day2.pwPolicy(2, 9, 'c', "ccccccccc"));
        int expected = 1;
        int result = d2.newCountValid(passwords);
        Assertions.assertEquals(expected, result);
    }
}