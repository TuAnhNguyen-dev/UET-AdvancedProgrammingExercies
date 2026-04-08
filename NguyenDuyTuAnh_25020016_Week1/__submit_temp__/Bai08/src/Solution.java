public class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }

        int reversedNum = 0;
        int original = n;

        while (n > 0) {
            int lastDigit = n % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            n = n / 10;
        }

        return original == reversedNum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {
                121, 12321, 1001,    // palindrome bình thương
                -121,                // số âm
                10,                  // số 0 đứng cuối
                0,                   // chỉ riêng số 0
                123,                 // khong palindrome
                12344321,            // số lớn
        };

        for (int n : testCases) {
            System.out.printf("Số %d: %b\n", n, sol.isPalindrome(n));
        }
    }
}