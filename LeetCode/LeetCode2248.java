import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2248 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{3,4,5,6}};
        List<Integer> list = intersection(nums);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int[] fArr = nums[0];

        for (int[] arr: nums) {
            for (int n: arr) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        for (int i = 0; i < fArr.length; i++) {
            if(map.get(fArr[i]) == nums.length)  {
                res.add(fArr[i]);
            }
        }

        res.sort((a, b) -> a - b);
        return res;
    }

    // public static List<Integer> intersection(int[][] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     List<Integer> res = new ArrayList<>();
    //     for (int[] arr : nums)
    //         for (int n : arr)
    //             map.put(n, map.getOrDefault(n, 0) + 1);
    //     return map.keySet().stream().filter(i -> map.get(i) == nums.length).sorted().collect(Collectors.toList());
    // }

    // public static List<Integer> intersection(int[][] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for (int[] arr : nums) {
    //         Set<Integer> set = new HashSet<>();
    //         for (int n : arr)  set.add(n);
    //         for (int n : set)  map.put(n, map.getOrDefault(n, 0) + 1);
    //     }

    //     return map.keySet()
    //             .stream()
    //             .filter(i -> map.get(i) == nums.length)
    //             .sorted()
    //             .collect(Collectors.toList());
    // }

    // public List<Integer> intersection(int[][] nums) {
    //     Set<Integer> res = new HashSet<>();

    //     for (int n : nums[0])  res.add(n);
    //     for (int i = 1; i < nums.length; i++) {
    //         Set<Integer> temp = new HashSet<>();
    //         for (int n : nums[i])  temp.add(n);
    //         res.retainAll(temp);
    //     }

    //     List<Integer> ans = new ArrayList<>(res);
    //     Collections.sort(ans);
    //     return ans;
    // }
}
