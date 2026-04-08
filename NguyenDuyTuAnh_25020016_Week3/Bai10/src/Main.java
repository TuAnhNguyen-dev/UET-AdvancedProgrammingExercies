import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Employee> employees = new ArrayList<>();

        // Đọc dữ liệu đầu vào
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double baseSalary = Double.parseDouble(parts[2]);

            switch (type) {
                case "E":
                    employees.add(new Employee(name, baseSalary));
                    break;
                case "D":
                    int overtime = Integer.parseInt(parts[3]);
                    employees.add(new Developer(name, baseSalary, overtime));
                    break;
                case "T":
                    int bugsFound = Integer.parseInt(parts[3]);
                    employees.add(new Tester(name, baseSalary, bugsFound));
                    break;
            }
        }

        // Duyệt danh sách, tính thưởng và tặng quà
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);

            // Tính tiền thưởng (Đa hình sẽ tự động gọi đúng hàm của Developer/Tester/Employee)
            System.out.println(emp.getName() + " - Bonus: " + emp.calculateBonus());

            // Kiểm tra kiểu đối tượng bằng instanceof để tặng quà bổ sung
            if (emp instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (emp instanceof Tester) {
                System.out.println("Tặng tool Test");
            }

            // In dòng trống giữa các nhân viên (trừ người cuối cùng) để khớp với Output mẫu
            if (i < employees.size() - 1) {
                System.out.println();
            }
        }

        sc.close();
    }
}