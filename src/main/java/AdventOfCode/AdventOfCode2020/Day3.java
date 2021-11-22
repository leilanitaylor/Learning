package AdventOfCode.AdventOfCode2020;
/*
Day 3:
    Part 1: Take a toboggan to the airport. Trees grow on exact integer coordinates in
        a grid. You make a map (puzzle input) of the open squares (.) and trees (#)
        you can see. For example:
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        These aren't the only trees, though; the same pattern repeats to the right
        many times:
            ..##.........##.........##.........##.........##.........##.......  --->
            #...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
            .#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
            ..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
            .#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
            ..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....  --->
            .#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
            .#........#.#........#.#........#.#........#.#........#.#........#
            #.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
            #...##....##...##....##...##....##...##....##...##....##...##....#
            .#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
        You start on the open square (.) in teh top-left corner and need to reach the
        bottom (below the bottom-most row on your map).
        The toboggan can only follow a few specific slopes (you opted for a cheaper
        model that prefers rational numbers); start by counting all the trees you
        would encounter for the slope right 3, down 1.
        From your starting position at the top-left, check the position that is right
        3 and down 1. Then, check the position that is right 3 and down 1 from there,
        and so on until  you go past the bottom of the map.
        The locations you'd check in the above example are marked here with O where
        there was an open square and X where there was a tree:
            ..##.........##.........##.........##.........##.........##.......  --->
            #..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
            .#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
            ..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
            .#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
            ..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##.....  --->
            .#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
            .#........#.#........X.#........#.#........#.#........#.#........#
            #.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
            #...##....##...##....##...#X....##...##....##...##....##...##....#
            .#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
        In this example, traversing the map using this slope would cause you to
        encounter 7 trees.
        Starting at the top-left corner of your map and following a slope of right 3
        and down 1, how many trees would you encounter?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> mapOfPaths = readFile();

        int numberOfCollisions = countCollisions(mapOfPaths);

        System.out.println("Number of collisions: " + numberOfCollisions);
    }

    protected static int countCollisions(List<String> mapOfPaths) {
        int count = 0;
        int[] currentPosition =  {0, 0};
        int moveRight = 3;
        int moveDown = 1;

        while (currentPosition[1] < mapOfPaths.size()) {
            boolean isCollision = checkCollision(currentPosition, mapOfPaths);
            if (isCollision) {
                count++;
            }
            currentPosition[0] += moveRight;
            currentPosition[1] += moveDown;
        }

        return count;
    }

    protected static boolean checkCollision(int[] currentPosition, List<String> mapOfPaths) {
        int xPosition = currentPosition[0];
        String yPosition = mapOfPaths.get(currentPosition[1]);
        while (xPosition >= yPosition.length()) {
            yPosition = extendYPosition(yPosition);
        }
        if (yPosition.charAt(xPosition) == '.') {
            return false;
        }
        return true;
    }

    protected static String extendYPosition(String yPosition) {
        StringBuilder yExtended = new StringBuilder();
        yExtended.append(yPosition);
        yExtended.append(yPosition);
        return yExtended.toString();
    }

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day3InputFile.txt");
        File map = path.toFile();
        List<String> mapOfPaths = new ArrayList<>();

        Scanner sc = new Scanner(map);
        while (sc.hasNextLine()) {
            String mapPath = sc.nextLine();
            mapOfPaths.add(mapPath);
        }

        return mapOfPaths;
    }
}
