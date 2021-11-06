package edXDataStructures.PriorityQueuesAndDisjointSets;
/*
Problem: Merging Tables
----------------------------------------------------------------------------------------------------------------------
Problem Introduction:
In this problem, your goal is to simulate a sequence of merge operations with tables in a database.
----------------------------------------------------------------------------------------------------------------------
Problem Description:
    Task: There are n tables stored in some datbase. The tables are numbered from 1 to n. All tables share the same
        set of columns. Each table contains either several rows with real data or a symbolic link to another table.
        Initially, all tables contain data, and i-th table has r(i) rows. You need to perform m of the following
        operations:
            1) Consider table number destination(i). Traverse the path of symbolic links to get the data. That is,
                while destination(i) contains a symbolic link instead of real data do
                    destination(i) <-- symlink(destination(i))
            2) Consider the table number source(i) and traverse the path of symbolic links from it in the same manner
                as for destination(i)
            3) Now, destination(i) and source(i) are the numbers of two tables with real data. If destination(i) !=
                source(i), copy all the rows from table source(i) to table destination(i) into it.
            4) Print the maximum size among all n tables (recall that size is the number of rows in the table). If
                the table contains only a symbolic link, its size is considered to be 0.
        See examples and explanations for further clarifications.
    Input Format: The first line of the input contains two integers n and m - the number of tables in the database
        and the number of merge queries to perform, respectively.
        The second line of the input contains n integers r(i) - the number of rows in teh i-th table.
        Then follow m lines describing merge queries. Each of them contains two integers destination(i), and source(i)
        - the numbers of the tables to merge.
    Constraints: 1 <= n, m <= 100,000; 1 <= destination(i), source(i) <= n.
    Output Format: For each query print a line containing a single integer - the maximum of the sizes of all tables
        (in terms of the number of rows) after the corresponding operation.
    Time Limits: 14 sec.
    Memory Limit: 512 MB.

Sample 1:
    Input:
        5 5
        1 1 1 1 1
        3 5
        2 4
        1 4
        5 4
        5 3
    Output:
        2
        2
        3
        5
        5
    In this sample, all the tables initially have exactly 1 row of data. Consider the merging operations:
        1) All the data from the table 5 is copied to table number 3. Table 5 now contains only a symbolic link to
            table 3, while table 3 has 2 rows. 2 becomes the new maximum size.
        2) 2 and 4 are merged in teh same way as 3 and 5.
        3) We are trying to merge 1 and 4, but 4 has a symbolic link pointing to 2, so we actually copy all the data
            from teh table number 2 to the table number 1, clear the table number 2 and put a symbolic link to the
            table number 1 in it. Table 1 now has 3 rows of data, and becomes the new maximum size.
        4) Traversing the path of symbolic links from 4 we have 4 --> 2 --> 1, and the path from 5 is 5 --> 3. So we
            are actually merging tables 3 and 1. WE copy all the rows from the table number 1 into the table number 3,
            and now the table number 3 has 5 rows of dat, which is the new maximum.
        5) All tables now directly of indirectly point to table 3, so all other merges won't change anything.

Sample 2:
    Input:
        6 4
        10 0 5 0 3 3
        6 6
        6 5
        5 4
        4 3
    Output:
        10
        10
        10
        11
    Explanation: In this example tables have different sizes. Let us consider the operations:
        1) Merging the table number 6 with itself doesn't change anything, and the maximum size is 10 (table number 1).
        2) After merging the table number 5 into the table number 6, the table number 5 is cleared and has size 0,
            while the table number 6 has size 6. Still, the maximum size is 10.
        3) By merging the table number 4 into the table number 5, we actually merge the table number 4 into the table
            number 6 (table 5 now contains just a symbolic link to table 6), so the table number 4 is cleared and
            has size 0, while the table number 6 has size 6. Still, the maximum size is 10.
        4) By merging the table number 3 into the table number 4, we actually merge the table number 3 into the table
            number 6 (table 4 now contains just a symbolic link to table 6), so the table number 3 is cleared and has
            size 0, while the table number 6 has size 11, which is the new maximum size.

Starter Files:
The starter solutions in C++, Java, and Python3 read the description of tables and operations from the input, declare
and partially implement disjoint set union for this problem. If you use other languages, you will have to implement
the solution from scratch.

What to Do:
Think how to use disjoint set union with path compression and union by rank heuristics to solve this problem. In
particular, you should separate in your thinking the data structure that performs union/find operations from the merged
tables. If you're asked to merge first table into second, but the rank of the second table is smaller than the rank of
the first table, you can ignore the request order while merging in the Disjoint Set Union data structure and join the
node corresponding to the first table instead in your disjoint Set Union. However, you will need to store the number
of the actual second table to which you were requested to merge the first table in the parent node of the corresponding
Disjoint Set, and you will need an additional field in the nodes of Disjoing Set Union to store it.
 */

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class MergingTables {

    private final InputReader reader;
    private final OutputWriter writer;


    public MergingTables(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new MergingTables(reader, writer).run();
        writer.writer.flush();
    }

    static class Table{
        int parent;
        int rank;
        int numberOfRows;

        Table (int numberOfRows, int index) {
            this.numberOfRows = numberOfRows;
            rank = 0;
            parent = index;
        }

        /*
        int getParent(Table[] tables, int index) {
            // find super parent and compress path
            if (index != parent) {
                parent = getParent(tables[index].parent);
            }
            return parent;
        }

         */
    }

    int maximumNumberOfRows = -1;

    void merge(Table[] tables, int destination, int source) {
        int realDestination = getParent(tables, destination);
        int realSource = getParent(tables, source);
        if (realDestination == realSource) {
            return;
        }
        // merge two components here, use rank heuristic
        // update maximumNumberOfRows
        if (tables[realDestination].rank > tables[realSource].rank) {
            tables[realSource].parent = realDestination;
            tables[realDestination].numberOfRows += tables[realSource].numberOfRows;
            maximumNumberOfRows = Math.max(maximumNumberOfRows, tables[realDestination].numberOfRows);
        }  else {
            tables[realDestination].parent = realSource;
            if (tables[realDestination].rank == tables[realSource].rank) {
                tables[realSource].rank++;
            }
            tables[realSource].numberOfRows += tables[realDestination].numberOfRows;
            maximumNumberOfRows = Math.max(maximumNumberOfRows, tables[realSource].numberOfRows);
        }
    }

    public int getParent(Table[] tables, int index) {
        // find super parent and compress path
        if (index != tables[index].parent) {
            tables[index].parent = getParent(tables, tables[index].parent);
        }
        return tables[index].parent;
    }

    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();
        Table[] tables = new Table[n];
        for (int i = 0; i < n; i++) {
            int numberOfRows = reader.nextInt();
            tables[i] = new Table(numberOfRows, i);
            maximumNumberOfRows = Math.max(maximumNumberOfRows, numberOfRows);
        }
        for (int i = 0; i < m; i++) {
            int destination = reader.nextInt() - 1;
            int source = reader.nextInt() - 1;
            merge(tables, destination, source);
            writer.printf("%d\n", maximumNumberOfRows);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }
}
