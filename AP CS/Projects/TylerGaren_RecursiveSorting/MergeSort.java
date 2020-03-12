import java.util.*;
public class MergeSort {
    public static void main() {
        System.out.println("\n-=-=- Merge Sort -=-=-\n");
        // Integer[] data = { 1, 2 };
        // Integer[] data = { 9, 5, 8, 2, 4, 1, 6, 5 };
        // Integer[] data = { 2, 5, 8, 9, 1, 4, 5, 6 };
        Integer[] data = {69, 420, 123, 5 ,23, 3, 56,2 ,67};
        System.out.print("Data: ");
        printArr(data);
        mergeSort(data);
        System.out.print("Merge Sorted: ");
        printArr(data);
    }

    public static void mergeSort(Integer[] arr) {
        // merge(arr, 0, (int)(arr.length)/2 - 1, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(Integer[] arr, int low, int high) {
        // System.out.println("max: " + maxRunCount + ", actual: " + runCount);
        int mid = low + (high - low)/2;
        // System.out.println("low: " + low + ", mid: " + mid + ", high: " + high);
        if (low == high) { // Base case
            // System.out.println("base");
            return;
        }
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(Integer[] arr, int low, int mid, int high) {
        // System.out.println("low: " + low + ", mid: " + mid + ", high: " + high);
        // Mid is a part of low
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        int lowIndex = low;
        int highIndex = mid + 1;
        for (int i = low; i <= high; i++) {
            if (lowIndex <= mid && highIndex <= high) { // Both have data
                // System.out.println("comparing: " + temp[lowIndex] + ", " + temp[highIndex]);
                if (temp[lowIndex] < temp[highIndex]) {
                    arr[i] = temp[lowIndex];
                    lowIndex++;
                } else {
                    arr[i] = temp[highIndex];
                    highIndex++;
                }
            } else if (lowIndex > mid && highIndex <= high) { // Low is all copied
                arr[i] = temp[highIndex];
                highIndex++;
            } else if (lowIndex <= mid && highIndex > high) { // High is all copied
                arr[i] = temp[lowIndex];
                lowIndex++;
            } else {} // Both are all copied
        }
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
