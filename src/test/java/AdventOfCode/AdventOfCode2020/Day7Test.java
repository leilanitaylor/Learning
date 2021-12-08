package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day7Test {

    Day7 d7;
    @BeforeEach
    public void setUp() {d7 = new Day7(); }

    @Test
    void test1getBagColor() {
        String rule = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        String expected = "light red";
        String result = d7.getBagColor(rule, 0);
    }

    @Test
    void test1getChildBagColors() {
        String rule = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        List<String[][]> childrenBagColors = new ArrayList<>();
        int currentIndex = 10;
        int test = d7.getChildBagColor(childrenBagColors, rule, currentIndex);
        List<String[][]> expected = new ArrayList<>();
        String[][] childBag = {{"1"}, {"bright white"}};
        expected.add(childBag);
        int endingIndex = 37;
        Assertions.assertEquals(endingIndex, test);
        Assertions.assertEquals(expected.size(), childrenBagColors.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertTrue(expected.get(i)[0][0].equals(childrenBagColors.get(i)[0][0]));
            Assertions.assertTrue(expected.get(i)[1][0].equals(childrenBagColors.get(i)[1][0]));
        }
    }

    @Test
    void test1createNewBag() {
        List<Day7.Node> rules = new ArrayList<>();
        String bagColor = "light red";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        d7.createNewBag(rules, bagColor);
        Assertions.assertEquals(expected.size(), rules.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, rules.get(i).bagColor);
            Assertions.assertEquals(expected.get(i).childrenBags, rules.get(i).childrenBags);
            Assertions.assertEquals(expected.get(i).isBase, rules.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag, rules.get(i).parentBag);
        }
    }

    @Test
    void test1setCurrentBag() {
        List<Day7.Node> rules = new ArrayList<>();
        String bagColor = "light red";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        d7.setCurrentBag(rules, bagColor);
        Assertions.assertEquals(expected.size(), rules.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, rules.get(i).bagColor);
            Assertions.assertEquals(expected.get(i).childrenBags, rules.get(i).childrenBags);
            Assertions.assertEquals(expected.get(i).isBase, rules.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag, rules.get(i).parentBag);
        }
    }

    @Test
    void test2setCurrentBag() {
        List<Day7.Node> rules = new ArrayList<>();
        rules.add(new Day7.Node("light red", true));
        rules.add(new Day7.Node("bright white", rules.get(0)));
        rules.add(new Day7.Node("muted yellow", rules.get(0)));
        String bagColor = "bright white";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        expected.add(new Day7.Node("muted yellow", expected.get(0)));
        expected.get(1).isBase = true;
        d7.setCurrentBag(rules, bagColor);
        Assertions.assertEquals(expected.size(), rules.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, rules.get(i).bagColor);
            Assertions.assertEquals(expected.get(i).childrenBags, rules.get(i).childrenBags);
            Assertions.assertEquals(expected.get(i).isBase, rules.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), rules.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, rules.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1getIndex() {
        List<Day7.Node> rules = new ArrayList<>();
        rules.add(new Day7.Node("light red", true));
        String bagColor = "light red";
        int expected = 0;
        int result = d7.getIndex(rules, bagColor);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2getIndex() {
        List<Day7.Node> rules = new ArrayList<>();
        rules.add(new Day7.Node("light red", true));
        rules.add(new Day7.Node("bright white", rules.get(0)));
        rules.add(new Day7.Node("muted yellow", rules.get(0)));
        String bagColor = "bright white";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        expected.add(new Day7.Node("muted yellow", expected.get(0)));
        expected.get(1).isBase = true;
        d7.setCurrentBag(rules, bagColor);
        int expectedIndex = 1;
        int result = d7.getIndex(rules, bagColor);
        Assertions.assertEquals(expectedIndex, result);
    }

    @Test
    void test1createNewChild() {
        List<Day7.Node> bags = new ArrayList<>();
        Day7.Node currentParrent = new Day7.Node("light red", true);
        bags.add(currentParrent);
        String bagColor = "bright white";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        //expected.get(0).childrenBags.add(expected.get(1));
        int childBagIndex = 1;
        int result = d7.createNewChild(bags, bagColor, currentParrent, 0);
        Assertions.assertEquals(childBagIndex, result);
        Assertions.assertEquals(expected.size(), bags.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, bags.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, bags.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, bags.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), bags.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, bags.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1addChildBag() {
        List<Day7.Node> bags = new ArrayList<>();
        Day7.Node currentParrent = new Day7.Node("light red", true);
        bags.add(currentParrent);
        bags.add(new Day7.Node("bright white", bags.get(0)));
        int currentBagIndex = 0;
        int childBagIndex = 1;
        int numOfChildBag = 1;
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        expected.get(0).childrenBags.add(expected.get(1));
        d7.addChildBag(currentBagIndex, childBagIndex, numOfChildBag, bags);
        Assertions.assertEquals(expected.size(), bags.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, bags.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, bags.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, bags.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), bags.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, bags.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test2addChildBag() {
        List<Day7.Node> bags = new ArrayList<>();
        Day7.Node currentParrent = new Day7.Node("light red", true);
        bags.add(currentParrent);
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        int currentBagIndex = 0;
        int childBagIndex = 1;
        int numOfChildBag = 2;
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("muted yellow", expected.get(0)));
        expected.get(0).childrenBags.add(expected.get(1));
        expected.get(0).childrenBags.add(expected.get(1));
        d7.addChildBag(currentBagIndex, childBagIndex, numOfChildBag, bags);
        Assertions.assertEquals(expected.size(), bags.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, bags.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, bags.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, bags.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), bags.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, bags.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1setChildrenBags() {
        List<Day7.Node> bags = new ArrayList<>();
        Day7.Node currentParrent = new Day7.Node("light red", true);
        bags.add(currentParrent);
        List<String[][]> childrenBagColors = new ArrayList<>();
        String[][] childBag1 = {{"1"}, {"bright white"}};
        String[][] childBag2 = {{"2"}, {"muted yellow"}};
        childrenBagColors.add(childBag1);
        childrenBagColors.add(childBag2);
        int currentBagIndex = 0;
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", currentParrent));
        expected.add(new Day7.Node("muted yellow", currentParrent));
        expected.get(0).childrenBags.add(expected.get(1));
        expected.get(0).childrenBags.add(expected.get(2));
        expected.get(0).childrenBags.add(expected.get(2));
        d7.setChildrenBags(bags, childrenBagColors, currentBagIndex);
        Assertions.assertEquals(expected.size(), bags.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, bags.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, bags.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, bags.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), bags.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, bags.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test2setChildrenBags() {
        List<Day7.Node> rules = new ArrayList<>();
        Day7.Node currentParrent = new Day7.Node("light red", true);
        rules.add(currentParrent);
        rules.add(new Day7.Node("bright white", true));
        List<String[][]> childrenBagColors = new ArrayList<>();
        String[][] childBag1 = {{"1"}, {"bright white"}};
        String[][] childBag2 = {{"2"}, {"muted yellow"}};
        childrenBagColors.add(childBag1);
        childrenBagColors.add(childBag2);
        int currentBagIndex = 0;
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", currentParrent));
        expected.add(new Day7.Node("muted yellow", currentParrent));
        expected.get(0).childrenBags.add(expected.get(1));
        expected.get(0).childrenBags.add(expected.get(2));
        expected.get(0).childrenBags.add(expected.get(2));
        expected.get(1).isBase = true;
        d7.setChildrenBags(rules, childrenBagColors, currentBagIndex);
        Assertions.assertEquals(expected.size(), rules.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, rules.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, rules.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, rules.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), rules.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, rules.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1createRule() {
        List<Day7.Node> rules = new ArrayList<>();
        String rule = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        expected.add(new Day7.Node("muted yellow", expected.get(0)));
        expected.get(0).childrenBags.add(expected.get(1));
        expected.get(0).childrenBags.add(expected.get(2));
        d7.createRule(rule, rules);
        Assertions.assertEquals(expected.size(), rules.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, rules.get(i).bagColor);
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, rules.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, rules.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), rules.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, rules.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1setRules() {
        List<String> rulesFile = new ArrayList<>();
        rulesFile.add("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        rulesFile.add("dark orange bags contain 3 bright white bags, 4 muted yellow bags.");
        rulesFile.add("bright white bags contain 1 shiny gold bag.");
        rulesFile.add("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");
        rulesFile.add("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");
        rulesFile.add("dark olive bags contain 3 faded blue bags, 4 dotted black bags.");
        rulesFile.add("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.");
        rulesFile.add("faded blue bags contain no other bags.");
        rulesFile.add("dotted black bags contain no other bags.");
        List<Day7.Node> expected = new ArrayList<>();
        expected.add(new Day7.Node("light red", true));
        expected.add(new Day7.Node("bright white", expected.get(0)));
        expected.add(new Day7.Node("muted yellow", expected.get(0)));
        expected.get(0).childrenBags.add(expected.get(1));
        expected.get(0).childrenBags.add(expected.get(2));
        expected.get(0).childrenBags.add(expected.get(2));
        expected.add(new Day7.Node("dark orange", true));
        expected.get(1).parentBag.add(expected.get(3));
        expected.get(2).parentBag.add(expected.get(3));
        expected.get(3).childrenBags.add(expected.get(1));
        expected.get(3).childrenBags.add(expected.get(1));
        expected.get(3).childrenBags.add(expected.get(1));
        expected.get(3).childrenBags.add(expected.get(2));
        expected.get(3).childrenBags.add(expected.get(2));
        expected.get(3).childrenBags.add(expected.get(2));
        expected.get(3).childrenBags.add(expected.get(2));
        expected.get(1).isBase = true;
        expected.add(new Day7.Node("shiny gold", expected.get(1)));
        expected.get(1).childrenBags.add(expected.get(4));
        expected.get(2).isBase = true;
        expected.get(4).parentBag.add(expected.get(2));
        expected.add(new Day7.Node("faded blue", expected.get(2)));
        expected.get(2).childrenBags.add(expected.get(4));
        expected.get(2).childrenBags.add(expected.get(4));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(2).childrenBags.add(expected.get(5));
        expected.get(4).isBase = true;
        expected.add(new Day7.Node("dark olive", expected.get(4)));
        expected.add(new Day7.Node("vibrant plum", expected.get(4)));
        expected.get(4).childrenBags.add(expected.get(6));
        expected.get(4).childrenBags.add(expected.get(7));
        expected.get(4).childrenBags.add(expected.get(7));
        expected.get(6).isBase = true;
        expected.get(5).parentBag.add(expected.get(6));
        expected.add(new Day7.Node("dotted black", expected.get(6)));
        expected.get(6).childrenBags.add(expected.get(5));
        expected.get(6).childrenBags.add(expected.get(5));
        expected.get(6).childrenBags.add(expected.get(5));
        expected.get(6).childrenBags.add(expected.get(8));
        expected.get(6).childrenBags.add(expected.get(8));
        expected.get(6).childrenBags.add(expected.get(8));
        expected.get(6).childrenBags.add(expected.get(8));
        expected.get(7).isBase = true;
        expected.get(5).parentBag.add(expected.get(7));
        expected.get(8).parentBag.add(expected.get(7));
        expected.get(7).childrenBags.add(expected.get(5));
        expected.get(7).childrenBags.add(expected.get(5));
        expected.get(7).childrenBags.add(expected.get(5));
        expected.get(7).childrenBags.add(expected.get(5));
        expected.get(7).childrenBags.add(expected.get(5));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(7).childrenBags.add(expected.get(8));
        expected.get(5).isBase = true;
        expected.get(8).isBase = true;
        List<Day7.Node> result = d7.setRules(rulesFile);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).bagColor, result.get(i).bagColor);
            Assertions.assertEquals(expected.get(i).childrenBags.size(), result.get(i).childrenBags.size());
            for (int j = 0; j < expected.get(i).childrenBags.size(); j++) {
                Assertions.assertEquals(expected.get(i).childrenBags.get(j).bagColor, result.get(i).childrenBags.get(j).bagColor);
            }
            Assertions.assertEquals(expected.get(i).isBase, result.get(i).isBase);
            Assertions.assertEquals(expected.get(i).parentBag.size(), result.get(i).parentBag.size());
            for (int j = 0; j < expected.get(i).parentBag.size(); j++) {
                Assertions.assertEquals(expected.get(i).parentBag.get(j).bagColor, result.get(i).parentBag.get(j).bagColor);
            }
        }
    }

    @Test
    void test1findDesired() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("light red", true));
        bags.add(new Day7.Node("bright white", bags.get(0)));
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.add(new Day7.Node("dark orange", true));
        bags.get(1).parentBag.add(bags.get(3));
        bags.get(2).parentBag.add(bags.get(3));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("shiny gold", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(4));
        bags.get(2).isBase = true;
        bags.get(4).parentBag.add(bags.get(2));
        bags.add(new Day7.Node("faded blue", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark olive", bags.get(4)));
        bags.add(new Day7.Node("vibrant plum", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(6));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(6).isBase = true;
        bags.get(5).parentBag.add(bags.get(6));
        bags.add(new Day7.Node("dotted black", bags.get(6)));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(7).isBase = true;
        bags.get(5).parentBag.add(bags.get(7));
        bags.get(8).parentBag.add(bags.get(7));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(5).isBase = true;
        bags.get(8).isBase = true;
        Day7.Node currentBag = bags.get(0);
        String desiredBag = "shiny gold";
        boolean expected = true;
        boolean result = d7.findDesired(desiredBag, currentBag);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2findDesired() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("light red", true));
        bags.add(new Day7.Node("bright white", bags.get(0)));
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.add(new Day7.Node("dark orange", true));
        bags.get(1).parentBag.add(bags.get(3));
        bags.get(2).parentBag.add(bags.get(3));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("shiny gold", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(4));
        bags.get(2).isBase = true;
        bags.get(4).parentBag.add(bags.get(2));
        bags.add(new Day7.Node("faded blue", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark olive", bags.get(4)));
        bags.add(new Day7.Node("vibrant plum", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(6));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(6).isBase = true;
        bags.get(5).parentBag.add(bags.get(6));
        bags.add(new Day7.Node("dotted black", bags.get(6)));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(7).isBase = true;
        bags.get(5).parentBag.add(bags.get(7));
        bags.get(8).parentBag.add(bags.get(7));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(5).isBase = true;
        bags.get(8).isBase = true;
        Day7.Node currentBag = bags.get(3);
        String desiredBag = "shiny gold";
        boolean expected = true;
        boolean result = d7.findDesired(desiredBag, currentBag);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3findDesired() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("light red", true));
        bags.add(new Day7.Node("bright white", bags.get(0)));
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.add(new Day7.Node("dark orange", true));
        bags.get(1).parentBag.add(bags.get(3));
        bags.get(2).parentBag.add(bags.get(3));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("shiny gold", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(4));
        bags.get(2).isBase = true;
        bags.get(4).parentBag.add(bags.get(2));
        bags.add(new Day7.Node("faded blue", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark olive", bags.get(4)));
        bags.add(new Day7.Node("vibrant plum", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(6));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(6).isBase = true;
        bags.get(5).parentBag.add(bags.get(6));
        bags.add(new Day7.Node("dotted black", bags.get(6)));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(7).isBase = true;
        bags.get(5).parentBag.add(bags.get(7));
        bags.get(8).parentBag.add(bags.get(7));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(5).isBase = true;
        bags.get(8).isBase = true;
        Day7.Node currentBag = bags.get(5);
        String desiredBag = "shiny gold";
        boolean expected = false;
        boolean result = d7.findDesired(desiredBag, currentBag);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1countUltimateParents() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("light red", true));
        bags.add(new Day7.Node("bright white", bags.get(0)));
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.add(new Day7.Node("dark orange", true));
        bags.get(1).parentBag.add(bags.get(3));
        bags.get(2).parentBag.add(bags.get(3));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("shiny gold", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(4));
        bags.get(2).isBase = true;
        bags.get(4).parentBag.add(bags.get(2));
        bags.add(new Day7.Node("faded blue", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark olive", bags.get(4)));
        bags.add(new Day7.Node("vibrant plum", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(6));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(6).isBase = true;
        bags.get(5).parentBag.add(bags.get(6));
        bags.add(new Day7.Node("dotted black", bags.get(6)));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(7).isBase = true;
        bags.get(5).parentBag.add(bags.get(7));
        bags.get(8).parentBag.add(bags.get(7));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(5).isBase = true;
        bags.get(8).isBase = true;
        String desiredBag = "shiny gold";
        int expected = 4;
        int result = d7.countUltimateParents(bags, desiredBag);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1getCount() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("light red", true));
        bags.add(new Day7.Node("bright white", bags.get(0)));
        bags.add(new Day7.Node("muted yellow", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.get(0).childrenBags.add(bags.get(2));
        bags.add(new Day7.Node("dark orange", true));
        bags.get(1).parentBag.add(bags.get(3));
        bags.get(2).parentBag.add(bags.get(3));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(1));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(3).childrenBags.add(bags.get(2));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("shiny gold", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(4));
        bags.get(2).isBase = true;
        bags.get(4).parentBag.add(bags.get(2));
        bags.add(new Day7.Node("faded blue", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(4));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(2).childrenBags.add(bags.get(5));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark olive", bags.get(4)));
        bags.add(new Day7.Node("vibrant plum", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(6));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(4).childrenBags.add(bags.get(7));
        bags.get(6).isBase = true;
        bags.get(5).parentBag.add(bags.get(6));
        bags.add(new Day7.Node("dotted black", bags.get(6)));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(5));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(6).childrenBags.add(bags.get(8));
        bags.get(7).isBase = true;
        bags.get(5).parentBag.add(bags.get(7));
        bags.get(8).parentBag.add(bags.get(7));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(5));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(7).childrenBags.add(bags.get(8));
        bags.get(5).isBase = true;
        bags.get(8).isBase = true;
        int desiredBagIndex = 4;
        int expected = 32;
        int result = d7.getCount(bags, desiredBagIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2getCount() {
        List<Day7.Node> bags = new ArrayList<>();
        bags.add(new Day7.Node("shiny gold", true));
        bags.add(new Day7.Node("dark red", bags.get(0)));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(0).childrenBags.add(bags.get(1));
        bags.get(1).isBase = true;
        bags.add(new Day7.Node("dark orange", bags.get(1)));
        bags.get(1).childrenBags.add(bags.get(2));
        bags.get(1).childrenBags.add(bags.get(2));
        bags.get(2).isBase = true;
        bags.add(new Day7.Node("dark yellow", bags.get(2)));
        bags.get(2).childrenBags.add(bags.get(3));
        bags.get(2).childrenBags.add(bags.get(3));
        bags.get(3).isBase = true;
        bags.add(new Day7.Node("dark green", bags.get(3)));
        bags.get(3).childrenBags.add(bags.get(4));
        bags.get(3).childrenBags.add(bags.get(4));
        bags.get(4).isBase = true;
        bags.add(new Day7.Node("dark blue", bags.get(4)));
        bags.get(4).childrenBags.add(bags.get(5));
        bags.get(4).childrenBags.add(bags.get(5));
        bags.get(5).isBase = true;
        bags.add(new Day7.Node("dark violet", bags.get(5)));
        bags.get(5).childrenBags.add(bags.get(6));
        bags.get(5).childrenBags.add(bags.get(6));
        bags.get(6).isBase = true;
        int bagIndex = 0;
        int expected = 126;
        int result = d7.getCount(bags, bagIndex);
        Assertions.assertEquals(expected, result);
    }
}