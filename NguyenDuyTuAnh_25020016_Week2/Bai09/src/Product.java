public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newTaxRate) {
        taxRate = newTaxRate;
    }

    public double calculateFinalPrice() {
        double finalPrice = (price - discount) * (1 + taxRate);
        return finalPrice;
    }

    public void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * calculateFinalPrice();
            System.out.println("Sell successful");
        } else {
            System.err.println("We dont have enough to sell. The number of remain product is " + quantity);
        }
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }
}
