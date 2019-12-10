public class Player {
  private int chips;
  private String name;
  public Player(String _name) {
    chips = 10;
    name  = _name;
  }

  public int getChips () {
    return chips;
  }

  public int removeChips (int num) {
    if (chips - num <= 0) {
        int temp = chips;
        chips = 0;
        return temp;
    } else return (chips -= num);
  }

  public boolean isOut () {
    return chips <= 0;
  }

  public String getName () {
    return name;
  }

  public String toString () {
    return name + ": " + getChips() + " chips";
  }
}
