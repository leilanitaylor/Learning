package juniorJavaDevClass.DataStructures;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args) {
        // LinkedHash - in order that they were entered
        // HashSet - complete random order
        // TreeSet - rearranges to natural order (alphabetical or numerical

        // 1. Define the collection
        Set<String> animals = new TreeSet<>();

        // 2. Adding elements
        animals.add("dog");
        animals.add("pig");
        animals.add("hog");
        animals.add("cat");
        animals.add("snake");

        // HashSets are random order
        System.out.println(animals.size() + " " + animals);

        // elements must be unique
        animals.add("cat");
        animals.add("snake");
        animals.add("goose");

        // only added 1 element, not 3
        System.out.println(animals.size() + " " + animals);

        // Create a new set that we can use for comparison
        Set<String> farmAnimals = new HashSet<>();
        farmAnimals.add("chicken");
        farmAnimals.add("cow");
        farmAnimals.add("pig");
        farmAnimals.add("horse");
        farmAnimals.add("dog");

        // what is the INTERSECTION (only animals and farm animals "AND")
        // 1. Copy existing set into a new set
        Set<String> intersectionSet = new HashSet<>(animals);
        System.out.println(intersectionSet);
        // 2. Retain ONLY the elements that are also in the other set
        intersectionSet.retainAll(farmAnimals);
        System.out.println("The intersection is: " + intersectionSet);

        // What is the UNION (are both animals and farm animals "OR")
        Set<String> unionSet = new HashSet<>(farmAnimals);
        unionSet.addAll(animals);
        System.out.println("The union is: " + unionSet);

        // What is the DIFFERENCE (animals but NOT farm animals - in 1 and NOT the other)
        Set<String> differenceSet = new HashSet<>(animals);
        differenceSet.removeAll(farmAnimals);
        System.out.println("The difference is: " + differenceSet);
    }
}
