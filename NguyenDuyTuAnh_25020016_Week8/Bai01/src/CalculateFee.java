public class CalculateFee {
    public double calculateFee(int hoursWorked, double hourlyRate, boolean isMember) {
        double fee = hoursWorked * hourlyRate;
        if (isMember) {
            fee *= 0.9; // Giảm 10% cho thành viên
        }
        return fee;
    }
}
