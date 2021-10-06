package edXDataStructures.BasicDataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeHeightTest {

    TreeHeight th;
    @BeforeEach
    public void setUp() {th = new TreeHeight(); }

    @Test
    void testSample1computeHeight() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.parent = new int[tree.n];
        tree.parent[0] = 4;
        tree.parent[1] = -1;
        tree.parent[2] = 4;
        tree.parent[3] = 1;
        tree.parent[4] = 1;
        int expected = 3;
        int result = tree.computeHeight();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2computeHeight() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.parent = new int[tree.n];
        tree.parent[0] = -1;
        tree.parent[1] = 0;
        tree.parent[2] = 4;
        tree.parent[3] = 0;
        tree.parent[4] = 3;
        int expected = 4;
        int result = tree.computeHeight();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample1height() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.nodes = new TreeHeight.Node[tree.n];
        tree.nodes[0] = new TreeHeight.Node(0, 4);
        tree.nodes[1] = new TreeHeight.Node(1, -1);
        tree.nodes[2] = new TreeHeight.Node(2, 4);
        tree.nodes[3] = new TreeHeight.Node(3, 1);
        tree.nodes[4] = new TreeHeight.Node(4, 1);
        int expected = 3;
        int result = tree.height();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSample2height() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.nodes = new TreeHeight.Node[tree.n];
        tree.nodes[0] = new TreeHeight.Node(0, -1);
        tree.nodes[1] = new TreeHeight.Node(1, 0);
        tree.nodes[2] = new TreeHeight.Node(2, 4);
        tree.nodes[3] = new TreeHeight.Node(3, 0);
        tree.nodes[4] = new TreeHeight.Node(4, 3);
        int expected = 4;
        int result = tree.height();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1height() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.nodes = new TreeHeight.Node[tree.n];
        tree.nodes[0] = new TreeHeight.Node(0, -1);
        tree.nodes[1] = new TreeHeight.Node(1, -1);
        tree.nodes[2] = new TreeHeight.Node(2, -1);
        tree.nodes[3] = new TreeHeight.Node(3, -1);
        tree.nodes[4] = new TreeHeight.Node(4, -1);
        int expected = 1;
        int result = tree.height();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2height() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 5;
        tree.nodes = new TreeHeight.Node[tree.n];
        tree.nodes[0] = new TreeHeight.Node(0, 3);
        tree.nodes[1] = new TreeHeight.Node(1, 4);
        tree.nodes[2] = new TreeHeight.Node(2, -1);
        tree.nodes[3] = new TreeHeight.Node(3, 2);
        tree.nodes[4] = new TreeHeight.Node(4, 0);
        int expected = 5;
        int result = tree.height();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3height() {
        TreeHeight.Height tree = new TreeHeight.Height();
        tree.n = 100000;
        tree.nodes = new TreeHeight.Node[tree.n];

    }
}