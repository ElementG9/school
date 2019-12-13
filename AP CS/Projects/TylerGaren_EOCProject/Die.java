import java.util.*;
public class Die {
    private int sides;
    public Die() {
        sides = 6;
    }

    public Die(int _sides) {
        sides = _sides;
    }

    public int roll() {
        int roll = (int)(Math.random() * sides) + 1;
        return roll;
    }
}
