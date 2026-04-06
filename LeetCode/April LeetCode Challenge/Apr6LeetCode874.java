
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Apr6LeetCode874 {
    public static void main(String[] args) {
        int[] commands = { 6, -1, -1, 6 };
        int[][] obstacles = { { 0, 0 } };
        System.out.println(robotSim(commands, obstacles));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles)
            set.add(o[0] + "," + o[1]);

        int[][] dirs = {
                { 0, 1 }, // N
                { 1, 0 }, // E
                { 0, -1 }, // S
                { -1, 0 } // W
        };

        int dir = 0;
        int x = 0, y = 0;
        int res = 0;

        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < c; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (set.contains(nx + "," + ny)) break;

                    x = nx;
                    y = ny;

                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }

    // public static int robotSim(int[] commands, int[][] obstacles) {
    // Set<List<Integer>> set = new HashSet<>();
    // for (int[] n : obstacles) {
    // set.add(Arrays.asList(n[0], n[1]));
    // }

    // Map<Integer, Character> map = new HashMap<>();
    // map.put(0, 'N');
    // map.put(1, 'E');
    // map.put(2, 'S');
    // map.put(3, 'W');
    // int dir = 0;
    // char d = 'N';

    // int res = 0;

    // int[][] moves = new int[1][2];

    // for (int i = 0; i < commands.length; i++) {
    // int c = commands[i];

    // if (c == -1) {
    // dir = (dir + 1) % 4;
    // d = map.get(dir);
    // } else if (c == -2) {
    // dir = (dir + 3) % 4;
    // d = map.get(dir);
    // }

    // if (1 <= c && c <= 9) {
    // int step = c;

    // while (step > 0) {
    // int nx = moves[0][0];
    // int ny = moves[0][1];

    // switch (d) {
    // case 'N' -> ny++;
    // case 'E' -> nx++;
    // case 'S' -> ny--;
    // default -> nx--;
    // }

    // if (set.contains(Arrays.asList(nx, ny))) break;

    // moves[0][0] = nx;
    // moves[0][1] = ny;
    // step--;
    // }
    // res = Math.max(res, moves[0][0] * moves[0][0] + moves[0][1] * moves[0][1]);
    // }
    // }
    // return res;
    // }
}
