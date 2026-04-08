public class Solution {
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] testCases = {
                {48, 18},    // Trường hợp thông thường -> 6
                {101, 10},   // Số nguyên tố -> 1
                {0, 5},      // Một số bằng 0 -> 5
                {0, 0},      // Cả hai bằng 0 -> 0
                {-12, 18},   // Số âm -> 6
                {7, 7}       // Hai số bằng nhau -> 7
        };

        for (int[] test : testCases) {
            int a = test[0];
            int b = test[1];
            System.out.printf("GCD của %d và %d là: %d\n", a, b, solution.gcd(a, b));
        }
    }
}
