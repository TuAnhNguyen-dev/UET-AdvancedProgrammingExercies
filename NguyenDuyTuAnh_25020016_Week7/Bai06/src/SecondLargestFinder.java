import java.util.concurrent.Callable;

public class SecondLargestFinder implements Callable<Integer> {
    private final int[] arr;

    public SecondLargestFinder(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() throws Exception {
        if (arr == null || arr.length < 2) {
            return null;
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int num : arr) {
            if (largest == null || num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num != largest && (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
