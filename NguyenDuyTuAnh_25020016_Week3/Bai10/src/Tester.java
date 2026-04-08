public class Tester extends Employee{
    public int bugsFound;

    public Tester(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.bugsFound = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return 0.1*getBaseSalary() + bugsFound *50_000;
    }
}
