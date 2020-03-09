import java.util.ArrayList;
public class Sorters {
    public static void main() {
        System.out.println("\n-=-=- Sorters -=-=-\n");
        int[] data = { 9, 5, 8, 2, 4, 1, 6, 5 };
        printArr(data, "Data");
        int[] bubbleSorted = bubbleSort(data);
        printArr(bubbleSorted, "Bubble Sort Output");
        int[] selectionSorted = selectionSort(data);
        printArr(selectionSorted, "Selection Sort Output");
        int[] insertionSorted = insertionSort(data);
        printArr(insertionSorted, "Insertion Sort Output");
    }
    public static int[] bubbleSort(int[] arr) {
        System.out.print("\n");
        printArr(arr, "Bubble Sort Input");
        // Copy data
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            out[i] = arr[i];
        boolean moved = false;
        boolean shouldContinue = true;
        while (shouldContinue) {
            for (int i = 0; i < out.length - 1; i++) {
                if (out[i + 1] < out[i]) { // Swap if larger than i + 1
                    moved = true;
                    int temp = out[i + 1];
                    out[i + 1] = out[i];
                    out[i] = temp;
                }
            }
            printArr(out, "\tBubble Sorting");
            if (!moved)
                shouldContinue = false;
            moved = false;
        }
        return out;
    }
    public static int[] selectionSort(int[] arr) {
        System.out.print("\n");
        printArr(arr, "Selection Sort Input");
        // Copy data
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            out[i] = arr[i];
        for (int iterations = 0; iterations < out.length - 1; iterations++) {
            // Find largest.
            int largestIndex = 0;
            for (int i = 0; i < out.length - iterations; i++)
                if (out[i] > out[largestIndex])
                    largestIndex = i;
            // Move largest to right.
            int tempLargest = out[largestIndex];
            for (int i = largestIndex; i < out.length - 1 - iterations; i++)
                out[i] = out[i+1];
            out[out.length - 1 - iterations] = tempLargest;
            printArr(out, "\tSelection Sorting");
        }
        return out;
    }
    public static int[] insertionSort(int[] arr) {
        System.out.print("\n");
        printArr(arr, "Insertion Sort Input");
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        sorted.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            System.out.print("\tInsertion Sorting: Current: " + current + ", Sorted");
            printArr(sorted, "");
            int index = 0;
            for (int j = 0; j < sorted.size(); j++)
                if (sorted.get(j) < current)
                    index++;
            sorted.add(index, current);
        }
        int[] out = new int[sorted.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = sorted.get(i);
        }
        return out;
    }
    public static void printArr(int[] arr, String label) {
        System.out.print(label);
        System.out.print(":");
        for (int i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
    public static void printArr(ArrayList<Integer> arr, String label) {
        System.out.print(label);
        System.out.print(":");
        for (int i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
}