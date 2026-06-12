public class LeetCode2352 {
    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(equalPairs(grid));
    }

    // v2
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                boolean equal = true;
                for (int k = 0; k < n; k++) {
                    if (grid[row][k] != grid[k][col]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    count++;
                }
            }
        }

        return count;
    }

    // v1
    // public static int equalPairss(int[][] grid) {
    //     List<List<Integer>> cols = new ArrayList<>();
    //     List<List<Integer>> rows = new ArrayList<>();

    //     for (int i = 0; i < grid.length; i++) {
    //         rows.add(new ArrayList<>());
    //         cols.add(new ArrayList<>());
    //     }

    //     for (int i = 0; i < cols.size(); i++) {
    //         for (int j = 0; j < grid.length; j++) {
    //             rows.get(i).add(grid[i][j]);
    //         }
    //     }

    //     for (int i = 0; i < cols.size(); i++) {
    //         for (int j = 0; j < grid.length; j++) {
    //             cols.get(i).add(grid[j][i]);
    //         }
    //     }

    //     int count = 0;

    //     for (List<Integer> row : rows) {
    //         for (List<Integer> col : cols) {
    //             if (row.equals(col)) {
    //                 count++;
    //             }
    //         }
    //     }

    //     return count;
    // }
}
