import java.util.HashSet;
import java.util.Set;

public class LeetCode217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)  
            if(!set.add(n))  
                return true;
        return false;
    }

    // public static boolean containsDuplicate(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for(int n: nums)    {
    //         if(set.contains(n))   return true;
    //         else  set.add(n);
    //     }
    //     return false;
    // }
}
