package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

    Day6 d6;
    @BeforeEach
    public void setUp() {d6 = new Day6(); }

    @Test
    void test1combineStrings() {
        String string1 = "ab";
        String string2 = "ac";
        String expected = "abac";
        String result = d6.combineStrings(string1, string2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1setGroups() {
        List<String> answers = Arrays.asList("abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b");
        List<String> expected = Arrays.asList("abc", "abc", "abac", "aaaa", "b");
        List<String> result = d6.setGroups(answers);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void test1getGroupAnswers() {
        List<String> groups = Arrays.asList("abc", "abc", "abac", "aaaa", "b");
        List<HashSet<Character>> expected = new ArrayList<>();
        HashSet<Character> group1 = new HashSet<>();
        group1.add('a');
        group1.add('b');
        group1.add('c');
        expected.add(group1);
        HashSet<Character> group2 = new HashSet<>();
        group2.add('a');
        group2.add('b');
        group2.add('c');
        expected.add(group2);
        HashSet<Character> group3 = new HashSet<>();
        group3.add('a');
        group3.add('b');
        group3.add('c');
        expected.add(group3);
        HashSet<Character> group4 = new HashSet<>();
        group4.add('a');
        expected.add(group4);
        HashSet<Character> group5 = new HashSet<>();
        group5.add('b');
        expected.add(group5);
        List<HashSet<Character>> result = d6.getGroupAnswers(groups);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i ++) {
            Iterator<Character> c = expected.get(i).iterator();
            while (c.hasNext())
                Assertions.assertTrue(result.get(i).contains(c.next()));
        }
    }

    @Test
    void test1getCounts() {
        List<HashSet<Character>> groupAnswers = new ArrayList<>();
        HashSet<Character> group1 = new HashSet<>();
        group1.add('a');
        group1.add('b');
        group1.add('c');
        groupAnswers.add(group1);
        HashSet<Character> group2 = new HashSet<>();
        group2.add('a');
        group2.add('b');
        group2.add('c');
        groupAnswers.add(group2);
        HashSet<Character> group3 = new HashSet<>();
        group3.add('a');
        group3.add('b');
        group3.add('c');
        groupAnswers.add(group3);
        HashSet<Character> group4 = new HashSet<>();
        group4.add('a');
        groupAnswers.add(group4);
        HashSet<Character> group5 = new HashSet<>();
        group5.add('b');
        groupAnswers.add(group5);
        int expected = 11;
        int result = d6.getCounts(groupAnswers);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1getGroupCount() {
        List<String> currentGroup = Arrays.asList("abc");
        int expected = 3;
        int result = d6.getGroupCount(currentGroup);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2getGroupCount() {
        List<String> currentGroup = Arrays.asList("a", "b", "c");
        int expected = 0;
        int result = d6.getGroupCount(currentGroup);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3getGroupCount() {
        List<String> currentGroup = Arrays.asList("ab", "ac");
        int expected = 1;
        int result = d6.getGroupCount(currentGroup);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4getGroupCount() {
        List<String> currentGroup = Arrays.asList("a", "a", "a", "a");
        int expected = 1;
        int result = d6.getGroupCount(currentGroup);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5getGroupCount() {
        List<String> currentGroup = Arrays.asList("b");
        int expected = 1;
        int result = d6.getGroupCount(currentGroup);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1sumGroupCounts() {
        List<String> answers = Arrays.asList("abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b");
        int expected = 6;
        int result = d6.sumGroupCounts(answers);
        Assertions.assertEquals(expected, result);
    }
}