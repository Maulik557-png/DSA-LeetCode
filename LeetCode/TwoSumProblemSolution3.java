// Time Complexity : Near to O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class TwoSumProblemSolution3 {

    // Generate all valid pairs for the target
    public static Set<String> pPairSet(int t) {
        Set<String> pairSet = new HashSet<>();
        for (int i = 0; i <= t / 2; i++) {
            int j = t - i;
            pairSet.add(i + "," + j);
        }
        return pairSet;
    }

    // O(n) search
    public static int[] twoSum(int[] nums, int target, Set<String> pairSet) {
        Map<Integer, Integer> seen = new HashMap<>(); // value → index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if this number's complement is already seen and valid in pair set
            String key1 = complement + "," + nums[i]; // to match your precomputed pairs
            String key2 = nums[i] + "," + complement; // both orders (just in case)
            if (seen.containsKey(complement) &&
                (pairSet.contains(key1) || pairSet.contains(key2))) {
                return new int[] { seen.get(complement), i };
            }

            // Add current number to map
            seen.put(nums[i], i);
        }
        return new int[] {};
    }

    // // Check using the set for O(1) lookup
    // public static int[] twoSum(int[] nums, int target, Set<String> pairSet) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int k = 0; k < i; k++) {
    //             String key = nums[i] + "," + nums[k];
    //             if (pairSet.contains(key)) {
    //                 return new int[] { i, k };
    //             }
    //         }
    //     }
    //     return new int[] {};
    // }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 11};
        int target = 9;

        Set<String> pairSet = pPairSet(target); // Precompute valid pairs
        int[] solution = twoSum(nums, target, pairSet);

        if (solution.length > 0) {
            System.out.println(Arrays.toString(solution));
        } else {
            System.out.println("[]");
        }
    }
}
