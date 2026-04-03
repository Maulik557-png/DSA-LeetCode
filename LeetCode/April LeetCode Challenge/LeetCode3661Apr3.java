import java.util.Arrays;

public class LeetCode3661Apr3 {
    public static void main(String[] args) {
        int[] robots = { 10, 2 };
        int[] distances = { 5, 1 };
        int[] walls = { 5, 2, 7 };

        System.out.println(maxWalls(robots, distances, walls));
    }

    public static int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] robo = new int[n + 2][2];

        for (int i = 0; i < n; i++) {
            robo[i][0] = robots[i];
            robo[i][1] = distance[i];
        }

        robo[n][0] = Integer.MIN_VALUE;
        robo[n][1] = 0;
        robo[n + 1][0] = Integer.MAX_VALUE;
        robo[n + 1][1] = 0;

        Arrays.sort(walls);
        Arrays.sort(robo, (a, b) -> Integer.compare(a[0], b[0]));

        int leftRobo = 0;
        int rightRobo = 1;
        int[] dp = new int[4];
        int LL = 0, LR = 1, RL = 2, RR = 3;

        for (int wall : walls) {

            while (wall > robo[rightRobo][0]) {
                rightRobo++;
                leftRobo++;

                int lMax = Math.max(dp[LL], dp[RL]);
                int rMax = Math.max(dp[LR], dp[RR]);

                dp[LL] = lMax;
                dp[LR] = lMax;
                dp[RL] = rMax;
                dp[RR] = rMax;
            }

            boolean lReach = wall <= robo[leftRobo][0] + robo[leftRobo][1];
            boolean rReach = wall >= robo[rightRobo][0] - robo[rightRobo][1];
            boolean samePoint = wall == robo[rightRobo][0];

            // LL
            if (rReach)
                dp[LL]++;
            // LR
            if (samePoint)
                dp[LR]++;
            // RL
            if (lReach || rReach)
                dp[RL]++;
            // RR
            if (lReach || samePoint)
                dp[RR]++;
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
