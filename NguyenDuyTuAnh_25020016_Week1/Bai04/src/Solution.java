public class Solution {
    public static long fibonacci(long n) {
        if (n > 100) {
//            throw
        }

        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        long prev = 0, curr = 1;
        while (n > 1) {
            if (Long.MAX_VALUE - prev < curr) {
                return Long.MAX_VALUE;
            }

            long temp = curr;
            curr += prev;
            prev = temp;
            n--;
        }

        return curr;
    }

    public static void main(String[] args) {
        long[] testCases = {-59, 0, 1, 5, 16, 69, 90, 95, 100}; // 95 và 100 sẽ gây tràn số
        Solution sol = new Solution();
        for (long test: testCases) {
            System.out.printf("Số fib thứ %d là: %d\n", test, sol.fibonacci(test));
        }
    }
}
