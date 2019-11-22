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
            System.out.println("Player " + (i + 1) + " name: ");
            String name = scan.nextLine();
            players[i] = new Player(name);
        }
        // Set up dice.
        dice = new Die[6];
        for (int i = 0; i < dice.length; i++)
            dice[i] = new Die();
        // Set up the pot.
        pot = 0;
        // Set up the gameboard.
        gameboard = new boolean[6];
        clearBoard();
    }
    private void clearBoard() {
        for (int i = 0; i < gameboard.length; i++)
            gameboard[i] = false; // Clear the board.
    }
}