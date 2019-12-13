import java.util.*;
public class Finish {
    public static void main(String[] args) {
        System.out.println("Welcome to Finish!");
        Finish game = new Finish();
        Scanner scan = new Scanner(System.in);
        while (game.isRunning) {
            System.out.print("Press enter to continue:");
            scan.nextLine();
            game.runRound();
            game.reset();
        }
        System.out.println("Thanks for playing Finish!");
    }

    private Board gameboard; // F-I-N-I-S-H
    private boolean runningRound;
    public Player[] players;
    public boolean isRunning;
    public int roundNum;
    public int currentPlayer;
    
    public Finish() {
        // Get the players
        players = getPlayers();
        // Set up the gameboard.
        gameboard = new Board();
        gameboard.clear();
        roundNum = 0;
        currentPlayer = 0;
        isRunning = true;
        runningRound = true;
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

    private void winRound(Player p) {
        System.out.println(p.getName() + " won the round by completing F I N I S H!");
        System.out.println("Each player must pay " + p.getName() + " 1 chip");
        allPayToOne(p, 1);
        runningRound = false;
    }

    private void winGame(Player p, String reason) {
        System.out.println(p.getName() + " won the game by " + reason);
        System.out.println(p.getName() + " collects the chips from all remaining players");
        int total = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].isOut())
                continue;
            if (players[i].getName() == p.getName())
                continue;
            total += players[i].getChips();
            players[i].removeChips(players[i].getChips());
        }
        System.out.println(p.getName() + " also gets to collect the pot.");
        total += gameboard.collectPot();
        p.addChips(total);
        isRunning = false;
        runningRound = false;
    }

    private void runRound() {
        roundNum++;
        System.out.print("Round #" + roundNum);
        if (roundNum == 69)
            System.out.println(": nice");
        else
            System.out.println(":");
        while(runningRound) {
            if (isRunning)
                takeTurn(players[currentPlayer]);
            checkWin();
            currentPlayer++;
            currentPlayer %= players.length;
        }
        printStatus();
        runningRound = true; // Reset the switch.
    }

    private void takeTurn(Player p) {
        if (p.isOut())
            return;
        // Print information.
        System.out.println(p.getName() + "'s turn:");
        gameboard.printStatus();
        System.out.println("\t" + p.getName() + " needs to roll a " + gameboard.numToRoll());
        // Roll the dice.
        System.out.print("\t" + p.getName() + " rolls " + (gameboard.getDice().length == 1 ? "the die" : (gameboard.getDice().length + " dice")) + " and gets");
        int[] rolls = gameboard.rollDice();
        if (rolls.length == 1)
            System.out.print(" a");
        for (int i = 0; i < rolls.length; i++)
            System.out.print(" " + rolls[i]);
        System.out.print(".\n");
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
            return;
        }
        // Check normally.
        int needed = gameboard.numToRoll();
        int numToCrossOff = 0;
        boolean needsToPay = true;
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == needed) {
                System.out.println("\t" + p.getName() + " got a " + needed);
                numToCrossOff++;
                needed++;
            }
        }
        if (numToCrossOff == 0) {
            System.out.println("\t" + p.getName() + " did not add to the board and must pay " + (7 - needed) + " to the pot.");
            int originalChips = p.getChips();
            gameboard.addToPot(originalChips - p.removeChips(7 - needed));
        }
        for (int i = 0; i < numToCrossOff; i++)
            gameboard.crossOff();
        if (needed > 6)
            winRound(p);
    }
    
    private void checkWin() {
        Player[] winners;
        int numIn = 0;
        for (int i = 0; i < players.length; i++)
            if (!players[i].isOut())
                numIn++;
        winners = new Player[numIn];
        int offset = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].isOut())
                offset++;
            else winners[i - offset] = players[i];
        }
        if (winners.length == 1)
            winGame(winners[0], "being the last player left.");
    }

    private void allPayToOne(Player p, int amt) {
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
            if (others[i].isOut())
                continue;
            int originalChips = others[i].getChips();
            total += (originalChips - others[i].removeChips(amt));
        }
        p.addChips(total); // Add the chips to the one player.
    }

    public void printStatus() {
        System.out.println("Game status:");
        gameboard.printStatus();
        for (int i = 0; i < players.length; i++) {
            System.out.print("\t");
            if (players[i].isOut())
                System.out.println(players[i].getName() + ": Out");
            else System.out.println(players[i].toString());
        }
    }
    
    public void reset() {
        gameboard.clear(); // Clear F I N I S H and reset the dice.
    }
}
