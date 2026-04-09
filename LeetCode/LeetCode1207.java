import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1207 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(nums));
    }

    public static boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)  map.put(n, map.getOrDefault(n, 0) + 1);
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }

    // public boolean uniqueOccurrences(int[] arr) {
    //     int max = arr[0];
    //     int min = arr[0];
    //     for (int n : arr) {
    //         max = Math.max(max, n);
    //         min = Math.min(min, n);
    //     }

    //     int[] freq = new int[max - min + 1];
    //     boolean[] occured = new boolean[arr.length + 1];
    //     for (int n : arr) freq[n - min]++;

    //     for (int n: freq) {
    //         if (n > 0) {
    //             if (occured[n]) return false;
    //             occured[n] = true;
    //         }
    //     }
    //     return true;
    // }
}
