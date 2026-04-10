import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Apr10LeetCode3740 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 2, 1, 2 };
        System.out.println(minimumDistance(nums));
    }

    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            if (list.size() >= 3) {
                int size = list.size();
                int i1 = list.get(size - 3);
                int i2 = list.get(size - 2);
                int i3 = list.get(size - 1);
                int dist = Math.abs(i1 - i2) + Math.abs(i2 - i3) + Math.abs(i3 - i1);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // public static int minimumDistance(int[] nums) {
    // Map<Integer, List<Integer>> map = new HashMap<>();
    // int min = Integer.MAX_VALUE;
    // for (int i = 0; i < nums.length; i++) {
    // map.putIfAbsent(nums[i], new ArrayList<>());
    // List<Integer> list = map.get(nums[i]);
    // list.add(i);
    // if (list.size() >= 3) {
    // int size = list.size();
    // int dist = 2 * (list.get(size - 1) - list.get(size - 3));
    // min = Math.min(min, dist);
    // }
    // }
    // return min == Integer.MAX_VALUE ? -1 : min;
    // }
}
