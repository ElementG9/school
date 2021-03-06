// U2.6.5
import java.text.NumberFormat;

public class ShoppingCart {
    private int itemCount; // Total number of items in the cart
    private double totalPrice; // Total price of items in the cart
    private int capacity; // Current cart capacity
    private Item[] cart; // The cart.

    // Creates an empty shopping cart with a capacity of 5 items.
    public ShoppingCart() {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new Item[capacity];
    }

    // Adds an item to the shopping cart.
    public void addToCart(String itemName, double price, int quantity) {
        if (itemCount + 1 > capacity)
            increaseSize();
        cart[itemCount] = new Item(itemName, price, quantity);
        totalPrice += price * quantity;
        itemCount++;
    }

    // Returns the contents of the cart together with summary information.
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

        int totalItems = 0;
        for (int i = 0; i < itemCount; i++) {
            contents += cart[i].toString() + "\n";
            totalItems += cart[i].getQuantity();
        }

        contents += "\nTotal Items: " + totalItems;
        contents += "\nTotal Price: " + fmt.format(totalPrice);
        contents += "\n";

        return contents;
    }

    // Increases the capacity of the shopping cart by 3
    private void increaseSize() {
        Item[] newCart = new Item[cart.length + 3];
        for (int i = 0; i < cart.length; i++)
            newCart[i] = cart[i];
        cart = newCart;
        capacity += 3;
    }
}
