import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            char type = line.charAt(0);

            int firstQuote = line.indexOf('"');
            int secondQuote = line.indexOf('"', firstQuote+1);
            String name = line.substring(firstQuote+1, secondQuote);

            String[] parts = line.substring(secondQuote + 1).trim().split("\\s+");

            if (type == 'F') {
                double base = Double.parseDouble(parts[0]);
                double bonus = Double.parseDouble(parts[1]);
                double penalty = Double.parseDouble(parts[2]);

                employees[i] = new FullTimeEmployee(name, base, bonus, penalty);
            } else {
                double hours = Double.parseDouble(parts[0]);
                double rate = Double.parseDouble(parts[1]);

                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }

        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
}
