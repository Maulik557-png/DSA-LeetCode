import java.util.*;

public class Apr14LeetCode2463 {
    private static Long[][] dp;
    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>(Arrays.asList(0, 4, 6));
        int[][] factory = {{2, 2}, {6, 2}};
        System.out.println(minimumTotalDistance(robot, factory));
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        dp = new Long[robot.size()][factory.length];
        Collections.sort(robot, (a, b) -> a - b);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        return helper(robot, factory, 0, 0);
    }

    private static long helper(List<Integer> robot, int[][] factory, int rIndex, int fIndex) {

        if(rIndex == robot.size())
            return 0;    
        if(fIndex ==  factory.length)
            return Long.MAX_VALUE;
        if(dp[rIndex][fIndex] != null)
            return dp[rIndex][fIndex];

        // skipping current factory
        long skip =  helper(robot, factory, rIndex, fIndex + 1);

        // picking current factory
        long dist = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < factory[fIndex][1] && rIndex + i < robot.size(); i++) {
            dist += Math.abs(robot.get(rIndex + i) - factory[fIndex][0]);
            long next = helper(robot, factory, rIndex + i + 1, fIndex + 1);
            if(next < Long.MAX_VALUE)
                res = Math.min(res, dist + next);
        }

        dp[rIndex][fIndex] = Math.min(skip, res);

        return Math.min(skip, res);
    }
}
