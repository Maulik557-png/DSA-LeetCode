import java.util.ArrayList;
import java.util.List;

public class LeetCode2553 {
    public static void main(String[] args) {
        int[] nums = {13,25,83,77};
        int[] res = separateDigits(nums);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 0) {
                list.add(num % 10);
                num = num / 10;
            }
        }

        int ans[] = new int[list.size()];
        int ind = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[ind++] = list.get(i);
        }

        return ans;
    }
}
