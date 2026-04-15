/**
 * Worker class demonstrating the need for volatile keyword
 * Volatile ensures visibility of changes across threads
 */
public class Worker implements Runnable {
    // Volatile keyword ensures that changes to this variable
    // are immediately visible to all threads
    private volatile boolean running = true;

    // Why volatile is needed:
    // Without volatile: A thread might cache the 'running' value in CPU cache
    // causing it to never see the change made by another thread (main thread)
    // With volatile: Every read/write bypasses cache, ensuring all threads
    // see the most current value immediately

    private long iterationCount = 0;

    /**
     * Stop the worker thread
     */
    public void stop() {
        running = false;
    }

    /**
     * Get the number of iterations completed
     */
    public long getIterationCount() {
        return iterationCount;
    }

    @Override
    public void run() {
        System.out.println("Worker thread started");
        while (running) {
            System.out.println("Working... (iteration: " + iterationCount + ")");
            iterationCount++;

            // Small delay to avoid overwhelming output
            try {
                Thread.sleep(100); // 100ms delay between iterations
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted");
                break;
            }
        }
        System.out.println("Worker thread stopped");
        System.out.println("Total iterations: " + iterationCount);
    }
}
