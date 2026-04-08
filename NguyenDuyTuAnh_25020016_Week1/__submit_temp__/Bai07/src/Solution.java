public class Solution {
    public int reverse(int n) {
        long reversed = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            reversed = reversed * 10 + lastDigit;
            n /= 10;

            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testCases = {
                123,         // Số dương bình thường -> 321
                -123,        // Số âm -> -321
                120,         // Số có chữ số 0 ở cuối -> 21
                0,           // Số 0 -> 0
                1534236469,  // Số lớn (sẽ bị tràn khi đảo ngược) -> 0
                -2147483648  // Integer.MIN_VALUE -> 0 (vì đảo ngược sẽ tràn)
        };

        for (int n : testCases) {
            System.out.printf("Số gốc: %d \t| Kết quả đảo ngược: %d\n", n, solution.reverse(n));
        }
    }
}