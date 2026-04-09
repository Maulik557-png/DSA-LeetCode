import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumSet = 0;
        int sumArray = 0;
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
                sumSet += n;
            }
            sumArray += n;
        }
        return 2 * sumSet - sumArray;
    }

    // public static int singleNumber(int[] nums) {
    //     int res = 0;
    //     for (int n : nums)  res ^= n;
    //     return res;
    // }

    // public static int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     int sumSet = 0;
    //     for (int n : nums) {
    //         sumSet += n;
    //         if (set.contains(n))  sumSet -= 2 * n;
    //         set.add(n);
    //     }
    //     return sumSet;
    // }
}
