public class Apr27LeetCode1393 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 1 }, { 1, 2, 1 } };
        System.out.println(hasValidPath(grid));
    }

    private static int m, n;
    private static boolean[][] visited;
    private static boolean canRight[] = { false, true, false, false, true, false, true };
    private static boolean canLeft[] = { false, true, false, true, true, true, false };
    private static boolean canUp[] = { false, false, true, false, false, true, true };
    private static boolean canDown[] = { false, false, true, true, true, false, false };

    private static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        return dfs(0, 0, grid);
    }

    private static boolean dfs(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < dir.length; k++) {
            int nr = i + dir[k][0];
            int nc = j + dir[k][1];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && canMove(grid[i][j], grid[nr][nc], k)) {
                if (dfs(nr, nc, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canMove(int curr, int next, int d) {
        if (d == 0) {
            return canRight[curr] && canLeft[next];
        } else if (d == 1) {
            return canLeft[curr] && canRight[next];
        } else if (d == 2) {
            return canUp[curr] && canDown[next];
        } else if (d == 3) {
            return canDown[curr] && canUp[next];
        }
        return false;
    }
}
