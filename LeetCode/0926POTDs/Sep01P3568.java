import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sep01P3568 {
    public int minMoves(String[] grid, int maxEnergy) {

        int m = grid.length;
        int n = grid[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterGrid = new int[m][n];

        for (int[] row : litterGrid) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = grid[i].charAt(j);

                if (cell == 'S') {
                    sr = i;
                    sc = j;
                } else if (cell == 'L') {
                    litterGrid[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;

        Queue<State> q = new LinkedList<>();

        q.offer(new State(sr, sc, maxEnergy, 0, 0));

        boolean[][][][] visited = new boolean[m][n][maxEnergy + 1][targetMask + 1];
        visited[sr][sc][maxEnergy][0] = true;

        int[][] dirs = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!q.isEmpty()) {

            State curr = q.poll();

            if (curr.mask == targetMask) {
                return curr.moves;
            }

            if (curr.energy == 0) {
                continue;
            }

            for (int[] d : dirs) {

                int nr = curr.r + d[0];
                int nc = curr.c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (grid[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = curr.energy - 1;

                if (grid[nr].charAt(nc) == 'R') {
                    newEnergy = maxEnergy;
                }

                int newMask = curr.mask;

                if (litterGrid[nr][nc] != -1) {
                    newMask |= (1 << litterGrid[nr][nc]);
                }

                if (!visited[nr][nc][newEnergy][newMask]) {
                    visited[nr][nc][newEnergy][newMask] = true;

                    q.offer(new State(
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            curr.moves + 1));
                }
            }
        }

        return -1;
    }
}

class State {
    int r, c, energy, mask, moves;

    public State(int r, int c, int energy, int mask, int moves) {
        this.r = r;
        this.c = c;
        this.energy = energy;
        this.mask = mask;
        this.moves = moves;
    }
}
