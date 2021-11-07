package edXDataStructures.PriorityQueuesAndDisjointSets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergingTablesTest {
/*
    MergingTables mt;
    @BeforeEach
    public void setUp() {mt = new MergingTables();}

    @Test
    void testSample1merge() {
        MergingTables.Table[] tables = new MergingTables.Table[5];
        tables[0] = new MergingTables.Table(1, 0);
        tables[1] = new MergingTables.Table(1, 1);
        tables[2] = new MergingTables.Table(1, 2);
        tables[3] = new MergingTables.Table(1, 3);
        tables[4] = new MergingTables.Table(1, 4);
        int[] maxRows = new int[5];
        for (int i = 0; i < tables.length; i++) {
            mt.maximumNumberOfRows = Math.max(mt.maximumNumberOfRows, tables[i].numberOfRows);
        }
        mt.merge(tables, 2, 4);
        maxRows[0] = mt.maximumNumberOfRows;
        mt.merge(tables, 1, 3);
        maxRows[1] = mt.maximumNumberOfRows;
        mt.merge(tables, 0, 3);
        maxRows[2] = mt.maximumNumberOfRows;
        mt.merge(tables, 4, 3);
        maxRows[3] = mt.maximumNumberOfRows;
        mt.merge(tables, 4, 2);
        maxRows[4] = mt.maximumNumberOfRows;
        int[] expected = {2, 2, 3, 5, 5};
        Assertions.assertNotNull(maxRows);
        Assertions.assertEquals(expected.length, maxRows.length);
        for (int i = 0; i < maxRows.length; i++) {
            Assertions.assertEquals(expected[i], maxRows[i]);
        }
    }

    @Test
    void testSample2merge() {
        MergingTables.Table[] tables = new MergingTables.Table[6];
        tables[0] = new MergingTables.Table(10, 0);
        tables[1] = new MergingTables.Table(0, 1);
        tables[2] = new MergingTables.Table(5, 2);
        tables[3] = new MergingTables.Table(0, 3);
        tables[4] = new MergingTables.Table(3, 4);
        tables[5] = new MergingTables.Table(3, 5);
        int[] maxRows = new int[4];
        for (int i = 0; i < tables.length; i++) {
            mt.maximumNumberOfRows = Math.max(mt.maximumNumberOfRows, tables[i].numberOfRows);
        }
        mt.merge(tables, 5, 5);
        maxRows[0] = mt.maximumNumberOfRows;
        mt.merge(tables, 5, 4);
        maxRows[1] = mt.maximumNumberOfRows;
        mt.merge(tables, 4, 3);
        maxRows[2] = mt.maximumNumberOfRows;
        mt.merge(tables, 3, 2);
        maxRows[3] = mt.maximumNumberOfRows;
        int[] expected = {10, 10, 10, 11};
        Assertions.assertNotNull(maxRows);
        Assertions.assertEquals(expected.length, maxRows.length);
        for (int i = 0; i < maxRows.length; i++) {
            Assertions.assertEquals(expected[i], maxRows[i]);
        }
    }

 */
}