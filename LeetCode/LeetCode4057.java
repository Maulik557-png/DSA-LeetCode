import java.util.Arrays;

public class LeetCode4057 {
    public long countIntersectingIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        long total = (long) n * (n - 1) / 2;
        long non = 0;

        int e = 0;
        for (int s = 0; s < n; s++) {
            while (e < n && end[e] < start[s]) {
                e++;
            }

            non += e;
        }

        return total - non;
    }
}
