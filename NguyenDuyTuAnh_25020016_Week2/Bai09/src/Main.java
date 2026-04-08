import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Nhập product 1
        String name1 = sc.nextLine();
        double price1 = sc.nextDouble();
        int quantity1 = sc.nextInt();
        double discount1 = sc.nextDouble();

        Product p1 = new Product(name1, price1, quantity1, discount1);

        // Nhập product 2
        sc.nextLine(); // clear buffer
        String name2 = sc.nextLine();
        double price2 = sc.nextDouble();
        int quantity2 = sc.nextInt();
        double discount2 = sc.nextDouble();

        Product p2 = new Product(name2, price2, quantity2, discount2);

        // Nhập số lượng mua
        int buy1 = sc.nextInt();
        int buy2 = sc.nextInt();

        p1.sell(buy1);
        p2.sell(buy2);

        // Giá sau discount + tax
        System.out.println("P1 final price: " + p1.calculateFinalPrice());
        System.out.println("P2 final price: " + p2.calculateFinalPrice());

        // đổi VAT
        Product.updateTaxRate(0.08);

        System.out.println("After tax change:");
        System.out.println("P1 final price: " + p1.calculateFinalPrice());
        System.out.println("P2 final price: " + p2.calculateFinalPrice());

        // đổi discount của p1
        p1.updateDiscount(10.0);

        System.out.println("After p1 discount change:");
        System.out.println("P1 final price: " + p1.calculateFinalPrice());
        System.out.println("P2 final price: " + p2.calculateFinalPrice());

        System.out.println("Total revenue: " + Product.getTotalRevenue());
    }
}

/**
 a
 13.4
 50
 0.4
 b
 2.3
 12
 0.1
 51
 2
 */