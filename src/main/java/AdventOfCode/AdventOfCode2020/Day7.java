package AdventOfCode.AdventOfCode2020;
/*
Day 7:
    Part 1: Many rules are being enforced about bags and their contents; bags must be
        color-coded and must contain specific quantities of other color-coded bags.
        For example, consider the following rules:
            - light red bags contain 1 bright white bag, 2 muted yellow bags
            - dark orange bags contain 3 bright white bags, 4 muted yellow bags
            - bright white bags contain 1 shiny gold bag
            - muted yellow bags contain 2 shiny gold bags, 9 faded blue bags
            - shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags
            - dark olive bags contain 3 faded blue bags, 4 dotted black bags
            - faded blue bags contain no other bags
            - dotted black bags contain no other bags
        These rules specify the required contents for 9 bag types. In this example,
        every faded blue bag is empty, every vibrant plum bag contains 11 bags (5
        faded blue and 6 dotted black), and so on.
        You have a shiny gold bag. If you wanted to carry it in at least one other
        bag, how many different bag colors would be valid for the outermost bag?
        In the above rules, the following options would be available to you:
            - a bright whit bag, which can hold your shiny gold bag directly
            - a muted yellow bag, which can hold your shiny gold bag directly, plus
              some other bags
            - a dark orange bag, which can hold bright white and muted yellow bags,
              either of which could then hold your shiny gold bag
            - a light red bag, which could hold bright white and muted yellow bags,
              either of which could then hold your shiny gold bag
        So, in this example, the number of bag colors that can eventually contain at
        least one shiny gold bag is 4.
        How many bag colors can eventually contain at least one shiny gold bag?
    Part 2: How many individual bags are required inside your single shiny gold bag?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day7 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> rulesFile = readFile();
/*
        List<Bag> bags = setRules(rulesFile);


        String desiredBag = "shiny gold";


        int numUltimateParentBags = countUltimateParents(bags, desiredBag);
        System.out.println("Number of bags that can ultimately hold your " + desiredBag + " bag is: " + numUltimateParentBags);

        int requiredBags = countNestedBags(bags, desiredBag);
        System.out.println("Number of bags in your " + desiredBag + " bag is: " + requiredBags);

         */
    }
/*
    protected static int countNestedBags(List<Bag> bags, String desiredBag) {
        int desiredBagIndex = getIndex(bags, desiredBag);
        int count = getCount(bags, desiredBagIndex);

        return count;
    }



    protected static int getCount(List<Bag> bags, int bagIndex) {
        int count = 0;

        Queue<Bag> queue = new LinkedList<>();
        queue.add(bags.get(bagIndex));

        while (queue.peek() != null) {
            if (queue.peek().childrenBags.size() != 0) {
                for (int i = 0; i < queue.peek().childrenBags.size(); i++) {
                    queue.add(queue.peek().childrenBags.get(i));
                }
            }
            count++;
            queue.remove();
        }
        return count-1;
    }

    protected static List<Bag> setRules(List<String> rulesFile) {
        List<Bag> bags = new ArrayList<>();

        for (int i = 0; i < rulesFile.size(); i++) {
            bags.add(createRule(rulesFile.get(i)));
        }

        //System.out.println(bags.size());

        return bags;
    }

    protected static Bag createRule(String rule) {

        rule.replaceAll(" bag", "").replaceAll(" bags", "").replaceAll(" contain", "");
        String[] parsedRule = rule.split("[ ,.]+");

        String bagColor1 = parsedRule[0] + " " + parsedRule[1];
        Bag currentBag = new Bag(bagColor1, 1);

        if (!parsedRule[parsedRule.length-1].equals("other")) {
            for (int i = 2; i < parsedRule.length; i+=3) {
                int numBags = Integer.parseInt(parsedRule[i]);
                String childBagColor = parsedRule[i+1] + " " + parsedRule[i+2];
                Bag child = new Bag(childBagColor, numBags);
                child.setParentBag(currentBag);
                currentBag.addChildBag(child);
            }
        }

        return currentBag;
    }

    protected static int countUltimateParents(List<Bag> bags, String desiredBag) {
        int count = 0;

        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).isBase == true) {
                Bag currentBag = bags.get(i);
                boolean isCurrentParentOfDesired = findDesired(desiredBag, currentBag);
                if (isCurrentParentOfDesired == true)
                    count++;
            }
        }
        return count;
    }

    protected static boolean findDesired(String desiredBag, Bag currentBag) {
        boolean canContainDesired = false;

        Queue<Bag> queue = new LinkedList<>();
        queue.add(currentBag);

        while (queue.peek() != null) {
            for (int i = 0; i < queue.peek().childrenBags.size(); i++) {
                if (queue.peek().childrenBags.get(i).bagColor.equals(desiredBag)){
                    canContainDesired = true;
                    break;
                }
                queue.add(queue.peek().childrenBags.get(i));
            }
            queue.remove();
        }
        return canContainDesired;
    }

 */

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day7InputFile.txt");
        File rulesFile = path.toFile();
        List<String> rules = new ArrayList<>();

        Scanner sc = new Scanner(rulesFile);
        while (sc.hasNextLine()) {
            String rule = sc.nextLine();
            rules.add(rule);
        }
        return rules;
    }

    static class Bag {
        String bagColor;
        Bag parentBag;
        List<Bag> childrenBags = new ArrayList<>();
        int numBags;

        Bag(String bagColor, int numBags) {
            this.bagColor = bagColor;
            this.numBags = numBags;
        }

        public void setParentBag(Bag parent) {
            this.parentBag = parent;
        }

        public void addChildBag(Bag child) {
            childrenBags.add(child);
        }
    }
}
