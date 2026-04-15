import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

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

        ExecutorService pool1 = Executors.newFixedThreadPool(2);
        ExecutorService pool2 = Executors.newFixedThreadPool(3);

        LongAdder totalPrimeSum = new LongAdder();
        List<CompletableFuture<Void>> allTasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final int arrayIndex = i;
            int[] currentArray = arrays.get(i);

            // Stage 1
            CompletableFuture<int[]> stage1 = CompletableFuture.supplyAsync(() -> {
                int[] primes = new PrimeNumberFilter(currentArray).call();

                try { Thread.sleep(20); } catch (InterruptedException e) {}

                System.out.println("Stage 1 - Array " + arrayIndex + ": " + Arrays.toString(primes));
                return primes;
            }, pool1);

            // Stage 2
            CompletableFuture<Void> stage2 = stage1.thenAcceptAsync(primes -> {
                long result = 0;
                String type = "";

                if (primes.length % 2 == 0) {
                    type = "sum of squares";
                    result = Arrays.stream(primes).mapToLong(p -> (long) p * p).sum();
                } else {
                    type = "sum of cubes";
                    result = Arrays.stream(primes).mapToLong(p -> (long) p * p * p).sum();
                }

                System.out.println("Stage 2 - Array " + arrayIndex + ": " + type + " = " + result);
                totalPrimeSum.add(result);
            }, pool2);

            allTasks.add(stage2);
        }

        // Wait for all tasks to complete
        CompletableFuture.allOf(allTasks.toArray(new CompletableFuture[0])).join();

        pool1.shutdown();
        pool2.shutdown();

        System.out.println("Total = " + totalPrimeSum.sum());
    }
}
