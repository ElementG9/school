import java.util.*;
public class Die {
    int[] rolls;
    int sides;
    public Die() {
        sides = 6;
    }
    public Die(int _sides) {
        sides = _sides;
    }
    public int roll() {
        int roll = (int)(Math.random() * sides) + 1;
        addRoll(roll);
        return roll;
    }
    public int[] getRolls() {
        return rolls;
    }
    private void addRoll(int roll) {
        int[] newRolls = new int[rolls.length + 1];
        for (int i = 1; i < rolls.length + 1; i++)
            newRolls[i] = rolls[i];
        newRolls[0] = roll;
        rolls = newRolls;
    }
}