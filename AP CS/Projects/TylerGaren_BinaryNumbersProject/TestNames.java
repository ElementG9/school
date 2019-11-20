import java.util.Scanner;
public class TestNames {
    public static void main() {
        System.out.println("TestNames");
        System.out.println("Name 1: ");
        Name name1 = getName();
        System.out.println("Name 2: ");
        Name name2 = getName();
        System.out.println("\nGot names.");
        System.out.println("Name 1:");
        System.out.println("\tFirst-Middle-Last: " + name1.firstMiddleLast());
        System.out.println("\tLast-First-Middle: " + name1.lastFirstMiddle());
        System.out.println("\tInitials: " + name1.initials());
        System.out.println("\tLength: " + name1.length());
        System.out.println("Name 2:");
        System.out.println("\tFirst-Middle-Last: " + name2.firstMiddleLast());
        System.out.println("\tLast-First-Middle: " + name2.lastFirstMiddle());
        System.out.println("\tInitials: " + name2.initials());
        System.out.println("\tLength: " + name2.length());
        System.out.println("The names are " + (name1.equals(name2.firstMiddleLast()) ? "the same." : "different."));
    }
    public static Name getName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("First name: ");
        String fname = scan.nextLine();
        System.out.print("Middle name: ");
        String mname = scan.nextLine();
        System.out.print("Last name: ");
        String lname = scan.nextLine();
        return new Name(fname, mname, lname);
    }
}