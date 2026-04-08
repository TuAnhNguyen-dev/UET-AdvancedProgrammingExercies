public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance = 0.0;

    public void openAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.openAccount("101202303", "Nguyen Van A");
        myAccount.deposit(500.0);
        myAccount.withdraw(150.0);
    }
}
