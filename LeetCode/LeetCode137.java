package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode137 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int sumSet = 0;
        for (int n : nums) {
            sumSet += n;
            if(!set.add(n))  set2.add(n);
            else set.add(n);

        }

        for (Integer i : set2)  sumSet = sumSet - (i * 3);
        return sumSet;
    }
}
