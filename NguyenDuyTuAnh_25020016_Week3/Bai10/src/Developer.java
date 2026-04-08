public class Developer extends Employee{
    public int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return 0.1*getBaseSalary() + overtimeHours*200_000;
    }
}
