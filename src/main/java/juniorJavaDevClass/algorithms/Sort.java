package juniorJavaDevClass.algorithms;

public class Sort {

    public static void bubbleSort(int[] dataSet) {
        boolean swapped;
        System.out.print("\nOriginal array: \n");
        printArr(dataSet);
        do {
            swapped = false;
            for (int i = 0; i < dataSet.length - 1; i++) {
                if (dataSet[i] > dataSet[i + 1]) {
                    int temp = dataSet[i];
                    dataSet[i] = dataSet[i + 1];
                    dataSet[i + 1] = temp;
                    printArr(dataSet);
                    swapped = true;
                }
            }
            System.out.println("ITERATION");
        } while (swapped);
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
