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


        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                int[] arr = new int[m];

                for (int j = 0; j < m; j++) {
                    arr[j] = scanner.nextInt();
                }

                arrays.add(arr);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        // Use thread pool to find second largest in each array
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(n, 4));
        List<Future<Integer>> futures = new ArrayList<>();

        for (int[] arr : arrays) {
            futures.add(executor.submit(new SecondLargestFinder(arr)));
        }

        executor.shutdown();

        // Collect results
        long sum = 0;

        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer secondLargest = futures.get(i).get();
                if (secondLargest != null) {
                    System.out.println("Array " + i + ": second largest = " + secondLargest);
                    sum += secondLargest;
                } else {
                    System.out.println("Array " + i + ": Not found");
                }

            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Execution error: " + e.getMessage());
            }
        }

        System.out.println("Sum = " + sum);
    }
}
