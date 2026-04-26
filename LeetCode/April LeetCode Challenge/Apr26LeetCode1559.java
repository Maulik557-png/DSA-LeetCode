public class Apr26LeetCode1559 {
    public static void main(String[] args) {
        char[][] grid = { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
                { 'f', 'c', 'c', 'c' } };
        System.out.println(containsCycle(grid));
    }

    private static boolean[][] visited;
    private static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(-1, -1, i, j, grid[i][j], grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int pr, int pc, int i, int j, char ch, char[][] grid) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != ch) {
            return false;
        }
        if (visited[i][j] == true) {
            return true;
        }

        visited[i][j] = true;

        for (int dir[] : dir) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x == pr && y == pc)
                continue;
            if (dfs(i, j, x, y, ch, grid))
                return true;
        }
        return false;
    }
}
