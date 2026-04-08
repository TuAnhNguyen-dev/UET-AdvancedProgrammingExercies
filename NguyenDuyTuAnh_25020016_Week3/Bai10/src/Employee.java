public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return 0.1*baseSalary;
    }

    public double getBaseSalary() { return baseSalary; }

    public String getName() { return name; }
}
