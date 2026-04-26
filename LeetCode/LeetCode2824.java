import java.util.ArrayList;
import java.util.List;

public class LeetCode2824 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(-1,1,2,3,1));
        int target = 2;

        System.out.println(countPairs(nums, target));
    }

    public static int countPairs(List<Integer> nums, int target) {
        nums.sort((a,b) -> a -b);
        int l = 0;
        int r = nums.size() - 1;

        int res = 0;

        while(r != l)   {

            if(nums.get(l) + nums.get(r) < target) {
                res += r - l;
                l++;
            }
            else r--;
        }

        return res;
    }
}
