package AdventOfCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdventOfCode2020Test {

    AdventOfCode2020 aoc;
    @BeforeEach
    public void setUp() {aoc = new AdventOfCode2020(); }

    @Test
    void test1findSum() {
        int first = 1721;
        int second = 979;
        int[] intsToSum = {first, second};
        int expected = 2700;
        int result = aoc.findSum(intsToSum);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1findIntsSumTo2020() {
        List<Integer> expenses = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        List<Integer> expected = Arrays.asList(1721, 299);
        List<Integer> result = aoc.findIntsSumTo2020(expenses, 2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void test1findProduct() {
        List<Integer> sumTo2020 = Arrays.asList(1721, 299);
        int expected = 514579;
        int result = aoc.findProduct(sumTo2020);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2findSum() {
        int[] intsToSum = {979, 366, 675};
        int expected = 2020;
        int result = aoc.findSum(intsToSum);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2findIntsSumTo2020() {
        List<Integer> expenses = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        List<Integer> expected = Arrays.asList(979, 366, 675);
        List<Integer> result = aoc.findIntsSumTo2020(expenses, 3);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void test2findProduct() {
        List<Integer> sumTo2020 = Arrays.asList(979, 366, 675);
        int expected = 241861950;
        int result = aoc.findProduct(sumTo2020);
        Assertions.assertEquals(expected, result);
    }
}