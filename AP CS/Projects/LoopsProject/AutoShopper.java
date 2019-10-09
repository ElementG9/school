public class AutoShopper {
    public static void main() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart("Pickle", 0.69, 420);
        shoppingCart.addToCart("Chicago Connection 17\" Pizza with Olive Oil, Cashews, Basil, and Broccoli", 25, 20);
        shoppingCart.addToCart("Ubiquiti Networks EdgeRouter Infinity (ER-8-XG) with a 16 core 1.8Ghz processor, 16GB DDR4 RAM, 4GB Storage, 8 SFP+, 1 RJ45, and 2 Hot-Swappable Power Supplies that draw 100W", 1849.00, 666);
        System.out.println(shoppingCart.toString());
    }
}
