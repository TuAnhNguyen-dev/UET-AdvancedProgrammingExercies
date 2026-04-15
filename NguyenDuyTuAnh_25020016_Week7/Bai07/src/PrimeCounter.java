import java.util.concurrent.Callable;

public class PrimeCounter implements Callable<Integer> {
    private final int[] arr;

    public PrimeCounter(int[] arr) {
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
    public Integer call() {
        int count = 0;

        for (int num: arr) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }
}
