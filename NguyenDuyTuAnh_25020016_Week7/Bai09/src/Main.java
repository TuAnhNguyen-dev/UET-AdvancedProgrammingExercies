public class Main {
    public static void main(String[] args) {
        // Create a shared counter
        Counter counter = new Counter();
        
        // Number of threads and increments per thread
        final int NUM_THREADS = 4;
        final int INCREMENTS_PER_THREAD = 10000;
        
        // Create and start threads
        Thread[] threads = new Thread[NUM_THREADS];
        
        System.out.println("--- PHASE 1: Test lock() ---");
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadId + " started");
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    counter.increment() ;
                }
                System.out.println("Thread " + threadId + " completed");
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete using join()
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error waiting for thread " + i + ": " + e.getMessage());
            }
        }
        
        // Print final counter value
        System.out.println("\n=== PHASE 1 Results (lock()) ===");
        System.out.println("Final Counter Value: " + counter.getValue());
        System.out.println("Expected Value: " + (NUM_THREADS * INCREMENTS_PER_THREAD));
        System.out.println("Check: " + (counter.getValue() == NUM_THREADS * INCREMENTS_PER_THREAD ? "✓ PASS" : "✗ FAIL"));

        // Reset for Phase 2
        System.out.println("\n--- PHASE 2: Test tryLock(100ms) ---");
        counter.reset();
        
        Thread[] lockTestThreads = new Thread[NUM_THREADS];
        int[] successCount = {0};
        int[] failCount = {0};
        
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            lockTestThreads[i] = new Thread(() -> {
                int success = 0;
                int fail = 0;
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    if (counter.incrementWithTryLock(100)) {
                        success++;
                    } else {
                        fail++;
                        if (fail <= 5) { // Print first 5 failures to avoid spam
                            System.out.println("Thread " + threadId + " failed to acquire lock (attempt: " + j + ")");
                        }
                    }
                }
                synchronized (Main.class) {
                    successCount[0] += success;
                    failCount[0] += fail;
                }
                System.out.println("Thread " + threadId + " - Success: " + success + ", Failed: " + fail);
            });
            lockTestThreads[i].start();
        }
        
        // Wait for all lock test threads to complete
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                lockTestThreads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error waiting for lock test thread " + i + ": " + e.getMessage());
            }
        }
        
        System.out.println("\n=== PHASE 2 Results (tryLock) ===");
        System.out.println("Successful increments: " + successCount[0]);
        System.out.println("Failed increments (timeout): " + failCount[0]);
        System.out.println("Counter Value: " + counter.getValue());
        System.out.println("Total attempts: " + (successCount[0] + failCount[0]) + " (expected: " + (NUM_THREADS * INCREMENTS_PER_THREAD) + ")");
    }
}
