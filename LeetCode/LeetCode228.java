import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        int l = 0;
        int r = 0;
        int i = 0;
        int n2 = nums[r];
        for (; r < nums.length; r++) {
            int n1 = nums[l];
            if (nums[r] == n1 + i) {
                n2 = n1 + i;
                i++;
                continue;
            } else if (n1 == n2) {
                list.add(n1 + "");
            } else {
                list.add(n1 + "->" + n2);
            }
            l = r;
            i = 1;
            n2 = nums[r];
        }

        int n1 = nums[l];
        if (n1 == n2) {
            list.add(n1 + "");
        } else {
            list.add(n1 + "->" + n2);
        }

        return list;
    }
}
