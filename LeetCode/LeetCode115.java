import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode115 {
    public int numDistinct(String s1, String s2) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map.computeIfAbsent(s1.charAt(i), k -> new ArrayList<>()).add(i);
        }

        long[] dp = new long[s1.length()];
        boolean first = true;

        for (char target : s2.toCharArray()) {
            List<Integer> positions = map.get(target);

            if (positions == null) {
                return 0;
            }

            if (first) {
                for (int pos : positions) {
                    dp[pos] = 1;
                }

                first = false;
            } else {
                long prefix = 0;
                int p = 0;

                for (int i = 0; i < s1.length(); i++) {
                    prefix += dp[i];

                    if (p < positions.size() && positions.get(p) == i) {
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
