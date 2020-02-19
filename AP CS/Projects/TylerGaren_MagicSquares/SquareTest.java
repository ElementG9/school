// ****************************************************************
// SquareTest.java
//
// Uses the Square class to read in square data and tell if 
// each square is magic.
//          
// ****************************************************************

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SquareTest {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("magicData.txt"));

        int count = 1;                 //count which square we're on
        int size = scan.nextInt();     //size of next square

        //Expecting -1 at bottom of input file
        while (size != -1) {

            //create a new Square of the given size
            Square s = new Square(size);

            //call its read method to read the values of the square
            s.readSquare(scan);
            System.out.println("\n******** Square " + count + " ********");
            
            //print the square
            s.printSquare();

            System.out.print("\n");
            
            //print the sums of its rows
            System.out.print("Row Sums: ");
            for (int i = 0; i < size; i++)
                System.out.print(s.sumRow(i) + " ");
            System.out.print("\n");

            //print the sums of its columns
            System.out.print("Column Sums: ");
            for (int i = 0; i < size; i++)
                System.out.print(s.sumCol(i) + " ");
            System.out.print("\n");

            //print the sum of the main diagonal
            System.out.println("Main Diagonal Sum: " + s.sumMainDiag());

            //print the sum of the other diagonal
            System.out.println("Other Diagonal Sum: " + s.sumOtherDiag());

            //determine and print whether it is a magic square
            System.out.print("\n");
            System.out.println("Square " + count + " is" + (s.magic() ? "" : " not") + " magic");

            //get size of next square
            size = scan.nextInt();
            count++;

        }

    }
    public static void test3x3() {
        System.out.println("\ntest3x3");
        int[][] data = {{0,1,2},{3,4,5},{6,7,8}};
        int[][] magicData = {{4,9,2},{3,5,7},{8,1,6}};
        
        Square s1 = new Square(3);
        s1.from2darr(data);
        s1.printSquare();
        System.out.println(s1.magic());
        
        Square s2 = new Square(3);
        s2.from2darr(magicData);
        s2.printSquare();
        System.out.println(s2.magic());
    }
}
