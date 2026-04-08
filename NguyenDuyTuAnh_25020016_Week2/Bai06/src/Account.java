import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }

    public List<Transaction> getHistory() {
        return new ArrayList<>(this.transactions);
    }
}
