// U2.6.5
import java.util.Scanner;

public class NormieShopper {
    static ShoppingCart cart = new ShoppingCart();
    static Scanner scan = new Scanner(System.in);
    public static void main() {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0) {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }

    // Do what the menu item calls for.
    public static void dispatch(int choice) {
        int loc;
        int item;
        switch(choice) {
            case 0: 
                System.out.println("Bye!");
                break;
            case 1:
                System.out.print("What item should be added? ");
                String itemName = scan.next();
                System.out.print("How expensive is it? ");
                double itemPrice = scan.nextDouble();
                System.out.print("How many of it are you getting? ");
                int itemQuantity = scan.nextInt();
                cart.addToCart(itemName, itemPrice, itemQuantity);
                System.out.println("Item added.");
                break;
            case 2:
                System.out.println(cart.toString());
                break;
            case 420:
                System.out.println("Epic gamer");
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }

    // Print the user's choices.
    public static void printMenu() {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Add an item to your cart");
        System.out.println("2: Print the contents of your cart"); 
        System.out.print("\nEnter your choice: ");
    }
}