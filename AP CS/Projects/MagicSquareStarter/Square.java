// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************

import java.util.Scanner;

public class Square
{
    int[][] square;

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size) {
        this.square = new int[size][size];
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row) {
        int sum = 0;
        for(int x = 0; x < this.square[row].length; x++)
            sum += this.square[row][x];
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumCol(int col) {
        int sum = 0;
        for(int y = 0; y < this.square.length; y++)
            sum += this.square[y][col];
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag() {
        int sum = 0;
        for (int i = 0; i < this.square.length; i++)
            sum += this.square[i][i];
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag() {
        int sum = 0;
        for (int i = 0; i < this.square.length; i++)
            sum += this.square[this.square.length - i - 1][i];
        return sum;
    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean magic() {
        boolean isMagic = true;
        return isMagic;
    }
    //--------------------------------------
    //read info into the square from the input stream associated with the 
    //Scanner parameter
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col ++)
                square[row][col] = scan.nextInt();
    }
    public void from2darr(int[][] arr) {
        if (arr.length != this.square.length || arr[0].length != this.square[0].length)
            return;
        for (int row = 0; row < this.square.length; row++)
            for (int col = 0; col < this.square[row].length; col ++)
                this.square[row][col] = arr[row][col];
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare() {
        System.out.println("Square size: " + this.square.length);
        for(int y = 0; y < this.square.length; y++) {
            for(int x = 0; x < this.square[y].length; x++)
                System.out.print(this.square[y][x]);
            System.out.print("\n");
        }
    }

}
