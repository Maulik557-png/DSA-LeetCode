import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sep12P3414 {
    private record Result(long weight, List<Integer> indices) {
    }

    private static class Interval {
        int left, right, weight, originalIndex;

        Interval(int left, int right, int weight, int originalIndex) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.originalIndex = originalIndex;
        }
    }

    private Result[][] memo;
    private List<Interval> sortedIntervals;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        sortedIntervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> inter = intervals.get(i);
            sortedIntervals.add(new Interval(inter.get(0), inter.get(1), inter.get(2), i));
        }

        sortedIntervals.sort(Comparator.comparingInt(a -> a.left));

        memo = new Result[n][5];

        Result bestResult = solve(0, 4);

        int[] ans = bestResult.indices.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ans);
        return ans;
    }

    private Result solve(int i, int quota) {
        if (i >= sortedIntervals.size() || quota == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (memo[i][quota] != null) {
            return memo[i][quota];
        }

        Result skip = solve(i + 1, quota);

        Interval curr = sortedIntervals.get(i);
        int nextIdx = findNextValid(i + 1, curr.right);
        Result takeNext = solve(nextIdx, quota - 1);

        long takeWeight = curr.weight + takeNext.weight;
        List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
        takeIndices.add(curr.originalIndex);

        Result take = new Result(takeWeight, takeIndices);

        memo[i][quota] = getBetterResult(skip, take);
        return memo[i][quota];
    }

    private int findNextValid(int start, int currentEnd) {
        int low = start, high = sortedIntervals.size() - 1;
        int ans = sortedIntervals.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedIntervals.get(mid).left > currentEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private Result getBetterResult(Result r1, Result r2) {
        if (r1.weight != r2.weight) {
            return r1.weight > r2.weight ? r1 : r2;
        }

        List<Integer> list1 = new ArrayList<>(r1.indices);
        List<Integer> list2 = new ArrayList<>(r2.indices);
        Collections.sort(list1);
        Collections.sort(list2);

        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) < list2.get(i) ? r1 : r2;
            }
        }

        return list1.size() <= list2.size() ? r1 : r2;
    }
}
