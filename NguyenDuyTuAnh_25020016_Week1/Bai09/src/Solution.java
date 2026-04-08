public class Solution {
    public int sumOfDigits(int n) {
        n = Math.abs(n);

        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {
                123,
                -456,
                0,
                9999, 1000000007
        };

        for (int n : testCases) {
            System.out.printf("Số: %d => Tổng chữ số: %d\n", n, sol.sumOfDigits(n));
        }
    }
}