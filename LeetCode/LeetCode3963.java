public class LeetCode3963 {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        StringBuilder row = new StringBuilder();
        for (int i = 0; i < n; i++) {
            row.append(".");
        }
        grid[0] = row.toString();

        for (int i = 1; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                sb.append("#");
            }
            sb.append(".");
            grid[i] = sb.toString();
        }

        return grid;
    }
}
