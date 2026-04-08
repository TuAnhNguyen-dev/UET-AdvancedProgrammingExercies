public class Main {
    public static void main(String[] args) {
        System.out.println("--- Test 1: Khởi tạo với số dư âm ---");
        BankAccount acc1 = new BankAccount("VCB123", -500, "Nguyen Van A");
        System.out.println("Số dư hiện tại: " + acc1.getBalance());

        System.out.println("\n--- Test 2: Nạp tiền âm ---");
        acc1.deposit(-100);

        System.out.println("\n--- Test 3: Rút quá số dư ---");
        boolean canWithdraw = acc1.withdraw(1000);
        System.out.println("Rút 1000 thành công? " + canWithdraw);

        System.out.println("\n--- Test 4: Rút tiền hợp lệ ---");
        acc1.deposit(500);
        boolean withdrawOk = acc1.withdraw(200);
        System.out.println("Rút 200 thành công? " + withdrawOk);
        System.out.println("Số dư cuối cùng: " + acc1.getBalance());

        // acc1.accountNumber = "NEW_ID"; // Dòng này sẽ báo lỗi compile vì là final
    }
}
