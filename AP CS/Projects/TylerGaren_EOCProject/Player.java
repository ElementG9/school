public class Player {
    int chips;
    String name;
    public Player(String _name) {
        chips = 10;
        name = _name;
    }
    public int getChips() {
        return chips;
    }
    public int removeChips(int num) {
        chips -= num;
        return chips;
    }
    public boolean isOut() {
        return chips <= 0;
    }
    public String getName() {
        return name;
    }
}
