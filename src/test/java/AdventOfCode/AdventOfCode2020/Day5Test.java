package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    Day5 d5;
    @BeforeEach
    public void setUp() {d5 = new Day5(); }

    @Test
    void test1getColumn() {
        String boardingId = "FBFBBFFRLR";
        int expected = 5;
        int result = d5.getColumn(boardingId, 7, 0, 7);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2getColumn() {
        String boardingId = "BFFFBBFRRR";
        int expected = 7;
        int result = d5.getColumn(boardingId, 7, 0, 7);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3getColumn() {
        String boardingId = "BBFFBBFRLL";
        int expected = 4;
        int result = d5.getColumn(boardingId, 7, 0, 7);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1getRow() {
        String boardingId = "FBFBBFFRLR";
        int expected = 44;
        int result = d5.getRow(boardingId, 0, 0, 127);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2getRow() {
        String boardingId = "BFFFBBFRRR";
        int expected = 70;
        int result = d5.getRow(boardingId, 0, 0, 127);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3getRow() {
        String boardingId = "FFFBBBFRRR";
        int expected = 14;
        int result = d5.getRow(boardingId, 0, 0, 127);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4getRow() {
        String boardingId = "BBFFBBFRLL";
        int expected = 102;
        int result = d5.getRow(boardingId, 0, 0, 127);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1getMaxSeatId() {
        List<String> boardingIds = Arrays.asList("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL");
        int expected = 820;
        int result = d5.getMaxSeatId(boardingIds);
        Assertions.assertEquals(expected, result);
    }
}