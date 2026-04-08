import java.util.List;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("Tu Anh Nguyen", 1000);
        acc.addTransaction(new Transaction("1", 100, "1/2/2005"));
        acc.addTransaction(new Transaction("2", -100, "2/3/2005"));
        acc.addTransaction(new Transaction("3", 4000, "3/10/2005"));

        List<Transaction> history = acc.getHistory();
        history.set(0, null);
        System.out.println("Change the first element to null");
        printHistory(history);

        List<Transaction> history2 = acc.getHistory();
        System.out.println("\nBut when call it again, the history didnt change");
        printHistory(history2);
    }

    public static void printHistory(List<Transaction> history) {
        for (Transaction t: history) {
            System.out.println(t);
        }
    }
}
