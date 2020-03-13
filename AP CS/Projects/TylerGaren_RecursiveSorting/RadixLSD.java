import java.util.*;
public class RadixLSD {
    public static void main() {
        System.out.println("\n-=-=- Radix LSD Sort -=-=-\n");
        // Integer[] data = { 1, 2 };
        // Integer[] data = { 9, 5, 8, 2, 4, 1, 6, 5 };
        Integer[] data = { 12, 35, 28, 9, 91, 4, 5, 56 };
        // Integer[] data = {69, -420, -123, 5 ,23, 3, -56,2 ,67,16};
        System.out.print("Data: ");
        printArr(data);
        radixLSD(data);
        System.out.print("Sorted: ");
        printArr(data);
    }
    
    public static void radixLSD(Integer[] arr) {
        int maxDigit = 0;
        boolean done = false;
        while (!done) {
            done = true;
            for (Integer i : arr) {
                if (i >= Math.pow(10, maxDigit)) {
                    maxDigit++;
                    done = false;
                }
            }
            
        }
        for (int i = 0; i < maxDigit; i++)
            sortDigit(arr, i);
    }
    
    public static void sortDigit(Integer[] arr, int digit) {
        ArrayList[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<Integer>();
        for (Integer i : arr)
            buckets[getDigit(i, digit)].add(i);
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (ArrayList<Integer> a : buckets)
            for (Integer i : a)
                sorted.add(i);
        for (int i = 0; i < arr.length; i++)
            arr[i] = sorted.get(i);
        printArr(arr);
    }

    public static int getDigit(Integer i, int digit) {
        if (digit < 0)
            throw new IllegalArgumentException("digit cannot be negative");
        if (i < Math.pow(10, digit))
            return 0;
        i /= (int) Math.pow(10, digit);
        i = (int) Math.floor(i) % 10;
        return i;
    }
    
    public static void printArr(Integer[] arr) {
        for (Integer i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
    public static void printArr(ArrayList<Integer> arr) {
        for (Integer i : arr)
            System.out.print(" " + i);
        System.out.print("\n");
    }
}