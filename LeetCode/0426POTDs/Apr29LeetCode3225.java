// import java.util.*;

public class Apr29LeetCode3225 {
    public static void main(String[] args) {
        int[][] grid = { { 10, 9, 0, 0, 15 }, { 7, 1, 0, 8, 0 }, { 5, 20, 0, 11, 0 }, { 0, 0, 0, 1, 2 },
                { 8, 12, 1, 10, 3 } };
        System.out.println(maximumScore(grid));
    }

    // Optimal approach
    public static long maximumScore(int[][] grid) {
        int n = grid.length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long res = 0, prev1 = 0, prev2 = 0;
        int i = 0;
        while (i < n - 1) {
            long curr = score(grid, dp1, i, prev1, 0, 1, n);
            prev1 = Math.max(res, prev2);
            prev2 = score(grid, dp2, i + 1, res, n - 1, -1, -1);
            res = Math.max(prev1, curr);
            i++;
        }
        return Math.max(res, prev2);
    }

    private static long score(int[][] grid, long[] dp, int col, long prev, int row, int dir, int stop) {
        long max = 0;
        while (row != stop) {
            max = Math.max(max, prev);
            prev = dp[row];
            max += grid[row][col];
            dp[row] = max;
            row += dir;
        }
        return max;
    }

    // O(n^3)
    // private static long pref[][];
    // private static int n;
    // private static long dp[][][];

    // public static long maximumScore(int[][] grid) {
    //     n = grid.length;
    //     pref = new long[n + 1][n + 1];
    //     dp = new long[2][n + 1][n + 1];

    //     for (int j = 0; j < n; j++) {
    //         for (int i = 1; i <= n; i++) {
    //             pref[i][j + 1] = pref[i - 1][j + 1] + grid[i - 1][j];
    //         }
    //     }

    //     for (int i = 0; i < 2; i++) {
    //         for (int j = 0; j <= n; j++)
    //             Arrays.fill(dp[i][j], -1);
    //     }

    //     return helper(0, 0, 1);
    // }

    // private static long helper(int prevTaken, int prevLen, int col) {
    //     if (col == n + 1) {
    //         return 0;
    //     }
    //     if (dp[prevTaken][prevLen][col] != -1) {
    //         return dp[prevTaken][prevLen][col];
    //     }

    //     long ans = 0;

    //     for (int len = 0; len <= n; len++) {
    //         long prevAns = 0, currAns = 0;

    //         if (prevTaken == 0 && col > 1 && len > prevLen) {
    //             prevAns = pref[len][col - 1] - pref[prevLen][col - 1];
    //         }

    //         if (prevLen > len) {
    //             currAns = pref[prevLen][col] - pref[len][col];
    //         }

    //         long ans1 = currAns + prevAns + helper(1, len, col + 1);
    //         long ans2 = prevAns + helper(0, len, col + 1);

    //         ans = Math.max(ans, Math.max(ans1, ans2));
    //     }

    //     return dp[prevTaken][prevLen][col] = ans;
    // }
}
