import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sep06P115 {

    // approach 1 - TLE
    private Map<Character, List<Integer>> indexMap;
    private long[][] memo;

    public int numDistinct(String s1, String s2) {
        // --------------------------------------------------
        // STEP 1:
        // Build:
        //
        // character -> sorted indices in s1
        //
        // Example:
        // b -> [0, 2, 4]
        // a -> [1, 5]
        // g -> [3, 6]
        // --------------------------------------------------

        indexMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            indexMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        // currentIndex can be -1 initially.
        // Therefore currentIndex + 1 is used as the memoization index.
        memo = new long[s1.length() + 1][s2.length()];

        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        // No character has been selected yet.
        return (int) countWays(-1, 0, s1, s2);
    }

    private long countWays(int currentIndex, int s2Index, String s1, String s2) {
        // --------------------------------------------------
        // We have successfully selected every character of s2.
        // --------------------------------------------------
        if (s2Index == s2.length()) {
            return 1;
        }

        // --------------------------------------------------
        // s1 has been exhausted but s2 is still incomplete.
        // --------------------------------------------------
        if (currentIndex >= s1.length() - 1) {
            /*
             * There might still technically be a valid character after currentIndex, so
             * don't use this condition directly.
             * Instead, let the index lookup below determine whether another position
             * exists.
             */
        }

        int memoIndex = currentIndex + 1;
        if (memo[memoIndex][s2Index] != -1) {
            return memo[memoIndex][s2Index];
        }

        char requiredChar = s2.charAt(s2Index);

        // --------------------------------------------------
        // Get all positions of the required character.
        // --------------------------------------------------
        List<Integer> positions = indexMap.get(requiredChar);

        if (positions == null) {
            return 0;
        }

        // --------------------------------------------------
        // Find the first position > currentIndex.
        //
        // Example:
        //
        // currentIndex = 2
        // a -> [1, 5]
        //
        // upperBound() returns index of 5.
        // --------------------------------------------------
        int start = upperBound(positions, currentIndex);
        long ways = 0;

        // --------------------------------------------------
        // Try every valid occurrence.
        //
        // This is YOUR original idea:
        //
        // current index
        // ↓
        // find all valid next indices
        // ↓
        // recursively continue
        // --------------------------------------------------
        for (int i = start; i < positions.size(); i++) {
            int nextIndex = positions.get(i);
            ways += countWays(nextIndex, s2Index + 1, s1, s2);
        }

        memo[memoIndex][s2Index] = ways;
        return ways;
    }

    // ------------------------------------------------------
    // Binary search:
    // Find first element strictly greater than target.
    // ------------------------------------------------------

    private int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // approach 2
    public int numDistinctt(String s1, String s2) {

        Map<Character, List<Integer>> map = new HashMap<>();

        // Build character -> sorted indices
        for (int i = 0; i < s1.length(); i++) {
            map.computeIfAbsent(s1.charAt(i),
                    k -> new ArrayList<>()).add(i);
        }

        /*
         * dp[i] = number of ways to form the current
         * prefix/suffix of s2 ending at position i in s1.
         *
         * We process s2 from left to right.
         */
        long[] dp = new long[s1.length()];

        boolean first = true;

        for (char target : s2.toCharArray()) {

            List<Integer> positions = map.get(target);

            if (positions == null) {
                return 0;
            }

            if (first) {

                /*
                 * First character:
                 * every occurrence is one valid way.
                 */
                for (int pos : positions) {
                    dp[pos] = 1;
                }

                first = false;

            } else {

                /*
                 * We need the number of ways to reach
                 * this position from an earlier position.
                 *
                 * Maintain prefix sum of dp.
                 */
                long prefix = 0;

                int p = 0;

                for (int i = 0; i < s1.length(); i++) {

                    prefix += dp[i];

                    /*
                     * If i is an occurrence of target,
                     * all previous valid paths can end here.
                     */
                    if (p < positions.size()
                            && positions.get(p) == i) {

                        dp[i] = prefix - dp[i];

                        p++;
                    } else {
                        dp[i] = 0;
                    }
                }
            }
        }

        long answer = 0;

        for (long value : dp) {
            answer += value;
        }

        return (int) answer;
    }
}
