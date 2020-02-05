/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        String[] ranks = {"Better", "Good", "Worse"};
        String[] suits = {"AMD", "Intel", "ARM"};
        int[] values = {3,5,7};
        Deck deck = new Deck(ranks, suits, values);
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
    }
}
