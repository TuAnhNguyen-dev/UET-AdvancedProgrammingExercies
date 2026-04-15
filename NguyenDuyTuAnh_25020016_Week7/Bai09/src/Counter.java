import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Counter {
    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    public Counter() {
        this.value = 0;
    }

    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    // Increment counter using tryLock with timeout
    // Returns true if successfully incremented, false if lock not acquired
    public boolean incrementWithTryLock(long timeoutMillis) {
        try {
            if (lock.tryLock(timeoutMillis, TimeUnit.MILLISECONDS)) {
                try {
                    value++;
                    return true;
                } finally {
                    lock.unlock();
                }
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    // Get current counter value
    public int getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    // Reset counter value
    public void reset() {
        lock.lock();
        try {
            value = 0;
        } finally {
            lock.unlock();
        }
    }
}
