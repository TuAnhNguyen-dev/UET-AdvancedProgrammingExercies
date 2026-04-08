import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Order order = new Order();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            if (line.startsWith("E")) {
                // E "Laptop" 1000 50
                String[] parts = line.split("\"");
                String name = parts[1];
                String[] rest = parts[2].trim().split(" ");

                double price = Double.parseDouble(rest[0]);
                double warranty = Double.parseDouble(rest[1]);

                order.addProduct(new Electronics(name, price, warranty));

            } else {
                // F "Milk" 30 2025-03-15
                String[] parts = line.split("\"");
                String name = parts[1];
                String[] rest = parts[2].trim().split(" ");

                double price = Double.parseDouble(rest[0]);
                LocalDate expiry = LocalDate.parse(rest[1]);

                order.addProduct(new Food(name, price, expiry));
            }
        }

        order.print();
    }
}