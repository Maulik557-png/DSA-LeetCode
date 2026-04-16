import java.util.*;

public class Apr16LeetCode3488 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 4, 1, 3, 2 };
        int[] queries = { 0, 3, 5 };
        System.out.println(solveQueries(nums, queries));
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(queries.length);

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int que = queries[i];
            int val = nums[que];

            List<Integer> temp = map.get(val);
            if (temp != null && temp.size() >= 2) {
                int idx = Collections.binarySearch(temp, que);

                int leftIdx = (idx - 1 + temp.size()) % temp.size();
                int rightIdx = (idx + 1) % temp.size();

                int left = Math.abs(temp.get(idx) - temp.get(leftIdx));
                int right = Math.abs(temp.get(idx) - temp.get(rightIdx));

                int res = Math.min(Math.min(left, nums.length - left), Math.min(right, nums.length - right));

                list.add(res);
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    // public static List<Integer> solveQueries(int[] nums, int[] queries) {
    //     int n = nums.length;

    //     Map<Integer, List<Integer>> map = new HashMap<>();

    //     // Step 1: Build index map
    //     for (int i = 0; i < n; i++) {
    //         map.putIfAbsent(nums[i], new ArrayList<>());
    //         map.get(nums[i]).add(i);
    //     }

    //     // Step 2: Precompute answers for each index
    //     int[] ans = new int[n];
    //     Arrays.fill(ans, -1);

    //     for (List<Integer> list : map.values()) {
    //         if (list.size() == 1)
    //             continue;

    //         int size = list.size();

    //         for (int i = 0; i < size; i++) {
    //             int curr = list.get(i);

    //             int prev = list.get((i - 1 + size) % size);
    //             int next = list.get((i + 1) % size);

    //             int distPrev = Math.min(Math.abs(curr - prev), n - Math.abs(curr - prev));
    //             int distNext = Math.min(Math.abs(curr - next), n - Math.abs(curr - next));

    //             ans[curr] = Math.min(distPrev, distNext);
    //         }
    //     }

    //     // Step 3: Answer queries in O(1)
    //     List<Integer> result = new ArrayList<>(queries.length);
    //     for (int q : queries) {
    //         result.add(ans[q]);
    //     }

    //     return result;
    // }
}
