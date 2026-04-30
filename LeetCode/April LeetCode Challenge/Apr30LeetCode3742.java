public class Apr30LeetCode3742 {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1 }, { 2, 0 } };
        int k = 1;
        System.out.println(maxPathScore(grid, k));
    }

    private static int m;
    private static int n;
    private static Integer[][][] dp;

    public static int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][k + 1];
        return helper(0, 0, grid, k);
    }

    private static int helper(int i, int j, int[][] grid, int k) {
        if (i >= m || j >= n || k < 0) {
            return -1;
        }

        int val = grid[i][j];
        boolean anyCost = val > 0;

        if (anyCost && k <= 0) {
            return -1;
        }

        if (i == m - 1 && j == n - 1) {
            return val;
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int nextK = k;
        if (val > 0) {
            nextK = k - 1;
        }

        int right = helper(i, j + 1, grid, nextK);
        int down = helper(i + 1, j, grid, nextK);

        if(right == -1 && down == -1) {
            return dp[i][j][k] = -1;
        }

        return dp[i][j][k] = val + Math.max(right, down);
    }
}
