import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("test.inp"));

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            students.add(new Student(parts[0], parts[1], Double.parseDouble(parts[2])));
        }

        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        students.forEach(System.out::println);

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("\nAfter sorting by name:");
        students.forEach(System.out::println);

        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

        System.out.println("\nTest with operations");
        System.out.println("Test Add 10 + 5 = " + add.execute(10.0, 5.0));
        System.out.println("Test Sub 10 - 5 = " + sub.execute(10.0, 5.0));
        System.out.println("Test Mul 10 * 5 = " + mul.execute(10.0, 5.0));
        System.out.println("Test Div 10 / 5 = " + div.execute(10.0, 5.0));

        sc.close();
    }
}