public class Inventory {
    private Product[] items;

    public Inventory(Product[] initialItems) {
        this.items = initialItems;
    }

    public void printProducts() {
        for (Product p : items) {
            System.out.println(p);
        }
    }
}