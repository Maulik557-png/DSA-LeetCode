import java.util.HashSet;
import java.util.Set;

public class LeetCode3718 {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int i = 1;
        int n = k;
        while (true) {
            n = k * i;
            if (!set.contains(n)) {
                break;
            }
            i++;
        }

        return n;
    }
}
