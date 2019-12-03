import java.util.*;
public class Finish {
    public static void main() {
        Finish game = new Finish();
    }

    int pot;
    boolean[] gameboard; // F-I-N-I-S-H
    Player[] players;
    Die[] dice;
    public Finish() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Finish!");
        System.out.print("How many players? (3-5): ");
        int numOfPlayers = scan.nextInt();
        while (numOfPlayers < 3 || numOfPlayers > 5) {
            System.out.println(numOfPlayers + " is not between 3 and 5");
            System.out.print("How many players? (3-5): ");
            numOfPlayers = scan.nextInt();
        }
        // Set up players.
        players = new Player[numOfPlayers];
        scan.nextLine();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scan.nextLine();
            players[i] = new Player(name);
        }
        System.out.println();
        // Set up the dice.
        dice = new Die[6];
        for (int i = 0; i < dice.length; i++)
            dice[i] = new Die();
        // Set up the pot.
        pot = 0;
        // Set up the gameboard.
        gameboard = new boolean[6];
        clearBoard();
        int roundNum = 1;
        while (roundNum < 75) {
            if (roundNum == 69)
                System.out.println("\nRound 69: Nice.");
            else System.out.println("\nRound " + roundNum +":");
            for (int i = 0; i < players.length; i++) {
                System.out.print("\tPlayer " + (i + 1) + "'s turn:");
                int[] rolls = new int[dice.length];
                for (int j = 0; j < dice.length; j++)
                    rolls[j] = dice[j].roll();
            }
            System.out.println("Status after round " + roundNum +":");
            printStatus();
            roundNum++;
        }
    }

    public void printStatus() {
        System.out.print("\tGame board: ");
        boolean printedGameboard = false;
        if(gameboard[0]) {
            System.out.print("F ");
            printedGameboard = true;
        }
        if(gameboard[1]) {
            System.out.print("I ");
            printedGameboard = true;
        }
        if(gameboard[2]) {
            System.out.print("N ");
            printedGameboard = true;
        }
        if(gameboard[3]) {
            System.out.print("I ");
            printedGameboard = true;
        }
        if(gameboard[4]) {
            System.out.print("S ");
            printedGameboard = true;
        }
        if(gameboard[5]) {
            System.out.print("H");
            printedGameboard = true;
        }
        if (!printedGameboard)
            System.out.print("Empty");
        System.out.println();
        for(int i = 0; i < players.length; i++) {
            System.out.print("\tPlayer " + (i + 1) + ": ");
            if (players[i].isOut())
                System.out.println("Out");
            else System.out.println(players[i].getChips() + " chips");
        }
    }

    private int[] sort(int[] arr) {

    }

    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
        for(int i = 0; i < n; i++){  
            for(int j = 1; j < (n - i); j++){  
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];
                    arr[j] = temp;  
                }
            }  
        }  

    }

    private int numToPay() {
        return 5 - numToRoll();
    }

    private int numToRoll() {
        int index = 0;
        while (!gameboard[index]) // While gameboard[index] is false
            index++;
        return index + 1;
    }

    private Die[] removeDie() {
        Die[] newDice = new Die[dice.length - 1];
        for (int i = 0; i < newDice.length; i++)
            newDice[i] = dice[i];
        return newDice;
    }

    private void clearBoard() {
        for (int i = 0; i < gameboard.length; i++)
            gameboard[i] = false; // Clear the board.
    }
}