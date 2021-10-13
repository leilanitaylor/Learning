package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    MajorityElement majElem;
    @BeforeEach
    public void setUp() {majElem = new MajorityElement(); }

    @Test
    void test1MajorityCount() {
        int[] a = {2, 3, 9, 2, 2};
        int left = 0;
        int right = 1;
        int majority = 2;
        int expected = 1;
        int result = majElem.majorityCount(a, left, right, majority);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2MajorityCount() {
        int[] a = {2, 3, 9, 2, 2};
        int left = 0;
        int right = 2;
        int majority = -1;
        int expected = 0;
        int result = majElem.majorityCount(a, left, right, majority);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3MajorityCount() {
        int[] a = {2, 3, 9, 2, 2};
        int left = 3;
        int right = 4;
        int majority = 2;
        int expected = 2;
        int result = majElem.majorityCount(a, left, right, majority);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4MajorityCount() {
        int[] a = {2, 3, 9, 2, 2};
        int left = 0;
        int right = 4;
        int majority = 2;
        int expected = 3;
        int result = majElem.majorityCount(a, left, right, majority);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1GetMajorityElement() {
        int[] a = {2, 3, 9, 2, 2};
        int left = 0;
        int right = a.length - 1;
        int expected = 2;
        int result = majElem.getMajorityElement(a, left, right);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2GetMajorityElement() {
        int[] a = {1, 2, 3, 4};
        int left = 0;
        int right = a.length - 1;
        int expected = -1;
        int result = majElem.getMajorityElement(a, left, right);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample3GetMajorityElement() {
        int[] a = {1, 2, 3, 1};
        int left = 0;
        int right = a.length - 1;
        int expected = -1;
        int result = majElem.getMajorityElement(a, left, right);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1GetMajorityElement() {
        int[] a = {9, 2, 2, 9, 9};
        int left = 0;
        int right = a.length - 1;
        int expected = 9;
        int result = majElem.getMajorityElement(a, left, right);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2GetMajorityElement() {
        int[] a = {512766168, 717383758, 5, 126144732, 5, 573799007, 5, 5, 5, 405079772};
        int left = 0;
        int right = a.length - 1;
        int expected = -1;
        int result = majElem.getMajorityElement(a, left, right);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}