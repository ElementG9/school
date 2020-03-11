import java.util.*;
public class MergeSort {
    public static void main() {
        System.out.println("\n-=-=- Merge Sort -=-=-\n");
        // Integer[] data = { 1, 2 };
        Integer[] data = { 9, 5, 8, 2, 4, 1, 6, 5 };
        Integer[] halfSorted = { 2, 5, 8, 9, 1, 4, 5, 6 };
        System.out.print("Data: ");
        printArr(data);
        mergeSort(halfSorted);
        System.out.print("Merge Sorted: ");
        printArr(data);
    }
    public static void mergeSort(Integer[] arr) {
        merge(arr, 0, (int)(arr.length - 1)/2, arr.length - 1);
        // mergeSort(arr, 0, arr.length - 1);
    }
    private static void mergeSort(Integer[] arr, int low, int high) {
        // System.out.println("Diff: " + (high - low));
        // int split = (high - low)/2;
        // System.out.println("Low Half: " + (split - low));
        // System.out.println("High Half: " + (high - split));
        // if (low != high) {
            // mergeSort(arr, low, split);
            // mergeSort(arr, split + 1, high);
        // }
    }
    private static void merge(Integer[] arr, int low, int mid, int high) {
        Integer[] sorted = new Integer[high - low];
        int index = 0;
        int lowIndex = low;
        int highIndex = mid + 1;
        printArr(arr);
        for (int i = 0; i < 8; i++) {
            if (lowIndex > mid && highIndex > high) {
            } else if (highIndex > high && lowIndex <= mid) {
                sorted[index] = arr[lowIndex];
                index++;
                lowIndex++;
                System.out.println("\tAdded low");
            } else if (lowIndex > mid && highIndex <= high) {
                sorted[index] = arr[highIndex];
                index++;
                highIndex++;
                System.out.println("\tAdded high");
            } else {
                System.out.println("low: " + arr[lowIndex] + ", index: " + lowIndex);
                System.out.println("high: " + arr[highIndex] + ", index: " + highIndex);
                if (arr[lowIndex] < arr[highIndex]) {
                    sorted[index] = arr[lowIndex];
                    index++;
                    lowIndex++;
                    System.out.println("\tAdded low");
                } else if (arr[highIndex] < arr[lowIndex]) {
                    sorted[index] = arr[highIndex];
                    index++;
                    highIndex++;
                    System.out.println("\tAdded high");
                } else {
                    sorted[index] = arr[highIndex];
                    index++;
                    highIndex++;
                    System.out.println("\tAdded high");
                }
            }
        }
        printArr(sorted);
    }
    public static void printArr(Integer[] arr) {
        for (Integer i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
    public static void printArr(boolean[] arr) {
        for (boolean i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
    public static void printArr(ArrayList<Integer> arr) {
        for (int i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
}
