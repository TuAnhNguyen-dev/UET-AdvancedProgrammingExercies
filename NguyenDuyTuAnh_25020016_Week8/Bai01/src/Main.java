public class Main {
    public static void main(String[] args) {
        CalculateFee feeCalculator = new CalculateFee();
        int hoursWorked = 5;
        double hourlyRate = 20.0;
        boolean isMember = true;


        double totalFee = feeCalculator.calculateFee(hoursWorked, hourlyRate, isMember);
        System.out.println("Calculate fee:");
        System.out.println("Total fee: " + totalFee);


        UserService userService = new UserService();
        System.out.println("\nUser Service:");
        userService.test();


        Geometry geometry = new Geometry();
        System.out.println("\nGeometry:");
        geometry.test();

        Author author = new Author("email@gmail.com", "John Doe", "1234567890", "123 Main St");
        Report report = new Report("Sample Report", "This is a sample report content.", author);
        System.out.println("\nReport created completely fine!");
    }
}
