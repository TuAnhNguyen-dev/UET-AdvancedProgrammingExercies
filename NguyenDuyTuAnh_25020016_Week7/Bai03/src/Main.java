public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);

        long startTime = System.currentTimeMillis();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100);
                if ((i + 1) % 100 == 0) {
                    System.out.println("[ThreadA] Đã nạp " + (i + 1) + " lần, số dư hiện tại: " + account.getBalance());
                }
            }
            System.out.println("[ThreadA] Hoàn thành! Tổng đã nạp: 100,000");
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(100);
                if ((i + 1) % 100 == 0) {
                    System.out.println("[ThreadB] Đã rút " + (i + 1) + " lần, số dư hiện tại: " + account.getBalance());
                }
            }
            System.out.println("[ThreadB] Hoàn thành! Tổng đã rút: 100,000");
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("\n=== Kết quả cuối cùng ===");
        System.out.println("Số dư tài khoản: " + account.getBalance());
        System.out.println("Thời gian thực thi: " + duration + "ms");
        if (account.getBalance() == 0) {
            System.out.println("✓ PASS: Số dư chính xác (Luồng an toàn)");
        } else {
            System.out.println("✗ FAIL: Số dư không chính xác (Race condition xảy ra)");
        }
    }
}
