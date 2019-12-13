public class Board {
    private boolean[] finish;
    private Die[] dice;
    private int pot;
    public Board() {
        pot = 0;
        clear();
    }

    public void crossOff() {
        System.out.println("\t\"" + ("FINISH".substring(numToRoll() - 1, numToRoll())) + "\" was crossed off.");
        finish[numToRoll() - 1] = true;
        removeDie();
        System.out.println("\t\tThe board is now " + toString() + ".");
        if (getDice().length == 1)
            System.out.println("\t\tThere is now 1 die.");
        else System.out.println("\t\tThere are now " + getDice().length + " dice.");
    }

    public void clear() {
        finish = new boolean[6];
        for (int i = 0; i < finish.length; i++)
            finish[i] = false;
        dice = new Die[6];
        for (int i = 0; i < dice.length; i++)
            dice[i] = new Die();
    }

    public int addToPot(int num) {
        if (num != 1)
            System.out.println("\tThe pot gained " + num + " chips.");
        else System.out.println("\tThe pot gained 1 chip.");
        pot += num;
        if (pot != 1)
            System.out.println("\tThe pot now has " + pot + " chips.");
        else System.out.println("\tThe pot now has 1 chip.");
        return pot;
    }
    
    public int collectPot() {
        int temp = pot;
        pot = 0;
        if (temp != 1)
            System.out.println("\tThe pot lost " + temp + " chips.");
        else
            System.out.println("\tThe pot lost 1 chip.");
        System.out.println("\tThe pot now has 0 chips.");
        return temp;
    }

    public int getPot() {
        return pot;
    }

    public boolean[] getBoard() {
        return finish;
    }

    public Die[] getDice() {
        return dice;
    }

    public int[] rollDice() {
        int[] rolls = new int[dice.length];
        for (int i = 0; i < dice.length; i++)
            rolls[i] = dice[i].roll();
        return rolls;
    }

    public Die[] removeDie() {
        Die[] newDice = new Die[dice.length - 1]; // Make the shorter array.
        for (int i = 0; i < newDice.length; i++)
            newDice[i] = dice[i];                   // Move the dice over.
        dice = newDice;                           // Set to the shorter array.
        return dice;
    }

    public int numToRoll() {
        int i = 0;
        while (finish[i])
            i++;
        return i + 1;
    }

    public String toString() {
        String  out = "";
        boolean printedGameboard = false;
        if (finish[0]) {
            out += "F";
            printedGameboard = true;
        }
        if (finish[1]) {
            out += " I";
            printedGameboard = true;
        }
        if (finish[2]) {
            out += " N";
            printedGameboard = true;
        }
        if (finish[3]) {
            out += " I";
            printedGameboard = true;
        }
        if (finish[4]) {
            out += " S";
            printedGameboard = true;
        }
        if (finish[5]) {
            out += " H";
            printedGameboard = true;
        }
        if (!printedGameboard)
            return "Empty";
        return out;
    }

    public void printStatus() {
        System.out.print("\tGame board: ");
        System.out.println(this.toString());
        System.out.print("\tPot: ");
        System.out.println(getPot());
    }
}
