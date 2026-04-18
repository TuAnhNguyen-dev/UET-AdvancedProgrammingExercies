public class PayrollService {
    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;
    private static final double PERSONAL_DEDUCTION = 11_000_000;

    private static final double TAX_TIER_1_LIMIT = 5_000_000;
    private static final double TAX_TIER_2_LIMIT = 10_000_000;

    private static final double TAX_TIER_1_RATE = 0.05;
    private static final double TAX_TIER_2_RATE = 0.10;

    // 250k = 5tr * 5%
    private static final double TAX_TIER_1_MAX_AMOUNT = 250_000;
    // 750k = 250k + (5tr * 10%)
    private static final double TAX_TIER_2_MAX_AMOUNT = 750_000;

    public double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        if (totalDays == 0) {
            return 0;
        }

        return baseSalary * (workDays / totalDays);
    }

    public double calculateInsurance(double actualSalary) {
        return actualSalary * SOCIAL_INSURANCE_RATE + actualSalary * HEALTH_INSURANCE_RATE;
    }

    public double calculateTaxableIncome(double actualSalary, double insurance) {
        return actualSalary - insurance - PERSONAL_DEDUCTION;
    }

    public double calculateTax(double taxableIncome, double taxRate) {
        if (taxableIncome <= 0) {
            return 0;
        } else if (taxableIncome <= TAX_TIER_1_LIMIT) {
            return taxableIncome * TAX_TIER_1_RATE;
        } else if (taxableIncome <= TAX_TIER_2_LIMIT) {
            return TAX_TIER_1_MAX_AMOUNT + (taxableIncome - TAX_TIER_1_LIMIT) * TAX_TIER_2_RATE;
        } else {
            return TAX_TIER_2_MAX_AMOUNT + (taxableIncome - TAX_TIER_2_LIMIT) * taxRate;
        }
    }

    public double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    public static void printPayroll(String name, double baseSalary,
                             int workDays, int totalDays,
                             double taxRate, double bonus) {

        PayrollService payrollService = new PayrollService();

        System.out.println("=== BẢNG LƯƠNG ===");
        System.out.println("Nhân viên: " + name);

        double actualSalary = payrollService.calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = payrollService.calculateInsurance(actualSalary);
        double taxableIncome = payrollService.calculateTaxableIncome(actualSalary, insurance);
        double tax = payrollService.calculateTax(taxableIncome, taxRate);
        double netSalary = payrollService.calculateNetSalary(actualSalary, insurance, tax, bonus);

        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }
}
