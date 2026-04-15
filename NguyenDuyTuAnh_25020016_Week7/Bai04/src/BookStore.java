import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookStore {
    private Map<String, Integer> stock = new HashMap<>();

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public BookStore() {
        stock.put("Java Backend", 10);
        stock.put("Clean Code", 5);
    }

    public int getStock(String title) {
        rwLock.readLock().lock(); // block write thread
        try {
            Thread.sleep(1000);

            return stock.getOrDefault(title, 0);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void addBook(String title, int quantity) {
        rwLock.writeLock().lock(); // block read thread
        try {
            stock.put(title, stock.getOrDefault(title, 0) + quantity);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void borrowBook(String title, int quantity) {
        rwLock.writeLock().lock();
        try {
            int currentStock = stock.getOrDefault(title, 0);
            if (currentStock >= quantity) {
                stock.put(title, currentStock - quantity);
            } else {
                System.out.println("Not enough stock for " + title);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
