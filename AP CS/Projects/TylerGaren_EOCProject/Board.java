public class Board {
    private boolean[] finish;
    private Die[] dice;
    private int pot;
    public Board() {
        clear();
    }
    
    public void crossOff() {
        finish[numToRoll() - 1] = true;
        removeDie();
    }

    public void clear () {
        finish = new boolean[6];
        for (int i = 0; i < finish.length; i++)
            finish[i] = false;
        dice = new Die[6];
        for (int i = 0; i < dice.length; i++)
            dice[i] = new Die();
        pot = 0;
    }

    public int addToPot (int num) {
        pot += num;
        return pot;
    }

    public int getPot () {
        return pot;
    }

    public boolean[] getBoard () {
        return finish;
    }

    public boolean[] setLetter (int i) {
        finish[i] = true;
        return finish;
    }

    public Die[] getDice () {
        return dice;
    }

    public int[] rollDice () {
        int[] rolls = new int[dice.length];
        for (int i = 0; i < dice.length; i++)
            rolls[i] = dice[i].roll();
        return rolls;
    }

    public Die[] removeDie () {
        Die[] newDice = new Die[dice.length - 1]; // Make the shorter array.
        for (int i = 0; i < newDice.length; i++)
            newDice[i] = dice[i];                   // Move the dice over.
        dice = newDice;                           // Set to the shorter array.
        return dice;
    }

    public int numToRoll () {
        int i = 0;

        while (finish[i])
            i++;
        return i + 1;
    }

    public String toString () {
        String  out = "";
        boolean printedGameboard = false;

        if (finish[0]) {
            out += "F ";
            printedGameboard = true;
        }
        if (finish[1]) {
            out += "I ";
            printedGameboard = true;
        }
        if (finish[2]) {
            out += "N ";
            printedGameboard = true;
        }
        if (finish[3]) {
            out += "I ";
            printedGameboard = true;
        }
        if (finish[4]) {
            out += "S ";
            printedGameboard = true;
        }
        if (finish[5]) {
            out += "H ";
            printedGameboard = true;
        }
        if (!printedGameboard)
            return "Empty";

        return out;
    }

    public void printStatus () {
        System.out.print("\tGame board: ");
        System.out.println(this.toString());
        System.out.print("\tPot: ");
        System.out.println(getPot());
    }

    public static int[] sort (int[] _arr) {
        int[] arr = _arr.clone();
        // Bubble sort.
        // Copied from https://www.javatpoint.com/bubble-sort-in-java.
        int n    = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < (n - i); j++)
                if (arr[j - 1] > arr[j]) {
                    temp       = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j]     = temp;
                }
        return arr;
    }
}
