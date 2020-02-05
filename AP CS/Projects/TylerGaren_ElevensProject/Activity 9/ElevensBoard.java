import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */ 
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() < 2 || selectedCards.size() > 3)
            return false;
        boolean allNumbers = true;
        boolean allJQK = true;
        for (int i = 0; i < selectedCards.size(); i++) {
            switch(cardAt(selectedCards.get(i)).rank()) {
                case "ace": // Counted as a 1.
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                allJQK = false;
                break;
                case "jack":
                case "queen":
                case "king":
                allNumbers = false;
                break;
                default:
                allNumbers = false;
                allJQK = false;
                break;
            }
        }
        if (!allNumbers && !allJQK)
            return false;
        if (selectedCards.size() != 3 && allJQK)
            return false;
        if (selectedCards.size() != 2 && allNumbers)
            return false;
        if (allNumbers) {
            int total = 0;
            for (int i = 0; i < selectedCards.size(); i++)
                total += cardAt(selectedCards.get(i)).pointValue();
            return total == 11;
        } else if (allJQK) {
            int numJ = 0;
            int numQ = 0;
            int numK = 0;
            for (int i = 0; i < selectedCards.size(); i++) {
                switch (cardAt(selectedCards.get(i)).rank()) {
                    case "jack":
                    numJ++;
                    break;
                    case "queen":
                    numQ++;
                    break;
                    case "king":
                    numK++;
                    break;
                }
            }
            if (numJ == 1 && numQ == 1 && numK == 1)
                return true;
            else return false;
        }
        return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        return containsPairSum11(cardIndexes()) || containsJQK(cardIndexes());
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        ArrayList<Card> integerCards = new ArrayList<Card>();
        for (int i = 0; i < selectedCards.size(); i++) {
            switch(cardAt(selectedCards.get(i)).rank()) {
                case "ace": // Counted as a 1.
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    integerCards.add(cardAt(selectedCards.get(i)));
                    break;
                case "jack":
                case "queen":
                case "king":
                    break;
                default:
                    break;
            }
        }
        for (Card a : integerCards) {
            for (Card b : integerCards) {
                if (a.matches(b))
                    continue;
                else if (a.pointValue() + b.pointValue() == 11)
                    return true;
            }
        }
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        int numJ = 0;
        int numQ = 0;
        int numK = 0;
        for (int i = 0; i < selectedCards.size(); i++) {
            switch (cardAt(selectedCards.get(i)).rank()) {
                case "jack":
                numJ++;
                break;
                case "queen":
                numQ++;
                break;
                case "king":
                numK++;
                break;
            }
        }
        if (numJ >= 1 && numQ >= 1 && numK >= 1)
            return true;
        else return false;
    }
}
