public class Solution {
    public int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int x : arr) {
            if (x > first) {
                if (first != Integer.MIN_VALUE) {
                    second = first;
                    foundSecond = true;
                }
                first = x;
            } else if (x < first && x > second) {
                second = x;
                foundSecond = true;
            }
        }

        return foundSecond ? second : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                {3, 5, 1, 5, 4},    // Mảng bình thường: KQ 4
                {5, 5, 5},          // Mảng các phần tử trùng nhau: KQ -1
                {10},               // Mảng 1 phần tử: KQ -1
                {1, 2},             // Mảng 2 phần tử: KQ 1
                {Integer.MIN_VALUE, 0} // Test case biên
        };

        for (int[] arr : testCases) {
            int result = sol.secondLargest(arr);
            System.out.print("Mảng: ");
            printArray(arr);
            System.out.println(" => Số lớn thứ hai: " + result);
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.print("]");
    }
}
