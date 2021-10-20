package edXDataStructures.PriorityQueuesAndDisjointSets;
/*
Problem: Parallel Processing
---------------------------------------------------------------------------------------------
Problem Introduction:
In this problem you will simulate a program that processes a list of jobs in parallel.
Operating systems such as Linux, MacOS or Windows all have special programs in them called
schedulers which do exactly this with the programs on your computer.
---------------------------------------------------------------------------------------------
Problem Description:
    Task: You have a program which is parallelized and uses n independent threads to process
        the given list of m jobs. Threads take jobs in the order they are given in the input.
        If there is a free thread, it immediately takes the next job from the list. If a
        thread has started processing a job, it doesn't interrupt or stop until it finishes
        processing the job. If several threads try to take jobs from the list simultaneously,
        the thread with the smaller index takes the job. For each job you know exactly how
        long will it take any thread to process this job, and this time is the same for all
        the threads. You need to determine for each job which thread will process it and when
        will it start processing.
    Input Format: The first line of the input contains integers n and m. The second line
        contains m integers t(i) - the times in seconds it takes any thread to process i-th
        job. The times are given in the same order as they are in the list from which threads
        take jobs. Threads are indexed starting from 0.
    Constraints: 1 <= n <= 10^5; 1 <= m <= 10^5; 0 <= t(i) <= 10^9.
    Output Format: Output exactly m lines. i-th line (0-based index is used) should contain
        two space-separated integers - the 0-based index of the thread which will process the
        i-th job and the time in seconds when it will start processing that job.
    Time Limits: 4 sec.
    Memory Limit: 512 MB.

Sample 1:
    Input:
        2 5
        1 2 3 4 5
    Output:
        0 0
        1 0
        0 1
        1 2
        0 4
    1) The two threads try to simultaneously take jobs from teh list, so thread with index 0
        actually takes the first job and starts working on it at the moment 0.
    2) The thread with index 1 takes the second job and starts working on it also at the
        moment 0.
    3) After 1 second, thread 0 is done with the first job and takes the third job from the
        list, and starts processing it immediately at time 1.
    4) One second later, thread 1 is done with the second job and takes the fourth job from
        the list, and starts processing it immediately at time 2.
    5) Finally, after 2 more seconds, thread 0 is done with the third job and takes the
        fifth job from teh list, and starts processing it immediately at time 4.

Sample 2:
    Input:
        4 20
        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    Output:
        0 0
        1 0
        2 0
        3 0
        0 1
        1 1
        2 1
        3 1
        0 2
        1 2
        2 2
        3 2
        0 3
        1 3
        2 3
        3 3
        0 4
        1 4
        2 4
        3 4
    Explanation: Jobs are taken by 4 threads in packs of 4, processed in 1 second, and then
    the next pack comes. This happens 5 times starting at moments 0, 1, 2, 3, and 4. After
    that all the 5 x 4 = 20 jobs are processed.

Starter Files:
    The starter solutions for C++, Java, and Python3 in this problem read the input, apply
an O(n^2) algorithm to solve the problem and write the output. You need to replace the
O(n^2) algorithm with a faster one. If yyou use other languages, you need to implement the
solution from scratch.

What to Do:
    Think about the sequence of events when one of the threads comes free (at the start and
later after completing some job). How to apply priority queue to simulate processing of these
events in the required order? Remember to consider the case when several threads becomes free
simultaneously.
    Beware of integer overflow in this problem: use type long long in C++ and type long in
Java wherever the regular type int can overflow given the restrictions in the problem
statement.
 */

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class JobQueue {
    public int numWorkers;
    public int[] jobs;

    public int[] assignedWorker;
    public long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // to do: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; ++i) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    public void assignJobs2() {
        // create int array to hold which worker (thread) was assigned to handle a given job
        assignedWorker = new int[jobs.length];
        // create long array to hold start time of each job
        startTime = new long[jobs.length];

        // create array of Thread objects to use for priority queue to determine which thread to use
        // Thread object holds next available time for the thread, and which worker it was
        Thread[] threads = getThreads();

        for (int i = 0; i < jobs.length; i++) {
            assignedWorker[i] = threads[0].thread;
            startTime[i] = threads[0].nextAvailTime;

            long timeAfterProcessing = threads[0].nextAvailTime + (long)jobs[i];

            changePriority(threads, timeAfterProcessing);
        }
    }

    public Thread[] getThreads() {
        Thread[] threads = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            threads[i] = new Thread(i);
        }
        return threads;
    }

    public void changePriority(Thread[] threads, long timeAfterProcessing) {
        threads[0].nextAvailTime = timeAfterProcessing;
        shiftDown(threads, 0);
    }

    public void shiftDown(Thread[] threads, int i) {
        int minIndex = i;

        int left = leftChild(i);
        if (left < threads.length
                && threads[left].nextAvailTime <= threads[minIndex].nextAvailTime) {
            if (threads[left].nextAvailTime < threads[minIndex].nextAvailTime) {
                minIndex = left;
            } else if (threads[left].thread < threads[minIndex].thread) {
                minIndex = left;
            }
        }

        int right = rightChild(i);
        if (right < threads.length
                && threads[right].nextAvailTime <= threads[minIndex].nextAvailTime) {
            if (threads[right].nextAvailTime < threads[minIndex].nextAvailTime) {
                minIndex = right;
            } else if (threads[right].thread < threads[minIndex].thread) {
                minIndex = right;
            }
        }

        if (i != minIndex) {
            Thread temp = threads[i];
            threads[i] = threads[minIndex];
            threads[minIndex] = temp;
            shiftDown(threads, minIndex);
        }
    }

    private int rightChild(int i) {
        return 2*i + 2;
    }

    public int leftChild(int i) {
        return 2*i + 1;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        //assignJobs();
        assignJobs2();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Thread {
        int thread;
        long nextAvailTime = 0L;

        public Thread(int thread) {
            this.thread = thread;
        }
    }
}
