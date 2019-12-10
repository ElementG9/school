import java.util.*;
public class Finish {
    public static void main (String[] args) {
        System.out.println("Welcome to Finish!");
        Finish game = new Finish();
        Scanner scan = new Scanner(System.in);
        while (game.isRunning) {
            System.out.print("Press enter to continue:");
            scan.nextLine();
            game.runRound();
        }
        System.out.println("Thanks for playing Finish!");
    }

    Board gameboard;   // F-I-N-I-S-H
    Player[] players;
    public boolean isRunning;
    public int roundNum;
    public Finish() {
        Scanner scan = new Scanner(System.in);
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
        // Set up the gameboard.
        gameboard = new Board();
        gameboard.clear();
        roundNum = 0;
        isRunning = true;
    }

    public void runRound () {
        roundNum++;
        System.out.print("Round #" + roundNum);
        if (roundNum == 69)
            System.out.println(": nice");
        else
            System.out.println(":");
        for (int i = 0; i < players.length; i++)
            if (isRunning)
                takeTurn(players[i]);
        printStatus();
    }

    public void winGame (Player p, String reason) {
        System.out.println(p.getName() + " won the game by " + reason);
        isRunning = false;
    }

    public void allPayToOne(Player p, int amt) {
        // Find the other players.
        Player[] others = new Player[players.length - 1];
        boolean found = false;
        for (int j = 0; j < players.length; j++) {
            if (players[j].getName() == p.getName())
                found = true;
            else
                others[j - (found ? 1 : 0)] = players[j];
        }
        // Make the other players pay.
        for(int i = 0; i < others.length; i++) {
            others[i].removeChips(amt); // Remove the chips.
            if (others[i].isOut())
                System.out.println("\t" + others[i].getName() + " is out due to running out of chips.");
            else System.out.println("\t" + others[i].getName() + " has " + others[i].getChips() + " chips"); // Print the new chips.
        }
        p.removeChips(-1 * others.length * amt); // Add all the chips to the one player.
        // Print the data.
        for (int j = 0; j < others.length; j++) {
            if (others.length == 1)
                System.out.println("\t" + others[j].getName() + " pays " + amt + (amt == 1 ? " chip" : " chips") + " to " + p.getName());
            else if (j == 0 && j + 1 < others.length)
                System.out.print("\t" + others[j].getName() + ", ");
            else if (j + 1 >= others.length)
                System.out.println(" and " + others[j].getName() + " pay " + amt + (amt == 1 ? " chip" : " chips") + " each to " + p.getName());
            else System.out.print(others[j].getName() + ", ");
        }
    }

    public void winRound (Player p) {
        System.out.println(p.getName() + " won the round by completing F I N I S H");
        System.out.println("Each player must pay " + p.getName() + " 1 chip");
        allPayToOne(p, 1);
    }

    public boolean takeTurn (Player p) {
        // Return true if a player won.
        // Check if p is the only player not out.
        int playersIn = 0;
        for (int i = 0; i < players.length; i++)
            if (!players[i].isOut())
                playersIn++;
        if (playersIn == 1) {
            winGame(p, "all the other players got out");
            return true;
        }
        // Don't do anything if the player is out.
        if (p.isOut())
            return false;
        // Print information.
        System.out.println(p.getName() + "'s turn:");
        gameboard.printStatus();
        System.out.println("\t" + p.getName() + " has " + p.getChips() + " chips");
        System.out.println("\t" + p.getName() + " needs to roll a " + gameboard.numToRoll());
        // Roll the dice.
        System.out.print("\t" + p.getName() + " rolls " + (gameboard.getDice().length == 1 ? "the die" : (gameboard.getDice().length + " dice")) + " and gets");
        int[] rolls = gameboard.rollDice();
        rolls = gameboard.sort(rolls);
        for (int i = 0; i < rolls.length; i++)
            System.out.print(" " + rolls[i]);
        System.out.print("\n");
        // Check instawin.
        boolean instawin = true;
        if (rolls.length == 6)
            for (int i = 0; i < rolls.length; i++)
                if (rolls[i] != (i + 1))
                    instawin = false;
        if (rolls.length != 6)
            instawin = false;
        if (instawin) {
            winGame(p, "rolling 1 2 3 4 5 6");
            return true;
        }
        // Check normally.
        int originalNeeded = gameboard.numToRoll();
        boolean needsToPay = true;
        for (int i = originalNeeded; i < 6; i++) {
            for (int j = 0; j < rolls.length; j++) {
                if (rolls[i] == originalNeeded)
                    needsToPay = true;
            }
        }
        return false;
    }

    public void printStatus () {
        System.out.println("Game status:");
        gameboard.printStatus();
        for (int i = 0; i < players.length; i++) {
            System.out.print("\t");
            if (players[i].isOut())
                System.out.println(players[i].getName() + ": Out");
            else System.out.println(players[i].toString());
        }
    }
}
