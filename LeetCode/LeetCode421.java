import java.util.HashSet;
import java.util.Set;

public class LeetCode421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        for (int bit = 31; bit >= 0; bit--) {
            mask = mask | (1 << bit);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int candidate = max | (1 << bit);
            for (int p : prefixes) {
                if (prefixes.contains(p ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
}
