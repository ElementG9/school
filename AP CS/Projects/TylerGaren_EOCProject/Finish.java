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
    int currentPlayer;
    public Finish() {
        System.out.println();
        // Get the players
        players = getPlayers();
        // Set up the gameboard.
        gameboard = new Board();
        gameboard.clear();
        roundNum = 0;
        currentPlayer = 0;
        isRunning = true;
    }
    
    public static Player[] getPlayers() {
        Player[] p;
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (3-5): ");
        int numOfPlayers = scan.nextInt();
        while (numOfPlayers < 3 || numOfPlayers > 5) {
            System.out.println(numOfPlayers + " is not between 3 and 5");
            System.out.print("How many players? (3-5): ");
            numOfPlayers = scan.nextInt();
        }
        // Set up players.
        p = new Player[numOfPlayers];
        scan.nextLine();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scan.nextLine();
            p[i] = new Player(name);
        }
        return p;
    }

    public void winRound (Player p) {
        System.out.println(p.getName() + " won the round by completing F I N I S H");
        System.out.println("Each player must pay " + p.getName() + " 1 chip");
        allPayToOne(p, 1);
    }

    public void winGame (Player p, String reason) {
        System.out.println(p.getName() + " won the game by " + reason);
        System.out.println(p.getName() + " collects the chips from all remaining players");
        int total = 0;
        for (int i = 0; i < players.length; i++) {
            total += players[i].getChips();
            players[i].removeChips(players[i].getChips());
            System.out.println(players[i].getName() );
        }
        isRunning = false;
    }

    public void runRound () {
        roundNum++;
        System.out.print("Round #" + roundNum);
        if (roundNum == 69)
            System.out.println(": nice");
        else
            System.out.println(":");
        for (int i = 0; i < players.length; i++) {
            if (isRunning) {
                if(takeTurn(players[i]))
                    isRunning = false;
            }
        }
        printStatus();
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
        int numToCrossOff = 0;
        boolean needsToPay = true;
        for (int j = 0; j < rolls.length; j++) {
            if (rolls[j] == originalNeeded)
                needsToPay = false;
            if (rolls[j] == gameboard.numToRoll()) {
                System.out.print("\t" + p.getName() + " got a " + gameboard.numToRoll());
                if (gameboard.numToRoll() == originalNeeded) {
                    needsToPay = false;
                    System.out.println(" and does not need to pay anything to the pot.");
                } else System.out.print("\n");
                gameboard.crossOff();
            }
            if(gameboard.numToRoll() == originalNeeded && needsToPay) {
                System.out.println("\t" + p.getName() + " did not get a " + originalNeeded + " and must pay " + (7 - originalNeeded) + " to the pot.");
                p.removeChips(7 - originalNeeded);
                gameboard.addToPot(7 - originalNeeded);
                if (p.isOut())
                    System.out.println("\t" + p.getName() + " is out due to running out of chips.");
                else System.out.println("\t" + p.getName() + " has " + p.getChips() + " chips"); // Print the new chips.
                break;
            }
        }
        return false;
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
        if (!found)
            throw new IllegalArgumentException("p was not found in players");
        // Make the other players pay.
        int total = 0;
        for(int i = 0; i < others.length; i++) {
            if (others[i].isOut()) {
                System.out.println("\t" + others[i].getName() + " is already out and cannot pay");
                continue;
            }
            total += others[i].removeChips(amt); // Remove the chips.
            if (others[i].isOut())
                System.out.println("\t" + others[i].getName() + " is out due to running out of chips.");
            else System.out.println("\t" + others[i].getName() + " has " + others[i].getChips() + " chips"); // Print the new chips.
        }
        p.removeChips(-1 * total); // Add the chips to the one player.
        System.out.println("\t" + p.getName() + " now has " + p.getChips() + " chips");
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
