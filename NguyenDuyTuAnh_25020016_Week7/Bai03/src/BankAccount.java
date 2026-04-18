public class BankAccount {
    private int balance;

    public BankAccount(int initBalance) {
        balance = initBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
//        if (balance < amount) {
//            System.out.println("Error: Insufficient funds. Withdrawal failed.");
//            return;
//        }

        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
