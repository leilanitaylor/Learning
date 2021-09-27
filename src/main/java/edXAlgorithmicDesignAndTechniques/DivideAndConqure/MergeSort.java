package edXAlgorithmicDesignAndTechniques.DivideAndConqure;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = ((right - left) / 2) + left;
        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] aLeft = Arrays.copyOfRange(a, left, mid+1);
        int[] aRight = Arrays.copyOfRange(a, mid+1, right+1);
        int i = 0;
        int j = 0;
        int sortedIndex = left;
        while (i < aLeft.length && j < aRight.length) {
            if (aLeft[i] <= aRight[j]) {
                a[sortedIndex++] = aLeft[i++];
                //sortedIndex++;
                //i++;
            } else {
                a[sortedIndex++] = aRight[j++];
                //sortedIndex++;
                //j++;
            }
        }
        while (i < aLeft.length) {
            a[sortedIndex++] = aLeft[i++];
            //sortedIndex++;
            //i++;
        }
        while (j < aRight.length) {
            a[sortedIndex++] = aRight[j++];
            //sortedIndex++;
            //j++;
        }
    }
}
