public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public abstract String getType();

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %.1f", getName(), getType(), calculateSalary());
    }
}
