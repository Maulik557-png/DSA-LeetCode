import java.util.ArrayList;
import java.util.List;

public class LeetCode1260 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;

        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int idx = r * n + c;
                
                int i = (idx - k + (m * n)) % (m * n);
                
                int row = i / n;
                int col = i % n;
                
                list.get(r).add(grid[row][col]);
            }
        }
        
        return list;
    }

    public static void main(String[] args) {
        int[][] g = new int[4][2];
        g[0][0] = 1;
        g[0][1] = 2;
        g[1][0] = 3;
        g[1][1] = 4;
        g[2][0] = 5;
        g[2][1] = 6;
        g[3][0] = 7;
        g[3][1] = 8;

        List<List<Integer>> list = shiftGrid(g, 6);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}
