package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Day3Test {

    Day3 d3;
    @BeforeEach
    public void setUp() {d3 = new Day3();}

    @Test
    void test1extendYPosition() {
        String test = "#...#...#..";
        String expected = "#...#...#..#...#...#..";
        String result = d3.extendYPosition(test);
        Assertions.assertEquals(expected.length(), result.length());
        for (int i = 0; i < expected.length(); i++) {
            Assertions.assertEquals(expected.charAt(i), result.charAt(i));
        }
    }

    @Test
    void test1checkCollision() {
        int[] currentPosition = {0, 0};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = false;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2checkCollision() {
        int[] currentPosition = {3, 1};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = false;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3checkCollision() {
        int[] currentPosition = {6, 2};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = true;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4checkCollision() {
        int[] currentPosition = {9, 3};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = false;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5checkCollisions() {
        int[] currentPosition = {12, 4};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = true;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6checkCollision() {
        int[] currentPosition = {15, 5};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = true;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7checkCollision() {
        int[] currentPosition = {18, 6};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = false;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test8checkCollision() {
        int[] currentPosition = {21, 7};
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        boolean expected = true;
        boolean result = d3.checkCollision(currentPosition, mapOfPaths);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1countCollisions() {
        List<String> mapOfPaths = new ArrayList<>();
        mapOfPaths.add("..##.......");
        mapOfPaths.add("#...#...#..");
        mapOfPaths.add(".#....#..#.");
        mapOfPaths.add("..#.#...#.#");
        mapOfPaths.add(".#...##..#.");
        mapOfPaths.add("..#.##.....");
        mapOfPaths.add(".#.#.#....#");
        mapOfPaths.add(".#........#");
        mapOfPaths.add("#.##...#...");
        mapOfPaths.add("#...##....#");
        mapOfPaths.add(".#..#...#.#");
        int expected = 7;
        int result = d3.countCollisions(mapOfPaths);
        Assertions.assertEquals(expected, result);
    }
}