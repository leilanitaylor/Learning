package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DifferentSummandsTest {

    DifferentSummands diffSummands;
    @BeforeEach
    public void setUp() {diffSummands = new DifferentSummands(); }

    @Test
    void testSample1OptimalSummands() {
        int n = 6;
        List<Integer> expectedSummands = new ArrayList<>(Arrays.asList(1, 2, 3));
        int expectedLength = expectedSummands.size();
        List<Integer> resultSummands = diffSummands.optinalSummands(n);
        int resultLength = resultSummands.size();
        Assertions.assertNotNull(resultSummands);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < resultLength; i++) {
            Assertions.assertEquals(expectedSummands.get(i), resultSummands.get(i));
        }
    }

    @Test
    void testSample2OptimalSummands() {
        int n = 8;
        List<Integer> expectedSummands = new ArrayList<>(Arrays.asList(1, 2, 5));
        int expectedLength = expectedSummands.size();
        List<Integer> resultSummands = diffSummands.optinalSummands(n);
        int resultLength = resultSummands.size();
        Assertions.assertNotNull(resultSummands);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < resultLength; i++) {
            Assertions.assertEquals(expectedSummands.get(i), resultSummands.get(i));
        }
    }

    @Test
    void testSample3OptimalSummands() {
        int n = 2;
        List<Integer> expectedSummands = new ArrayList<>(Arrays.asList(2));
        int expectedLength = expectedSummands.size();
        List<Integer> resultSummands = diffSummands.optinalSummands(n);
        int resultLength = resultSummands.size();
        Assertions.assertNotNull(resultSummands);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < resultLength; i++) {
            Assertions.assertEquals(expectedSummands.get(i), resultSummands.get(i));
        }
    }

    @Test
    void test1OptimalSummands() {
        int n = 1;
        List<Integer> expectedSummands = new ArrayList<>(Arrays.asList(1));
        int expectedLength = expectedSummands.size();
        List<Integer> resultSummands = diffSummands.optinalSummands(n);
        int resultLength = resultSummands.size();
        Assertions.assertNotNull(resultSummands);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < resultLength; i++) {
            Assertions.assertEquals(expectedSummands.get(i), resultSummands.get(i));
        }
    }

    @Test
    void test2OptimalSummands() {
        int n = 5;
        List<Integer> expectedSummands = new ArrayList<>(Arrays.asList(1, 4));
        int expectedLength = expectedSummands.size();
        List<Integer> resultSummands = diffSummands.optinalSummands(n);
        int resultLength = resultSummands.size();
        Assertions.assertNotNull(resultSummands);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < resultLength; i++) {
            Assertions.assertEquals(expectedSummands.get(i), resultSummands.get(i));
        }
    }

}