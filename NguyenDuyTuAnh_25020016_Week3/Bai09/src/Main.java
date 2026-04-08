import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng đối tượng
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        // Tạo danh sách chứa TẤT CẢ những gì có thể thanh toán (Staff, Invoice,...)
        List<IPayable> payableList = new ArrayList<>();

        // Quét dữ liệu đầu vào
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];

            if (type.equals("S")) {
                String id = parts[1];
                String name = parts[2];
                int hours = Integer.parseInt(parts[3]);
                double rate = Double.parseDouble(parts[4]);

                payableList.add(new PartTimeStaff(id, name, hours, rate));

            } else if (type.equals("I")) {
                String itemName = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);

                payableList.add(new Invoice(itemName, quantity, price));
            }
        }

        // Tính tổng chi phí và in ra màn hình
        double totalPayment = 0;

        for (IPayable item : payableList) {
            double payment = item.getPaymentAmount();
            totalPayment += payment;

            // Dùng instanceof (như bài 8) để ép kiểu lấy tên in ra cho đúng format
            if (item instanceof PartTimeStaff) {
                PartTimeStaff p = (PartTimeStaff) item;
                System.out.println("PartTimeStaff " + p.getName() + " - Payment: " + payment);
            } else if (item instanceof Invoice) {
                Invoice inv = (Invoice) item;
                System.out.println("Invoice " + inv.getItemName() + " - Payment: " + payment);
            }
        }

        System.out.println("Total Payment = " + totalPayment);
        sc.close();
    }
}