public class Sep29P2267 {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        int maxBal = (m + n) / 2;
        memo = new Boolean[m][n][maxBal + 1];

        return dfs(grid, 0, 0, 0, m, n, maxBal);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal, int m, int n, int maxBal) {
        if (grid[r][c] == '(') {
            bal++;
        } else {
            bal--;
        }

        if (bal < 0 || bal > maxBal) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }

        boolean foundPath = false;
        if (c + 1 < n) {
            foundPath = dfs(grid, r, c + 1, bal, m, n, maxBal);
        }

        if (!foundPath && r + 1 < m) {
            foundPath = dfs(grid, r + 1, c, bal, m, n, maxBal);
        }

        return memo[r][c][bal] = foundPath;
    }
}
