public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee(
                "An",
                new MyDate(1, 1, 2000)
        );

        Employee emp2 = new Employee(emp1);

        emp1.birthday = new MyDate(2, 2, 2022);

        System.out.println("Birthday of emp1: " + emp1.birthday);
        System.out.println("Birthday of emp2 after change emp1: " + emp2.birthday);
    }
}