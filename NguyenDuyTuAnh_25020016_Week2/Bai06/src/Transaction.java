public class Transaction {
    private String transactionId;
    private double amount;
    private String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("Transaction(transactionId: %s; double: %f; timestamp: %s)", this.transactionId, this.amount, this.timestamp);
    }
}
