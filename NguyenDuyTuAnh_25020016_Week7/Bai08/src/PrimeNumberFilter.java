import java.util.concurrent.Callable;

public class PrimeNumberFilter implements Callable<int[]> {
    private final int[] arr;

    public PrimeNumberFilter(int[] arr) {
        this.arr = arr;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        if (num % 2 == 0) {
            return num == 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int[] call() {
        return java.util.Arrays.stream(arr)
                .filter(this::isPrime)
                .toArray();
    }
}
