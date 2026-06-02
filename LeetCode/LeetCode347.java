import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.PriorityQueue;

public class LeetCode347 {

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] res = new int[k];

        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int count : map.keySet()) {
            bucket[map.get(count)].add(count);
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            List<Integer> list = bucket[i];
            for (Integer j : list) {
                temp.add(j);
            }
        }

        while(k-- > 0) {
            res[k] = temp.get(k);
        }
        
        return res;
    }

    // public static int[] topKFrequent(int[] nums, int k) {
    //     int[] res = new int[k];
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for (int n : nums)  map.put(n, map.getOrDefault(n, 0) + 1);

    //     PriorityQueue<Integer> pq = new PriorityQueue<>(
    //             (a, b) -> map.get(a) - map.get(b)
    //     );

    //     for (int key : map.keySet()) {
    //         pq.add(key);
    //         if (pq.size() > k)  pq.poll();
    //     }

    //     for (int i = k - 1; i >= 0; i--)  res[i] = pq.poll();

    //     return res;
    // }
}
