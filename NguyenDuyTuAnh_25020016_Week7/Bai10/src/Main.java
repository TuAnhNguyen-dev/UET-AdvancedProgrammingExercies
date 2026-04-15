public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        
        Thread workerThread = new Thread(worker);
        
        System.out.println("Starting worker thread...");
        workerThread.start();
        
        // Let the worker thread run for approximately 1 second
        try {
            System.out.println("Main thread: Letting worker run for ~1 second...\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
        
        // Request the worker thread to stop
        System.out.println("\nMain thread: Requesting worker to stop...");
        worker.stop();
        
        // Wait for the worker thread to finish using join()
        try {
            System.out.println("Main thread: Waiting for worker thread to complete...");
            workerThread.join();
            System.out.println("Main thread: Worker thread has finished successfully");
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting: " + e.getMessage());
        }
        
        System.out.println("\n=== Program completed ===");
        System.out.println("Final worker iterations: " + worker.getIterationCount());

    }
}
