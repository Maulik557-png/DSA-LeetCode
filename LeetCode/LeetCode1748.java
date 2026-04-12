// import java.util.HashMap;
// import java.util.Map;

public class LeetCode1748 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 6, 2};
        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums) {
       int[] arr = new int[101];
        for(int n: nums) arr[n]++;
        int sum = 0;
        for(int n: nums) if(n == 1) sum += n;
        return sum;  
    }

    // public static int sumOfUnique(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int sum = 0;
    //     for (int n : nums) {
    //         int f = map.getOrDefault(n, -1);
    //         if(f == -1) {
    //             sum += n;
    //             map.put(n, 1);
    //         } else if(f != -1 && f > 0) {
    //             sum -= n;
    //             map.put(n, 0);
    //         }
    //     }
    //     return sum;
    // }

    // public static int sumOfUnique(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int sum = 0;
    //     for(int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
    //     for(int n: map.keySet()) if(map.get(n) == 1) sum += n;
    //     return sum;
    // }
}
