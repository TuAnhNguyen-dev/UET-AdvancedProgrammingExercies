public class Solution {
    public boolean isPrime(int n) {
        if (n <= 1) return false;

        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testNumbers = {
                -5,          // Số âm
                0, 1,        // Biên dưới
                2, 3,        // Số nguyên tố nhỏ nhất
                4, 9,        // Số chính phương
                17, 19,      // Số nguyên tố thông thường
                104729,      // Số nguyên tố lớn
                Integer.MAX_VALUE // Số nguyên tố Mersenne lớn nhất của kiểu int
        };

        for (int n : testNumbers) {
            System.out.printf("Số %d: %b\n", n, solution.isPrime(n));
        }
    }
}