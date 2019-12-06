import java.util.*;
public class Finish {
  public static void main (String[] args) {
    Finish  game     = new Finish();
    int     roundNum = 0;
    Scanner scan     = new Scanner(System.in);

    while (game.isRunning) {
      roundNum++;
      System.out.print("Round " + roundNum + ":");
      if (roundNum == 69)
        System.out.println(" nice");
      else System.out.print("\n");
      game.runRound();
      game.printStatus();
      System.out.print("Press enter to continue:");
      scan.nextLine();
    }
    System.out.println("Thanks for playing Finish!");
  }

  Board gameboard;   // F-I-N-I-S-H
  Player[] players;
  public boolean isRunning;
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
    // Set up the gameboard.
    gameboard = new Board();
    gameboard.clear();
    isRunning = true;
  }

  public void runRound () {
    for (int i = 0; i < players.length; i++)
      if (takeTurn(players[i]))
        isRunning = false;
  }

  public void winGame (Player p, String reason) {
    System.out.println(p.getName() + " won the game by " + reason);
  }

  public void instawin (Player p) {
    winGame(p, "rolling 1 2 3 4 5 6");
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
    for(int i = 0; i < others; i++) {
      others[i].removeChips(amt); // Remove the chips.
      if (others[i].isOut())
        System.out.println("\t" + others[i].getName() + " is out due to running out of chips.");
      else System.out.println("\t" + others[i].getName() + " has " + others[i].getChips() + " chips"); // Print the new chips.
    }
    p.removeChips(-1 * others[i].length * amt); // Add all the chips to the one player.
    // Print the data.
    for (int j = 0; j < others.length; j++) {
      if (others.length == 1)
        System.out.println("\t" + others[j].getName() + " pays " + amt + (amt == 1 : " chip" : " chips") + " to " + p.getName());
      else if (j == 0 && j + 1 < others.length)
        System.out.print("\t" + others[j].getName() + ", ");
      else if (j + 1 >= others.length)
        System.out.println(" and " + others[j].getName() + " pay " + amt + (amt == 1 : " chip" : " chips") + " each to " + p.getName());
      else System.out.print(others[j].getName() + ", ");
    }
  }

  public void winRound (Player p) {
    System.out.println(p.getName() + " won the round by completing F I N I S H");
    System.out.println("Each player must pay " + p.getName() + " 1 chip");
    allPayToOne(p, 1);
  }

  public boolean takeTurn (Player p) {
    // Check if p is the only player not out.
    int playersIn = 0;

    for (int i = 0; i < players.length; i++)
      if (!players[i].isOut())
        playersIn++;
    if (playersIn == 1)
      winGame(p, "all the other players got out");
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
    System.out.println();
    // Check instawin.
    boolean instawin = true;
    if (rolls.length == 6)
      for (int i = 0; i < rolls.length; i++)
        if (rolls[i] != (i + 1))
          instawin = false;
    if (rolls.length != 6)
      instawin = false;
    if (instawin) {
      instawin(p);
      return true;
    }
    // Check normally.
    int originalNeeded = gameboard.numToRoll();
    for (int needed = gameboard.numToRoll(); needed < rolls.length; needed++) {
      boolean found = false;
      for (int i = 0; i < rolls.length; i++) // Search for the number in the player's rolls.
        if (rolls[i] == needed)
          found = true;
      if (found) { // The player got the required number.
        // Print out the data.
        System.out.print("\t" + p.getName() + " got a " + needed);
        if (needed == 6) { // The player got a 6 and won the round.
          System.out.print("\n");
          winRound(p);
        } else if (needed == originalNeeded) // The player got something on the board.
          System.out.println(" and does not need to pay anything to the pot");
        else System.out.print("\n"); // The player got something extra on the board.
        // Update the gameboard.
        gameboard.setLetter(needed - 1);
        gameboard.removeDie();
      } else { // The player did not get the required number.
        System.out.print("\t" + p.getName() + " did not get a " + needed);
        if (needed == originalNeeded) { // They got nothing on the board.
          // Print out the data.
          System.out.println(" and needs to pay " + (7 - needed) + " to the pot");
          // Update the pot.
          gameboard.addToPot(7 - needed);
          p.removeChips(7 - needed);
          // Check if the player goes out.
          if (p.isOut())
            System.out.println("\t" + p.getName() + " is out due to running out of chips.");
          else System.out.println("\t" + p.getName() + " has " + p.getChips() + " chips"); // Print the new chips.
          System.out.println("\tPot: " + gameboard.getPot()); // Print the new pot.
        }
        else System.out.print("\n");
        break;         // Stop looking for higher numbers if p didn't get a roll.
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
