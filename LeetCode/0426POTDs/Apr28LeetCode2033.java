import java.util.Arrays;

public class Apr28LeetCode2033 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 5 }, { 2, 3 } };
        int x = 1;
        System.out.println(minOperations(grid, x));
    }

    // Better (Optimized)
    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m * n];
        int k = 0;
        int rem = grid[0][0] % x;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[k++] = grid[i][j];
                if (grid[i][j] % x != rem)
                    return -1;
            }
        }

        Arrays.sort(arr);

        int num = arr[arr.length / 2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.abs(num - arr[i]) / x;
        }

        return count;
    }

    // First attempt (Working)
    // public static int minOperations(int[][] grid, int x) {
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int[] nums = new int[m * n];

    //     int k = 0;
    //     for (int[] g : grid) {
    //         for (int l : g) {
    //             nums[k] = l;
    //             k++;
    //         }
    //     }

    //     Arrays.sort(nums);

    //     int base = nums[0];
    //     for (int num : nums) {
    //         if ((num - base) % x != 0)
    //             return -1;
    //     }

    //     int mid = nums.length / 2;
    //     int element = nums[mid];
    //     int ops = 0;
    //     for (int i = 0; i < mid; i++) {
    //         ops += ((element - nums[i]) / x);
    //     }

    //     for (int i = mid; i < nums.length; i++) {
    //         ops += ((nums[i] - element) / x);
    //     }

    //     return ops;
    // }

    // ChatGPT version
    // public static int minOperations(int[][] grid, int x) {
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int[] nums = new int[m * n];
    //     int k = 0;

    //     for (int[] row : grid) {
    //         for (int val : row) {
    //             nums[k++] = val;
    //         }
    //     }

    //     Arrays.sort(nums);

    //     int base = nums[0];
    //     for (int num : nums) {
    //         if ((num - base) % x != 0)
    //             return -1;
    //     }

    //     int median = nums[nums.length / 2];
    //     int ops = 0;

    //     for (int num : nums) {
    //         ops += Math.abs(num - median) / x;
    //     }

    //     return ops;
    // }
}
