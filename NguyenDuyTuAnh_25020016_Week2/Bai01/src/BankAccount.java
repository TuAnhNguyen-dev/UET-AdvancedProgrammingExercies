class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, 0, ownerName);
    }

    public BankAccount(String accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            this.balance = 0;
            System.out.println("Balance should not be negative. Balance default set to 0");
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }
}
