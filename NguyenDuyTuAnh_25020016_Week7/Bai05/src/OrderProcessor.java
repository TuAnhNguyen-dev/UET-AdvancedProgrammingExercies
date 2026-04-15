import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor implements Callable<Boolean> {
    private String id;
    private long processMs;

    // shared resources
    private List<String> sharedLogs;
    private AtomicInteger successCount;

    public OrderProcessor(String id, long processMs, List<String> sharedLogs, AtomicInteger successCount) {
        this.id = id;
        this.processMs = processMs;
        this.sharedLogs = sharedLogs;
        this.successCount = successCount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Start " + id);

        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        // check valid conditions
        boolean isSuccess = processMs <= 1500;
        String logMessage = (isSuccess ? "DONE " : "FAILED ") + id;

        // update counter
        if (isSuccess) {
            successCount.incrementAndGet();
        }

        // update shared logs
        synchronized (sharedLogs) {
            sharedLogs.add(logMessage);
        }

        return isSuccess;
    }
}
