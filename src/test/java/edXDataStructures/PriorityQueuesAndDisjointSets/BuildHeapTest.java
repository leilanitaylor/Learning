package edXDataStructures.PriorityQueuesAndDisjointSets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildHeapTest {

    BuildHeap bh;
    @BeforeEach
    public void setUp() {bh = new BuildHeap(); }

    @Test
    void test1LeftChild() {
        int i = 0;
        int expected = 1;
        int result = bh.leftChild(i);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2LeftChild() {
        int i = 1;
        int expected = 3;
        int result = bh.leftChild(i);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3LeftChild() {
        int i = 2;
        int expected = 5;
        int result = bh.leftChild(i);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1RightChild() {
        int i = 0;
        int expected = 2;
        int result = bh.rightChild(i);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2RightChild() {
        int i = 1;
        int expected = 4;
        int result = bh.rightChild(i);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1shiftDown() {
        bh.data = new int[5];
        bh.data[0] = 5;
        bh.data[1] = 4;
        bh.data[2] = 3;
        bh.data[3] = 2;
        bh.data[4] = 1;
        int i = 1;
        bh.swaps = new ArrayList<>();
        bh.shiftDown(i);
        int[] expected = {5, 1, 3, 2, 4};
        for (int j = 0; j < bh.data.length; j++) {
            Assertions.assertEquals(expected[j], bh.data[j]);
        }
    }

    @Test
    void test2shiftDown() {
        bh.data = new int[5];
        bh.data[0] = 5;
        bh.data[1] = 1;
        bh.data[2] = 3;
        bh.data[3] = 2;
        bh.data[4] = 4;
        int i = 0;
        bh.swaps = new ArrayList<>();
        bh.shiftDown(i);
        int[] expected = {1, 2, 3, 5, 4};
        for (int j = 0; j < bh.data.length; j++) {
            Assertions.assertEquals(expected[j], bh.data[j]);
        }
    }

    @Test
    void testSample1genSwaps() {
        bh.data = new int[5];
        bh.data[0] = 5;
        bh.data[1] = 4;
        bh.data[2] = 3;
        bh.data[3] = 2;
        bh.data[4] = 1;
        List<BuildHeap.Swap> expected = new ArrayList<>();
        expected.add(new BuildHeap.Swap(1, 4));
        expected.add(new BuildHeap.Swap(0, 1));
        expected.add(new BuildHeap.Swap(1, 3));
        bh.genSwaps();
        Assertions.assertNotNull(bh.swaps);
        Assertions.assertEquals(expected.size(), bh.swaps.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).index1, bh.swaps.get(i).index1);
            Assertions.assertEquals(expected.get(i).index2, bh.swaps.get(i).index2);
        }
    }

    @Test
    void testSample2genSwaps() {
        bh.data = new int[5];
        bh.data[0] = 1;
        bh.data[1] = 2;
        bh.data[2] = 3;
        bh.data[3] = 4;
        bh.data[4] = 5;
        List<BuildHeap.Swap> expected = new ArrayList<>();
        bh.genSwaps();
        Assertions.assertNotNull(bh.swaps);
        Assertions.assertEquals(expected.size(), bh.swaps.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).index1, bh.swaps.get(i).index1);
            Assertions.assertEquals(expected.get(i).index2, bh.swaps.get(i).index2);
        }
    }
}