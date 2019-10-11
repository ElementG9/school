// U2.6.3
import java.util.Scanner;
import java.util.Arrays;

public class ArrayReverser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nArray Reverser:");
        
        System.out.print("\nHow many values are in the array: ");
        final int VALUES = scan.nextInt();
        int[] arr = new int[VALUES];

        scan.nextLine();
        
        arr = getArray(scan, VALUES);
        arr = reverseArray(arr);
        
        System.out.print("[");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }
    private static int[] getArray(Scanner scan, int length) {
        int[] arr = new int[length];
        System.out.print("Array: ");
        String[] arrStrings = scan.nextLine().split("\\s+");
        if (arrStrings.length != length) {
            System.out.println("Wrong number of values. Expected " + length + " but got " + arrStrings.length + ".");
            return getArray(scan, length);
        }
        for(int i=0; i<arrStrings.length; i++){
            arr[i] = Integer.parseInt(arrStrings[i]);
        }
        return arr;
    }
    public static int[] reverseArray(int[] arr) {
        int swap;
        if(arr.length == 1) {
            return arr; // No sorting needed.
        } else if (arr.length == 2) {
            // Swap the two.
            swap = arr[0];
            arr[0] = arr[1];
            arr[1] = swap;
            return arr;
        } else {
            // Swap the first and the last.
            swap = arr[0];
            arr[0] = arr[arr.length - 1];
            arr[arr.length - 1] = swap;
            int[] middle = reverseArray(Arrays.copyOfRange(arr, 1, arr.length - 1));
            for(int i=0;i<middle.length;i++) {
                arr[i+1] = middle[i];
            }
            return arr;
        }
    }
}
