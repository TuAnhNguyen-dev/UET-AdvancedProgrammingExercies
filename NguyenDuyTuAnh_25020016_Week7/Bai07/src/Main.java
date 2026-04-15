import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        List<int[]> arrays = new ArrayList<>();

        // Read input file
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int size = scanner.nextInt();
                int[] arr = new int[size];

                for (int j = 0; j < size; j++) {
                    arr[j] = scanner.nextInt();
                }

                arrays.add(arr);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        //
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(n, 4));
        List<Future<Integer>> futures = new ArrayList<>();

        for (int[] arr: arrays) {
            futures.add(executor.submit(new PrimeCounter(arr)));
        }

        executor.shutdown();

        // Get results
        List<Integer> results = new ArrayList<>();
        int maxPrimeCount = 0;

        for (Future<Integer> future: futures) {
            try {
                int count = future.get();
                results.add(count);
                maxPrimeCount = Math.max(maxPrimeCount, count);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Execution error: " + e.getMessage());
                results.add(-1);
            }
        }

        // Print results
        // Get all array's count
        for (int i = 0; i < results.size(); i++) {
            int count = results.get(i);
            System.out.println("Array " + i + ": " + count);
        }

        // Get all array that have most count
        if (maxPrimeCount > 0) {
            System.out.print("Most primes: ");
            boolean isFirst = true;

            for (int i = 0; i < results.size(); i++) {
                if (results.get(i) == maxPrimeCount) {
                    if (!isFirst) {
                        System.out.print(", ");
                    }
                    System.out.print("Array " + i);
                    isFirst = false;
                }
            }
            System.out.println(" with " + maxPrimeCount + " primes.");
        } else {
            System.out.println("No prime numbers found in any array.");
        }
    }
}
