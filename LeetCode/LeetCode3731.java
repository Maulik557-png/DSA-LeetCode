import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode3731 {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
            set.add(n);
        }

        for(int i = min; i <= max; i++) {
            if(set.contains(i)) {
                continue;
            }
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}
