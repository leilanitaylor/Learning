package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {

    LargestNumber largeNum;
    @BeforeEach
    public void setUp() {largeNum = new LargestNumber(); }

    @Test
    void testSample1SortStrings() {
        String[] a = {"21", "2"};
        String[] expected = {"2", "21"};
        String[] result = largeNum.sortStrings(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample2SortStrings() {
        String[] a = {"9", "4", "6", "1", "9"};
        String[] expected = {"9", "9", "6", "4", "1"};
        String[] result = largeNum.sortStrings(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample3SortStrings() {
        String[] a = {"23", "39", "92"};
        String[] expected = {"92", "39", "23"};
        String[] result = largeNum.sortStrings(a);
        Assertions.assertNotNull(result);;
        Assertions.assertEquals(expected.length, result.length);;
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void testSample1LargestNumber() {
        String[] a = {"21", "2"};
        String expected = "221";
        String result = largeNum.largestNumber(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2LargestNumber() {
        String[] a = {"9", "4", "6", "1", "9"};
        String expected = "99641";
        String result = largeNum.largestNumber(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3LargestNumber() {
        String[] a = {"23", "39", "92"};
        String expected = "923923";
        String result = largeNum.largestNumber(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1LargestNumber() {
        String[] a = {"2", "8", "2", "3", "6", "4", "1", "1", "10"};
        String expected = "8643221110";
        String result = largeNum.largestNumber(a);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}