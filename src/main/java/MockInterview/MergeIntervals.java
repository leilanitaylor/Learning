package MockInterview;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {5, 7}, {6, 8}, {10, 12}};

        mergeInterals(intervals);

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null)
                System.out.println("[" + intervals[i][0] + " " + intervals[i][1] + "]");
        }
    }

    public static int[][] mergeInterals(int[][] intervals) {
        int index = 0;

        sortIntervals(intervals);

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == -1)
                continue;

            int upperBound = intervals[index][1];

            if (index < i) {
                if (upperBound >= intervals[i][0]) {
                    intervals[index][1] = intervals[i][1];
                    intervals[i][0] = -1;
                    continue;
                } else index = i;
            } else index = i;

            upperBound = intervals[index][1];

            if (index != i) {
                if (upperBound >= intervals[i][0]) {
                    if (upperBound < intervals[i][1])
                        intervals[index][1] = intervals[i][1];
                    intervals[i][0] = -1;
                    continue;
                }
            }

            if (i < intervals.length-1) {
                if (upperBound < intervals[i + 1][0]) {
                    index = i;
                    continue;
                }

                if (upperBound < intervals[i+1][1])
                    intervals[index][1] = intervals[i + 1][1];
                intervals[i + 1][0] = -1;
            }
        }

        shiftIntervals(intervals);

        return intervals;
    }

    private static void shiftIntervals(int[][] intervals) {
        boolean jHasReachedEnd = false;
        for (int i = 0; i < intervals.length; i ++){
            if (jHasReachedEnd)
                break;
            if (intervals[i][0] == -1) {
                for (int j = i+1; j < intervals.length; j++) {
                    if (intervals[j][0] != -1) {
                        intervals[i][0] = intervals[j][0];
                        intervals[i][1] = intervals[j][1];
                        intervals[j][0] = -1;
                        if (j == intervals.length-1)
                            jHasReachedEnd = true;
                        break;
                    }
                    if (j == intervals.length-1)
                        jHasReachedEnd = true;
                }
            }
        }

        for (int i = intervals.length-1; i > 0; i--) {
            if (intervals[i][0] != -1)
                break;
            intervals[i] = null;
        }
    }

    private static void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                if (entry1[0] > entry2[0])
                    return 1;
                else return -1;
            }
        });
    }
}
