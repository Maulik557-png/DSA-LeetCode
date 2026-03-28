package LeetCode;

// import java.util.Collection;
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

    // Over Complicated
    // public static boolean uniqueOccurrences(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for(int n: nums)  {
    //         map.put(n, map.getOrDefault(n, 1));
    //         if(!set.add(n))  {
    //             map.put(n, map.get(n) + 1);
    //         } 
    //         set.add(n);
    //     }

    //     Collection<Integer> values = map.values();
    //     HashSet<Integer> uniqueValues = new HashSet<>(values);
    //     return uniqueValues.size() == values.size();
    // }

}
