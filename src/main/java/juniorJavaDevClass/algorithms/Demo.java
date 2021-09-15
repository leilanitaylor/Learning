package juniorJavaDevClass.algorithms;

public class Demo {

    public static void main(String[] args) {
        int[] numbers = {10, 25, 433, 26, 73, 132, 5, 35};
        int[] sortedNumbers = {5, 9, 12, 18, 21, 26, 29, 35, 39, 45, 49, 51, 58, 59, 61, 72, 88, 91, 94};

        // Call the linear search function that searchers for a specific number;
        int pos = Search.linearSearch(numbers, 73);
        System.out.println("Found at position: " + pos);

        // Call the binary search
        int index = Search.binarySearch(sortedNumbers, 49, 0, sortedNumbers.length-1);
        System.out.println("Found at position: " + index);

        // Call the bubble sort function
        Sort.bubbleSort(numbers);
    }
}
