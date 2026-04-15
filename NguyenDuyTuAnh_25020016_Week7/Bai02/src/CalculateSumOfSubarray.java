import java.util.concurrent.Callable;

public class CalculateSumOfSubarray implements Callable<Integer> {
    private int[] arr;
    private int start;
    private int end;

    public CalculateSumOfSubarray(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
