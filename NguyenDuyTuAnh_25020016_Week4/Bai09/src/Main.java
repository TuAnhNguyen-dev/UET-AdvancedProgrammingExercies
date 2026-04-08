import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("test.inp"));

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronics> electronicsWarehouse = new Warehouse<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            if (type.equals("F")) {
                String expiryDate = parts[3];
                foodWarehouse.add(new Food(id, name, expiryDate));
            } else if (type.equals("E")) {
                int warranty = Integer.parseInt(parts[3]);
                electronicsWarehouse.add(new Electronics(id, name, warranty));
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.printInventory();

        System.out.println("\nKho Điện tử:");
        electronicsWarehouse.printInventory();

        sc.close();
    }
}