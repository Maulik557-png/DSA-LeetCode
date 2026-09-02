public class Apr2LeetCode3418 {
    public static void main(String[] args) {
        int[][] coins = {{0,1,-1}, {1,-2,3}, {2,-3,4}};
        System.out.println(maximumAmount(coins));
    }

    private static int m;
    private static int n;
    private static Integer dp[][][];
    public static int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        dp = new Integer[m][n][3];
        return helper(coins, 0, 0, 2);
    }

    private static int helper(int[][] coins, int i, int j, int skips) {
        if(i >= m || j >= n) return Integer.MIN_VALUE;

        if(dp[i][j][skips] !=  null) {
            return dp[i][j][skips];
        }

        if(i == m - 1 && j == n - 1) {
            if(coins[i][j] < 0 && skips > 0) return 0;
            return coins[i][j];
        }

        int right = helper(coins, i, j + 1, skips);
        int down = helper(coins, i + 1, j, skips);

        int s = Integer.MIN_VALUE;

        if(coins[i][j] < 0 && skips > 0) {
            int rSkip = helper(coins, i, j + 1, skips - 1);
            int dSkip = helper(coins, i + 1, j, skips - 1);

            s = Math.max(rSkip, dSkip);
        }
        int maxCoins = Math.max(Math.max(right, down) + coins[i][j], s);
        dp[i][j][skips] = maxCoins;
        return maxCoins;
    }
}
