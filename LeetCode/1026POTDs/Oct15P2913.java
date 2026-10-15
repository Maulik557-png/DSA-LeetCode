import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Oct15P2913 {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                res += Math.pow(set.size(), 2);
            }
            set = new HashSet<>();
        }

        return res;
    }
}
