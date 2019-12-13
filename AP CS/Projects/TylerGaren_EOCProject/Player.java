public class Player {
    private int chips;
    private String name;
    public Player(String _name) {
        chips = 10;
        name  = _name;
    }

    public int getChips() {
        return chips;
    }

    public int addChips(int num) {
        if (num != 1)
            System.out.println("\t" + name + " gained " + num + " chips.");
        else System.out.println("\t" + name + " gained 1 chip.");
        chips += num;
        if (chips != 1)
            System.out.println("\t" + name + " now has " + chips + " chips.");
        else System.out.println("\t" + name + " now has 1 chip.");
        return chips;
    }

    public int removeChips(int num) {
        if (num > chips)
            num = chips;
        if (num != 1)
            System.out.println("\t" + name + " lost " + num + " chips.");
        else System.out.println("\t" + name + " lost " + num + " chip.");
        chips -= num;
        if (chips == 1)
            System.out.println("\t" + name + " now has 1 chip.");
        else if (chips == 0)
            System.out.println("\t" + name + " now has 0 chips and is out.");
        else System.out.println("\t" + name + " now has " + chips + " chips.");
        return chips;
    }

    public boolean isOut() {
        return chips <= 0;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ": " + getChips() + " chips";
    }
}
