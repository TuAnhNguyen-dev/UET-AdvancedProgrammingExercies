public class Main {
    public static void main(String[] args) {
        String name = "Nguyen Van A";
        double baseSalary = 15_000_000;
        int workDays = 22;
        int totalDays = 26;
        double taxRate = 0.15;
        double bonus = 2_000_000;

        PayrollService.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }
}
