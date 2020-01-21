/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        System.out.print("\nnew run\n");
        Card card1 = new Card("King", "Spades", 13);
        Card card2 = new Card("2", "Clubs", 10);
        Card card3 = new Card("King", "Spades", 13);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        System.out.println(card1.matches(card2) ? "card1 matches card2" : "card1 does not match card2");
        System.out.println(card1.matches(card3) ? "card1 matches card3" : "card1 does not match card3");
    }
}
