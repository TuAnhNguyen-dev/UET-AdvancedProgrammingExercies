import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            double baseSalary = Double.parseDouble(parts[3]);

            if (type.equals("O")) {
                employees.add(new OfficeWorker(id, name, baseSalary));
            } else if (type.equals("T")) {
                int overtime = Integer.parseInt(parts[4]);
                employees.add(new Technician(id, name, baseSalary, overtime));
            }
        }

        double totalPay = 0;

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            double pay = emp.calculatePay();
            totalPay += pay;

            System.out.println(emp.getName() + " - Pay: " + pay);
            emp.work();

            if (i < employees.size() - 1) {
                System.out.println();
            }
        }

        System.out.println("\nTotal Pay = " + totalPay);

        sc.close();
    }
}