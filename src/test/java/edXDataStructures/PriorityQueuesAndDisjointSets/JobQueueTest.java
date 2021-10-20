package edXDataStructures.PriorityQueuesAndDisjointSets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobQueueTest {

    JobQueue jq;
    @BeforeEach
    public void setUp() {jq = new JobQueue(); }

    @Test
    void test1getThreads() {
        jq.numWorkers = 2;
        JobQueue.Thread[] expected = new JobQueue.Thread[jq.numWorkers];
        expected[0] = new JobQueue.Thread(0);
        expected[1] = new JobQueue.Thread(1);
        JobQueue.Thread[] result = jq.getThreads();
        Assertions.assertNotNull(result);
        for (int i = 0; i < jq.numWorkers; i++) {
            Assertions.assertEquals(expected[i].nextAvailTime, result[i].nextAvailTime);
            Assertions.assertEquals(expected[i].thread, result[i].thread);
        }
    }

    @Test
    void test2getThreads() {
        jq.numWorkers = 4;
        JobQueue.Thread[] expected = new JobQueue.Thread[jq.numWorkers];
        expected[0] = new JobQueue.Thread(0);
        expected[1] = new JobQueue.Thread(1);
        expected[2] = new JobQueue.Thread(2);
        expected[3] = new JobQueue.Thread(3);
        JobQueue.Thread[] result = jq.getThreads();
        Assertions.assertNotNull(result);
        for (int i = 0; i < jq.numWorkers; i++) {
            Assertions.assertEquals(expected[i].nextAvailTime, result[i].nextAvailTime);
            Assertions.assertEquals(expected[i].thread, result[i].thread);
        }
    }

    @Test
    void testSample1assignJobs2() {
        jq.numWorkers = 2;
        jq.jobs = new int[5];
        jq.jobs[0] = 1;
        jq.jobs[1] = 2;
        jq.jobs[2] = 3;
        jq.jobs[3] = 4;
        jq.jobs[4] = 5;
        int[] expectedWorkers = {0, 1, 0, 1, 0};
        long[] expectedTimes = {0, 0, 1, 2, 4};
        jq.assignJobs2();
        Assertions.assertNotNull(jq.assignedWorker);
        Assertions.assertNotNull(jq.startTime);
        Assertions.assertEquals(expectedWorkers.length, jq.assignedWorker.length);
        Assertions.assertEquals(expectedTimes.length, jq.startTime.length);
        for (int i = 0; i < jq.jobs.length; i++) {
            Assertions.assertEquals(expectedWorkers[i], jq.assignedWorker[i]);
            Assertions.assertEquals(expectedTimes[i], jq.startTime[i]);
        }
    }

    @Test
    void testSample2assignJobs2() {
        jq.numWorkers = 4;
        jq.jobs = new int[20];
        jq.jobs[0] = 1;
        jq.jobs[1] = 1;
        jq.jobs[2] = 1;
        jq.jobs[3] = 1;
        jq.jobs[4] = 1;
        jq.jobs[5] = 1;
        jq.jobs[6] = 1;
        jq.jobs[7] = 1;
        jq.jobs[8] = 1;
        jq.jobs[9] = 1;
        jq.jobs[10] = 1;
        jq.jobs[11] = 1;
        jq.jobs[12] = 1;
        jq.jobs[13] = 1;
        jq.jobs[14] = 1;
        jq.jobs[15] = 1;
        jq.jobs[16] = 1;
        jq.jobs[17] = 1;
        jq.jobs[18] = 1;
        jq.jobs[19] = 1;
        int[] expectedWorkers = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        long[] expectedTimes = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        jq.assignJobs2();
        Assertions.assertNotNull(jq.assignedWorker);
        Assertions.assertNotNull(jq.startTime);
        Assertions.assertEquals(expectedWorkers.length, jq.assignedWorker.length);
        Assertions.assertEquals(expectedTimes.length, jq.startTime.length);
        for (int i = 0; i < jq.jobs.length; i++) {
            Assertions.assertEquals(expectedWorkers[i], jq.assignedWorker[i]);
            Assertions.assertEquals(expectedTimes[i], jq.startTime[i]);
        }
    }
}