public class Main {
    public static void main(String[] args) {
        Product[] arr = new Product[2];
        arr[0] = new Product(1, "Laptop", 1000);
        arr[1] = new Product(2, "Mouse", 20);

        Inventory kho = new Inventory(arr);

        System.out.println("Before change first element");
        kho.printProducts();

        arr[0].setPrice(5000);

        System.out.println("\nAfter change first element");
        kho.printProducts();
    }
}