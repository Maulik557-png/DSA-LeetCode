import java.util.*;

public class Apr17LeetCode3761 {
    public static void main(String[] args) {
        int[] nums = {12,21,45,33,54};
        System.out.println(minMirrorPairDistance(nums));
    }

    public static int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (lastSeen.containsKey(n)) {
                res = Math.min(res, i - lastSeen.get(n));
            }
            int rev = reverse(n);
            lastSeen.put(rev, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    // public static int minMirrorPairDistance(int[] nums) {
    //     Map<Integer, List<Integer>> idx = new HashMap<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         idx.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    //     }

    //     int res = Integer.MAX_VALUE;

    //     for (int n : idx.keySet()) {
    //         int rev = reverse(n);

    //         if (!idx.containsKey(rev))
    //             continue;

    //         List<Integer> list1 = idx.get(n);
    //         List<Integer> list2 = idx.get(rev);

    //         int i = 0, j = 0;

    //         while (i < list1.size() && j < list2.size()) {
    //             int a = list1.get(i);
    //             int b = list2.get(j);

    //             if (a < b) {
    //                 res = Math.min(res, b - a);
    //                 i++;
    //             } else {
    //                 j++;
    //             }
    //         }
    //     }

    //     return res == Integer.MAX_VALUE ? -1 : res;
    // }

    // private static int reverse(int n) {
    //     int rev = 0;
    //     while (n > 0) {
    //         rev = rev * 10 + n % 10;
    //         n /= 10;
    //     }
    //     return rev;
    // }

    // public static int minMirrorPairDistance(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     Map<Integer, Integer> idx = new HashMap<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         idx.put(nums[i], i);
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < nums.length; i++) {
    //         int n = nums[i];
    //         if(!map.containsKey(n)) {
    //             sb.setLength(0);
    //             int r =  Integer.parseInt(sb.append(n).reverse().toString());
    //             map.put(r, n);
    //         }
    //     }

    //     int res = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         int n = nums[i];
    //         if(map.containsKey(n)) {
    //             if(idx.get(map.get(n)) < idx.get(n)) {
    //                 res =  Math.min(res, Math.abs(idx.get(n) - idx.get(map.get(n))));
    //             }
    //         }
    //     }

    //     return res == Integer.MAX_VALUE? -1: res;
    // }
}
