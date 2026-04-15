import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 0, k = 0;
        int[] arr = null;

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            n = scanner.nextInt();
            k = scanner.nextInt();

            if (k == 0) {
                System.out.println("Error: k cannot be zero.");
                return;
            }

            arr = new int[n];

            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                arr[i] = num;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

//        for (var num: arr) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        int range = n / k;
        int remainder = n % k;

        int start = 0;

        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int end = start + range + (i < remainder ? 1 : 0);
            CalculateSumOfSubarray task = new CalculateSumOfSubarray(arr, start, end);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
            start = end;
        }

        executor.shutdown();

        int totalSum = 0;
        try {
            for (int i = 0; i < futures.size(); i++) {
                int subSum = futures.get(i).get();
                System.out.println("Sum of subarray " + (i + 1) + ": " + subSum);
                totalSum += subSum;
            }
            System.out.println("Total sum of all subarrays: " + totalSum);
        } catch (Exception e) {
            System.out.println("Error calculating sums: " + e.getMessage());
        }
    }
}
