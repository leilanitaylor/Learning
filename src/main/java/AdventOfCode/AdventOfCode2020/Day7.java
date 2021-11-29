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

        List<Node> bags = setRules(rulesFile);


        String desiredBag = "shiny gold";

        //int numUltimateParentBags = countUltimateParents(bags, desiredBag);
        //System.out.println("Number of bags that can ultimately hold your " + desiredBag + " bag is: " + numUltimateParentBags);

        int requiredBags = countNestedBags(bags, desiredBag);
        System.out.println("Number of bags in your " + desiredBag + " bag is: " + requiredBags);
    }

    protected static int countNestedBags(List<Node> bags, String desiredBag) {
        int desiredBagIndex = getIndex(bags, desiredBag);
        int count = getCount(bags, desiredBagIndex);

        return count;
    }

    protected static int getCount(List<Node> bags, int bagIndex) {
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
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

    protected static List<Node> setRules(List<String> rulesFile) {
        List<Node> bags = new ArrayList<>();

        for (int i = 0; i < rulesFile.size(); i++) {
            createRule(rulesFile.get(i), bags);
        }

        //System.out.println(bags.size());

        return bags;
    }

    protected static void createRule(String rule, List<Node> bags) {
        int currentIndex = 0;

        String bagColor = getBagColor(rule, currentIndex);
        currentIndex = bagColor.length()+1;

        List<String[][]> childrenBagColors = new ArrayList<>();
        while (currentIndex < rule.length()-1) {
            currentIndex = getChildBagColor(childrenBagColors, rule, currentIndex);
        }

        setCurrentBag(bags, bagColor);

        int currentBagIndex = getIndex(bags, bagColor);

        setChildrenBags(bags, childrenBagColors, currentBagIndex);
    }

    protected static int countUltimateParents(List<Node> bags, String desiredBag) {
        int count = 0;

        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).isBase == true) {
                Node currentBag = bags.get(i);
                boolean isCurrentParentOfDesired = findDesired(desiredBag, currentBag);
                if (isCurrentParentOfDesired == true)
                    count++;
            }
        }
        return count;
    }

    protected static boolean findDesired(String desiredBag, Node currentBag) {
        boolean canContainDesired = false;

        Queue<Node> queue = new LinkedList<>();
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

    protected static void setChildrenBags(List<Node> bags, List<String[][]> childrenBagColors, int currentBagIndex) {
        if (childrenBagColors.size() == 0)
            return;
        Node currentBag = bags.get(currentBagIndex);
        for (int i = 0; i < childrenBagColors.size(); i++) {
            boolean currentChildExists = false;
            String childBagColor = childrenBagColors.get(i)[1][0];
            int numOfChildBag = Integer.parseInt(childrenBagColors.get(i)[0][0]);
            for (int j = 0; j < bags.size(); j++) {
                if (bags.get(j).bagColor.equals(childBagColor)) {
                    int childBagIndex = j;
                    bags.get(j).parentBag.add(currentBag);
                    //bags.get(currentBagIndex).childrenBags.add(bags.get(j));
                    addChildBag(currentBagIndex, childBagIndex, numOfChildBag, bags);
                    currentChildExists = true;
                    break;
                }
            }
            if (currentChildExists == false) {
                int childBagIndex = createNewChild(bags, childBagColor, currentBag, currentBagIndex);
                addChildBag(currentBagIndex, childBagIndex, numOfChildBag, bags);
            }
        }
    }

    protected static void addChildBag(int currentBagIndex, int childBagIndex, int numOfChildBag, List<Node> bags) {
        bags.get(currentBagIndex).childrenBags.add(bags.get(childBagIndex));
        if (numOfChildBag != 1) {
            numOfChildBag--;
            addChildBag(currentBagIndex, childBagIndex, numOfChildBag, bags);
        }
    }

    protected static int createNewChild(List<Node> bags, String bagColor, Node currentParent, int currentBagIndex) {
        int childBagIndex = bags.size();
        Node currentChild = new Node(bagColor, currentParent);
        bags.add(currentChild);
        //bags.get(currentBagIndex).childrenBags.add(currentChild);
        return childBagIndex;
    }

    protected static int getIndex(List<Node> bags, String bagColor) {
        int index = -1;
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).bagColor.equals(bagColor)) {
                index = i;
            }
        }
        return index;
    }

    protected static void setCurrentBag(List<Node> bags, String bagColor) {
        boolean bagExists = false;

        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).bagColor.equals(bagColor)) {
                bags.get(i).isBase = true;
                bagExists = true;
                break;
            }
        }

        if (bagExists == false) {
            createNewBag(bags, bagColor);
        }
    }

    protected static void createNewBag(List<Node> bags, String bagColor) {
        Node newBag = new Node(bagColor, true);
        bags.add(newBag);
    }

    protected static String getBagColor(String rule, int currentIndex) {
        //System.out.println(rule.length());
        String bagColor = null;
        int spaceCount = 0;
        for (int i = 0; i < rule.length(); i++) {
            if (rule.charAt(i) == ' ') {
                spaceCount++;
            }
            if (spaceCount == 2) {
                bagColor = rule.substring(0, currentIndex);
                currentIndex++;
                //System.out.println(bagColor + currentIndex);
                break;
            }
            currentIndex++;
        }
        return bagColor;
    }

    protected static int getChildBagColor(List<String[][]> childrenBagColors, String rule, int currentIndex) {
        int spaceCount = 0;

        int numIndex = -1;
        int colorIndex = -1;

        for (int i = currentIndex; i < rule.length(); i++) {
            if (rule.charAt(i) == ' ')
                spaceCount++;
            if (spaceCount == 2 && rule.charAt(i) == ' ')
                numIndex = i+1;
            if (spaceCount == 3 && rule.charAt(i) == ' ')
                colorIndex = i+1;
            if (spaceCount == 5) {
                String numOfChildBag = rule.substring(numIndex, colorIndex-1);
                String childBagColor = rule.substring(colorIndex, currentIndex);
                String[][] childBags = {{numOfChildBag}, {childBagColor}};
                childrenBagColors.add(childBags);
                //currentIndex++;
                //System.out.println(childBagColor + currentIndex);
                break;
            }
            if (currentIndex == rule.length()-1)
                break;
            currentIndex++;
        }
        return currentIndex;
    }

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

    static class Node {
        String bagColor;
        List<Node> parentBag = new ArrayList<>();
        List<Node> childrenBags = new ArrayList<>();
        boolean isBase = false;

        Node (String bagColor, boolean isBase) {
            this.bagColor = bagColor;
            this.isBase = isBase;
        }

        Node (String bagColor, Node parentBag) {
            this.bagColor = bagColor;
            this.parentBag.add(parentBag);
        }
    }
}
