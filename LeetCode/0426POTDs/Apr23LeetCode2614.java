import java.util.*;

public class Apr23LeetCode2614 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 1, 2 };
        long[] res = distance(nums);
        for (long l : res) {
            System.out.println(l);
        }
    }

    // Time complexity: O(n)
    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        // group indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();

            long prefixSum = 0;

            // left to right
            for (int i = 0; i < size; i++) {
                int idx = list.get(i);
                res[idx] += (long) idx * i - prefixSum;
                prefixSum += idx;
            }

            prefixSum = 0;

            // right to left
            for (int i = size - 1; i >= 0; i--) {
                int idx = list.get(i);
                res[idx] += prefixSum - (long) idx * (size - 1 - i);
                prefixSum += idx;
            }
        }

        return res;
    }

    // Time complexity: O(n)
    // public static long[] distance(int[] nums) {
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     int l = nums.length;
    //     long[] res = new long[l];

    //     for (int i = 0; i < l; i++) {
    //         map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    //     }

    //     for (List<Integer> list : map.values()) {
    //         int s = list.size();

    //         long leftSum = 0l;
    //         long rightSum = 0l;

    //         for (int i = 0; i < s; i++) {
    //             rightSum += list.get(i);
    //         }

    //         for (int i = 0; i < s; i++) {
    //             rightSum -= list.get(i);

    //             long currSum = 0l;

    //             currSum += ((long) list.get(i) * i) - leftSum;
    //             currSum += rightSum - ((long) list.get(i) * (s - i - 1));

    //             leftSum += list.get(i);

    //             res[list.get(i)] = currSum;
    //         }
    //     }
    //     return res;
    // }

    // TLE
    // public static long[] distance(int[] nums) {
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     int l = nums.length;
    //     long[] res = new long[l];

    //     for (int i = 0; i < l; i++) {
    //         map.putIfAbsent(nums[i], new ArrayList<>());
    //         map.get(nums[i]).add(i);
    //     }

    //     for (int i = 0; i < l; i++) {
    //         int k = nums[i];
    //         if (map.get(k).size() == 1) {
    //             res[i] = 0;
    //             continue;
    //         } else {
    //             for (int n : map.get(k)) {
    //                 res[i] += Math.abs(i - n);
    //             }
    //         }
    //     }
    //     return res;
    // }
}
