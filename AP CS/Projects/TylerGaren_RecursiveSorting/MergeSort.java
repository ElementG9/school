import java.util.*;
public class MergeSort {
    public static void main() {
        System.out.println("\n-=-=- Merge Sort -=-=-\n");
        // Integer[] data = { 1, 2 };
        Integer[] data = { 9, 5, 8, 2, 4, 1, 6, 5 };
        System.out.print("Data: ");
        printArr(data);
        mergeSort(data);
        System.out.print("Merge Sorted: ");
        printArr(data);
    }
    public static void mergeSort(Integer[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    private static void mergeSort(Integer[] arr, int low, int high) {
        if (high - low > 1) {
            mergeSort(arr, low, (high-low)/2);
            mergeSort(arr, (high-low)/2, high);
        }
    }
    private static void merge(Integer[] arr, int low, int mid, int high) {
    }
    // public static int[] mergeSort(int[] arr) {
        // if (arr.length == 1)
            // return arr;
        // int splitIndex = (int) (arr.length * 0.5);
        // int[] firstHalf = new int[splitIndex];
        // int[] secondHalf = new int[arr.length - splitIndex];
        // for (int i = 0; i < arr.length; i++) {
            // if (i < splitIndex)
                // firstHalf[i] = arr[i];
            // else secondHalf[i - splitIndex] = arr[i];
        // }
        // int[] sortedFirstHalf = mergeSort(firstHalf);
        // int[] sortedSecondHalf = mergeSort(secondHalf);
        
        // return arr;
    // }
    public static void printArr(Integer[] arr) {
        for (int i : arr)
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
