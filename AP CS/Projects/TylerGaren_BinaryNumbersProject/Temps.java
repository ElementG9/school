import java.util.Scanner;
public class Temps {
    public static void main (String[] args)
    {

        final int HOURS_PER_DAY = 24;
        int temp;
        int maxTemp;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Temperature Readings for " + HOURS_PER_DAY + " Hour" + " Period");
        System.out.println();
        for (int hour = 0; hour < HOURS_PER_DAY; hour++) {
            System.out.print("Enter the temperature reading at " + hour + " hours: ");
            temp = scan.nextInt();
            if (hour == 0)
                maxTemp = temp;
            // else if (temp > maxTemp)
                // maxTemp = temp;
        }
        // Print the results

    }
}