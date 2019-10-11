// U2.6.1
import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nSales Manager:");
        System.out.print("\nHow many salespeople: ");
        final int SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE];
        double sum;

        for (int i = 0; i < sales.length; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        int maxId = 0;
        int max = sales[0];
        int minId = 0;
        int min = sales[0];
        sum = 0;
        for (int i = 0; i < sales.length; i++) {
            System.out.println("     " + (i + 1) + "         " + sales[i]);
            sum += sales[i];
            if (sales[i] > max) {
                maxId = i;
                max = sales[i];
            }
            if (sales[i] < min) {
                minId = i;
                min = sales[i];
            }
        }

        System.out.println("\nTotal sales: " + (int) sum);
        System.out.println("Average sales: " + (sum/SALESPEOPLE));
        System.out.println("Salesperson " + (maxId + 1) + " had the highest sale with $" + max + ".");
        System.out.println("Salesperson " + (minId + 1) + " had the lowest sale with $" + min + ".");
        
        System.out.print("\nRemove sales under: ");
        int minSales = scan.nextInt();
        int numOverMin = 0;
        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        for (int i = 0; i < sales.length; i++) {
            if(sales[i] >= minSales) {
                System.out.println("     " + (i + 1) + "         " + sales[i]);
                numOverMin++;
            }
        }
        if (numOverMin == 1) {
            System.out.println("1 salesperson had sales over " + minSales);
        } else System.out.println(numOverMin + " salespeople had sales over " + minSales);
    }
}
